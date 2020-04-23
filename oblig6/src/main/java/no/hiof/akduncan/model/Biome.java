package no.hiof.akduncan.model;

public class Biome{
    private String environment;
    private String weatherConditions;

    public Biome(String environment, String weatherConditions) {
        this.environment = environment;
        this.weatherConditions = weatherConditions;

    }

    public Biome() {
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }
}
