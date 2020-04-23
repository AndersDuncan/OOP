package no.hiof.akduncan.repository;

import no.hiof.akduncan.model.*;

import java.io.IOException;
import java.util.ArrayList;

public interface ObservationInterface {
    void saveToJson(String filname, ArrayList<Observation> name) throws IOException;
    ArrayList<Observation> getObservations();
    Observation getAnObservation(String name);
    Animal getAnAnimal(String obsName);
    void deleteAnObservation(String obsName);
}
