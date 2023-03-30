import domain.Employee;
import domain.EmployeeComparator;
import domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee(10001, "Ralph", 2015),
            new Employee(10005, "Carole", 2021),
            new Employee(10022, "Jane", 2013),
            new Employee(13151, "Laura", 2020),
            new Employee(10050, "Jim", 2018)
    ));

//    var comparator = new EmployeeComparator<>();
//    employees.sort(comparator);

    employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

    for (Employee e : employees) {
      System.out.println(e);
    }

    System.out.println("Store Members");

    List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
            new StoreEmployee(10015, "Meg", 2019, "Target"),
            new StoreEmployee(10515, "Joe", 2021, "Walmart"),
            new StoreEmployee(10105, "Tom", 2020, "Macys"),
            new StoreEmployee(10215, "Marty", 2018, "Walmart"),
            new StoreEmployee(10322, "Bud", 2016, "Target")
    ));

//    var comparator = new StoreEmployee.StoreComparator<>();
    storeEmployees.sort(new StoreEmployee().new StoreComparator<>());

    for (StoreEmployee e : storeEmployees) {
      System.out.println(e);
    }

    System.out.println("With Pig Latin Names");
    addPigLatinName(storeEmployees);
  }

  public static void addPigLatinName(List<? extends StoreEmployee> list) {

    String lastName = "Piggy";

    class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {
      private String pigLatinName;
      private Employee originalInstance;

      public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
        this.pigLatinName = pigLatinName;
        this.originalInstance = originalInstance;
      }

      @Override
      public String toString() {
        return originalInstance.toString() + " " + pigLatinName;
      }

      @Override
      public int compareTo( DecoratedEmployee o) {
        return pigLatinName.compareTo(o.pigLatinName);
      }
    }

    List<DecoratedEmployee> newList = new ArrayList<>(list.size());
    for (StoreEmployee employee : list) {
      String name = employee.getName();
      String pigLatin = name.substring(1) + " " + lastName;
      newList.add(new DecoratedEmployee(pigLatin, employee));
    }

    newList.sort(null);
    for (DecoratedEmployee dEmployee : newList) {
      System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
    }
  }
}