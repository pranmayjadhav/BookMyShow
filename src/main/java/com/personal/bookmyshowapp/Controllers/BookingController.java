package com.personal.bookmyshowapp.Controllers;

import com.personal.bookmyshowapp.DTOs.BookingMovieRequestDTO;
import com.personal.bookmyshowapp.DTOs.BookingMovieResponseDTO;
import com.personal.bookmyshowapp.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired // Automatically finds the objects in the params,
                //Create it if not already created and pass it over
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookingMovieResponseDTO bookMovie(BookingMovieRequestDTO bookingMovieRequestDTO) {


        return null;
    }
}
