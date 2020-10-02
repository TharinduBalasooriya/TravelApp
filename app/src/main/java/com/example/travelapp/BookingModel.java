package com.example.travelapp;

public class BookingModel {
    private int id;
    private String name,nic,email,hName,checkIn,checkOut;
    private int mobile,price,discount,personCount;
    private long started, finished;
    private double totPrice;
    private double discountPrice;
    private double finalPrice;


    public BookingModel(){

    }

    public BookingModel(int id, String name, String nic, String email, String hName, int mobile, long started, long finished,int price,int discount,String checkIn,String checkOut,int personCount) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.hName = hName;
        this.mobile = mobile;
        this.started = started;
        this.finished = finished;
        this.price = price;
        this.discount = discount;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;

        calcPrice(price,discount,personCount);
    }

    public BookingModel(String name, String nic, String email, String hName, int mobile, long started, long finished,int price,int discount,String checkIn,String checkOut, int personCount) {
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.hName = hName;
        this.mobile = mobile;
        this.started = started;
        this.finished = finished;
        this.price = price;
        this.discount = discount;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;
        calcPrice(price,discount,personCount);
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

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }

    public void calcPrice(double price, double discount, int personCount){

        double totPrice = price * personCount;
        this.totPrice = totPrice;
        double discountPrice = totPrice* (discount/100);
        double finalPrice = totPrice - discountPrice;
        this.finalPrice = finalPrice;
        this.discountPrice = discountPrice;
    }
}
