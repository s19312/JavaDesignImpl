package edu.pl.mas.s19312.mp3.multiAspect;

import java.time.LocalDateTime;
import java.util.*;

public class Race {
    private int idRace;
    private LocalDateTime startDate;
    private Map<Integer,Vehicle> vehicles = new HashMap<>();

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

    public Map<Integer, Vehicle> getVehicles() {
        return Collections.unmodifiableMap(vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        if(vehicle == null){
            throw new RuntimeException("Vehicle cannot be null!");
        }
        if(this.vehicles.containsKey(vehicle.getIdVehicle())){
            return;
        }
        this.vehicles.put(vehicle.getIdVehicle(),vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if(!this.vehicles.containsKey(vehicle.getIdVehicle())){
            return;
        }
        this.vehicles.remove(vehicle.getIdVehicle());
        vehicle.removeRace();
    }
}
