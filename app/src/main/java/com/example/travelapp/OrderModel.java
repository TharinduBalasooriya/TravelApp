package com.example.travelapp;

import java.io.Serializable;

public class OrderModel implements Serializable {
    private int id;
    private String cusName;
    private String cusMobile;
    private int item1q,itemq2,itemq3;
    private double totPrice;

    public OrderModel(){

    }

    public OrderModel(int id, String cusName, String cusMobile, int item1q, int itemq2, int itemq3) {
        this.id = id;
        this.cusName = cusName;
        this.cusMobile = cusMobile;
        this.item1q = item1q;
        this.itemq2 = itemq2;
        this.itemq3 = itemq3;
        this.totPrice = item1q * 100 + itemq2 + 270 + itemq3 * 300;
    }

    public OrderModel(String cusName, String cusMobile, int item1q, int itemq2, int itemq3) {
        this.cusName = cusName;
        this.cusMobile = cusMobile;
        this.item1q = item1q;
        this.itemq2 = itemq2;
        this.itemq3 = itemq3;
        this.totPrice = item1q * 100 + itemq2 + 270 + itemq3 * 300;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusMobile() {
        return cusMobile;
    }

    public void setCusMobile(String cusMobile) {
        this.cusMobile = cusMobile;
    }

    public int getItem1q() {
        return item1q;
    }

    public void setItem1q(int item1q) {
        this.item1q = item1q;
    }

    public int getItemq2() {
        return itemq2;
    }

    public void setItemq2(int itemq2) {
        this.itemq2 = itemq2;
    }

    public int getItemq3() {
        return itemq3;
    }

    public void setItemq3(int itemq3) {
        this.itemq3 = itemq3;
    }

    public double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }
}
