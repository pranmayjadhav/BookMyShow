package com.personal.bookmyshowapp.Controllers;

import com.personal.bookmyshowapp.DTOs.BookingMovieRequestDTO;
import com.personal.bookmyshowapp.DTOs.BookingMovieResponseDTO;
import com.personal.bookmyshowapp.DTOs.ResponseStatus;
import com.personal.bookmyshowapp.Models.Booking;
import com.personal.bookmyshowapp.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired // Automatically finds the objects in the params,
                //Create it if not already created and pass it over
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookingMovieResponseDTO bookMovie(BookingMovieRequestDTO bookingMovieRequestDTO) {
        BookingMovieResponseDTO response = new BookingMovieResponseDTO();

        try{
            Booking booking = bookingService.bookMovie(
                    bookingMovieRequestDTO.getUserId(),
                    bookingMovieRequestDTO.getShowSeatIds(),
                    bookingMovieRequestDTO.getShowId()
            );
            response.setBookingId(booking.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setAmount(booking.getAmount());
        }
        catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FALURE);
        }

        return response;
    }
}
