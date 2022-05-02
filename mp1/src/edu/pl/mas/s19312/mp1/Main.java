package edu.pl.mas.s19312.mp1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Owner owner1 = new Owner("Jan","Blick","FG5050433");
        Manufacture car1manu = new Manufacture("Toyota","Poland","Warsaw", LocalDateTime.now());
        Car car1 = new Car(1, "Toyota Siena", CarEquipment.CLASSIC,car1manu,owner1,60,12);

        Owner owner2 = new Owner("Bob","Marli","FG5050343");
        Manufacture car2manu = new Manufacture("Mercedes","Germany","Berlin", LocalDateTime.now());
        Car car2 = new Car(2, "Mercedes Benz", CarEquipment.COMFORT,car2manu,owner2,80,14);

        Car.recordExtent();
//        System.out.println(Car.getCarExtent());
        Car.loadExtent();
        System.out.println(Car.getCarExtent());

        Owner owner3 = new Owner("Glock","Smith","FG5066343");
        Manufacture car3manu = new Manufacture("Mitsubishi","Japan","Okazaki ", LocalDateTime.now());
        Car car3 = new Car(3,"Mitsubishi Outlander",CarEquipment.SPORT, car3manu);

        Car.loadExtent();
//        System.out.println(Car.getCarExtent().indexOf(0));
    }
}
