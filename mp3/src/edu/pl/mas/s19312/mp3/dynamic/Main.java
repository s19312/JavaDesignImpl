package edu.pl.mas.s19312.mp3.dynamic;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Weather w1 = new Weather(WeatherType.WINDY, LocalDate.now(),null,11.2,null);
        System.out.println(w1.getDegrees());
        System.out.println(w1.getRainFall());
        System.out.println(w1.getWindSpeed());
        System.out.println(w1.getWeatherType());

        w1.setSunnyWeather(21);
        System.out.println(w1.getDegrees());
        System.out.println(w1.getRainFall());
        System.out.println(w1.getWindSpeed());
        System.out.println(w1.getWeatherType());

        w1.setRainFall(22);
    }
}
