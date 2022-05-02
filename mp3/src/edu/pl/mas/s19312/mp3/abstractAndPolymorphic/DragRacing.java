package edu.pl.mas.s19312.mp3.abstractAndPolymorphic;

import java.time.LocalDateTime;

public class DragRacing extends Race {
    private double wheelSize;

    public DragRacing(int idRace, LocalDateTime startDate, double wheelSize) {
        super(idRace, startDate);
    }
    @Override
    public double getRaceDistance() {
        return wheelSize > 20 ?900:(wheelSize > 15 && wheelSize < 20)?750:500;
    }

    @Override
    public int getNumberOfParticipants() {
        return 2;
    }

    public void setWheelSize(double wheelSize) {
        if(wheelSize < 0){
            throw new RuntimeException("Wheel size cannot be negative!");
        }
        this.wheelSize = wheelSize;
    }


}
