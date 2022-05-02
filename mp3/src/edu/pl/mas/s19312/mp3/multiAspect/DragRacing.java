package edu.pl.mas.s19312.mp3.multiAspect;

import java.time.LocalDateTime;

public class DragRacing extends Race{
    private double raceDistance;

    public DragRacing(int idRace, LocalDateTime startDate,double raceDistance) {
        super(idRace, startDate);
        setRaceDistance(raceDistance);
    }

    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        if(raceDistance < 0){
            throw new RuntimeException("Race Distance cannot be negative!");
        }
        this.raceDistance = raceDistance;
    }
}
