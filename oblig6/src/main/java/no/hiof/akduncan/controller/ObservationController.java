package no.hiof.akduncan.controller;

import io.javalin.http.Context;
import no.hiof.akduncan.model.*;
import no.hiof.akduncan.repository.ObservationInterface;

import java.io.IOException;
import java.util.ArrayList;

public class ObservationController {
    private ObservationInterface observationInterface;

    public ObservationController(ObservationInterface observationInterface){
        this.observationInterface = observationInterface;
    }

    public void getAllObservations(Context ctx) throws IOException {
        ArrayList<Observation> allObservations = observationInterface.getObservations();

        ctx.json(allObservations);

        observationInterface.saveToJson("observations.json", allObservations);
    }

    public void getObservation(Context ctx){
        String observationName = ctx.pathParam(":observation-id");

        Observation observation = observationInterface.getAnObservation(observationName);
        ctx.json(observation);
    }

    public void getAnimal(Context ctx){
        String observationName = ctx.pathParam(":observation-id");

        Animal anAnimal = observationInterface.getAnAnimal(observationName);
        ctx.json(anAnimal);
    }

    public void updateAnimal(Context ctx){
        String observationName = ctx.pathParam(":observation-id");

        String name = ctx.formParam("name");
        String scientificName = ctx.formParam("scientificName");
        String diet = ctx.formParam("diet");
        int legs = Integer.parseInt(ctx.formParam("numberOfLegs"));
        int bodylength = Integer.parseInt(ctx.formParam("bodylength"));
        Animal anAnimal = observationInterface.getAnAnimal(observationName);
        anAnimal.setName(name);
        anAnimal.setScientificName(scientificName);
        anAnimal.setDiet(diet);
        anAnimal.setNumberOfLegs(legs);
        anAnimal.setBodylength(bodylength);
    }
}
