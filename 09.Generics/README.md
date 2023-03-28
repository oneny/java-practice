# Generics

## Generices

### What are Generics?

- Java supports generic types, such as classes, records and interfaces.
- It also supports generic methods. Sound confusing?

### Declaring a Class vs Declaring a generic Class

- The thing to notice with the generic class, is that the class declaration has angle brackets with a T in them, directly after the class name.
- `T` is the placeholder for a type that will be specified later.
- This is called a type identifier, and it can be any letter or word, but `T` which is short for Type is commonly used.
- For the generic class, the field's type is that placeholder, just `T`, and this means it can be any type at all.
- The `T` in the angle brackets means it's the same type as the `T`, specified as the type of the filed.

#### Regular Class

```java
class ItellYou {
  private String field;
}
```

#### Generic Class

```java
class YouTellMe<T> {
  private T field;
}
```

### Using a generic class as a reference type

```java
ArrayList<String> listOfString;
```

- In the declaration of a reference type that uses generics, the type parameter is declared in angle brackets.
- The reference type is ArrayList, the type parameter (or parameterized type) is String, which is declared in angle brackets, and listOfString is the variable name.
- Many of Java's libraries are written using generic classes and interfaces, so we'll be using them a lot moving forward.
- But it's still a good idea to learn to write your own generic class, to help you understand the concept.

### Generice Type Parameters

```java
public class Team<T> {}
```

- Using T is just a convention, short for whatever type you want to use this Team class for.
- But you can put anything you want in there.
- Single letter types are the convention however, and they're a lot easier to spot in the class code, so let me encourage you to stick to this convention.
- You can have more than one type parameter, so we could do T1, T2, T3.
  ```java
  public class Team<T1, T2, T3> {}
  ```
- But again convention says, that instead of using type parameters like this, it's easier to read the code with alternate letter selections.
  ```java
  public class Team<T, S, U>
  ```
  - And these are usually S, U, and V, in that order.
  - If we had three types, we'd probably want to declare this class as shown here, with T, S, and U.
- A few letters are reserved for special use cases.
- The most commonly used type parameter identifiers are:
  - `E` for Element (used extensively by the Java Collections Framework).
  - `K` for Key (used for mapped types).
  - `N` for Number.
  - `T` for Type.
  - `V` for Value.
  - S, U, V etc. for 2nd, 3rd, 4th types.

### Raw usage of generic classes.

```java
Team phillies = new Team("Philadelphia Phillies"); // Raw use of parameterized class 'Team'
```

- When you use generic classes, either referencing them or instantiating them, it's definitely recommended that you include a type parameter.
- But you can still use them without specifying one. This is called the `Raw Use` of the reference type.
- The raw use of these classes is still available, for backward compatibility, but it's discouraged for several reasons.
  - Generics allow the compiler to do compile- time type checking, when adding an processing elements in the list.
  - Generics simplify code, because we don't have to do our own type checking and casting, as we would, if the type of our elements was Object.

### Generic classes can be bounded, limiting the types that can use it.

```java
public class Team<T extneds Player> {}
```

- This `extends` keyword doesn't have the same meaning as extends, when it's used in a class declaration.
- This isn't saying our type `T extends Player`, although it could.
- This is saying the prameterized type `T`, has to be a Player, or a `subtype` of Player.
- Now Player in this case could have been either a clas or an interface, the syntax would be the same.
- This declaration establishes what is called an `upper bound`, on the types that are allowed to be used with this class.

### Why specify an upper bound?

- An upper bound permits access to the bounded type's functionality.
- An upper bound limits the kind of type parameters you can use when using a generic class. The type used must be equal to, or a subtype of the bounded type.

## Revisiting Comparable

### Interfaces used for sorting

- Now that I've covered interfaces and generic classes, I want to review in more detail, interfaces I mentioned in previous lectures.
- The first is Comparable.
  - For an array, we can simply call `Arrays.sort`, and pass it an array, but as I have previously mentioned, the elements in the array, need to implement `Comparable`.
  - Types like String, or primitive wrapper classes like Integer or Character are sortable, and this is because they do implement this interface.

### Comparable Interface

```java
public interface Comparable<T> {
  int compareTo(T o);
}
```

- The interface declaration in Java.
- It's a generic type, meaning it's parameterized.
- Any class that implements this interface, needs to implement the `compareTo` method.
- This method takes one object as an argument, shown on this code as the letter `o`, and compares it to the current instance, shown as this.
- The table shows what results of the `compareTo` method should mean, when implementd.

  | resulting Value | Meaning   |
  | --------------- | --------- |
  | zero            | 0 == this |
  | negative value  | this < o  |
  | positive value  | this > o  |

## Comparable vs Comparator

### The Comparator Interface

```java
// Comparator
public interface comparator<T> {
  int compare(T o1, T o2);
}

// Comparable
public interface Comparable<T> {
  int compareTo(T o);
}
```

- The Comparator interface is similar to the Comparable interface, and the two can often be confused with each other.
- Its declaration and primary abstract method are shown here, in comparison to `Comparable`.
- You'll notice that the method names are different, compare vs compareTo.
- The comapre method takes two arguments vs onew for compareTo, meaning that it will compare the two arguments to on another, and not one object to the instance itself.
- It's common practice to include a Comparator as a nested class.

### Summary of Differences

#### Comparable

```java
int compare(T o);
```

- Compares the argument with the current instance.
- Called from the instance of the class that implements `Comparable`.
- Best practice is to have this.compareTo(o) == o result in this.equals(o) being true.
- Arrays.sort(T[] elements) requires `T` to implement Comparable.

#### Comparator

```java
int compare(T o1, T o2);
```

- Compares two arguments of the same type with each other.
- Called from an instance of `Comparator`
- Does not require the class itself to implement `Comparator`, though you could also implement it this way.
- `Array.sort(T[] elements, Comparator<T>)` does not require `T` to implement Comparable.

## Generics classes as reference types

### This isn't inheritance

```
* GenericExtra 참고
 (Inheritance)   (inheritance Implementation)     (NOT INHERITANCE!!!!)
    Student             List<Student>              ArrayList<Student>
      ⬆️                      ⬆️                            ⬆️
      ⬆️                      ⬆️                            ⬆️
  LPAStudent          ArrayList<Student>          ArrayList<LPAStudent>
```

- We know `LPAStudent` inherits from `Student`, and we can pass an instance of `LPA Student` to any method, or assign it to any reference type, declared with the type Student.
- We also know that `ArrayList` implements `List`, and we can pass an `ArrayList` to a method or assign it to a reference of the List type.
- Why can't we pass an ArrayList of LPA Student, to the method parameter that's declared as a List of Student?
- Surely, if an LPAStudent is a Student, a List of LPAStudent is ultimately a List of Student.
- It's very natural to assume that a method that takes a List with `Students` should accept a List with `LPAStudent`, because `LPAStudent` is a Student after all.
  - But that's not how it works!!!
  - When used as reference types, a container of one type has no relationship to the same container of another type, even if the contained types do have a relationship.
    - 한 유형의 컨테이너는 다른 유형의 동일한 컨테이너와는 아무 관계가 없다. 포함된 유형들이 관계가 있다고 해도! 관계가 없다.

```java
// 정상 실행!
public static void main(String[] args) {
  int studentCount = 10;
  List<Student> students = new ArrayList<>();
  for (int i = 0; i < studentCount; i++) {
    students.add(new Student());
  }
  students.add(new LPAStudent());
  printList(students);
}

public static void printList(List<Student> students) {
  for (Student student : students) {
    System.out.println(student);
  }

  System.out.println();
}
```

```java
// ERROR!
// Required type: List<Student>, Provided: ArrayList<LPAStudent>
List<Student> students = new ArrayList<LPAStudent>();
```

- 문제는 참조의 형식 문제이다.

## Generics methods, wildcards, and type erasure

### Limitation of a reference of generic class with a list argument

- When we declare a variable or method parameter with:
  - `List<Student>`
- Only List subtypes with Student elements can be assigned to this variable or method argument.
  - 오직 Student을 요소로 가진 List의 서브타입들만 메서드 아나 변수에 할당할 수 있다.
- We can't assign a list of Student subtypes to this!
  - 여기에 학생 하위 목록을 지정할 수는 없다!
- 다행히 몇 가지 방법이 있다.
  - 제네릭 메서드 만들기

### The generic method

```java
public static void printList(List<Student> students) {
  for (Student student : students) {
    System.out.println(student);
  }

  System.out.println();
}

public static <T> void printList(List<T> students) {
  for (T student : students) {
    System.out.println(student);
  }

  System.out.println();
}
```

- For method, type parameters are placed after any modifiers and before the method's return type.
- The type parameter can be referenced in method parameters, or as the method return type, or in the method code block, much as we saw a class's type parameter can be used.
- A generic method can be used for collections with type arguments, as we just saw, to allow for variability of the elements in the collection, without using a raw version of the collection.
- A generic method can be used for static methods on a generic class, because static methods can't use class type parameters.
- A generic method can be used on a non-generic class, to enforce type rules on a specific method.
- The generic method type parameter is separate from a generic class type parameter.
- In fact, if you've used `T` for both, the `T` declared on the method means a different type, than the `T` for the class.

### Type Parameters, Type Arguments and using a Wildcard

```java
// Generic Class
public class Team<T> {}

// Generic Method
public static <T> void doSomething(T t) {}
```

- A `type parameter` is a generic class, or generic method's declaration fo the type.
- In both of these example, `T` is said to be the type parameter.
- You can bind a type parameter with the use of the `extends` keyword, to specify an `upper bound`.
- A `type argument` declares the type to be used, and is specified in a type reference, such as a local variable reference, method parameter declaration, or field declaration.
  ```java
  // In this example, BaseballPlayer is the type argument for the Team class.
  Team<BaseballPlayer> team = new Team<>();
  ```

### Type Parameters, Type Arguments and using a Wildcard

```java
List<?> unknownList;
```

- A `wildcard`can only be used in a `type argument`, not in the type parameter declaration.
- A wildcard is represented with the `?` character.
- A wildcard means the type is `unknown`.
- For this reason, a wildcard `limits what you can do`, when you specify a type this way.

#### Invalid! You can't use a wildcard in an instantiation expression

```java
var myList = new ArrayList<?>();
```

- A wild card can't be used in an instantiation of a generic class.

#### unbounded, upper bound, lower bound

| Argument    | Example                    | Description                                                                                                                                |
| ----------- | -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| unbounded   | List<?>                    | A List of any type can be passed or assigned to a List using this wildcard.                                                                |
| upper bound | List<? `extends` Student>  | A list containing any type that is a Student of a `sub type` of Student can be assigned or passed to an argument specifying this wildcard. |
| lower bound | List<? `super` LPAStudent> | A list containing any type that is an LPAStudent or a `super type` of LPAStudent, so in our case, that would be Student AND Object.        |

- A wildcard can be unbounded, or alternately, specify either an upper bound or lower bound.
- You **can't specify both** an `upper` bound and a `lower` bound, in the same declaration.

### TYpe Erasure

- Generics exist to enforce tighter type checks, at compile time.
  - 제네릭은 컴파일 타임에 형식을 더 꼼꼼히 확인하기 위해 존재한다.
- The compiler transforms a generic class into a typed class, meaning the byte code, or class file, contains no type parameters.
- Everywhere a type parameter is used in a class, it gets replaced with either the type Object, if no upper bound was specified, or the upper bound type itself.
  - 클래스에서 형식 매개 변수가 사용되는 모든 곳에서 상부 바운딩이 없는 형식 객체로 지정되거나 상부 바운딩 유형 자체로 대체될 수 있다.
- This transformation process is called type erasure, because the `T` parameter (or `S`, `U`, `V`) is erased, or replaced with a true type.
  - 변환 과정을 `형식 삭제`라고 한다.
- Why is this important?
- Understanding how type erasure works for overloaded methods, may be important.

### Using Multiple types to declare an Upper Bound

```java
interface InterfaceA {}
interface InterfaceB {}
abstract class AbstractClassA {}

// Extends for class & interface
// & means any type must be subtype of ALL
// Class must be listed first
// Interface(s) follow class
public class GenericClass<T extends AbstractClassA & InterfaceA & InterfaceB> {}
```

- You can use multiple types to set a more restrictive upper bound, with the use of an ampersand between types.
- The conditions require a type argument, to implement all interfaces declared, and to be a subtype of any class specified.
- You can extend only one class at most, and zero to many interfaces.
- You use `extends` for either a class or an interace or both.
- If you do extend a class as weel as an interface or two, the class must be the first type listed.