package edu.pl.mas.s19312.mp3.overlapping;

import java.time.LocalDate;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        Weather w1 = new Weather(EnumSet.of(WeatherType.RAINY), LocalDate.now(),3.0,null,null);
        System.out.println(w1.getRainFall());

        //error
        w1.setDegrees(23);
        //error
        System.out.println(w1.getDegrees());
    }
}
