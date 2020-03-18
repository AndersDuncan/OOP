package no.hiof.akduncan.javalin.model;

public class Planet extends NaturalSatellite{

    public static final double Mjup = 1.898*(Math.pow(10,27));
    public static final double Rjup = 71492;
    public static final double gravity = 0.00000000006674;
    private String pictureUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureURL(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, int orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
        this.pictureUrl = pictureUrl;
    }

    public double massInMjup() {
        return super.getMass() / Mjup;
    }

    public double radiusInRjup() {
        return super.getRadius() / Rjup;
    }

    public double surfaceGravity() {
        double kmToM = super.getRadius() * 1000;
        return (super.getMass()*gravity) / (Math.pow(kmToM,2));
    }

    @Override
    public String toString(){
        return "Name: " + super.getName() + ". radius: " + super.getRadius() + " km. mass: " + super.getRadius()
                + " kg. It's mass in Mjup is: " + massInMjup() + " and radius in Rjup is: " + radiusInRjup()+
                ". It has a surface gravity of: " + surfaceGravity() + " m/s^2"+"\n";
    }
}


