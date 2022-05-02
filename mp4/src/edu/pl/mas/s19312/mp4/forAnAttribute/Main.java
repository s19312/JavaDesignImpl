package edu.pl.mas.s19312.mp4.forAnAttribute;

public class Main {

    public static void main(String[] args) {
        Phone p1 = new Phone("ssad5461s", 3);
        System.out.println(p1.getNumberOfCameras());

        p1.addOneMoreCamera();
        System.out.println(p1.getNumberOfCameras());

        //error
        //trying to add one more camera while Phone has maximum number of cameras
//        p1.addOneMoreCamera();

        Phone p2 = new Phone("ssf005461s", 0);
        //error
        //trying to remove camera while Phone has 0 number of cameras
        p2.removeOneCamera();

    }
}
