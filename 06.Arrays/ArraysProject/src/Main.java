import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] myIntArray = new int[10];
    myIntArray[5] = 50;

    double[] myDoubleArray = new double[10];
    myDoubleArray[2] = 3.5;
    System.out.println(myDoubleArray[2]);

    int[] newArray = {1, 2, 3, 4, 5};
    for (int element : newArray) {
      System.out.print(element + " ");
    }

     Object objectVariable = newArray;
    if (objectVariable instanceof int[])  {
       System.out.println("objectVariable is really an int array.");
    }

    String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
    Arrays.sort(sArray);
    System.out.println(Arrays.toString(sArray));
    if (Arrays.binarySearch(sArray, "Mark") >= 0) {
      System.out.println(Arrays.binarySearch(sArray, "Mark"));
    }
   }
}