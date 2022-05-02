package edu.pl.mas.s19312.mp4.custom;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String phoneSerialNumber;
    private int numberOfCameras;
    private double price;
    private static List<Phone> phonesExtent = new ArrayList<>();

    public Phone(String phoneSerialNumber, int numberOfCameras, double price) {
        setPhoneSerialNumber(phoneSerialNumber);
        setNumberOfCameras(numberOfCameras);
        setPrice(price);
        phonesExtent.add(this);
    }

    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    public void setNumberOfCameras(int numberOfCameras) {
        if(numberOfCameras < 0){
            throw new RuntimeException("Number of cameras cannot be negative!");
        }
        this.numberOfCameras = numberOfCameras;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new RuntimeException("Price cannot be negative!");
        }
        if(price < (650 + numberOfCameras * 150)){
            throw new RuntimeException("Price is to low for this Phone!");
        }else if(price > (650 + numberOfCameras * 270)){
            throw new RuntimeException("Price is to high for this Phone!");
        }
        this.price = price;
    }

    public String getPhoneSerialNumber() {
        return phoneSerialNumber;
    }

    public void setPhoneSerialNumber(String phoneSerialNumber) {
        if(phoneSerialNumber == null || phoneSerialNumber.trim().equals("")){
            throw new RuntimeException("Phone serial number cannot be null or empty!");
        }
        for(Phone ph : phonesExtent){
            if(ph.getPhoneSerialNumber().equals(phoneSerialNumber)){
                throw new RuntimeException("This serial already exists!");
            }
        }
        this.phoneSerialNumber = phoneSerialNumber;
    }


}
