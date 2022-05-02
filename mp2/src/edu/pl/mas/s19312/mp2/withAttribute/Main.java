package edu.pl.mas.s19312.mp2.withAttribute;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car(1,"toyota", "AO12356BG", Equipment.CLASSIC);
        Car car2 = new Car(2,"BMW", "AA54435TG",Equipment.SPORT);
        Car car3 = new Car(3,"BMW", "AI55665BG", Equipment.SPORT);
        Car car4= new Car(4,"BMW", "AI51115BG", Equipment.SPORT);

        Owner owner1 = new Owner(1,"Jacek", "Smith", LocalDateTime.now(),"FF33432");
        Owner owner2 = new Owner(2,"Johm", "Kowalski", LocalDateTime.now(),"FF35732");
        Owner owner3 = new Owner(3,"Jacub", "Nowak", LocalDateTime.now(),"FF66432");

        CarDocuments d1 = new CarDocuments(1000,LocalDateTime.now(),"ss44w2355",car1,owner1);
        System.out.println("Owner1 has amount of cars: " + owner1.getCarDocuments().size());
        d1.remove();
        System.out.println("After removing d1:\n\tOwner1 contains d1:" + owner1.getCarDocuments().contains(d1) + "\n\t" +
                "Car assign to: " + car1.getCarDocuments() + "\n\tOwner1 has amount of cars:" + owner1.getCarDocuments().size());

        //Trying to use already removed Car documents "d1"
//        owner1.addCarDocuments(d1);// Rise an Exception.

        //Trying to use already removed Car documents "d1"
//        car1.setCarDocuments(d1);// Rise an Exception.

        CarDocuments d2 = new CarDocuments(1500,LocalDateTime.now(),"4564s9845",car2,owner2);

        //reassign car2 to another owner3
        CarDocuments d3 = new CarDocuments(2250,LocalDateTime.now(),"r88432498",car2,owner3);
        CarDocuments d4 = new CarDocuments(2250,LocalDateTime.now(),"r88432498",car3,owner3);
        CarDocuments d5 = new CarDocuments(2250,LocalDateTime.now(),"r88432498",car4,owner3);

        System.out.println("After reassign car2 to another owner3:\n\tOwner2 contains car2: " + owner2.getCarDocuments().contains(d2)+ "\n\t" +
                "Owner3 contains car2: " + owner3.getCarDocuments().contains(d3));
        //remove car4 from owner3
        owner3.removeCarDocuments(d5);
        //remove car3 from owner3
        car3.removeCarDocuments();

        //Trying to assign the same to the same owner twice
//        CarDocuments d5 = new CarDocuments(2250,LocalDateTime.now(),"r88432498",car2,owner3);//Rise an Exception

    }
}
