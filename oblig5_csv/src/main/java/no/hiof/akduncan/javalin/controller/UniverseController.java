package no.hiof.akduncan.javalin.controller;

import io.javalin.http.Context;
import no.hiof.akduncan.javalin.model.PlanetSystem;
import no.hiof.akduncan.javalin.repository.IUniverseRepository;
import no.hiof.akduncan.javalin.Application;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniverseController {
    private IUniverseRepository universeRepository;

    public UniverseController(IUniverseRepository universeCSVRepository) {
        this.universeRepository = universeCSVRepository;
    }


    public void getAllSystems(Context context) {
        //String name = context.pathParam(":planet-system-id");

        ArrayList<PlanetSystem> allSystems = universeRepository.getPlanetSystems();
        universeRepository.writeToCSV(universeRepository.getPlanetSystems(), new File("planets_100.csv"));
        context.json(allSystems);

    }


    public void getAPlanetSystem(Context context) {
        String systemID = context.pathParam(":planet-system-id");

        PlanetSystem aSystem = universeRepository.getAPlanetSystem(systemID);


       context.json(aSystem);
    }
}




    public void skriftilFIL(File kilde) {
        run()
        //method body
    }
