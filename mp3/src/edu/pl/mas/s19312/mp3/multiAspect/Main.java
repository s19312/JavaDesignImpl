package edu.pl.mas.s19312.mp3.multiAspect;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        TrackRacing tr1 = new TrackRacing(1, LocalDateTime.now(),2);
        Car c1 = new Car(1,"Toyota",1000,tr1);
        c1.removeRace();
        System.out.println(c1.getRace());
    }
}
