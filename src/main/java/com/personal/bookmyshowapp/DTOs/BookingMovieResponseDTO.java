package com.personal.bookmyshowapp.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingMovieResponseDTO {
    private ResponseStatus responseStatus;
    private Long bookingId;
    private int amount;
}
