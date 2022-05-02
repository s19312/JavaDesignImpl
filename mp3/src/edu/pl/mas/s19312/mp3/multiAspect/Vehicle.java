package edu.pl.mas.s19312.mp3.multiAspect;

public class Vehicle {
    private int idVehicle;
    private String brand;
    private Race race;

    public Vehicle(int idVehicle, String brand, Race race) {
        setIdVehicle(idVehicle);
        setBrand(brand);
        setRace(race);
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        if(idVehicle < 0){
            throw new RuntimeException("Id Vehicle cannot be negative!");
        }
        this.idVehicle = idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().equals("")){
            throw new RuntimeException("Brand cannot be null or empty ");
        }
        this.brand = brand;
    }

    public Race getRace() {
        return race;
    }

    private void setRace(Race race) {
        if(race == null){
            throw new RuntimeException("Race cannot be null!");
        }
        this.race = race;
        race.addVehicle(this);
    }

    public void removeRace() {
        if (this.race == null){
            return;
        }
        Race tmp = this.race;
        this.race = null;
        tmp.removeVehicle(this);
    }
}
