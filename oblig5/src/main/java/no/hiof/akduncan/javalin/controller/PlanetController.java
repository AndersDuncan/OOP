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


    public void getAPlanet(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String relevantPlanet = ctx.pathParam(":planet-id");

        Planet aPlanet = universeRepository.getAPlanet(relevantSystem, relevantPlanet);

        ctx.json(aPlanet);

    }

    public void getAllPlanets(Context ctx) {
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

    public void deleteAPlanet(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String relevantPlanet = ctx.pathParam(":planet-id");


        universeRepository.deletePlanet(relevantSystem, relevantPlanet);


        universeRepository.saveToJson("planets_100.json", universeRepository.getPlanetSystems());
        ctx.redirect("/planet-systems/" + relevantSystem);
    }

    public void createAPlanet(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String name = ctx.formParam("name");
        double mass = Double.parseDouble(ctx.formParam("mass"));
        double radius = Double.parseDouble(ctx.formParam("radius"));
        double semiMajorAxis = Double.parseDouble(ctx.formParam("semiMajorAxis"));
        double eccentricity = Double.parseDouble(ctx.formParam("eccentricity"));
        double orbitalPeriod = Double.parseDouble(ctx.formParam("orbitalPeriod"));
        String pictureUrl = ctx.formParam("pictureUrl");
        CelestialBody centerStar = universeRepository.getAPlanetSystem(relevantSystem).getCenterStar();
        Planet usermade = universeRepository.makePlanet(relevantSystem,name,mass,radius,semiMajorAxis,eccentricity,orbitalPeriod,centerStar,pictureUrl);
        universeRepository.getAllPlanets(relevantSystem).add(usermade);

        universeRepository.saveToJson("planets_100.json", universeRepository.getPlanetSystems());
        ctx.json(usermade);
        ctx.redirect("/planet-systems/" + relevantSystem);
    }

    public void updateAPlanet(Context ctx) {
        String relevantSystem = ctx.pathParam(":planet-system-id");
        String relevantPlanet = ctx.pathParam(":planet-id");

        String name = ctx.formParam("name");
        double mass = Double.parseDouble(ctx.formParam("mass"));
        double radius = Double.parseDouble(ctx.formParam("radius"));
        double semiMajorAxis = Double.parseDouble(ctx.formParam("semiMajorAxis"));
        double eccentricity = Double.parseDouble(ctx.formParam("eccentricity"));
        double orbitalPeriod = Double.parseDouble(ctx.formParam("orbitalPeriod"));
        String pictureUrl = ctx.formParam("pictureUrl");
        Planet aPlanet = universeRepository.getAPlanet(relevantSystem, relevantPlanet);
        aPlanet.setName(name);
        aPlanet.setMass(mass);
        aPlanet.setRadius(radius);
        aPlanet.setSemiMajorAxis(semiMajorAxis);
        aPlanet.setEccentricity(eccentricity);
        aPlanet.setOrbitalPeriod(orbitalPeriod);
        aPlanet.setPictureUrl(pictureUrl);

        universeRepository.saveToJson("planets_100.json", universeRepository.getPlanetSystems());
        ctx.json(aPlanet);
        ctx.redirect("/planet-systems/" + relevantSystem);
    }

}
