package edu.pl.mas.s19312.mp4.unique;

public class Main {

    public static void main(String[] args) {
        Phone ph1 = new Phone("1155g456");
        //error
        Phone ph2 = new Phone("1155g456");
        System.out.println(ph1.getPhoneSerialNumber());
        ph1.setPhoneSerialNumber("ssss565412s");
        System.out.println(ph1.getPhoneSerialNumber());
        //error
        ph1.setPhoneSerialNumber("ssss565412s");
    }
}
