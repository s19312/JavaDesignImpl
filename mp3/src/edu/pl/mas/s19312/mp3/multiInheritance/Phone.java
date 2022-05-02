package edu.pl.mas.s19312.mp3.multiInheritance;

public class Phone extends ElectronicDevice{
    private int numberSIMSlots;

    public Phone(String brand, int RAM, int numberSIMSlots) {
        super(brand, RAM);
        setNumberSIMSlots(numberSIMSlots);
    }

    public int getNumberSIMSlots() {
        return numberSIMSlots;
    }

    public void setNumberSIMSlots(int numberSIMSlots) {
        if(numberSIMSlots < 0){
            throw new RuntimeException("Number Of Cameras cannot be negative!");
        }
        this.numberSIMSlots = numberSIMSlots;
    }
}
