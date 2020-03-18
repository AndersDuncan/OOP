package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import java.util.ArrayList;

public interface IUniverseRepository {
    ArrayList<PlanetSystem> getPlanetSystems();
    ArrayList<Planet> getAllPlanets(String name);
    Planet getAPlanet(String systemName, String planetName);
    PlanetSystem getAPlanetSystem(String name);
}



