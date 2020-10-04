package com.example.travelapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateDifferenceTest {
    private hotelBookinForm1 hotel_booking_form;
    private float result;
    @Before
    public  void setUP(){
        hotel_booking_form = new hotelBookinForm1();
    }
    @Test

    public void get_date_difference_is_corredt(){

         result = hotel_booking_form.getDateDif("24/09/2020","26/09/2020");
        assertEquals(2,result,0.001);
    }
    @After
    public void clear_Data(){
        result = 0;
        hotel_booking_form = null;
    }
}
