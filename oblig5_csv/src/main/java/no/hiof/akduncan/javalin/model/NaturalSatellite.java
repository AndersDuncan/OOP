package no.hiof.akduncan.javalin.model;
import java.util.ArrayList;

import static no.hiof.akduncan.javalin.model.Planet.gravity;

public abstract class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis;
    private double eccentricity;
    private double orbitalPeriod;
    private CelestialBody centralCelestialBody;
    public static final int AU = 149597871;

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, mass, radius);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }

    public NaturalSatellite() {
    }

    public static int getAU() {
        return AU;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }

    public double distanceToCentralBody(double degrees) {
        double toRadians = Math.toRadians(degrees);
        double distanceFormula = (getSemiMajorAxis() * (1 - Math.pow(getEccentricity(),2))) / (1 + getEccentricity() * Math.cos(toRadians));
        return (distanceFormula * AU);
    }

    public double orbitingVelocity(double distance) {
        double kmToM = distance * 1000;
        double speedFormula = Math.sqrt((gravity * centralCelestialBody.getMass()) / kmToM);
        return speedFormula / 1000;
    }
}
