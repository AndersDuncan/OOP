package no.hiof.akduncan.javalin.model;

public class Star extends CelestialBody {
    private double effectiveTemperature;
    private String pictureUrl;
    public static final double Msun = 1.98892*(Math.pow(10,30));
    public static final double Rsun = 695700;

    public Star(String name, double mass, double radius, String pictureUrl, double effectiveTemperature){

        super(name, mass, radius);
        this.effectiveTemperature = effectiveTemperature;
        this.pictureUrl = pictureUrl;
    }

    public Star() {
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getEffectiveTemperature() {
        return effectiveTemperature;
    }

    public void setEffectiveTemperature(double effectiveTemp) {
        this.effectiveTemperature = effectiveTemp;
    }

    public double massInMsun() {
        return getMass() / Msun;
    }

    public double radiusInRsun() {
        return getRadius() / Rsun;
    }

    public static double getMsun() {
        return Msun;
    }

    public static double getRsun() {
        return Rsun;
    }

    @Override
    public String toString(){
        return "Name: " + super.getName() + ". radius: " + super.getRadius() + " km . mass: " + super.getMass() + " kg . Temp: " + effectiveTemperature
                + " Kelvin. And it's mass in Msun is: " + massInMsun() + " with radius in Rsun being: " + radiusInRsun();
    }

    /*public void printStar() {
        System.out.println("Name: " + name + ". radius: " + radius + " km . mass: " + mass + " kg . Temp: " + effectiveTemp
        + " Kelvin. And it's mass in Msun is: " + massInMsun() + " with radius in Rsun being: " + radiusInRsun());
    }*/
}


