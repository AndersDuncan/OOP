package no.hiof.akduncan.javalin.repository;

import no.hiof.akduncan.javalin.model.*;

import java.util.ArrayList;

public interface IUniverseRepository {
    PlanetSystem getPlanetSystems();
    ArrayList<Planet> getAllPlanets();
    Planet getAPlanet();
    PlanetSystem getAPlanetSystem();
}



