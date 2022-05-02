package edu.pl.mas.s19312.mp3.multiInheritance;

public class Tablet extends ElectronicDevice implements ITablet {
    private double screenSize;

    public Tablet(String brand, int RAM, double screenSize) {
        super(brand, RAM);
        setScreenSize(screenSize);
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public void setScreenSize(double screenSize) {
        if(screenSize < 0){
            throw new RuntimeException("Screen size cannot be negative!");
        }
        this.screenSize = screenSize;
    }
}
