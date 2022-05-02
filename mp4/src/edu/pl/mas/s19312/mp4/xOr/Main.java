package edu.pl.mas.s19312.mp4.xOr;

public class Main {

    public static void main(String[] args) {
        Store s1 = new Store("StoreName1");
        Service ser1 = new Service("ServiceName1");

        Laptop l1 = new Laptop(1,"Asus MD570");
        l1.setStore(s1);

        System.out.println("Size of s1: " + s1.getLaptops().size());
        System.out.println("After reassigning l1 from store to service");

        //add l1 to service
        ser1.addLaptop(l1);
        System.out.println("Size of s1: " + s1.getLaptops().size());
        System.out.println("Size of ser1: " + ser1.getLaptops().size());

        //error
        //trying to get Store while laptop is in the Service
        l1.getStore();
    }
}
