package com.example.travelapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateBookingTotalPriceTest {

    public BookingModel booking;
    public double result ;

    @Before
    public void setUP(){
        booking = new BookingModel();
        booking.setCheckIn("24/09/2020"); //set check in Date;
        booking.setCheckOut("26/09/2020"); //set check out Date;


    }

    @Test

    public void test_final_pirice_is_correct(){

        booking.calcPrice(2500,10,2);
        result = booking.getFinalPrice();
        assertEquals(9000,result,0.001);

    }
    @After
    public void  clear_Data(){
        booking = null;
        result = 0;
    }

}
