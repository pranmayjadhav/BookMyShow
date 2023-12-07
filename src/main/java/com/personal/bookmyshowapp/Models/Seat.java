package com.personal.bookmyshowapp.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @ManyToMany
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
