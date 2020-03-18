package no.hiof.akduncan.oblig2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<CelestialBody> planetArray = new ArrayList();


        Star sun = new Star("Sun", 1.988*(Math.pow(10,30)), 695342, 5777);
        Planet mercury = new Planet("Mercury", 3.283E23,2439.7, 0.387, 0.206, 88, sun);
        Planet venus = new Planet("Venus",4.867E24,6051.8, 0.723, 0.007, 225, sun);
        Planet earth = new Planet("Earth",5.972E24,6371, 1, 0.017, 365, sun);
        Planet mars = new Planet("Mars",6.39E23,3389.5, 1.524, 0.093, 687, sun);
        Planet jupiter = new Planet("Jupiter",1.898E27,69911, 5.20440, 0.049, 4380, sun);
        Planet saturn = new Planet("Saturn",5.683E26,58232, 9.5826, 0.057, 10585, sun);
        Planet uranus = new Planet("Uranus",8.681E25,25362, 19.2184, 0.046, 30660, sun);
        Planet neptune = new Planet("Neptune",1.024E26,24622, 30.11, 0.010, 60225, sun);

        //System.out.println(neptune.toString());
       // System.out.println(sun.toString());

        planetArray.add(mercury);
        planetArray.add(venus);
        planetArray.add(earth);
        planetArray.add(mars);
        planetArray.add(jupiter);
        planetArray.add(saturn);
        planetArray.add(uranus);
        planetArray.add(neptune);

        System.out.println(planetArray);

        ArrayList<CelestialBody> bodyArray = (ArrayList<CelestialBody>) planetArray.clone();
        bodyArray.add(sun);
        System.out.println("-------Celestial bodies sorted by name-------------");
        Collections.sort(bodyArray);
        System.out.println(bodyArray);
        System.out.println("-------End of sort-------------");





        PlanetSystem ours = new PlanetSystem("Solar System", sun, planetArray);

        public static List<PlanetSystem> lesFraJson(String filename) {
            List<PlanetSystem> karakterer = new ArrayList<>();

            try {
                ObjectMapper objectMapper = new ObjectMapper();

                Karakter[] karakterArray = objectMapper.readValue(new File(filnavn), Karakter[].class);

                karakterer = Arrays.asList(karakterArray);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            return karakterer;
        }

        System.out.println("lmao");
        Collections.sort(ours.getPlanets());
        System.out.println(ours.getPlanets());

        System.out.println("alle er homo");

        /*

        System.out.println(ours.printPlanetByName("Saturn"));
        //System.out.println(ours);
        System.out.println("The biggest planet is: " + ours.findBiggestPlanet(planetArray).getName());
        System.out.println("The smallest planet is: " + ours.findSmallestPlanet(planetArray).getName());
        System.out.println(jupiter);
        System.out.println(neptune);
        System.out.println(saturn);
        //sun.printStar();
        System.out.println(sun);
        System.out.println(earth.getName() + " has a distance of " + earth.distanceToCentralBody(0) + " km to the " + earth.getCentralCelestialBody().getName());
        System.out.println(earth.getName() + " has a velocty of " + earth.orbitingVelocity(147054707));


         */

    }
}
