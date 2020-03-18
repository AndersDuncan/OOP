package no.hiof.akduncan.javalin.model;

public abstract class CelestialBody implements Comparable<Planet>{
    private String name;
    private double radius;
    private double mass;

    public CelestialBody(String name, double mass, double radius) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
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
    public int compareTo(Planet o) {
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
