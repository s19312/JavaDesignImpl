package edu.pl.mas.s19312.mp3.multiInheritance;
public class MixedDevice extends Phone implements ITablet {
    private double screenSize;

    public MixedDevice(String brand, int RAM, int numberSIMSlots, double screenSize) {
        super(brand, RAM, numberSIMSlots);
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
