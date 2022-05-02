package edu.pl.mas.s19312.mp4.xOr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private String serviceName;

    private List<Laptop> laptops = new ArrayList<>();

    public Service(String serviceName) {
        setServiceName(serviceName);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        if(serviceName == null || serviceName.trim().equals("")){
            throw new RuntimeException("Service name cannot be null or empty!");
        }
        this.serviceName = serviceName;
    }

    public List<Laptop> getLaptops() {
        return Collections.unmodifiableList(laptops);
    }

    public void addLaptop(Laptop laptop) {
        if(laptop == null){
            throw new RuntimeException("Laptop cannot be null!");
        }
        if(laptops.contains(laptop)){
            return;
        }
        laptops.add(laptop);
        laptop.setService(this);
    }

    public void removeLaptops(Laptop laptop) {
        if(laptop == null){
            throw new RuntimeException("Laptop cannot be null!");
        }
        if(!laptops.contains(laptop)){
            return;
        }
        laptops.remove(laptop);
        laptop.removeService();
    }
}
