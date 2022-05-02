package edu.pl.mas.s19312.mp4.bag;

public class Car {
    private long id;
    private String brand;
    private Equipment carEquipment;
    private String plateNumber;
    private CarDocuments carDocuments;

    public Car(long id, String brand, String plateNumber, Equipment carEquipment) {
        setId(id);
        setBrand(brand);
        setCarEquipment(carEquipment);
        setPlateNumber(plateNumber);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(id < 0){
            throw new RuntimeException("Car Id cannot be negative!");
        }
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().equals("")){
            throw new RuntimeException("Car brand cannot be null or empty!");
        }
        this.brand = brand;
    }

    public Equipment getCarEquipment() {
        return carEquipment;
    }

    public void setCarEquipment(Equipment carEquipment) {
        if(carEquipment == null){
            throw new RuntimeException("Car Equipment cannot be null");
        }
        this.carEquipment = carEquipment;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if(plateNumber == null || plateNumber.trim().equals("")){
            throw new RuntimeException("Plate Number cannot be null or empty!");
        }
        this.plateNumber = plateNumber;
    }

    public CarDocuments getCarDocuments() {
        return carDocuments;
    }

    public void setCarDocuments(CarDocuments carDocuments) {
        if(carDocuments == null){
            throw new RuntimeException("Car Document cannot be null");
        }
        if(carDocuments.getCar() == null && carDocuments.getOwner() == null){
            throw new RuntimeException("This Car Documents cannot be used!");
        }
        if(this != carDocuments.getCar()){
            throw new RuntimeException("Car Document assign to another car!");
        }

        if(this.carDocuments != carDocuments && this.carDocuments != null){
            this.carDocuments.remove();
        }
        this.carDocuments = carDocuments;
    }

    public void removeCarDocuments(){
        if(this.carDocuments == null){
            return;
        }
        CarDocuments tmp = this.carDocuments;
        this.carDocuments = null;
        tmp.remove();
    }
}
