package com.personal.bookmyshowapp.Models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
