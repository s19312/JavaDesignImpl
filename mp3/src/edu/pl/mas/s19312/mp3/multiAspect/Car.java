package edu.pl.mas.s19312.mp3.multiAspect;

public class Car extends Vehicle{
    private double weight;

    public Car(int idVehicle, String brand, double weight, Race race) {
        super(idVehicle, brand, race);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight < 0){
            throw new RuntimeException("Car weight cannot be negative!");
        }
        this.weight = weight;
    }
}
