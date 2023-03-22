# OOP - Polymorphism

## Composition

### Inheritance vs Composition

- **Inheritance** is a way to reuse functionality and attributes.
- **Composition** is a way to make the combination of classes, act like a single coherent object.
- Inheritance defines an `IS A` relationship.
- Composition defines a `HAS A` relationship.

```
  Product
     | Inherits(IS A)       ↗️ Monitor
PersonalComputer  ----------- Motherboard
      is Made Up Of(Has A)  ↘️ ComputerCase
```

### Composition is creating a whole from different parts

- We built this personal computer, by passing objects, to the constructor, like assembling the computer.
- We can actually hide the functionality further.
- In this case, we're not going to aloow the **calling program**, to **access those objects, the parts, directly**.

### Use Composition or Inheritance or Both?

- As a general rule, when you're designing your programs in Java, you probably want to look at composition first.
- Most of the experts will tell you, that as a rule, look at using composition before implementing inheritance.

### Why is Composition preferred over Inheritance in many designs?

- The reason composition is preferred over inheritance:
  - Composition is more flexible. You can add parts in, or remove them, and these changes are less likely to have a downstream effect.
  - Composition provides functional reuse outside of the class hierarchy, meaning classes can share attributes & behavior, by having similar components, instead of inheriting functionality from a parent or base class.
- Java's inheritance breaks encapsulation, because subclasses may need direct access to a parent's state or behavior.
  - 서브클래스는 부모의 상태나 행동에 직접 접근해야 하기 떄문에 캡슐화를 깰 수 있다.

### Wny is Inheritance less flexiable?

- Inheritance is less flexible.
- Adding a class to, or removing a class from, a class hierarchy, may impact all subclasses from that point.
- In addition, a new subclass may not need all the functionality or attributes of its parent class.

## Encapsulation

### What does Encapsulation Mean?

- In Java, encapsulation means hiding things, by making them private, or inaccessible.

### Why hide things?

- Why would we want to hide things in Java?
  - To make the interface simper, we may want to hide unneccessary details.
  - To protect the integrity of data on an object, we may hide or restrict access to some of the data and operations. 
    - 어떤 객체의 데이터 무결성을 보호하기 위해 일부 데이터와 작업에 대한 액세스 권한을 숨기거나 제한할 수 있다.
  - To decouple the published interface from the internal details of the clas, we may hide actual names and types of class members.

### What do we mean by interface here?

- Although Java has a type called interface, that's not what we're talking about here.
- When we talk about a class's public or published interface, we're really talking about the class members that are exposed to, or can be accessed by, the calling code.
- Everything else in the class is internal, or private to it.
- An application programming interface, or API, is the public contract, that tells others how to use the class.

### Probleam

```java
public class Main {
  public static void main(String[] args) {
    Player player = new Player();
    player.name = "Tim";
    player.health = 20;
    player.weapon = "Sword";

    int damage = 10;
    player.loseHealth(damage);
    System.out.println("Remaining health = " + player.healthRemaining());
    player.health = 200;
    player.loseHealth(11);
    System.out.println("Remaining health = " + player.healthRemaining());
  }
}
```

#### Problem

- Allowing direct access to data on an object, can potentially bypass checks, and additional processing, your class has in place to manage the data.
  - It encourages an interdependency, or coupling, between the calling code and the class.
- Allowing direct access to fields, means calling code would need to change, when you edit any of the fields.
- Omitting a constructor, that would accept initialization data, may mean the calling code is responsible for setting up this data, on the new object.

### Benefits of Encapsulation

- That's really one of the huge benefits of encapsulation, is that you're actually affecting any other code.
  - 캡슐화의 큰 장점 중 하나는 다른 코드에 실제 영향을 주지 않는다는 것이다.(해당 클래스를 사용한 인스턴스에는 클래스 내부가 바뀌어도 인스턴스에는 영향이 가지 않는다.)
- It's sort of like a black box in many ways.
- But the EnhancedPlayer class has more control over it's data.

### Staying in Control

- This is why we want to use encapsulation.
- We protect the members of the class, and some methods, from external access.
- This prevents calling code from bypassing the rules and constraints, we've built into the class.
- When we create a new instance, it's initialized with valid data.
- But likewise, we're also making sure that there's no direct access to the fields.
- That's why you want to always use encapusulation.
- It's something that you should really get used to.

### Encapsulation Principles

- To create an encapsulated class, you want to:
  - Create constructors for object initialization, which enforces that only objects with valid data will get created.
    - 객체 초기화를 위한 생성자를 만들어 유효한 데이터만 생성되도록 만들 수 있다.
  - use the private access modifier for your fields.
  - Use setter and getter methods sparingly, and only as needed.
  - Use access modifiers that aren't private, only for the methods that the calling code needs to use.

## Polymorphism

### Polymorphism

- Simply stated, polymorphism, means many forms.
- How does this apply to code?

### Polymorphism

- Polymorephism lets us write code to call a method, but at runtime, this method's behavior can be different, for different objects.
- This means the behavior that occurs, while the program is executing, depends on the runtime type of the object.
- And the runtime type, might be different from the declared type in the code.
- The delcared type has to have some kind of relationship to the runtime type, and inheritance is one way to establish this relationship.
- There are other ways, but in this video, we'll talk about how to use inheritance, to support polymorphism.

### Polymorphism in action

- That was polymorphism in actino.
- It's the ability to execute different behavior, for different types, which are determined at runtime.
- And yet we did it with just two statements, in the main method, as shown here.
  ```java
  Movie movie = Movie.getMovie(type, title);
  movie.watchMovie();
  ```
- Polymorphism enables you to write generic code, based on the base class, or a parent class.
- This code can handle any instances that are a Movie, or a subclass of moive, that are returned from the factory method.

### What is var?

- `var`, is a special contextual keyword in Java, that lets our code take advantage of Local Variable Type Interface.
- By using var as the type, we're telling Java to figure out the compile-time type for use.

### Local Variable Type Interface (LVTI)

- Local Variable Type Interface was introduced in Java 10.
- One of the benefits is to help with the readability of the code, and to reduce boilerplate code.
- It's called `Local Variable Type Interface` for a lesson, becuase:
  - It can't be used in field declarations on a class.
  - It can't be used in method signatures, either as a parameter type or a return type.
    - 메서드에서 파라미터나 리턴 타입으로 사용될 수 없다.
  - It can't be used without an assignment, because the type can't be inferred in that case.
    - 유형을 추론할 수 없기 때문에 할당 없이 사용할 수 없다.
  - It can't be assigned a null literal, again because a type can't be inferred in that case.
    - 유형을 추론할 수 없기 때문에 null 리터럴을 할당할 수 없다

### Run Time vs Compile Time Typing

- Are you still confused about the difference between run time and compile time typing?
- You can think of the compile time type as the **declared** type.
- This type is declared either as a variable reference, or a method return type, or a method parameter, for example.
- In the case of `LVTI`, we don't declare a type for the compiled reference type, it gets inferred, but the byte code is the same, as if we had declared it.
- In many cases, the compile time type, is the declared type to the left of the assignmment operator.
- What is returned on the right side of the assignment operator, from whatever expression or method is executed, sometimes can only be determined at runtime, when the code is executing conditionally, through the statements in the code.
- You can assign a runtime instance, to a different compile time type, only if certain rules are followed.
  - In this course, up to now, we've looked at only one rule that applies, and that's the inheritance rule.
  - We can assign an instance to a variable of the same type, or a parent type, or a parent's parent type, including java.lang.Object, the ultimate base class.

### Run Time vs Compile Time Typing

- Why are runtime types different than compile time types?
- Because of polymorphism.
  - Polymorphism lets us write code once, in a more generic fashion, like the code we started this lecture with.
- We saw that those two lines of code, using a single compile time type of Movie, actually supported four different runtime types.
  - Each type was able to execute behavior unique to the class.

<details>
  <summary>Four dirrent runtime types</summary>

```java
public class Movie {
  private String title;

  public Movie(String title) {
    this.title = title;
  }

  public void watchMovie() {
    String instanceType = this.getClass().getSimpleName();
    System.out.println(title + " is a " + instanceType + " film");
  }

  public static Movie getMovie(String type, String title) {
    return switch (type.toUpperCase().charAt(0)) {
      case 'A' -> new Adventure(title);
      case 'C' -> new Comedy(title);
      case 'S' -> new ScienceFiction(title);
      default -> new Movie(title);
    };
  }
}

class Adventure extends Movie {
  public Adventure(String title) {
    super(title);
  }

  @Override
  public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3), "Pleasant Score", "Scary Music", "Something Bad Happens");
  }

  public void watchAdventure() {
    System.out.println("Watching an Adventure!");
  }
}
class Comedy extends Movie {
  public Comedy(String title) {
    super(title);
  }

  @Override
  public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3), "Something funny happens", "Something even funnier happens", "Happy Ending");
  }

  public void watchComedy() {
    System.out.println("Watching an Comedy!");
  }
}

class ScienceFiction extends Movie {
  public ScienceFiction(String title) {
    super(title);
  }

  @Override
  public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3), "Bad Aliens do Bad Stuff", "Space Guys Chase Aliens", "Planet Blow Up");
  }

  public void watchScienceFiction() {
    System.out.println("Watching an ScienceFiction!");
  }
}
```

</details>

### Evaluating what the runtime type is

```java
Object unknownObject = Movie.getMovie("C", "Airplane");
if (unknownObject.getClass().getSimpleName().equals("Comedy")) {
  Comedy c = (Comedy) unknownObject;
  c.watchComedy();
} else if (unknownObject instanceof Adventure) {
  ((Adventure) unknownObject).watchAdventure();
} else if (unknownObject instanceof ScienceFiction syfy) {
  // JDK 16에서 공식적으로 Java의 일부가 됨. 캐스팅 없이 바로 ScienceFiction 타입의 syfy 사용 가능
  syfy.watchScienceFiction();
}
```

- And how do we test what the runtime type, of a variable really is at runtime, if the declared type is something else?
- We can teset to see what type the actual object is, at runtime, in several different ways.
  - `if` 문 이용해 메서드에서 돌아오는 객체의 클래스 이름을 알 수 있다.
  - `instanceof` 사용하기


#### instanceof operator

- The `instanceof` opeator, lets you test the type of an object or instance.
- The reference variable you are testing, is the left operand.
- The type you are testing for, is the right operand.
- It's important to see that Adventure is not in quotes, meaning we're not testing the type name, but the actual type.
- This operator returns `true`, if `unknownObject` is an instance of `Adventure`.

#### Pattern Matching for the instanceof Operator

- If the JVM can identify that the object matches the type, it can extract data from the object, without casting.
- For this operator, the object can be assigned to a binding variable, which here is called `syfy`.
- The variable `syfy` (if the instanceof method returns true) is already typed as a `ScienceFiction` variable.

## Organizing Java Classes, Packages and Import Statements

### Organinizing Java Classes

- Up untill this point in the class, we haven't created a lot of classes, so we haven't had to think much about organizing those classes.
- As the course progresses, we're going to be using more and more of Java's libraries, and our applications are going to ge more complex.
- This feels like a good time to talk about the package and import statements, in more detail.
- We've talked briefy about import statements, when we used the Scanner class, and we mentioned packages when we talked about access modifiers.

### Package

- As per the Oracle Java Documentation:
  - A package is a namespace that organizes a set of related types.
- In general, a package corresponds to a folder or directory, on the operating system, but this isn't a requirement.
- When using an IDE, ilke IntelliJ, we don't have to worry about how packages and classes are stored on the file system.
- The package structure is hierarchical, meaning you group types in a tree fashion.
- You can use any legal Java identifier for your package names, but common practice has package names as all lower case.
- The period separates the hierarchical level of the package.

### What is the purpose of packages?

- Package let us re-use common class names across different libraries or applications, and provide a way to identify the correct class, either with an import statement, or a qualifying name.
- For example, you might have a package for utility classes, that can provide common functionality, for all of your classes to access.
- Packages let us organize our classes by functionality, or relationships.
- Packages also let us encapsulate our classes, from classes in other packages.
- So you migh have a package of tightly coupled classes, that should only be accessed by each other, but not by the outside world, as an example.

### The Fully Qualified Class Name vs the import statemenet

```java
package dev.lpa.package_one;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
  }
}
```


