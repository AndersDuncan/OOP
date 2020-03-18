package no.hiof.akduncan.oblig2;

public class Star extends CelestialBody {
    private double effectiveTemp;
    public static final double Msun = 1.98892*(Math.pow(10,30));
    public static final double Rsun = 695700;

    public Star(String name, double mass, double radius, double effectiveTemp){

        super(name, mass, radius);
        this.effectiveTemp = effectiveTemp;
    }

    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    public double massInMsun() {
        return getMass() / Msun;
    }

    public double radiusInRsun() {
        return getRadius() / Rsun;
    }

    @Override
    public String toString(){
        return "Name: " + super.getName() + ". radius: " + super.getRadius() + " km . mass: " + super.getMass() + " kg . Temp: " + effectiveTemp
                + " Kelvin. And it's mass in Msun is: " + massInMsun() + " with radius in Rsun being: " + radiusInRsun();
    }

    /*public void printStar() {
        System.out.println("Name: " + name + ". radius: " + radius + " km . mass: " + mass + " kg . Temp: " + effectiveTemp
        + " Kelvin. And it's mass in Msun is: " + massInMsun() + " with radius in Rsun being: " + radiusInRsun());
    }*/
}


