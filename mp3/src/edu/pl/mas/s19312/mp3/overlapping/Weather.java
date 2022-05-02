package edu.pl.mas.s19312.mp3.overlapping;

import java.time.LocalDate;
import java.util.Collections;
import java.util.EnumSet;

public class Weather implements RainyWeather, WindyWeather, SunnyWeather {
    private LocalDate date;
    private Double rainFall, windSpeed, degrees;

    private EnumSet<WeatherType> weatherTypes;

    public Weather(EnumSet<WeatherType> weatherTypes,LocalDate date, Double rainFall, Double windSpeed, Double degrees) {
        setDate(date);
        setWeatherTypes(weatherTypes);
        if(isWeatherRainy()){
            setRainFall(rainFall);
        }
        if(isWeatherSunny()){
            setDegrees(degrees);
        }
        if(isWeatherWindy()){
            setWindSpeed(windSpeed);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if(date == null){
            throw new RuntimeException("Date cannot be null!");
        }
        this.date = date;
    }

    public EnumSet<WeatherType> getWeatherTypes() {
        return (EnumSet<WeatherType>) Collections.unmodifiableSet(weatherTypes);
    }

    private void setWeatherTypes(EnumSet<WeatherType> weatherTypes) {
        if(weatherTypes == null || weatherTypes.size() < 1){
            throw new RuntimeException("Weather types cannot be null or empty!");
        }
        this.weatherTypes = weatherTypes;
    }

    @Override
    public double getRainFall() {
        if(!isWeatherRainy()){
            throw new RuntimeException("Weather is not rainy!");
        }
        return this.rainFall;
    }

    @Override
    public void setRainFall(double rainFall) {
        if(!isWeatherRainy()){
            throw new RuntimeException("Weather is not rainy!");
        }
        this.rainFall = rainFall;
    }

    @Override
    public double getDegrees() {
        if(!isWeatherSunny()){
            throw new RuntimeException("Weather is not sunny!");
        }
        return this.degrees;
    }

    @Override
    public void setDegrees(double degrees) {
        if(!isWeatherSunny()){
            throw new RuntimeException("Weather is not sunny!");
        }
        this.degrees = degrees;
    }

    @Override
    public double windSpeed() {
        if(!isWeatherWindy()){
            throw new RuntimeException("Weather is not windy!");
        }
        return this.windSpeed;
    }

    @Override
    public void setWindSpeed(double windSpeed) {
        if(!isWeatherWindy()){
            throw new RuntimeException("Weather is not windy!");
        }
        this.windSpeed  = windSpeed;
    }

    public boolean isWeatherSunny(){
        return this.weatherTypes.contains(WeatherType.SUNNY);
    }

    public boolean isWeatherRainy(){
        return this.weatherTypes.contains(WeatherType.RAINY);
    }

    public boolean isWeatherWindy(){
        return this.weatherTypes.contains(WeatherType.WINDY);
    }


}
