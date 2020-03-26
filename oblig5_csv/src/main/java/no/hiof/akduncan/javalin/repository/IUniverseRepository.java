package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface IUniverseRepository {
    ArrayList<PlanetSystem> getPlanetSystems();
    ArrayList<Planet> getAllPlanets(String name);
    Planet getAPlanet(String systemName, String planetName);
    PlanetSystem getAPlanetSystem(String name);
    void writeToCSV(ArrayList<PlanetSystem> planetSystems, File file);
}



