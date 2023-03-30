import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(args));
    int[] unsortedArray = getRandomArray(5);
    System.out.println(Arrays.toString(unsortedArray));

    sortInteger(unsortedArray);
  }

  public static int[] getRandomArray(int len) {
    Random random = new Random();
    int[] randomArray = new int[len];
    for (int i = 0; i < len; i++) {
      randomArray[i] = random.nextInt(1000);
    }

    return randomArray;
  }

  public static int[] sortInteger(int[] array) {
    int[] sortedArray = Arrays.copyOf(array, array.length);
    boolean flag = true;
    int temp;

    System.out.println(Arrays.toString(array));

    while (flag) {
      flag = false;
      for (int i = 0; i < sortedArray.length - 1; i++) {
        if (sortedArray[i] < sortedArray[i + 1]) {
          temp = sortedArray[i];
          sortedArray[i] = sortedArray[i + 1];
          sortedArray[i + 1] = temp;
          flag = true;
          System.out.println("---->" + Arrays.toString(sortedArray));
        }
      }

      System.out.println("-->" + Arrays.toString(sortedArray));
    }

    return sortedArray;
  }
}