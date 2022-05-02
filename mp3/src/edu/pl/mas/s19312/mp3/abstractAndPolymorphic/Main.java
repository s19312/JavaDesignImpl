package edu.pl.mas.s19312.mp3.abstractAndPolymorphic;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        TrackRacing r1 = new TrackRacing(1, LocalDateTime.now(),16);
        System.out.println(r1.getRaceDistance());
        System.out.println(r1.getNumberOfParticipants());

        Race r2 = new DragRacing(1,LocalDateTime.now(),18.5);
        System.out.println(r2.getRaceDistance());
        System.out.println(r2.getNumberOfParticipants());
    }
}
