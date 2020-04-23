package no.hiof.akduncan.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import no.hiof.akduncan.model.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ObservationRepo implements ObservationInterface {
    ArrayList<Observation> newList = fromJson("observations.json");
    public ArrayList<Observation> observations = new ArrayList<>();

    public ObservationRepo(){
        Biome grasslands = new Biome("Grasslands", "Sunny & mild");
        Biome aquatic = new Biome("Aquatic", "Underwater");
        Biome desert = new Biome("Desert", "Hot & dry");
        Biome arctic = new Biome("Arctic", "Cold & windy");
        Biome woodlands = new Biome("Woodlands", "Rainy and damp");

        Planet taglios = new Planet("Taglios", 107952.92, 3.492320000003E27, "Siren's Storm");
        Planet cadia = new Planet("Cadia", 14012.432, 4.209764E25, "Uhulis");
        Planet ophelia = new Planet("Ophelia", 63627.88, 1.95494E27, "Schindelgeist");

        Habitat location1 = new Habitat(grasslands, 51.37140, 58.41144, "Vegetation & Prey", taglios);
        Habitat location2 = new Habitat(arctic,21.92979, 61.12609, "Various birds and bugs", cadia);
        Habitat location3 = new Habitat(desert, -23.29837,  -83.55350, "Cacti-like vegetation", taglios);
        Habitat location4 = new Habitat(aquatic,  -2.46141,1.25031, "Algae", ophelia);
        Habitat location5 = new Habitat(aquatic, 8.62214, 152.81743, "Krill", ophelia);
        Habitat location6 = new Habitat(woodlands, 38.677490, -121.774719, "Bugs and fruit", cadia);

        Animal ochreJelly = new Invertebrate(0, "gelata", "Ochre Jelly", "Vegetation & bugs", 120, "Decomposer", false);
        Animal faerieDragon = new Birds(4, "nympharum plus draco", "Faerie Dragon", "Small prey & berries", 60, 18, "Varies by it's age", 120);
        Animal flumph = new Invertebrate(22, "arcanum summa", "Flumph", "Feelings & emotions", 40, "Unknown", true);
        Animal peryton = new Birds(2, "prodigiosum in alis", "Peryton", "Bigger prey & unsuspecting explorers", 200, 25, "Purple", 340);
        Animal kuoToa = new Amphibians(2, "purpura sponsione ranarum", "Kuo-Toa", "Algae and fish", 150, "Gills & lungs", "External");
        Animal aboleth = new Amphibians(0, "formidulosus piscis", "Aboleth", "Anything it can", 600, "Absorbs oxygen through their skin", "Internal");

        observations.add(new Observation(ochreJelly, "Ochre Jellies", location1, 2514, "test", "https://media-waterdeep.cursecdn.com/avatars/thumbnails/0/279/327/315/636252770058723674.jpeg",
                LocalDate.of(2567, 11, 12), 390000));
        observations.add(new Observation(faerieDragon, "Faerie Dragons", location6, 1432, "test", "https://vignette.wikia.nocookie.net/forgottenrealms/images/f/f4/Faerie_dragon-5e.jpg/revision/latest/scale-to-width-down/350?cb=20171010161947",
                LocalDate.of(2571, 3, 18), 5700000));
        observations.add(new Observation(flumph, "Flumphs", location2, 5666, "Not sure how it survives in this vast empty place", "https://vignette.wikia.nocookie.net/forgottenrealms/images/7/78/Flumph.jpg/revision/latest/scale-to-width-down/350?cb=20171010183015",
                LocalDate.of(2566, 9, 1),10000 ));
        observations.add(new Observation(peryton, "Perytons", location3, 1073, "test", "https://vignette.wikia.nocookie.net/forgottenrealms/images/8/8d/Peryton5e.png/revision/latest?cb=20171010174015",
                LocalDate.of(2572, 12, 24), 30000));
        observations.add(new Observation(kuoToa, "Kuo-Toa's", location4, 0563, "test", "https://vignette.wikia.nocookie.net/forgottenrealms/images/2/28/Kuo-toa-5e.jpg/revision/latest?cb=20190710143644",
                LocalDate.of(2575, 5, 9), 90000000));
        observations.add(new Observation(aboleth, "Aboleths", location5, 0564, "test", "https://vignette.wikia.nocookie.net/forgottenrealms/images/5/58/Monster_Manual_5e_-_Aboleth_-p13.jpg/revision/latest?cb=20200313153917",
                LocalDate.of(2575,5,13), 60000));

        Collections.sort(observations);
    }

    @Override
    public void saveToJson(String filename, ArrayList<Observation> observations) throws IOException {
        File file = new File(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, observations);
    }

    public ArrayList<Observation> fromJson(String filename){
        ArrayList<Observation> observations = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Observation[] obsArray = new Observation[0];
        try {
            obsArray = objectMapper.readValue(new File(filename), Observation[].class);
            observations.addAll(Arrays.asList(obsArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(observations);
        return observations;
    }

    @Override
    public ArrayList<Observation> getObservations(){
        return observations;
    }

    @Override
    public Observation getAnObservation(String name) {
        for (Observation observation : observations){
            if (observation.getName().equals(name))
                System.out.println(observation);
                return observation;
        }
        return null;
    }

    @Override
    public Animal getAnAnimal(String obsName) {
        Observation observation = getAnObservation(obsName);
        return observation.getAnimal();
    }

    @Override
    public void deleteAnObservation(String obsName) {
        observations.removeIf(next -> next.getName().equals(obsName));
        System.out.println(observations);
    }

}
