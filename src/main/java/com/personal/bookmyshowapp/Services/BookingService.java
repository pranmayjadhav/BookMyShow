package com.personal.bookmyshowapp.Services;

import com.personal.bookmyshowapp.Models.Booking;
import com.personal.bookmyshowapp.Models.Enum.BookingStatus;
import com.personal.bookmyshowapp.Models.Enum.ShowSeatStatus;
import com.personal.bookmyshowapp.Models.Show;
import com.personal.bookmyshowapp.Models.ShowSeat;
import com.personal.bookmyshowapp.Models.User;
import com.personal.bookmyshowapp.Repositories.BookingRepository;
import com.personal.bookmyshowapp.Repositories.ShowRepository;
import com.personal.bookmyshowapp.Repositories.ShowSeatRepository;
import com.personal.bookmyshowapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    @Autowired
    public BookingService(UserRepository userRepository, BookingRepository bookingRepository,
                          ShowSeatRepository showSeatRepository, ShowRepository showRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> ShowSeatIds, Long showId) {
        //1. Get the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("No such user Found!");
        }
        User bookedBy = userOptional.get();
        //-----------------------------------------------------------------------------------------

        //2. Get the show by showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()) {
          throw new RuntimeException("NO show like that!");
        }
        Show bookedShow = showOptional.get();
        //-----------------------------------------------------------------------------------------

        //........Take Lock......(Start Transaction)
        //3. Get the ShowSeat using seatId
        List<ShowSeat> showSeats = showSeatRepository.findAllById(ShowSeatIds);
        //-----------------------------------------------------------------------------------------

        //4. Check if all seats are available
        for (ShowSeat showSeat : showSeats) {
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getLockedAt().toInstant() , new Date().toInstant()).toMinutes() > 15))) {
                //5. if no, throw error
                throw new RuntimeException("Selected seats are not available!");
            }
        }
        //-----------------------------------------------------------------------------------------

        //6. if yes, mark all the seats as BLOCKED
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            //7. Save it in DB
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        //-----------------------------------------------------------------------------------------

        //........Release Lock......(End Transaction)
        //8. Create the corresponding booking object
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeats);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
        booking.setAmount(0);
        booking.setPayments(new ArrayList<>());
        //-----------------------------------------------------------------------------------------

        //9. savethe booking details in the Dababase
        booking = bookingRepository.save(booking);
        //-----------------------------------------------------------------------------------------

        //10. return the booking object
        return booking;
    }
}
//1. Get the user by userId
//2. Get the show by showId
//........Take Lock......(Start Transaction)
//3. Get the ShowSeat using seatId
//4. Check if all seats are available
//5. if no, throw error
//6. if yes, mark all the seats as BLOCKED
//7. Save it in DB
//........Release Lock......(End Transaction)
//8. Create the corresponding booking object
//9. savethe booking details in the Dababase
//10. return the booking object