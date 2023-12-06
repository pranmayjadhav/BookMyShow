package com.personal.bookmyshowapp.Models;
import com.personal.bookmyshowapp.Models.Enum.PaymentProvider;
import com.personal.bookmyshowapp.Models.Enum.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;

@Getter
@Setter
public class Payment extends BaseModel{
    private String referenceNumber;
    private int amount;
//    private Booking booking;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentProvider;
}
