import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(List.of(
            "alpha", "bravo", "charlie", "delta"
    ));

    for (String s : list) {
      System.out.println(s);
    }

    System.out.println("---------------");

    list.forEach((String s) -> System.out.println(s));

    System.out.println("---------------");
//    list.forEach((var s) -> System.out.println(s));
//    list.forEach((s) -> System.out.println(s));
//    list.forEach(s -> System.out.println(s));
    String prefix = "nato";
    list.forEach((var myString) -> {
      char first = myString.charAt(0);
      System.out.println(prefix + " " + myString + " means " + first);
    });
    System.out.println("------------------------------------");

    var forEachInst = new Consumer<String>() {

      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };

    list.forEach(forEachInst);
    System.out.println("-------------------------------------------------------------");

    int result = calculator((a, b) -> a + b, 5, 2);
    var result2 = calculator((a, b) -> a / b, 10, 3);
    var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramen");

    System.out.println("-------------------------------------------------------------");

    var coords = Arrays.asList(
            new double[]{47.2160, -95.2348},
            new double[]{29.1566, -89.2495},
            new double[]{35.1556, -90.0658}
    );

    coords.forEach(s -> System.out.println(Arrays.toString(s)));

    BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lng:%.3f]%n", lat, lng);

    var firstPont = coords.get(0);
    processPoint(firstPont[0], firstPont[1], p1);

    System.out.println("---------------------------------------------");

    coords.forEach(s -> processPoint(s[0], s[1], p1));

    list.removeIf(s -> s.equalsIgnoreCase("bravod"));
    list.forEach(s -> System.out.println(s));

    System.out.println("---------------------------------------------");

    list.addAll(List.of("echo", "easy", "earnest"));
    list.forEach(s -> System.out.println(s));

    System.out.println("---------------------------------------------");

    var a = list.removeIf(s -> s.startsWith("ea"));
    list.forEach(s -> System.out.println(s));
    System.out.println(a);

    System.out.println("---------------------------------------------");

    list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());

    list.forEach(s -> System.out.println(s));

    System.out.println("---------------------------------------------");

    String[] emptyStrings = new String[10];
    System.out.println(Arrays.toString(emptyStrings));
    Arrays.fill(emptyStrings, "");
    System.out.println(Arrays.toString(emptyStrings));

    Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
                    + switch (i) {
              case 0 -> "one";
              case 1 -> "two";
              case 2 -> "three";
              default -> "";
            }
    );
    System.out.println(Arrays.toString(emptyStrings));

    System.out.println("---------------------------------------------");


    String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
    String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
    System.out.println(Arrays.toString(randomList));
  }

  public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
    T result = function.apply(value1, value2);
    System.out.println("Result of operation: " + result);
    return result;
  }

  public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
    consumer.accept(t1, t2);
  }

  public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
    String[] selectedValues = new String[count];
    for (int i = 0; i < count; i++) {
      selectedValues[i] = values[s.get()];
    }

    return selectedValues;
  }
}