package no.hiof.akduncan.model;

public class Invertebrate extends Animal{
    private String roleInNature;
    private boolean abilityToFly;

    public Invertebrate(int numberOfLegs, String scientificName, String name, String diet, int bodylength, String roleInNature, boolean abilityToFly) {
        super(numberOfLegs, scientificName, name, diet, bodylength);
        this.roleInNature = roleInNature;
        this.abilityToFly = abilityToFly;
    }

    public Invertebrate() {
    }

    public String getRoleInNature() {
        return roleInNature;
    }

    public void setRoleInNature(String roleInNature) {
        this.roleInNature = roleInNature;
    }

    public boolean isAbilityToFly() {
        return abilityToFly;
    }

    public void setAbilityToFly(boolean abilityToFly) {
        this.abilityToFly = abilityToFly;
    }

    @Override
    public String toString() {
        return "Invertebrate{" +
                "roleInNature='" + roleInNature + '\'' +
                ", abilityToFly=" + abilityToFly +
                '}';
    }
}
