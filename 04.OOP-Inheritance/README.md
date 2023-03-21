# OOP - Inheritance

## Introduction to Classes and Objects

### What is Object Oriented Programming?

- `Object oriented programming` is a way to model real world objects, as software objects, which contain both data and code.
  - 데이터와 코드를 포함한 소프트웨어 객체로 모델링하는 방법이다.

### Class-based Programming

- Class-based programming starts with classes, which become the blueprints for objects.
- But what does this really mean?
  - So, to start, we need to understand whta objects are.
  - They're really the key to undestanding this `Object Oriented terminology`.
- Real world objects have two major components
  - State, behavior

### State and Behavior

- Modelling real world objects as software objects, is a fundamental part of Object Oriented Programming.
- Now, a software object stores its state in fields, which can also be called variables, or attributes.
- And Objects expose their behavior with methods, which we've talked about before.

### The class as the blueprint

- The class describes the data (fields), and the behavior (methods), that are relevant to the real world object we want to describe.
- A class member can be a field, or a metohd, or some other type of dependent element.
- If a field is staic, there is onlly one copy in memory, and this value is associated with the class, or template, itself.
- If a field is not static, it's called an instance field, and each object may have a different value stored for this field.
- A static method can't be dependent on any one object's state, so it can't reference any instance members.
- In other words, any method that operates on instance fields, needs to be non-static.

### Organizing classes

- Classes can be organized into logical groupings, which are called packages.
- You declare a package name in the class using the package statement.
- If you don't declare a package, the class implicitly belongs to the default package.

### Access modifiers for the class

- A class is said to be a top-level class, if it is defined in the source code file, and not enclosed in the code block of another class, type or method.
- A top-level class has only two valid access modifier options: public, or none.

  | Access keyword | Description                                                                                                                                         |
  | -------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
  | public         | public means any other class in any package can access this class.                                                                                  |
  |                | When the modifier is omitted, this has special meaning, called package access, meaning the class is accessible only to classes in the same package. |

### Access modifiers for class members

- An access modifier at the member level, allows granular control over class members.
- The valid access modifiers are shown in this table from the least restrictive, to the most restrictive.

  | Access keyword | Description                                                                                                                                         |
  | -------------- | ------------------------- -------------------------------------------------------------------------------------------------------------------------- |
  | public         | public means any other class in any package can access this class.                                                                                  |
  | protected      | protected allows classes in the same package, and anysubclasses in other packages, to have access to the member.                                    |
  |                | When the modifier is omitted, this has special meaning, called package access, meaning the class is accessible only to classes in the same package. |
  | private        | private means that no toher class can access this member                                                                                            |

### Encapsulation

- Encapsulation in Object. Oriented Programming usually has two meanings.
- One is the bundling of behavior and attributes on a single object.
- The other is the practice fo hiding fields, and some methods, from public access.

## Introduction to Classes, Using Getter Methods

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

### Covariant Return Type

- The return type of an overridden method can be the same type as the parent method's declaration.
- But it can also be a subclass.
- The term, covariant return type, is more appropriate.
- We briefly mentionsed, in a previous video, that there's a clone method on the class Object, that all classes inherit from.
- A simplified look at this declaration, for our purposes, is shown below.
  ```java
  protected Object clone() throw CloneNotSupportedException
  ```
- And if you override this method, by using IntelliJ's code generation tools, it would generate this code in your class:
  ```java
  protected Object clone() throw CloneNotSupportedException {
    return super.clone();
  }
  ```
- But in general, when you're cloning an instance, you're going to want to return an Object, that's the same typue as the Object you're are cloning.
- Remember, we said all classes ultimately have Object as a base class, so every class can be said to be a covariant of Object.

## The Text Block and other Formatting Options

### What's a TextBlock

- A Text Block is just a special format for `multi-line` String literals.
- It's simply a `String`, with a new representation in the source code.
- It became part of the official language as of **JDK 15**.

### Some Common Escape Sequence

- An escape sequence starts with a backslash. Java has several, but the most common ones, are shown on this slide.

  | Escape Sequence | Description                      |
  | --------------- | -------------------------------- |
  | \t              | Insert a tab character.          |
  | \n              | Insert a new line character.     |
  | \"              | Insert a double quote character. |
  | \\              | Insert a backslash character.    |

### Format Specifiers

- At their most complex, format specifiers take the form shown here.
- `%[argument_index$][flags][width][.precision]conversion`
- They start with a percent sign, and end with a conversion symbol, and have lots of options in between.
- We've looked at one conversion type, `d`, which is the symbol used for a decimal integer value.
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html
- `d`는 10진수 정수이다.
- `f`는 소수점을 표현할 때 사용

## Another Look at the String

### The String

- The String has **over 60 methods** avaiable.
- The String is a sequence of characters, meaning its characters are ordered and indexed.
  - The index starts at 0, and not 1.

### The purpose of String methods

- We can split String's methods up into three basic categories:
  - String Inspection Methods.
  - Methods for Comparing String values.
  - String Manipulation Methods.

### String Inspection Methods

- `length`
  - Returns the number of characters in the String.
- `charAt`
  - Returns the character at the index that's passed.
- `indexOf`, `lastIndexOf`
  - Returns an integer, representing the index in the sequence where the String or character passed, can be located in the String.
- `isEmpty`
  - Returns true if length is zero.
- `isBlank`
  - Returns true if length is zero OR the string only contains whitespace characters, added in JDK 11.
- `contentEquals`
  - Returns a boolean if the String's value is equal to the value of the argument passed. This method allows for arguments other than String, for any type that is a character sequence.
- `equals` 
  - Return a boolean if the String's value is equal to the value of the argument passed.
- `equalsIgnoreCase`
  - Return a boolean if the String's value is equal (ignoring case), to the value of the argument passed.
- `contains`
  - Returns a boolean if the String contains the argument passed.
- `endsWith`, `startWith`
  - THese return a boolean, and are much like the contains method, but more specific to the plcaement of the argumetn in the String.
- `regionMatches`
  - Returns a boolean, if defined sub-regions are matched.

### String Comparison Methods

- The first set of methods, don't actually change the underlying meaning of the text value, but perform some kind of clean up.
- `indent`
  - This method was aded in JDK 15, and adds or removes spaces from the beginning of lines in multi-line text.
- `strip`, `stripLeading`, `stripTrailing`, `trim`
  - The difference between the strip method and trim meethod is that the `strip()` supports a larger set of white space characters. It and the corresponding stripLeading and stripTrailing methods were added in JDK 11.
- `toLowerCase`, `toUpperCase`
  - Returns a new String, either in a lower case or in upper case.
- The second set of string manipulation methods, transform the String value, and return a String with a different meaning, than the original String.
  - `concat`
    - Similar to the plus operator for strings, it concatenates text to the String and returns a new String as the result.
    - ex: "25".concat("/").concat("11").concat("/").concat("1982")
  - `join`
    - Allows multiple strings to be concatenated together in a single method, specifying a delimiter.
    - ex: String.join("/", "25", "11", "1982)
  - `repeat`
    - Returns the String repeated by the number of times specified in the argument.
  - `replace`, `replaceAll`, `replaceFirst`
    - These methods replcae characters or strings in the stirng, returning a new String with replcaements made.
    - `replaceAll`의 첫 번째 인자로 `regex`를 전달해야 한다. `replace`는 `oldChar`를 전달.
  - `substring`, `subSequence`
    - These return a part of the String, its range defined by the start and end index specified.

## The StringBuilder class

### String vs StringBuilder

- Java provides a mutable class that lets us change its text value.
- This is the StringBuilder Class.

### Creating Instances

- There are four ways to create a new StringBuilder object, using the new keyword:
  - Pass a String.
  - Pass no arguments at all.
  - Pass an integer value.
  - Pass some other type of character sequence (like StringBuilder)

### String

```java
String hello = "Hello World";
hello.concat(" and Goodbye");
System.out.println(hello); // Hello World
```

- When we passed the String literal, `and Goodbye`, to the `concat` method, this created an Object in memory for that literal, `and Goodbye`
- It also created the result of the concat method, the object, the String, that has the value, "Hello World and Goodbye"
- These methods don't change the internals of the existing String object.
- The String referenced by the helloWorld variable never changed, instead a new String was created by the method call.

### StringBuilder

```java
StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
helloWorldBuilder.append(" and Goodbye");

printStringBuilder(helloWorldBuilder); // Hello World and Goodbye
```

- After the call to the `append` method, we still only have one StringBuilder object.
- The variable `helloWorldBuilder`, is still referencing the same object, but the value of that objecte changed.
- This is important, because it means the character sequence in the StringBuilder changed.

### String method vs StringBuilder methods

- String methods create a new object in memory, and return a reference to this new object.
- StringBuilder methods return a StringBuilder reference, but it's really a self-reference.

```java
StringBuilder emptyStart = new StringBuilder();
StringBuilder emptyStart32 = new StringBuilder(32);

System.out.println(emptyStart); // 
System.out.println(emptyStart32); // 
System.out.println(emptyStart.capacity()); // 16
System.out.println(emptyStart32.capacity()); // 32
```

- 빈 StringBuilder는 기본값으로 용량이 16으로 시작한다.
- 더 많은 메모리를 요청하기 전에 최대 16글자를 포함할 수 있다.
- StringBuilder는 텍스트가 증가맣에 따라 용량을 조정해야 한다.
- 만약 StringBuilder 객체에 큰 텍스트 값을 보관할 계획이라면 더 큰 용량으로 시작하는 것이 좋다.

### Some methods unique to the StringBuilder class

- A StringBuilder class has manuy similar methods to Strings.
- `delete`, `deleteCharAt`
  - You can delete a substring using indices to specify a range, or delete a single character at an index.
- `insert`
  - You can insert text at a specified position.
- `reverse`
  - You can reverse the order of the characters in the sequence.
- `setLength`
  - setLength can be used to truncate the sequence, or include null sequences to `fill out` the sequence to that length.
- But it also has methods to remove and insert characters or Strings, and truncate it's size.