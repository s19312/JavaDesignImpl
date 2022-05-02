package edu.pl.mas.s19312.mp3.multiInheritance;

public abstract class ElectronicDevice {
    private String brand;
    private int RAM;

    public ElectronicDevice(String brand, int RAM) {
        setBrand(brand);
        setRAM(RAM);
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

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        if(RAM < 0){
            throw new RuntimeException("RAM value cannot be negative!");
        }
        this.RAM = RAM;
    }
}
