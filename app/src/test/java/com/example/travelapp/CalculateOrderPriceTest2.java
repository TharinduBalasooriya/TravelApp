package com.example.travelapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateOrderPriceTest2 {
    public OrderModel order;
    public double result;

    @Before
    public void start(){
        order = new OrderModel();
        order.setItem1q(3);
        order.setItemq2(3);
        order.setItemq3(3);

    }
    @Test

    public void checktotalpricecalculation(){
        result = order.calctotprice(order.getItem1q(),order.getItemq2(),order.getItemq3());
        assertEquals(2010,result,0.001);

    }
    @After
    public void  end(){
        order = null;
        result = 0;
    }
}
