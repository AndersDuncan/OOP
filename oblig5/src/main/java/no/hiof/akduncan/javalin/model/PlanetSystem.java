package no.hiof.akduncan.javalin.model;

import java.util.ArrayList;
import java.util.List;

public class PlanetSystem implements Comparable<PlanetSystem> {
    private String name;
    private Star centerStar;
    private ArrayList<Planet> planets;
    private String pictureUrl;


    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public PlanetSystem() {
    }

    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planets, String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
        this.pictureUrl = pictureUrl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }



    @Override
    public String toString() {
       return "Name: " + name + ". CenterStar: " + centerStar.getName() + ". Planets: "  + planets;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;

    }

    public CelestialBody findBiggestPlanet(ArrayList<CelestialBody> planets) {
        CelestialBody biggestPlanet = planets.get(0);

        for(CelestialBody currentPlanet : planets) {
            if (currentPlanet.getRadius() > biggestPlanet.getRadius()) {
                biggestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == biggestPlanet.getRadius()) {
                if (currentPlanet.getMass() > biggestPlanet.getMass())
                    biggestPlanet = currentPlanet;
            }
        }
        return biggestPlanet;
    }

    public CelestialBody findSmallestPlanet(ArrayList<CelestialBody> planets) {
        CelestialBody smallestPlanet = planets.get(0);

        for(CelestialBody currentPlanet : planets) {
            if (currentPlanet.getRadius() < smallestPlanet.getRadius()) {
                smallestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == smallestPlanet.getRadius()) {
                if (currentPlanet.getMass() < smallestPlanet.getMass())
                    smallestPlanet = currentPlanet;
            }
        }
        return smallestPlanet;
    }

     public String printPlanetByName(String planetName) {
            String found = "Planet not found. Check if the first letter is capitalized.";

        for (CelestialBody currentPlanet : planets ){
            if (planetName.equals(currentPlanet.getName())){
                found = currentPlanet.toString();
            }
        }
        return found;
     }


    @Override
    public int compareTo(PlanetSystem o) {
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

