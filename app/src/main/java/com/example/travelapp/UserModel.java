package com.example.travelapp;

public class UserModel {

    private int id ;
    private String userName;
    private  String password;
    private  String email;
    private  String mobile;

    public UserModel(){

    }
    public UserModel(int id, String userName, String password, String email, String mobile) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public UserModel(String userName, String password, String email, String mobile) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
