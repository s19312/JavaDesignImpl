package edu.pl.mas.s19312.mp3.abstractAndPolymorphic;

import java.time.LocalDateTime;


public abstract class Race {
    private int idRace;
    private LocalDateTime startDate;

    public Race(int idRace, LocalDateTime startDate) {
        setIdRace(idRace);
        setStartDate(startDate);
    }

    public int getIdRace() {
        return idRace;
    }

    public void setIdRace(int idRace) {
        if(idRace < 0){
            throw new RuntimeException("Id Race cannot be negative!");
        }
        this.idRace = idRace;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        if(startDate == null){
            throw new RuntimeException("Start Date cannot be null!");
        }
        this.startDate = startDate;
    }

    public abstract double getRaceDistance();

    public abstract int getNumberOfParticipants();

}
