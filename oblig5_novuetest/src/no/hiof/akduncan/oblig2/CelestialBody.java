package no.hiof.akduncan.oblig2;

public abstract class CelestialBody implements Comparable<CelestialBody>{
    private String name;
    private double radius;
    private double mass;

    public CelestialBody() {

    }

    public CelestialBody(String name, double mass, double radius) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }


    public double getRadius() {
        return radius;
    }


    public double getMass() {
        return mass;
    }

    @Override
    public int compareTo(CelestialBody o) {
        int compare = this.getName().compareTo(o.getName());
        if (compare < 0) {
            return -1;
        }
        else if (compare > 0){
            return 1;
        }
        return 0;
    }
}
