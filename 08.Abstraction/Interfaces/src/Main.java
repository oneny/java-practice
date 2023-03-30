import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Bird bird = new Bird();
    Animal animal = bird;
    FlightEnabled flier = bird;
    Trackable tracker = bird;

//    animal.move();
//    flier.fly();
//    tracker.track();
//    flier.land();

    inFlight(flier);
    inFlight(new Jet());
    Trackable truck = new Truck();
    truck.track();

    double kmsTraveled = 100;
    double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
    System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

    ArrayList<FlightEnabled> fliers = new ArrayList<>();
    fliers.add(bird);

    List<FlightEnabled> betterFliers = new ArrayList<>();
    betterFliers.add(bird);

    triggerFilers(fliers);
    flyFliers(fliers);
    landFliers(fliers);

    triggerFilers(betterFliers);
    flyFliers(betterFliers);
    landFliers(betterFliers);
  }

  private static void inFlight(FlightEnabled flier) {
    flier.takeOff();
    flier.fly();
    if (flier instanceof Trackable tracked) tracked.track();
    flier.land();
  }

  private static void triggerFilers(List<FlightEnabled> fliers) {
    for (var flier : fliers) {
      flier.takeOff();
    }
  }

  private static void flyFliers(List<FlightEnabled> fliers) {
    for (var flier : fliers) {
      flier.fly();
    }
  }

  private static void landFliers(List<FlightEnabled> fliers) {
    for (var flier : fliers) {
      flier.land();
    }
  }
}