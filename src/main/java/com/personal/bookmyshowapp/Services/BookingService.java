package com.personal.bookmyshowapp.Services;

import com.personal.bookmyshowapp.Models.Booking;
import com.personal.bookmyshowapp.Models.User;
import com.personal.bookmyshowapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    @Autowired
    public BookingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> seatIds, Long showId) {
        //1. Get the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
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



        return null;
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