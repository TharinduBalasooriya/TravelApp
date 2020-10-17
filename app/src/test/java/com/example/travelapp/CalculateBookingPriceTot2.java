package com.example.travelapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateBookingPriceTot2 {

    public BookingModel booking;
    public double result ;

    @Before
    public void setUP(){
        booking = new BookingModel();
        booking.setCheckIn("24/09/2020"); //set check in Date;
        booking.setCheckOut("30/09/2020"); //set check out Date;


    }

    @Test

    public void test_final_pirice_is_correct(){

        booking.calcPrice(1000,10,2);
        result = booking.getFinalPrice();
        assertEquals(10800,result,0.001);

    }
    @After
    public void  clear_Data(){
        booking = null;
        result = 0;
    }
}
