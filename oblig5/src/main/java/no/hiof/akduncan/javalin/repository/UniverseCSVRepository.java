package no.hiof.akduncan.javalin.repository;


import no.hiof.akduncan.javalin.model.*;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class UniverseCSVRepository implements IUniverseRepository{

    File source = new File("planets_100.csv");

    HashMap<String, PlanetSystem> newMap = new HashMap<>();

    {
        try {
            newMap = fromCSV(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, PlanetSystem> fromCSV(File file) throws IOException {
        HashMap<String, PlanetSystem> systemMap = new HashMap<>();
        String meh = new String(Files.readAllBytes(file.toPath()));

        for (String line : meh.split("\n")) {
            String[] item = line.split(",", -1);

            String systemName = item[0];
            String systemPic = item[1];
            String starName = item[2];
            String starMass = item[3];
            String starRadius = item[4];
            String starEffectiveTemp = item[5];
            String starPic = item[6];
            String planetName = item[7];
            String planetMass = item[8];
            String planetRadius = item[9];
            String planetSemiMajorAxis = item[10];
            String planetEccentricity = item[11];
            String planetOrbital = item[12];
            String planetPic = item[13];

            double parsedStarMass = (Double.parseDouble(starMass));
            double parsedStarRadius = (Double.parseDouble(starRadius));
            double parsedStarEffectiveTemp = (Double.parseDouble(starEffectiveTemp));
            double parsedPlanetMass = (Double.parseDouble(planetMass));
            double parsedPlanetRadius = (Double.parseDouble(planetRadius));
            double parsedPlanetSemiMajorAxis = (Double.parseDouble(planetSemiMajorAxis));
            double parsedPlanetEccentricity = (Double.parseDouble(planetEccentricity));
            double parsedPlanetOrbital = (Double.parseDouble(planetOrbital));

            PlanetSystem tempSystem;
            Star tempStar;

            if (systemMap.containsKey(systemName)) {
                tempSystem = systemMap.get(systemName);

                tempStar = tempSystem.getCenterStar();
            } else {
                tempStar = new Star(starName, parsedStarMass, parsedStarRadius, starPic, parsedStarEffectiveTemp);
                tempSystem = new PlanetSystem(systemName, tempStar, systemPic);
            }
            tempSystem.addPlanet(new Planet(planetName, parsedPlanetMass, parsedPlanetRadius, parsedPlanetSemiMajorAxis, parsedPlanetEccentricity, parsedPlanetOrbital, tempStar, planetPic));
            systemMap.put(systemName, tempSystem);

        }
        return systemMap;
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        System.out.println(newMap);
        return new ArrayList<PlanetSystem>(newMap.values());

    }

    @Override
    public ArrayList<Planet> getAllPlanets(String name) {
        return newMap.get(name).getPlanets();

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
    public PlanetSystem getAPlanetSystem(String name) {
        return newMap.get(name);
    }

    //Easier to have it here when switching between repositories
    @Override
    public Planet makePlanet(String systemName, String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        return null;
    }

    //Easier to have it here when switching between repositories
    @Override
    public void deletePlanet(String systemName, String planetName) {

    }

    //Easier to have it here when switching between repositories
    @Override
    public void saveToJson(String filename, ArrayList<PlanetSystem> name) {

    }

    @Override
    public void writeToCsv(ArrayList<PlanetSystem> planetSystems, File file) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

                for( PlanetSystem aSystem : planetSystems ) {

                    for( Planet aPlanet : aSystem.getPlanets()){
                        bufferedWriter.write(aSystem.getName() + "," + aSystem.getPictureUrl() + "," + aSystem.getCenterStar().getName() + "," + aSystem.getCenterStar().getMass() + ","
                                + aSystem.getCenterStar().getRadius() + "," + aSystem.getCenterStar().getEffectiveTemperature() + "," + aSystem.getCenterStar().getPictureUrl() + "," + aPlanet.getName() + "," + aPlanet.getMass() + "," +
                                aPlanet.getRadius() + "," + aPlanet.getSemiMajorAxis() + "," + aPlanet.getEccentricity() + "," + aPlanet.getOrbitalPeriod() + "," + aPlanet.getPictureUrl() + "\n");
                    }

                }
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
            } catch (IOException ioexc) {
                System.out.println(ioexc.getLocalizedMessage());
            }

        }
    }





