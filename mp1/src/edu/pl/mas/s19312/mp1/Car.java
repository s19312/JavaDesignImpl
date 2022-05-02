package edu.pl.mas.s19312.mp1;

import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Car implements Serializable {
    private static List<Car> carExtent = new ArrayList<>();
    private long id;
    private String carName;
    private CarEquipment equipment;
    private Manufacture manufacture;
    private Owner owner;
    private Integer gasTankVolume;
    private Integer gasRatePerHundredKm;
    private List<Owner> owners = new ArrayList<>();
    private static List<String> nameOfCars = new ArrayList<>();

    public Car(long id, String carName, CarEquipment equipment, Manufacture manufacture) throws Exception {
        setId(id);
        setCarName(carName);
        setNameOfCars(carName);
        setEquipment(equipment);
        setManufacture(manufacture);
        carExtent.add(this);
    }

    public Car(long id, String carName, CarEquipment equipment, Manufacture manufacture,
               Owner owner, Integer gasTankVolume, Integer gasRatePerHundredKm) throws Exception {
        setId(id);
        setCarName(carName);
        setNameOfCars(carName);
        setEquipment(equipment);
        setManufacture(manufacture);
        setOwner(owner);
        setGasTankVolume(gasTankVolume);
        setGasRatePerHundredKm(gasRatePerHundredKm);
        carExtent.add(this);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id < 0) {
            throw new RuntimeException("Id cannot be negative!");
        }
        for (Car c : carExtent) {
            if (c.id == id) {
                System.out.print("List of existing car IDs: {");
                for (Car k : carExtent) {
                    System.out.print(k.id + ", ");
                }
                System.out.print("}\n");
                throw new RuntimeException("Car ID: " + id + " already exists!");
            }
        }
        this.id = id;
    }

    public void setCarName(String carName) {
        if (carName == null || carName.trim().equals("")) {
            throw new RuntimeException("CarName cannot be Empty or null");
        }
        this.carName = carName;
    }


    public String getCarName() {
        return carName;
    }

    public CarEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(CarEquipment equipment) {
        if (equipment == null) {
            throw new RuntimeException("Car Equipment cannot be null");
        }
        this.equipment = equipment;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        if (manufacture == null) {
            throw new RuntimeException("Manufacture cannot be null");
        }
        this.manufacture = manufacture;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        if (owner == null) {
            throw new RuntimeException("Owner Cannot be null");
        }
        if (owners.size() < 1) {
            addOwner(owner);
        } else {
            if (!owners.contains(owner)) {
                addOwner(owner);
            }
        }
        this.owner = owner;
    }

    public List<Owner> getOwners() {
        return new ArrayList<>(this.owners);
    }

    public void addOwner(Owner owner) {
        if (owner == null) {
            throw new RuntimeException("Owner cannot be null");
        }
        if (!owners.contains(owner)) {
            this.owners.add(owner);
        } else {
            throw new RuntimeException("Such Owner already exists in the list of Owners!");
        }
    }


    public void removeOwner(Owner owner) throws Exception {
        if (owners.contains(owner)) {
            owners.remove(owner);
        } else {
            throw new RuntimeException("No such owner in the list to remove!");
        }

    }

    public static List<Car> getCarExtent() {
        return Collections.unmodifiableList(carExtent);
    }

    public static void recordExtent() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\edu\\pl\\mas\\s19312\\mp1\\extent.ser"));
        out.writeObject(carExtent);
        out.close();
    }

    public static void loadExtent() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src\\edu\\pl\\mas\\s19312\\mp1\\extent.ser"));
        carExtent = (List<Car>) input.readObject();
        input.close();
    }

    public Integer getGasTankVolume() {
        return gasTankVolume;
    }

    public void setGasTankVolume(Integer gasTankVolume) {
        if (gasTankVolume == null || gasTankVolume < 0) {
            throw new RuntimeException("Gas Tank Value cannot be null or negative");
        }
        this.gasTankVolume = gasTankVolume;
    }

    public Integer getGasRatePerHundredKm() {
        return gasRatePerHundredKm;
    }

    public void setGasRatePerHundredKm(Integer gasRatePerHundredKm) {
        if (gasRatePerHundredKm == null || gasRatePerHundredKm < 0) {
            throw new RuntimeException("Gas rate per 100km  cannot be null or negative");
        }
        this.gasRatePerHundredKm = gasRatePerHundredKm;
    }

    public static List<String> getNameOfCars() {
        return nameOfCars;
    }

    public static void setNameOfCars(String nameOfCars) {
        if (nameOfCars == null || "".equals(nameOfCars.trim())) {
            throw new RuntimeException("Name of car can not be null or empty");
        }
        Car.nameOfCars.add(nameOfCars);
    }

    public Integer getRoadPerOneGasTank() {
        if (gasTankVolume == null || gasRatePerHundredKm == null) {
            throw new RuntimeException("Gas tank volume cannot be null!");
        }
        return (gasTankVolume / gasRatePerHundredKm) * 100;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + carName + '\'' +
                ",\n equipment=" + equipment +
                ",\n manufacture=" + manufacture.toString() + "}\n";
    }

    public static List<Car> getCarByEquipment(CarEquipment carEquipment) {
        List<Car> cars = new ArrayList<>();
        for (Car c : carExtent) {
            if (c.equipment == carEquipment) {
                cars.add(c);
            }
        }
        return cars;
    }

    public static List<Car> getCarByCompanyName(String companyName) {
        List<Car> cars = new ArrayList<>();
        for (Car c : carExtent) {
            if (c.manufacture.getCompanyName() == companyName) {
                cars.add(c);
            }
        }
        return cars;
    }
}
