import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Main {

  private static final Map<String, HeavenlyBody> solarSystem = new HashMap<>();
  private static final Set<HeavenlyBody> planets = new HashSet<>();

  public static void main(String[] args) {
    // write your code here
    HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    temp = new HeavenlyBody("Venus", 225);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    // Earth
    temp = new HeavenlyBody("Earth", 365);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    // Mars
    temp = new HeavenlyBody("Mars", 687);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    tempMoon = new HeavenlyBody("Deimos", 1.3);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    tempMoon = new HeavenlyBody("Phobos", 0.3);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    // Jupiter
    temp = new HeavenlyBody("Jupiter", 4332);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    tempMoon = new HeavenlyBody("Io", 1.8);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    tempMoon = new HeavenlyBody("Europa", 3.5);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    tempMoon = new HeavenlyBody("Ganymede", 7.1);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    tempMoon = new HeavenlyBody("Callisto", 16.7);
    solarSystem.put(tempMoon.getName(), tempMoon);
    temp.addMoon(tempMoon);

    // Saturn
    temp = new HeavenlyBody("Saturn", 10759);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    temp = new HeavenlyBody("Uranus", 30660);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    temp = new HeavenlyBody("Neptune", 165);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    temp = new HeavenlyBody("Pluto", 248);
    solarSystem.put(temp.getName(), temp);
    planets.add(temp);

    System.out.println("Planets");
    for (HeavenlyBody planet : planets) {
      System.out.println("\t" + planet.getName());
    }

    HeavenlyBody body = solarSystem.get("Jupiter");
    System.out.println("Moons of " + body.getName());
    for (HeavenlyBody jupiter : body.getSatellites()) {
      System.out.println("\t" + jupiter.getName());
    }

    Set<HeavenlyBody> moons = new HashSet<>();
    for (HeavenlyBody planet : planets) {
      moons.addAll(planet.getSatellites());
    }

    System.out.println("All Moons");
    for (HeavenlyBody moon : moons) {
      System.out.println("\t" + moon.getName());
    }

    HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
    planets.add(pluto);

    for (HeavenlyBody planet : planets) {
      System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
    }

//    Object o = new Object();
//    o.equals(o);
  }
}