package edu.pl.mas.s19312.mp3.multiInheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        List<ITablet> tablets = new ArrayList<>();

        MixedDevice mx = new MixedDevice("Asus",4,1,3.3);
        phones.add(mx);
        tablets.add(mx);
    }
}
