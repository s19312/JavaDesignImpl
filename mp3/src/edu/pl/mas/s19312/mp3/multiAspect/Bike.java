package edu.pl.mas.s19312.mp3.multiAspect;

public class Bike extends Vehicle{
    private String engine;

    public Bike(int idVehicle, String brand, String engine, Race race) {
        super(idVehicle, brand, race);
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        if(engine == null || engine.trim().equals("")){
            throw new RuntimeException("Bike engine cannot be null or empty ");
        }
        this.engine = engine;
    }
}
