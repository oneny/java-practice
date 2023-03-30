import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Integer boxedInt = Integer.valueOf(15); // preferred but unnecessary
    Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9
    int unboxedInt = boxedInt.intValue(); // unnecessary
    
    // Automatic
    Integer autoBoxed = 15;
    int autoUnboxed = autoBoxed;
    System.out.println(autoBoxed.getClass().getName());
//    System.out.println(autoUnboxed.getClass().getName());

    Double resultBoxed = getDoubleObject();
    double resultUnboxed = getLiteralDoublePrimitive();

    Integer[] wrapperArray = new Integer[5];
    wrapperArray[0] = 50;
    System.out.println(Arrays.toString(wrapperArray));
    System.out.println(wrapperArray[0].getClass().getName());

    var outList = List.of(1, 2, 3, 4, 5);
    System.out.println(outList.get(1).getClass().getName());

    var outList2 = getLIst(1, 2, 3, 4, 5);
    System.out.println(outList2.get(1).getClass().getName());
  }

  private static ArrayList<Integer> getLIst(Integer... varargs) {
    ArrayList<Integer> aList = new ArrayList<>();
    for (int i : varargs) {
      aList.add(i);
    }
    return aList;
  }

  private static int returnAnInteger(int i) {
    return i;
  }

  private static int returnAnInt(Integer i) {
    return i;
  }

  private static Double getDoubleObject() {
    return Double.valueOf(100.00);
  }

  private static double getLiteralDoublePrimitive() {
    return 100.0;
  }
}