package no.hiof.akduncan.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

public class Observation implements Comparable<Observation>{
    private Animal animal;
    private String name;
    private Habitat location;
    private int id;
    private String comment;
    private String picture;
    private LocalDate timeOfDiscovery;
    private int estimatedPopulation;

    public Observation(Animal animal, String name, Habitat location, int id, String comment, String picture, LocalDate timeOfDiscovery, int estimatedPopulation) {
        this.animal = animal;
        this.name = name;
        this.location = location;
        this.id = id;
        this.comment = comment;
        this.picture = picture;
        this.timeOfDiscovery = timeOfDiscovery;
        this.estimatedPopulation = estimatedPopulation;
    }

    public Observation() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Habitat getLocation() {
        return location;
    }

    public void setLocation(Habitat location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public LocalDate getTimeOfDiscovery() {
        return timeOfDiscovery;
    }

    public void setTimeOfDiscovery(LocalDate timeOfDiscovery) {
        this.timeOfDiscovery = timeOfDiscovery;
    }

    public int getEstimatedPopulation() {
        return estimatedPopulation;
    }

    public void setEstimatedPopulation(int estimatedPopulation) {
        this.estimatedPopulation = estimatedPopulation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Observation o){
        int compare = this.getAnimal().getName().compareTo(o.getAnimal().getName());
        if (compare < 0){
            return -1;
        }
        else if(compare > 0){
            return 1;
        }
        return 0;
    }
}
