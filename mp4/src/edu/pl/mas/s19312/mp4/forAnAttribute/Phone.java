package edu.pl.mas.s19312.mp4.forAnAttribute;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String phoneSerialNumber;
    private final int maxNumberOfCameras = 4;
    private final int minNumberOfCameras = 0;
    private int numberOfCameras;
    private static List<Phone> phonesExtent = new ArrayList<>();

    public Phone(String phoneSerialNumber, int numberOfCameras) {
        setPhoneSerialNumber(phoneSerialNumber);
        setNumberOfCameras(numberOfCameras);
        phonesExtent.add(this);
    }

    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    private void setNumberOfCameras(int numberOfCameras) {
        if(numberOfCameras < minNumberOfCameras){
            throw new RuntimeException("Number of cameras cannot be lower then minNumber!");
        }else if(numberOfCameras > maxNumberOfCameras){
            throw new RuntimeException("Number of cameras cannot be bigger then maxNumber!");
        }
        this.numberOfCameras = numberOfCameras;
    }

    public void addOneMoreCamera(){
        if((this.numberOfCameras+1) > maxNumberOfCameras){
            throw new RuntimeException("Cannot add one more camera for this Phone!");
        }
        this.numberOfCameras++;
    }

    public void removeOneCamera(){
        if((this.numberOfCameras-1) < maxNumberOfCameras){
            throw new RuntimeException("Cannot remove camera. Phone has not any camera to remove");
        }
        this.numberOfCameras--;
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
