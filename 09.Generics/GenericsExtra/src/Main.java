import model.LPAStudent;
import model.Student;
import util.QueryItem;
import util.QueryList;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {
  @Override
  public boolean matchFieldValue(String fieldName, String value) {
    return false;
  }
}

public class Main {
  public static void main(String[] args) {
    int studentCount = 10;
    List<Student> students = new ArrayList<>();
    for (int i = 0; i < studentCount; i++) {
      students.add(new Student());
    }
    students.add(new LPAStudent());
//    printList(students);
    printMoreList(students);

    List<LPAStudent> lpaStudents = new ArrayList<>();
    for (int i = 0; i < studentCount; i++) {
      lpaStudents.add(new LPAStudent());
    }
    printList(lpaStudents);
    printMoreList(lpaStudents);

    testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
    testList(new ArrayList<Integer>(List.of(1, 2, 3)));

    QueryList<LPAStudent> queryList = new QueryList<>(lpaStudents);
    List<LPAStudent> matches = queryList.getMatches("Course", "Python");
    printMoreList(matches);

    var student2021 = QueryList.<Student>getMatches(new ArrayList<>(), "YEARSTARTED", "2021");
    printMoreList(student2021);

    // Type parameter 'Employee' is not within its bound; should extend 'model.Student'
    // QueryList는 QueryItem과 Student 서브타입이어야 한다.
//    QueryList<Employee> employeeList = new QueryList<>();
  }


  public static void printMoreList(List<? extends Student> students) {
    Student last = students.get(students.size() - 1);
//    students.set(0, last); //
    for (var student : students) {
      System.out.println(student.getYearStarted() + ": " + student);
    }

    System.out.println();
  }

//  Generic Method
  public static <T extends Student> void printList(List<T> students) {
    for (T student : students) {
      System.out.println(student.getYearStarted() + ": " + student);
    }

    System.out.println();
  }

  public static void testList(List<?> list) {
    for (var element : list) {
      if (element instanceof String s) {
        System.out.println("String: " + s.toUpperCase());
      } else if (element instanceof Integer i) {
        System.out.println("Integer: " + i.floatValue());
      }
    }
  }
}