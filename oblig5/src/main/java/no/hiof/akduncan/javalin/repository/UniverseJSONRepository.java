package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UniverseJSONRepository implements IUniverseRepository {

    ArrayList<PlanetSystem> newList = fromJson("planets_100.json");


    public ArrayList<PlanetSystem> fromJson(String filename) {
        ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            PlanetSystem[] systemArray = objectMapper.readValue(new File(filename), PlanetSystem[].class);

            planetSystems.addAll(Arrays.asList(systemArray));
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        System.out.println(planetSystems);
        return planetSystems;
    }

    public class saveRunnable implements Runnable{
        private String filename;
        private ArrayList<PlanetSystem> planetSystems;
        public saveRunnable(String filename, ArrayList<PlanetSystem> planetSystems){
            this.filename = filename;
            this.planetSystems = planetSystems;
        }
        @Override
        public void run() {
            try {
                File file = new File(filename);
                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, planetSystems);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToJson(String filename, ArrayList<PlanetSystem> planetSystems) {
        Runnable save = new saveRunnable(filename,planetSystems);
        new Thread(save).start();
    }

    //Easier to have it here when switching between repositories
    @Override
    public void writeToCsv(ArrayList<PlanetSystem> planetSystems, File file) {

    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return newList;
    }

    @Override
    public PlanetSystem getAPlanetSystem(String name) {

        for (PlanetSystem planetSystem : newList) {
            if (planetSystem.getName().equals(name))
                return planetSystem;
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets(String name) {
        PlanetSystem relevantSystem = getAPlanetSystem(name);

        if(relevantSystem != null) {
            return relevantSystem.getPlanets();
        }
        return new ArrayList<>();

    }


    @Override
    public Planet getAPlanet(String systemName, String planetName) {
        PlanetSystem aSystem = getAPlanetSystem(systemName);

        if (aSystem != null) {
            for(Planet aPlanet: aSystem.getPlanets()) {
                if (aPlanet.getName().equals(planetName))
                    return aPlanet;
            }
        }
        return null;
    }

    @Override
    public void deletePlanet(String systemName, String planetName) {
        PlanetSystem aSystem = getAPlanetSystem(systemName);

        if (aSystem != null) {
            for(Iterator<Planet> iterator = aSystem.getPlanets().iterator(); iterator.hasNext();){
                Planet aPlanet = iterator.next();
                if(aPlanet.getName().equals(planetName)){
                    iterator.remove();
                }
            }
        }
    }



    @Override
    public Planet makePlanet(String systemName, String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        return new Planet(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
    }

}



