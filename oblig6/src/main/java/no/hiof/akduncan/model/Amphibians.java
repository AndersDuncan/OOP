package no.hiof.akduncan.model;

public class Amphibians extends Animal{
    private String methodOfBreathing;
    private String eggFertilizing;

    public Amphibians(int numberOfLegs, String scientificName, String name, String diet, int bodylength, String methodOfBreathing, String eggFertilizing) {
        super(numberOfLegs, scientificName, name, diet, bodylength);
        this.methodOfBreathing = methodOfBreathing;
        this.eggFertilizing = eggFertilizing;
    }

    public Amphibians() {
    }

    public String getMethodOfBreathing() {
        return methodOfBreathing;
    }

    public void setMethodOfBreathing(String methodOfBreathing) {
        this.methodOfBreathing = methodOfBreathing;
    }

    public String getEggFertilizing() {
        return eggFertilizing;
    }

    public void setEggFertilizing(String eggFertilizing) {
        this.eggFertilizing = eggFertilizing;
    }

    @Override
    public String toString() {
        return "Amphibians";
    }
}
