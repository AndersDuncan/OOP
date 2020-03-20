package no.hiof.akduncan.javalin.controller;

import io.javalin.http.Context;
import no.hiof.akduncan.javalin.model.CelestialBody;
import no.hiof.akduncan.javalin.model.Planet;
import no.hiof.akduncan.javalin.model.PlanetSystem;
import no.hiof.akduncan.javalin.repository.*;
import no.hiof.akduncan.javalin.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanetController {
    private IUniverseRepository universeRepository;

    public PlanetController(IUniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    /*public void getAllPlanets(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String sortBy = ctx.queryParam("sort_by");

        ArrayList<Planet> allPlanetsinSystem = universeRepository.getAllPlanets(relevantSystem);


            switch (sortBy) {
                case "num":
                    break;
                case "name":
                    allPlanetsinSystem.sort(Comparator.comparing(CelestialBody::getName));
                    break;
                case "mass":
                    allPlanetsinSystem.sort(Comparator.comparing(CelestialBody::getMass).reversed());
                    break;
                case "radius":
                    allPlanetsinSystem.sort(Comparator.comparing(CelestialBody::getRadius).reversed());
                    break;
            }
        ctx.json(allPlanetsinSystem);
        }

    public void getAPlanet(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String relevantPlanet = ctx.pathParam(":planet-id");

        Planet aPlanet = universeRepository.getAPlanet(relevantSystem, relevantPlanet);

        ctx.json(aPlanet);

    }

     */



}
