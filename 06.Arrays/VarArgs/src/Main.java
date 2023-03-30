import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
  public static void main(String... args) {
    System.out.println("Hello World again");

//    String[] splitStrings = "Hello World again".split(" ");
//    printText(splitStrings);

    System.out.println("_".repeat(20));

    //
    printText("Hello");
    printText("Hello", "World", "again");
    int[] arr = {1, 99, 3, 3, 5};
    reverse(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void printText(String firstStr, String... textList) {
    System.out.println("Nice! " + firstStr);
    for (String t : textList) {
      System.out.println(t);
    }
  }

  private static void reverse(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      int temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
    }
  }
}