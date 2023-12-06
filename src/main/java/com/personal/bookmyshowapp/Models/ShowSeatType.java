package com.personal.bookmyshowapp.Models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}