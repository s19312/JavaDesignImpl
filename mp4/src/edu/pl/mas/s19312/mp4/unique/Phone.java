package edu.pl.mas.s19312.mp4.unique;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String phoneSerialNumber;
    private static List<Phone> phonesExtent = new ArrayList<>();

    public Phone(String phoneSerialNumber) {
        setPhoneSerialNumber(phoneSerialNumber);
        phonesExtent.add(this);
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
