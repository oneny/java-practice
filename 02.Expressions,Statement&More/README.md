# Expressions, Statement & More

## Introduction

```java
public class FirstClass {
    public static void main(String[] args) {
        System.out.print("Hello World");
    }
}
```

#### Access Modifiers

- The `public` java keyword is what's called on `access modifier`.
- An access modifier allows us to define which parts of our code, or even someone else's code, can access a particular element.

#### Class Keyword

- The `class` keyword is used to define a class. The class name will be the text following the keyword, so `FirstClass` in this case.
- Notice the **left and right curly braces**, they are used to define the class code block, or class body.
- `void`는 메서드가 어떤 정보도 반환하지 않는다는 것을 나타낸다.

## Code Blocks And The If Then Else Control Statement

### if with an Else if and Else block

```java
if (firstCondition) {
  // Code in block will execute only if
  // firstCondition is true
} else if (secondCondition) {
  // Code in block will execute if firstCondition is false
  // and secondCondition is true
  THERE IS NO LIMIT TO THE NUMBER OF CONDITIONS THAT CAN BE TESTED
} else {
  // Code in block will execute if
  // all conditions above are false
  THE ELSE BLOCK MUST BE LAST BUT IS OPTIONAL
}
```

## Methods in Java

### The Method

- Java's description of the method is:
  - A method declares executable code that can be invoked, passing a fixed number of values as arguments.

### The Benefits of the EMthod

- A method is a way of reducing code duplication.
- A method can be executed many times with potentially different results, by passing data to the method in the form of arguments.

### Structure of the Method

```java
public static void methodName() {
  // Method statements form the method body
}
```

- One of the simplest ways to declare a method is shown on this slide.
- This method has a name, but takes no data in, and returns no data from the method (which is wahwt the special word `void` means in this declaration).

### Executing a Method as a Statement

- To execute a method, we can warie a statement in code, which we say is calling, or invoking, the method.
- For a simple method like calculateScore, we just use the name of the method, where we want it to be executed, follwed by parentheses, and a semi-colon to complete the statement.
- So for this example, the calling statement would look like the code shown here:
  ```java
  calculateScore();
  ```

### Structure of the Method

- WHere we previously had empty parentheses after the method name, we now have method parameters in the declaration.
  ```java
  public static void methodName(p1type p1, p2type p2, {more}) {
    // Method statements form the method body
  }
  ```

### Parameters or Arguments?

- Parameters and arguments are terms that are often used interchangeably by developers.
- But technically, a parameter is the definition as shown in the method declaration, and the argument will be the value that's passed to the method when we call it.

### The Return Statement for methods that have a return type

- One common practice is to declare a default return value at the start of a method, and only have a single return statement from a method, returning that variable, as shown in this example method:
  ```java
  public static boolean isTooYoung(int age) {
    boolean result = false;
    if (age < 21) {
      result = true;
    }
    return result;
  }
  ```

### Revisiting the main method

- Now, that we're armed with knowledge about methods, we can revisit the main method, and examine it again.
- The main method is special in Java, because Java's virtual machine (JVM) looks for the method, with this particular signature, and uses it as the entry point for execution of code.
  ```java
  public static void main(String[] args) {
    // code in here
  }
  ```

### Method Overloading

- Method overloading occurs when a class has multiple methods, with the same name, but the methods are declared with different parameters.
- So you can execute a method with one name, but call it with different arguments.
- Java can resolve which method it needs to execute, based on the arguments being passed, when the method is invoked.

### More on Method Signatures

- A method signature consists of the name of the method, and the uniqueness of the declaration of its parameters.
- In other words, a signature if unique, not just by the method name, but in combination with the number of parameters, their types, and the order in which they are declared.
- A method's return type is not part of the signature.
- A parameter name is also not part of the signature.

### Valid Overloaded Methods

- The type, order, and number of parameters, in conjuction with the name, make a method signature unique.
- A unique method signature is the key for the Java compiler, to determine if a method is overloaded correctly.
- The name of the parameter is not part of the signature, and therefor it doesn't matter, from Java's point of view, what we call our parameters.

### Valid Overloaded Methods

```java
public static void doSomething(int parameterA) {
  // method body
}

public static void doSomething(float parameterA) {
  // method body
}

public static void doSomething(int parameterA, float parameterB) {
  // method body
}

public static void doSomething(float parameterA, int parameterB) {
  // method body
}

public static void doSomething(int parameterA, int parameterB, float parameterC) {
  // method body
}
```

### Invalid Overloaded Methods

- Parameter names are not important when determining if a method is overloaded.
- Nor are return types used when determining if a method is unique.

```java
public static void doSomething(int parameterA) {
  // method body
}

public static void doSomething(int parameterB) {
  // method body
}

public static int doSomething(int parameterA) {
  return 0;
}
```

### Overloaded Method Callenge Instructions

- Create two methods with the same name: converToCentimeters
  - The first method has one paremeter of type `int`, which represents the entire height in inches. You'll convert inches to centimeters, in this method, and pass back the number of centimeters, as a double.
  - The second method has two parameters of type `int`, one to represent height in feet, and one to represent the remaining height in inches. So if a person is 5 foot, 8 inches, the values 5 for feet and 8 for inches would be passed to this method. This method will convert feet and inches to just inches, then call the first method, to get the number of centimeters, also returning the value as a double.

```java
public class SecondClass {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5, 8));
        System.out.println(convertToCentimeters(68));
    }

    public static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches) {
        return convertToCentimeters((feet * 12) + inches);
    }
}
```

## Introduct ion to Classes, Using Getter Methods

```java
public class Car {
  private String make;
  private String model;
  private String color;
  private int doors;
  private boolean convertible;

  public void describeCar() {
    System.out.println(doors + " - Doors " + color + " " + make + " " + model + " " + (convertible ? "Convertable" :  ""));
  }
}


public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    car.describeCar(); // 0 - Doors null null null
  }
}
```

### What is null?

- `null` is a special keyword in Java, meaning the variable or attribute has a type, but no reference to an object.
- This means that no instance, or object, is assigned to the variable or field.
- Fields with primitive data types are never null.

### Default values for fields on classes

- Fields on classes are assigned default values, intrinsically by Java, if not assigned explicitly.

  | Data type                | Defaultg value assigned |
  | ------------------------ | ----------------------- |
  | booelan                  | false                   |
  | byte short int long char | 0                       |
  | double float             | 0.0                     |

### What are getters and setters? Why should we use them?

- A getter is a method on a class, that retrieves the value of a private field, and returns it.
  - getter 메서드는 보통 개인 속성의 값을 반환한다.
- A setter is a method on a class, that sets the value of a private field.
  - setter 메서드는 단순히 특성에 인수를 할당할 수도 있지만 종종 데이터 유효성을 검사할 코드를 포함하고 있다.
  - 필드 값의 변동성을 확인하는 추가 보안 요구 사항 혹은 개체의 상태 보호와 검증을 위해 필요한 다른 코드들을 확인한다.
  - 개인 필드에서는 세터 방식을 쓸 수 없을 때가 많다. 클래스 자체에서만 필요한 데이터일 수도 외부 세계에 노출될 필요가 없는 데이터일 수도 있다.
- The purpose of these methods is to control, and protect, access to private fields.

## Classes, Using Setters, and Creating Objects

```java
public void setMake(String make) {
  this.make = make;
}
```

### this

- `this` is a special keyword in Java.
- What it really refers to is the instance that was created when the object was instantiated.
- So `this` is a special reference name for the object or instance, which it can use to describe itself.
- And we can use `this` to access fields on the class.

### 왜 getter, setter를 사용할까?

```java
public void setMake(String make) {
  if (make == null) make = "Unknown";

  String lowercaseMake = make.toLowerCase();
  switch (lowercaseMake) {
    case "holden", "porsche", "tesla" -> this.make = make;
    default -> {
      this.make = "Unsupported";
    }
  }
}
```

- 유효성 검사가 가능!

## Constructors

### Constructor

- A `constructor` is used in the creation of an object, that's an insstance of a class.
- It is a special type of code block that has a specific name and parameters, much like a method.
- It has the same name as the class itself, and it doesn't return any values.
- You never include a return type from a constructor, not even void.
- You can, and should, specify an appropriate access modio
  ```java
  public class Account { // This is the class declaration
    public Account() { // This is the constructor declaration
      // Constructor code is code to be executed as the object is created.
    }
  }
  ```

### The default constructor

- If a class contains no constructor declarations, then a default constructor is implicitly declared.
- This constructor has no parameters, and is often called the no-args (no arguments) constructor.
- If a class contains any other constructor declarations, then a default constructor is `NOT` implicitly declared.

### Constructor overloading

- Constructor overloading is declaring multiple constructors, with different formal parameters.
- The number of parameters can be different between constructors.
- Or if the number of parameters is the same between two constructors, their types or order of the types must differ.

### Constructor chaining with this()

- Constructor chaining is when one constructor explicitly calls another overloaded constructor.
- You can call a constructor only from another constructor.
- You must use the special statement `this()` to execute another constructor, passing it arguments if required.
- And `this()` must be the first executable statement, if it's used from another constructor.

```java
public Account(String customerName, String customerEmail, String customerPhone) {
  this("99999", 100.55, customerName, customerEmail, customerPhone);
//    this.customerName = customerName;
//    this.customerEmail = customerEmail;
//    this.customerPhone = customerPhone;
}
```

## Reference vs Object vs Instance vs Class

### Reference vs Object vs Instance vs Class

- A **class** is basically a blueprint for the house.
- Using the blueprint, we can build as many houses as we like, based on those plans.
- Each house we build (in other words using the new operator) is an object.
- This object can also be knwon as an instance, often we'll say it's an instance of the class. So we would have an instance of house in this example.
- In other words, if we want to tell someone where we live, we give them our address (perhaps written on a piece of page). This is known as a reference.
- We can copy that reference as many times as we like, but there is still just one house that we're refering to.
- In other words, we're copying the paper that has the address on it, not the house itself.
- We can pass references as parameters to constructors and methods.

### The Reference vs The Object

```java
new House("blue"); // house object gets created in memory
```

- This object is created in memory, but after that statement completes, our code has no way to access it.
- The object exists in memory, but we can't communicate with it, after that statement is executed.
- The object is said to be eligible for garbage collection, immediately after that first statement.
- It's no longer accessible.

```java
// house object gets created in memory
// and it's location (reference) is assigned to myHouse
House myHouse = new HOuse("beige");
```

- Our reference, myHouse, lets us have access to that beige house, as long as our variable, myHouse, stays in scope.

## Static vs Instance Variables

### Static Variables

- Declared by using the keyword static.
- Static variables are also known as static member variables.
- Every instance of the class shares the same static variable.
- So if changes are made to that variable, all other instnaces of that class will see the effect of that change.
- It is considered best practice to use the Class name, and not a reference variable to access a static variable.

  ```java
  class Dog {
    static String genus = "Canis";

    void printData() {
      Dog d = new Dog();
      System.out.println(d.genus); // Confusing!
      System.our.println(Dog.genus); // Clearer!
    }
  }
  ```

- Static variables aren't used very often, but can sometimes be very useful.
- They can be used for
  - Stroing counters
  - Generating unique ids.
  - Storing a constant value that doesn't change, lik PI for example.
  - Creating, and controlling access, to a shared resource.

```java
class Dog {
  private static String name;

  public Dog(String name) {
    Dog.name = name;
  }

  public void printName() {
    System.out.println("name = " + name);
  }
}

public class Main {
  public static void main(String[] args) {
    Dog rex = new Dog("rex");
    Dog fluffy = new Dog("fluffy");

    rex.printName(); // prints fluffy
    fluffy.printName(); // prints fluffy
  }
}
```

- 정적 변수는 서로 공유하는 인스턴스라는 것을 기억홰야한다!
- 정적 변수를 변경하면 모든 인스턴스가 변경한 것을 확인할 수 있다.

### Instance Variables

- They don't use the static keyword.
- They're also known as fields, or member variables.
- Instance variables belong to a specific instance of a class.
- Each instance has its own copy of an instance variable.
- Every instance can have a different value.
- Instnace variables represent the state, of a specific instnace of class.

```java
public class Main {
  public static void main(String[] args) {
    Dog rex = new Dog("rex");
    Dog fluffy = new Dog("fluffy");

    rex.printName(); // name = rex
    fluffy.printName(); // name = fluffy
  }
}

class Dog {
  private String name;

  public Dog(String name) {
    this.name = name;
  }

  public void printName() {
    System.out.println("name = " + name);
  }
}
```

## Static vs Instance Methods

### Static Methods

- Static methods are declared using a sttaic modifier.
- Static methods can't access instnace methods and instant variables directly.
- They're usually used for operations that don't require any data from an instance of the class (from `this`)
- If you remember, the `this` keyword is the current instance of a class.
- So inside a static method, we can't use the `this` keyword
- Whenever you see a method that doesn't use instance variables, that method should probably be declared as a static method.
- For example, main is a static method, and it's called by the Java virtual machine when it starts the Java application.

```java
public class Main {
  public static void main(String[] args) {
    Calculator.printSum(5, 10);
    printHello();
  }

  public static void printHello() {
    System.out.println("Hello");
  }
}

class Calculator {
  public static void printSum(int a, int b) {
    System.out.println("sum = " + (a + b));
  }
}
```

### Instance Methods

- Instance methods belong to an instance, of a class.
- To use an instance method, we have to instantiate the class first, usually by using the `new` keyword.
- Instance methods can access instance methods and instance variables directly.
- Instance methods can also access static methods and static variables directly.

### Static or Instance method

```
                                                                (yes) ↗️ It should probably be an instance method
Should a method  -->  Does it use any fields (instance variables)
   be staid?             or instance methods?
                                                                 (no) ↘️ It should probably be a st aic method
```

## The POJO

### Plain Old Java Object

- A plain old Java objerct (whose acroinym is `POJO`) is a class that generally only has instance fields.
- It's used to house data, and pass data, between functional classes.
- It usually has few, if any methods other than getters and setters.
- Many database frameworks use POJO's to read data from, or write data to, databases, files or streams.

### Examples of POJOS

- A POJO also might be called a bean, or a JavaBean.
- A JavaBean is just a POJO, with some extra rules applied to it.
- A POJO is sometimes called an Entity, because it mirrors database entities.
  - POJO는 데이터베이스 엔터티를 반영하기 때문애 가끔 엔터티라고 불린다.
- Another acronym is DTO, for Data Transfer Object(데이터 전송 객체).
- It's a description of an object, that can be modeled as just data.

## Support for POJO creation

- There are many generation tools, that will turn a data model into generated POJO's or JavaBean.

### Annotation

```java
@Override
public String toString() {
  return "Student{" +
          "id='" + id + '\'' +
          ", name='" + name + '\'' +
          ", dateOfBirth='" + dateOfBirth + '\'' +
          ", classList='" + classList + '\'' +
          '}';
}
```

- Annotations are a type of metadata.
- Metadata is a way of formally describing additional information about our code.
- Annotations are more structured, and have more meaning, than comments.
- This is because they can be used by the compiler, or other types of pre-processing functions, to get information about the code.
- Metadata doesn't effect how the code runs, so this code will still run, with or without the annotation.

### Overridden Method

- An overriden method, is not the same thing as an overloaded method.
- An overriden method is a special method in Java, that other calsses can implement, if they use a specified method signature.

## Java's Implicit POJO Type, The Record

### The Record type

- The record was introduced in JDK 14, and became officially part of Java in JDK 16.
- It's purpose is to replcae the boilerplate code of the POJO, but to be more restrictive.
  - 목적은 POJO의 보일러 플레이트 코드를 대체하기 위해서지만, 좀 더 제약이 가해진다.
- Java calls them `plain data carriers`.
- The record is a special class that contains data, that's not meant to be altered.
  - Record는 특별한 클래스로 변경할 수 없는 데이터가 포함되어 있다.
- In other words, it seeks to achieve immutability, for the data in its members.
- It contains only the most fundamental methods, such as constructors and accessors.
- Best of all, you the developer, don't have to write or generate any of this code.

```java
public class Student {
  private String id;
  private String name;
  private String dateOfBirth;
  private String classList;

  public Student(String id, String name, String dateOfBirth, String classList) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.classList = classList;
  }
  // ...
}
```

```java
public record LPAStudent(String id, String name, String dateOfBirth, String classList) {
}
```

- Record는 setter 메서드를 지원하거나 갖고 있지 않다.

### Implicit or Generated Code that Java provides

- What does Java tell us about what is implicitly created, when we declare a record as we did in this code?
  ```java
  public record LPAStudent(String id, String name, String dateOfBirth, String classList) {}
  ```
  - First, it's important to understand that the part that's in parentheses, is called the record header.
    - 괄호 안에 있는 부분을 **레코드 헤더**라고 부른다.
  - The record haeder consists of record components, a comma delimited list of components.
    - 레코드 헤더는 레코드 구성 요소로 구성되어 있다. 쉼표로 구분된 구성 요소 목록이다.
  - For each component in the header, Java generates:
    - A field with the same name and declared type as the record component.
    - The field is declared private and final.
    - The field is sometimes referred to as a component field.
  - Java generates a toString method that prints out each attribute in a formatted String.
  - In addition to creating a private final field for each component, Java generates a public accessor method for each component.
  - This method has the same name and type of the component, but it doesn't have any kind of special prefix, no get, or is, for example.
  - The accessor method, for id in this example, is simply id().

```java
public static void main(String[] args) {
  Student pojoStudent = new Student("S923006", "Ann", "05/11/1985", "Java Masterclass");
  LPAStudent recordStudent = new LPAStudent("S923007", "Bill", "05/11/1985", "Java Masterclass");

  System.out.println(pojoStudent);
  System.out.println(recordStudent);

  System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
  System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
}
```

### Why have an immutable record?

- Why is the record built to be immutable?
- There are more use cases for immutable data transfer objects, and keeping them well encapsulated.
  - 불변의 데이터 전송 객체를 위한 유스케이스가 존재한다.
- You want to protect the data from unintended mutations.

### POJO vs Record

- If you want to modify data on your class, you won't be using the record.
- You can use the code generation options for the POJO, as we showed in the earlier video.
- But if you're reading a whole lot of records, from a database or file source, and simply passing this data around, then the record is a big improvement.
  - 데이터베이스나 파일 소스로부터 많은 레코드를 읽고 이 데이터를 전달할 경우 레코드가 크게 개선된다.

### Java's new type, the record

- We've only touched on some of the features of the record, to give you an introduction.
- When we do talk more about the final keyword, and immutability of data, espeically as it may be affected by concurrent threads, we'll be revisiting this type.
- We'll also be showing it ot you in action, when we get to the Database and I/O sections of this course.

## Inheritance

### Inheritance

- We can look at Inheritance as a form of code re-use.
- It's a way to organize classes into a parent-child hierarchy, which lets the child inherit (re-use), fields and methods from its parent.
  - 클래스르 부모-자녀로 체계화해서 child가 상속받게 하는 방법이다.

### extends

- Using extends specifies the superclass (or the parent class) of the class we're declaring.
- We can say Dog is a subclass, or child class, of Animal.
- We can say Animal is a parent, or super class, of Dog.
- A class can specify one, and only one, class in tis extends clause.

### super()

- `super()` is a lot like `this()`.
- It's a way to call a constructor on the super class, directly from the sub class's constructor.
- Like `this()`, it has to be the first statement of the constructor.
- Because of that rule, `this()` and `supe()` can never be called from the same constructor.
- If you don't make a call to `super()`, then Java makes it for you, using super's default constructor.
- If your super class doesn't have a default constructor, than you must explicitly call `super()` in all of your constructors, passing the right arguments to that constructor.

### Code Re-use

- All subclasses can execute methods, even though the code is declared on the parent class.
- The code doesn't have to be duplicated in each subclass.
- We can use code, from the parent.
- Or we can change that code for the subclass.

### Overriding a method

- Overriding a method is when you create a method on a subclass, which has the same signature as a method on a super class.
- You override a parent class method, when you want the child class to show different behavior for that method.

### Overridden method

- The overridden method can do one of three things:
  - It can implement completely different behavior, overriding the behavior of the parent.
  - It can simply call the parent class's method, which is somewhat redundant to do.
  - Or the method can call the parent class's method, and include other code to run, so it can extend the functionality for the Dog, for that behavior.

### Polymorphism

- Polymorphism simply means 'many forms'.
- And as you've seen, some advantages of Polymorphism are:
  - It makes code simpler.
  - It encourages code extensibililty.(코드 확장성을 장려한다.)

## What is java.lang.Object?

### java.lang.Object

- This is because every class you create in Java, intrinsically extends a special Java class.
- This class is named Object, and it's in the java.lang package.
- Ok, that's confusing, a class called Object?
- Let's see what Java has to say about this class.
  - https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html

### Every Class inherits from Object

```
                Object - clone(), equals(obj: Object), hashCode(), toString()
              ↗️      ↖️
Main - static main()   String - charAt(int, index), equals(obj: Object), toString(), static valueOf(Object obj)
```

- our Main class inherits from, or is a subclass of Object, as also is String.
- The String class has over 60 methods!
- The String class overrides several methods on Object, two of which are `equals()`, and `toString()`.

## this vs super

### this vs super

- Let's start with the `super`, and the `this` keywords first.
- The keyword `super` is used to access or call the parent class members (variables and methods)
- The keyword `this` is used to call the current class members (variables and methods).
- `this` is required, when we have a parameter with the same name, as an instance variable or field.
- NOTE: We can use either of them anywhere in a class, except for static elements, like a static method. Any attempt to do so there, will lead to compile time errors.

### this() vs super() call

- In Java, we've got the `this()` and `super()` call. Notice the parentheses.
- These are known as calls, since it looks like a regular method call, although we're calling certain constructors.
- Use `this()` to call a constructor, from another overloaded constructor in the same class.
- The call to `this()` can only be used in a constructor, and it must be the first statement in a constructor.
- It's used with constructor chaining, in other words when one constructor calls another constructor, and it helps to reduce duplicated code.
- The only way to call a parent constructor, is by calling `super()`, which calls the parent constructor.

### this() vs super() call

- The Java compiler puts a default call to `super()`, if we don't add it, and it's always a call to the no argument constructor, which is inserted by the compiler.
- The call to `super()` must be the first statement in each constructor.
- A constructor can have a call to `super()` or `this()`, but never both.

### this, this(), super() example

```java
class Shape {
  private int x;
  private int y;

  public Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Rectangle extends Shape {
  private int width;
  private int height;

  // 1st constructor
  public Rectangle(int x, int y) {
    this(x, y, 0, 0); // call 2nd constructor
  }

  // 2nd constructor
  public Rectangle(int x, int y, int width, int height) {
    super(x, y); // calls constructor from parent (Shape)
    this.width = width;
    this.height = height;
  }
}
```

## Method Overloading vs Overriding

### Method overloading

- `Method overloading` means providing two or more separate methods, in a class, with the `same name`, but `different parameters`.
- Method return type may or may not be different, and that allows us to reuse the same method name.
- `Overloading` is very handy, it **reduce duplicated code**, and we don't have to remember multiple method names.
- We can overload static, or instance methods.
- To the code calling an overloaded method, it looks like a single method can be called, with different sets of arguments.
- In actuality, each call that's made with a different set of arguments, is calling a separate method.
- Java developers often refer to method overloading, as compile-time polymorphism.
- This means the compiler is determining the right method to call, based on the method name and argument list.
- Usually `overloading` happends within a `single class`.
- But methods can also be overloaded by subclasses.
- That's because, a subclass inherits one version of the method from the parent class, and then the subclass can have another overloaded version of that merthod.

### Method Overloading Rules

- Methods will be considered overloaded if both methods follow the following rules:
  - Methods must have the same method name.
  - Methods must have different parameters.
- If methods follow the rules above:
  - They may or may not have different return types.
  - They may or may not have different access modifiers.
  - They may or may not throw different checked or unchecked exceptions.

### Method Overriding

- Method overriding, means defining a method in a child class, that already exists in the parent class, with the same signature (the **same name, smae argument**).
- By extending the parent class, the child class gets all the methods defined in the parent class (those methods are also known as derived methods).
- `Method overriding` is also known as `Runtime Polymorphism`, or `Dynamic Method Dispatch`, because the method that is going to be called, is decided at runtime, by the Java virtual machine.
- When we `override` a method, it's recommended to put `@Override`, immediately above the method definition.
- The `@Override` statement is not required, but it's a way to get the compiler to flag an error, if you don't actually properly override this method.
- We'll get an error, if we don't follow the overriding rules correctly.
- We can't override static methods, **only instance methods** can be overridden.

### Method Overriding Rules

- A method wil be considered overridden, if we follow these rules.
- It must have the same name and same arguments.
- The return type can be a subclass of the return type in the parent class.
- It can't have a lower access modifier. In other words, it can't have more restrictive access privileges.
- For example, if the parent's method is protected, then using private in the child's overridden method is not allowed. However, using pulbic for the child's method would be allowed, in this example.
- There's also some important points about method overriding to keep in mind.
  - Only. **inherited methods** can be overridden, in other words, methods can be overridden only in child classes.
  - Constructors and private methods cannot be overridden.
  - Methods that are final cannot be overridden.
  - A subclass can use `super.methodName()` to call the superclass version of an overridden method.

### Method Overriding vs Overloading

| Method Overloading                                                       | Method Overriding                                                                |
| ------------------------------------------------------------------------ | -------------------------------------------------------------------------------- |
| Provides functionality to reuse a method name with different parameters. | Used to override a behavior which the class has inherited from the parent class. |
| Usually in a single clas but may also be used in a child class.          | **Always in two classes** that have a child-parent or IS-A relationship.         |
| **Must have** different parameters.                                      | **Must have** the same parameters and smae name.                                 |
| May have different return types.                                         | **Must have** the same return type or covariant return type(child class).        |
| May have different access modifiers(private, protected, public).         | **Must NOT** have a lower modifier but may have a higher modifie.                |
| May throw different exceptions.                                          | **Must NOT** throw a new or broader check exceiption.                            |
