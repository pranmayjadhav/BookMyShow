package com.personal.bookmyshowapp.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingMovieRequestDTO {
    private List<Long> showSeatIds;
    private Long userId;
    private Long showId;
}
