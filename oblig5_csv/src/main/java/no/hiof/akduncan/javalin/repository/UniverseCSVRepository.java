package no.hiof.akduncan.javalin.repository;


import no.hiof.akduncan.javalin.model.*;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class UniverseCSVRepository implements IUniverseRepository{

    File source = new File("planets_100.csv");

    HashMap<String, PlanetSystem> newMap = fromCSV(source);

    private HashMap<String, PlanetSystem> fromCSV(File file){
        HashMap<String, PlanetSystem> systemMap = new HashMap<>();
        String meh = "";

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                meh += scanner.nextLine() + "\n";
            }
        }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        System.out.println(meh);
        List<String> items = Arrays.asList(meh.split("\\r_\\n"));
        for(String item : items) {
            List<String> items2 = Arrays.asList(item.split(","));

            double starMass = parseDouble(items2.get(3)),
                    starRadius = parseDouble(items2.get(4)),
                    starEffectiveTemperatur = parseDouble(items2.get(5));

            Star tmpStar = new Star(items2.get(2), starMass, starRadius, items2.get(6), starEffectiveTemperatur);
            PlanetSystem tmpSystem = new PlanetSystem(items2.get(0), tmpStar, items2.get(0));
            if(!systemMap.containsKey(items2.get(0))){
                systemMap.put(items2.get(0), tmpSystem);
            }
            double planetMass = parseDouble(items2.get(8)),
                    planetRadius = parseDouble(items2.get(9)),
                    planetAxis = parseDouble(items2.get(10)),
                    planetEccentricity = parseDouble(items2.get(11)),
                    planetOrbitalPeriod = parseInt(items2.get(12));

            Planet tempPlanet = new Planet(items2.get(7), planetMass, planetRadius, planetAxis, planetEccentricity, (int) planetOrbitalPeriod, tmpStar, items2.get(13));
            systemMap.get(items2.get(0)).addPlanet(tempPlanet);
            //System.out.println("a print: " + systemMap.get(items2.get(0)));
        }
        return systemMap;
    }

    @Override
    public PlanetSystem getPlanetSystems() {
        for (String key : newMap.keySet()) {
            return newMap.get(key);
        }

        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets() {
        return null;
    }

    @Override
    public Planet getAPlanet() {
        return null;
    }

    @Override
    public no.hiof.akduncan.javalin.model.PlanetSystem getAPlanetSystem() {
        return null;
    }
}

