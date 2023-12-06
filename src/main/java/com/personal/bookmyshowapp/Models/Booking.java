package com.personal.bookmyshowapp.Models;

import com.personal.bookmyshowapp.Models.Enum.BookingStatus;
import com.personal.bookmyshowapp.Models.Enum.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeats;
    private User user;
    private Date bookedAt;
    private Show show;
    private int amount;
    private List<Payment> payments;
}