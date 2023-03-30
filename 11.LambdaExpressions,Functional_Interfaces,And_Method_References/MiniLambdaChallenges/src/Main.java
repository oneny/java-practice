import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
  public static void main(String[] args) {
    Consumer<String> printWords = new Consumer<String>() {
      @Override
      public void accept(String sentence) {
        String[] parts = sentence.split(" ");
        for (String part : parts) {
          System.out.println(part);
        }
      }
    };

    Consumer<String> printWordsLambda = sentence -> {
      String[] parts = sentence.split(" ");
      for (String part : parts) {
        System.out.println(part);
      }
    };

    printWordsLambda.accept("Let's split this up into an array");

    System.out.println("-------------------------");

    Consumer<String> printWordsForEach = sentence -> {
      String[] parts = sentence.split(" ");
      Arrays.asList(parts).forEach(s -> System.out.println(s));
    };

    printWordsForEach.accept("Let's split this up into an array");

    System.out.println("-------------------------");

    Consumer<String> printWordsConcise = sentence -> {
      Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
    };

    printWordsConcise.accept("Let's split this up into an array");

    System.out.println("-------------------------");

    UnaryOperator<String> everySecondChar = source -> {
      StringBuilder returnVal = new StringBuilder();

      for (int i = 0; i < source.length(); i++) {
        if (i % 2 == 1) { // if odd
          returnVal.append(source.charAt(i));
        }
      }
      return returnVal.toString();
    };

    System.out.println(everySecondChar.apply("123456789"));

    System.out.println("-------------------------");

    String result = everySecondCharacter(everySecondChar, "1234567890");
    System.out.println(result);

    Supplier<String> iLoveJava = () -> "I love Java";

    System.out.println(iLoveJava.get());

    String result2 = everySecondCharacterWithGeneric(everySecondChar, "12345");
    System.out.println(result2);
  }

  public static String everySecondChar(String source) {
    StringBuilder returnVal = new StringBuilder();
    for (int i = 0; i < source.length(); i++) {
      if (i % 2 == 1) { // if odd
        returnVal.append(source.charAt(i));
      }
    }
    return returnVal.toString();
  }

  public static String everySecondCharacter(Function<String, String> func, String source) {
    return func.apply(source);
  }

  public static <T> T everySecondCharacterWithGeneric(UnaryOperator<T> func, T source) {
    return func.apply(source);
  };
}