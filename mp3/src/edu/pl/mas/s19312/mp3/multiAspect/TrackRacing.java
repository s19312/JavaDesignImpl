package edu.pl.mas.s19312.mp3.multiAspect;

import java.time.LocalDateTime;

public class TrackRacing extends Race {
    private int numberOfLaps;

    public TrackRacing(int idRace, LocalDateTime startDate,int numberOfLaps) {
        super(idRace, startDate);
        setNumberOfLaps(numberOfLaps);
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(int numberOfLaps) {
        if(numberOfLaps < 0){
            throw new RuntimeException("Number of laps cannot be negative!");
        }
        this.numberOfLaps = numberOfLaps;
    }
}
