package edu.pl.mas.s19312.mp2.withAttribute;

import java.time.LocalDateTime;

public class CarDocuments {
    private double carPrice;
    private LocalDateTime purchaseDate;
    private String insuranceNumber;

    private Car car;
    private Owner owner;

    public CarDocuments(double carPrice, LocalDateTime purchaseDate, String insuranceNumber, Car car, Owner owner) {
        setCarPrice(carPrice);
        setPurchaseDate(purchaseDate);
        setInsuranceNumber(insuranceNumber);
        for( CarDocuments cd : owner.getCarDocuments()){
            if(cd.getCar() == car){
                throw new RuntimeException("This Car already assigned to this Owner");
            }
        }
        setCar(car);
        setOwner(owner);

    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        if(purchaseDate == null){
            throw new RuntimeException("Purchase Date cannot not be null!");
        }
        this.purchaseDate = purchaseDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        if(insuranceNumber == null || insuranceNumber.trim().equals("")){
            throw new RuntimeException("Insurance Number cannot be null or empty!");
        }
        this.insuranceNumber = insuranceNumber;
    }

    public Car getCar() {
        return car;
    }

    private void setCar(Car car) {
        if(car == null){
            throw new RuntimeException("Car cannot be null");
        }
        this.car = car;
        car.setCarDocuments(this);
    }

    public Owner getOwner() {
        return owner;
    }

    private void setOwner(Owner owner) {
        if(owner == null){
            throw new RuntimeException("Owner cannot be null");
        }
        this.owner = owner;
        owner.addCarDocuments(this);
    }

    public void remove(){
        if (this.car != null) {
            Car tmp = this.car;
            this.car = null;
            tmp.removeCarDocuments();
        }
        if (this.owner != null) {
            Owner tmp = this.owner;
            this.owner = null;
            tmp.removeCarDocuments(this);
        }
    }
}
