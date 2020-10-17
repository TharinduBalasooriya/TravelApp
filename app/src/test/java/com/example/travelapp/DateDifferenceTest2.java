package com.example.travelapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateDifferenceTest2 {

    private hotelBookinForm1 hotel_booking_form;
    private float result;
    @Before
    public  void setUP(){
        hotel_booking_form = new hotelBookinForm1();
    }
    @Test

    public void get_date_difference_is_corredt(){

        result = hotel_booking_form.getDateDif("13/09/2020","20/09/2020");
        assertEquals(7,result,0.001);
    }
    @After
    public void clear_Data(){
        result = 0;
        hotel_booking_form = null;
    }
}
