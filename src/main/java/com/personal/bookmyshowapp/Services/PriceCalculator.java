package com.personal.bookmyshowapp.Services;

import com.personal.bookmyshowapp.Models.Show;
import com.personal.bookmyshowapp.Models.ShowSeat;
import com.personal.bookmyshowapp.Models.ShowSeatType;
import com.personal.bookmyshowapp.Repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats,
                              Show show) {
        //1. Find out the type of seats in the given show
        //2. Get seat types for all the selected shows
        //3. Calculate the amount
        return null;

    }
}
