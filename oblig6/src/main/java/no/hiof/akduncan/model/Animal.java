package no.hiof.akduncan.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Amphibians.class, name = "amphibians"),
        @JsonSubTypes.Type(value = Invertebrate.class, name = "invertebrate"),
        @JsonSubTypes.Type(value = Birds.class, name = "birds")
})

public abstract class Animal {
    private int numberOfLegs;
    private String scientificName;
    private String name;
    private String diet;
    private int bodylength;

    public Animal(int numberOfLegs, String scientificName, String name, String diet, int bodylength) {
        this.numberOfLegs = numberOfLegs;
        this.scientificName = scientificName;
        this.name = name;
        this.diet = diet;
        this.bodylength = bodylength;
    }

    public Animal() {
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int getBodylength() {
        return bodylength;
    }

    public void setBodylength(int bodylength) {
        this.bodylength = bodylength;
    }
}
