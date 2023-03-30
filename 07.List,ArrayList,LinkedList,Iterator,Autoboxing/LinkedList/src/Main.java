import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
  public static void main(String[] args) {
    LinkedList<String> placesToVisit = new LinkedList<>();

    placesToVisit.add("Sydney");
    placesToVisit.add(0, "Canberra");
    System.out.println(placesToVisit);

    placesToVisit.addFirst("Darwin");
    placesToVisit.addLast("Hobart");
    System.out.println(placesToVisit);

    // Queue Methods
    placesToVisit.offer("Melbourne");
    placesToVisit.offerFirst("Brisbane");
    placesToVisit.offerLast("Toowoomba");

    // Stack Methods
    placesToVisit.push("Alice Springs");
    System.out.println(placesToVisit);

    placesToVisit.remove(4);
    placesToVisit.remove("Brisbane");

    String s1 = placesToVisit.remove();
    System.out.println(s1 + " was removed");

    String s2=  placesToVisit.removeFirst();
    System.out.println(s2 + " was removed");

    String s3 = placesToVisit.removeLast();
    System.out.println(s3 + " was removed");

    // Queue/Dequeue poll methods
    String p1 = placesToVisit.poll(); // removes first element
    System.out.println(p1 + " was removed");
    String p2 = placesToVisit.pollFirst(); // removes first element
    System.out.println(p1 + " was removed");
    String p3 = placesToVisit.pollLast(); // removes last element
    System.out.println(p1 + " was removed");

    System.out.println(placesToVisit);

    placesToVisit.push("Sydney");
    placesToVisit.push("Brisbane");
    placesToVisit.push("Canberra");

    String p4 = placesToVisit.pop(); // removes first element
    System.out.println(p4 + " was removed");

    System.out.println(placesToVisit);

    placesToVisit.addFirst("Alice Springs");
    placesToVisit.addLast("Hobart");

    System.out.println(placesToVisit);

    gettingElements(placesToVisit);

    printItinerary(placesToVisit);
    printItinerary2(placesToVisit);
  }

  private static void gettingElements(LinkedList<String> list) {
    System.out.println("Retrieved Element = " + list.get(3));
    System.out.println("First Element = " + list.getFirst());
    System.out.println("Last Element = " + list.getLast());
    System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
    System.out.println("Darwin is at position: " + list.lastIndexOf("Darwin"));

    // Queue retrieval method
    System.out.println("Element from element() = " + list.element());

    // Stack retrieval method
    System.out.println("Element from peek() = " + list.peek());
    System.out.println("Element from peekFirst() = " + list.peekFirst());
    System.out.println("Element from peekLast() = " + list.peekLast());
  }

  public static void printItinerary(LinkedList<String> list) {
    System.out.println("Trip starts at " + list.getFirst());
    String previousTown = list.getFirst();

    for (String town: list) {
      System.out.println("--> From: " + previousTown + " to " + town);
      previousTown = town;
    }

    System.out.println("Trip ends at " + list.getLast());
  }

  public static void printItinerary2(LinkedList<String> list) {
    System.out.println("Trip starts at " + list.getFirst());
    String previousTown = list.getFirst();
    ListIterator<String> iterator = list.listIterator(1);
    System.out.println(list);

    while (iterator.hasNext()) {
      String town = iterator.next();
      if (town.equals("Brisbane")) iterator.add("Lake Wivennhoe");
      System.out.println("--> From: " + previousTown + " to " + town);
      previousTown = town;
    }

    while (iterator.hasPrevious()) System.out.println(iterator.previous());

    System.out.println(list);

    var iterator2 = list.listIterator(3);
    System.out.println(iterator2.previous());

    System.out.println("Trip ends at " + list.getLast());
  }
}