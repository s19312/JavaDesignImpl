package edu.pl.mas.s19312.mp3.dynamic;

import java.time.LocalDate;

public class Weather implements RainyWeather, WindyWeather, SunnyWeather {
    private LocalDate date;
    private Double rainFall, windSpeed, degrees;
    private WeatherType weatherType;

    public Weather(WeatherType weatherType, LocalDate date, Double rainFall, Double windSpeed, Double degrees) {
        setDate(date);
        setWeatherType(weatherType);
        if (isWeatherRainy()) {
            setRainyWeather(rainFall);
        }
        if (isWeatherSunny()) {
            setSunnyWeather(degrees);
        }
        if (isWeatherWindy()) {
            setWindyWeather(windSpeed);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new RuntimeException("Date cannot be null!");
        }
        this.date = date;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    private void setWeatherType(WeatherType weatherType) {
        if (weatherType == null) {
            throw new RuntimeException("Weather type cannot be null!");
        }
        this.weatherType = weatherType;
    }

    @Override
    public Double getRainFall() {
        return rainFall;
    }

    @Override
    public void setRainFall(double rainFall) {
        if (!isWeatherRainy()) {
            throw new RuntimeException("Weather is not rainy!");
        }
        this.rainFall = rainFall;
    }

    @Override
    public Double getDegrees() {
        return degrees;
    }

    @Override
    public void setDegrees(double degrees) {
        if (!isWeatherSunny()) {
            throw new RuntimeException("Weather is not sunny!");
        }
        this.degrees = degrees;
    }

    @Override
    public Double getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public void setWindSpeed(double windSpeed) {
        if (!isWeatherWindy()) {
            throw new RuntimeException("Weather is not windy!");
        }
        this.windSpeed = windSpeed;
    }

    public void setWindyWeather(double windSpeed){
        if(isWeatherRainy()){
            this.rainFall = null;
            setWeatherType(WeatherType.WINDY);
        }else if(isWeatherSunny()){
            this.degrees = null;
            setWeatherType(WeatherType.WINDY);
        }
        setWindSpeed(windSpeed);
    }

    public void setSunnyWeather(double degrees){
        if(isWeatherRainy()){
            this.rainFall = null;
            setWeatherType(WeatherType.SUNNY);
        }else if(isWeatherWindy()){
            this.windSpeed = null;
            setWeatherType(WeatherType.SUNNY);
        }
        setDegrees(degrees);
    }

    public void setRainyWeather(double rainFall){
        if(isWeatherSunny()){
            this.degrees = null;
            setWeatherType(WeatherType.RAINY);
        }else if(isWeatherWindy()){
            this.windSpeed = null;
            setWeatherType(WeatherType.RAINY);
        }
        setRainFall(rainFall);
    }

    public boolean isWeatherSunny() {
        return weatherType.equals(WeatherType.SUNNY);
    }

    public boolean isWeatherRainy() {
        return weatherType.equals(WeatherType.RAINY);
    }

    public boolean isWeatherWindy() {
        return weatherType.equals(WeatherType.WINDY);
    }

}
