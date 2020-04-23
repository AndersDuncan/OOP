package no.hiof.akduncan.model;

public class Habitat{
    private Biome biome;
    private double latitude;
    private double longitude;
    private String foodsource;
    private Planet planet;

    public Habitat(Biome biome, double latitude, double longitude, String foodsource, Planet planet) {
        this.biome = biome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foodsource = foodsource;
        this.planet = planet;
    }

    public Habitat() {
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getFoodsource() {
        return foodsource;
    }

    public void setFoodsource(String foodsource) {
        this.foodsource = foodsource;
    }
}
