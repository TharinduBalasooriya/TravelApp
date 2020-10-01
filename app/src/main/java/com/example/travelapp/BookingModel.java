package com.example.travelapp;

public class BookingModel {
    private int id;
    private String name,nic,email,hName;
    private int mobile;
    private long started, finished;

    public BookingModel(){

    }

    public BookingModel(int id, String name, String nic, String email, String hName, int mobile, long started, long finished) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.hName = hName;
        this.mobile = mobile;
        this.started = started;
        this.finished = finished;
    }

    public BookingModel(String name, String nic, String email, String hName, int mobile, long started, long finished) {
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.hName = hName;
        this.mobile = mobile;
        this.started = started;
        this.finished = finished;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
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
