package no.hiof.akduncan.model;

import java.util.ArrayList;

public class Planet {
    private ArrayList<Habitat> habitats = new ArrayList<>();
    private String name;
    private double radius;
    private double mass;
    private String system;

    public Planet(ArrayList<Habitat> habitats, String name, double radius, double mass, String system) {
        this.habitats = habitats;
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.system = system;
    }

    public Planet(String name, double radius, double mass, String system) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.system = system;
    }

    public Planet() {
    }

    public void addHabitat(Habitat habitat){
        habitats.add(habitat);
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
