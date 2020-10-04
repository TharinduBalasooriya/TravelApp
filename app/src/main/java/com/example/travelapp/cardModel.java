package com.example.travelapp;

import java.io.Serializable;

public class cardModel implements Serializable {

    private int id;
    private String name;
    private String number;
    private String expDate;
    private String cvv;

    public cardModel(int id, String name, String number, String expDate, String cvv) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public cardModel(String name, String number, String expDate, String cvv) {
        this.name = name;
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
    }
    public cardModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
