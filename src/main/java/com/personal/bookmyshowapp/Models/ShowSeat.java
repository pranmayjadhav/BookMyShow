package com.personal.bookmyshowapp.Models;
import com.personal.bookmyshowapp.Models.Enum.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
private ShowSeatStatus showSeatStatus;
}
