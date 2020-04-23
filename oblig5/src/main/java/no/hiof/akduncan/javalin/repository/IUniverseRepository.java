package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface IUniverseRepository {
    ArrayList<PlanetSystem> getPlanetSystems();
    ArrayList<Planet> getAllPlanets(String name);
    Planet getAPlanet(String systemName, String planetName);
    PlanetSystem getAPlanetSystem(String name);
    Planet makePlanet(String systemName, String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod,CelestialBody centralCelestialBody, String pictureUrl);
    void deletePlanet(String systemName, String planetName);
    void saveToJson(String filename, ArrayList<PlanetSystem> name);
    void writeToCsv(ArrayList<PlanetSystem> planetSystems, File file);
}



