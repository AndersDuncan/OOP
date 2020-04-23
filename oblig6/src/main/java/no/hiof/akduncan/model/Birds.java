package no.hiof.akduncan.model;

public class Birds extends Animal {
    private int flyingSpeed;
    private String wingColour;
    private int wingspan;

    public Birds(int numberOfLegs, String scientificName, String name, String diet, int bodylength, int flyingSpeed, String wingColour, int wingspan) {
        super(numberOfLegs, scientificName, name, diet, bodylength);
        this.flyingSpeed = flyingSpeed;
        this.wingColour = wingColour;
        this.wingspan = wingspan;
    }

    public Birds() {
    }

    public int getFlyingSpeed() {
        return flyingSpeed;
    }

    public void setFlyingSpeed(int flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }

    public String getWingColour() {
        return wingColour;
    }

    public void setWingColour(String wingColour) {
        this.wingColour = wingColour;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "bleh";
    }
}
