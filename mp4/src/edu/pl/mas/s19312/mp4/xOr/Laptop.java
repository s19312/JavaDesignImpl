package edu.pl.mas.s19312.mp4.xOr;

import java.io.Serializable;

public class Laptop {
    private int id;
    private String brand;

    private Service service;
    private Store store;

    public Laptop(int id, String brand) {
        setId(id);
        setBrand(brand);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new RuntimeException("Id cannot be negative!");
        }
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().equals("")){
            throw new RuntimeException("Brand cannot be null or empty!");
        }
        this.brand = brand;
    }

    public Service getService() {
        if(this.service == null){
            throw new RuntimeException("Laptop is not in the Service!");
        }
        return service;
    }

    public Store getStore() {
        if(this.store == null){
            throw new RuntimeException("Laptop is not in the Store!");
        }
        return store;
    }

    public void setService(Service service) {
        if(service == null){
            throw new RuntimeException("service cannot be null!");
        }
        if(this.service == service){
            return;
        }
        if(this.service != null){
            removeService();
        }else{
            removeStore();
        }
        this.service = service;
        service.addLaptop(this);
    }

    public void removeService() {
        if(this.service == null){
            return;
        }
        Service tmp = this.service;
        this.service = null;
        tmp.removeLaptops(this);
    }

    public void setStore(Store store) {
        if(store == null){
            throw new RuntimeException("service cannot be null!");
        }
        if(this.store == store){
            return;
        }
        if(this.store != null){
            removeStore();
        }else{
            removeService();
        }
        this.store = store;
        store.addLaptop(this);
    }

    public void removeStore() {
        if(this.store == null){
            return;
        }
        Store tmp = this.store;
        this.store = null;
        tmp.removeLaptops(this);
    }
}
