package com.example.travelapp;

public class TripModel {
     private int id;
     private String place, date, time, number;
     private long started, finished;

    public TripModel(){

    }

    public TripModel(int id, String place, String date, String time, String number, long started, long finished) {
        this.id = id;
        this.place = place;
        this.date = date;
        this.time = time;
        this.number = number;
        this.started = started;
        this.finished = finished;
    }

    public TripModel( String place, String date, String time, String number, long started, long finished) {
        this.place = place;
        this.date = date;
        this.time = time;
        this.number = number;
        this.started = started;
        this.finished = finished;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
