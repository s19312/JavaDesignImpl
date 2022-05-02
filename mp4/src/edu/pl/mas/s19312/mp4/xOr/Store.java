package edu.pl.mas.s19312.mp4.xOr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private String storeName;

    private List<Laptop> laptops = new ArrayList<>();

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<Laptop> getLaptops() {
        return Collections.unmodifiableList(laptops);
    }

    public void setStoreName(String storeName) {
        if (storeName == null || storeName.trim().equals("")) {
            throw new RuntimeException("Store name cannot be null or empty!");
        }
        this.storeName = storeName;
    }

    public void addLaptop(Laptop laptop) {
        if (laptop == null) {
            throw new RuntimeException("Laptop cannot be null!");
        }
        if (laptops.contains(laptop)) {
            return;
        }
        laptops.add(laptop);
        laptop.setStore(this);
    }

    public void removeLaptops(Laptop laptop) {
        if (laptop == null) {
            throw new RuntimeException("Laptop cannot be null!");
        }
        if (!laptops.contains(laptop)) {
            return;
        }
        laptops.remove(laptop);
        laptop.removeStore();
    }
}
