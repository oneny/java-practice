# Abstraction in Java

## Abstraction & Generalization (with orverview of abstract and other modifiers)

### Generalization

- When you start mdeling objects for your application, you start by identifying what features and behavior your objects have in common.
- We generalize when we create a class hierarchy.
- A base class is the most general class, the most basic building block, which everything can be said to have in common.

### Abstraction

- Part of generalizing is using abstraction.
- You can generalize a set of characteristics and behvior into an abstract type.
- If you consider an octopus, a dog, and a penguin, you would probably say they're all animals.
- An animal is really an abstract concept.
- An animal doesn't really exist, except as a way to describe a set of more specific things.
- If you can't draw it on a piece of paper, it's probably abstract.
- Abstraction simplifies the view of a set of items'traits and behavior, so we can talk about them as a group, as well as generalize their functionality.

### Java's support for Abstraction

- Java supports abstraction in several different ways.
- Java allows us to create a class hierarchy, where the top of the hierarchy, the base class, is usually an abstract concept, whether it's an abstract class or not.
- Java let's us create abstract classes.
- Java gives us a way to create interfaces.

### Abstract method

- An abstract method has a method signature, and a return type, but doesn't have a method body.
- Because of this, we say an abstract method is `unimplemented`.
- It's purpose is to describe behavior, which any object of that type will always have.
- Concepually, we can understand behaviors like move or eat on an Animal, so we might include those as abstract methods, on an abstract type.
- You can think of an abstract method as a contract.
- This contract promises that all subtypes will provide the promised functionality, with the agreed upon name and arguments.

### Concrete method

- A concrete method has a method body, usually with at least on statemenet.
- This means it has operational code, that gets executed, under the right conditions.
- A concrete method is said to `implement` an abstract method, if it overrides one.
- Abstract classes and interfaces, can have a mix of abstract and concrete methods.

### Method Modifiers

- We know we have public, protected, package, and private access modifiers, as options for the memebers.
- In addition to access modifiers, methods have other modifiers, which we'll list here, as a high-level introduction.

| Modifier     | Purpose                                                                                                                                                                                                                                                                                                                     |
| ------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| abstract     | When you declare a method abstract, a method body is always omitted. An abstract method can only be declared on an abstract class or an interface.                                                                                                                                                                          |
| static       | Sometimes called a class method, rather than an instance method, because it's called directly on the Class instance.                                                                                                                                                                                                        |
| final        | A method that is final connot be overridden by subclasses.                                                                                                                                                                                                                                                                  |
| default      | This modifier is only applicable to an interface, and we'll talk about it in our interface videos.                                                                                                                                                                                                                          |
| native       | This is another method with no body, but it's very different from the abstract modifier. The method body will be implemented in platform-dependent code, typically written in another programming language such as C. This is an advanced topic and not generally commonly used, and we won't be covering it in this couse. |
| synchronized | This modifier manages how multiple threads will access the code in this method. We'll cover this in a later section on multi-threaded code.                                                                                                                                                                                 |

## Abstract Classes

### The abstract class

```java
// An abstract class is declared with the abstract modifier.
abstract class Animal {}
```

- The abstract class is declared with the `abstract` modifier.
- Here we are declaring an abstract class called Animal.
- An `abstract` class is a class that's `incomplete`.
  ```java
  Animal a = new Animal(); // INVALID, an abstract class never gets instantiated
  ```
  - An abstract class can still have a constrctor, which will be called by its subclasses, during their construction.
- An abstract class's purpose is to define the behavior it's subclasses are required to have, so it always participates in `inheritance`.
- For the examples, assume that Animal is an abstract class.
  ```java
  class Dog extends Animal {} // Animal is abstract, Dog is not
  ```
  - Classes extend abstract classes, and can be concrete.
  - Dog extends Animal, Animal is abstract, but Dog is concrete.
- A class that extends an abstract class, can also be abstract itself.
  ```java
  abstract class Mammal extends Animal {} // Animal is abstract, Mammal is also abstract
  ```
  - Mammal is declared abstract and it extends Animal, which is also abstract.
- And finally an abstract class can extend a concrete class.
  ```java
  abstract class BestOfBreed extends Dog {} // Dog is not abstract, but BestOfBreed is
  ```

### What's an abstract method?

```java
abstract class Animal {
  public abstract void move();
}
```

- An abstract method is declared with the modifier `abstract`.
- we're declaring an abstract method called move, with a void return type.
- It's simply ends with a semi-colon.
- It doesn't have a body, not even curly braces.

### What good is an abstract method, if it doesn't have any code in it?

```java
abstract class Animal {
  public abstract void move();
}
```

- An abstract method tells the outside world, that all Animals will move.
- Any code that uses a subtype of Animal, knows it can call the move method, and the subtype will implement this method with this signature.
- This is also true for a concrete class, and a concrete method that's overridden.

### An Abstract class doesn't have to implement abstract methods?

- An abstract class that extends another abstract class has some flexibility.
  - It can implement all of the parent's abstract methods.
  - It can implement some of them.
  - Or it can implement none of them.
  - It can also include additional abstract methods, which will force subclasses to implement both Animal's abstract methods, as well as Mammal's.

### Why use an abstract class?

- In truth, you may never need to use an abstract class in your design, but there are some good arguments for using them.
- An abstract class in your hierarchy forces the designers of subclasses, to think about, and create unique and targeted implementsations, for the abstracted methods.
- It may not always make sense to provide a default, or inherited implementation, of a particular method.
- An abstract class can't be instantiated, so if you're using abstract classes to design a framework for implementation, this is definitely an advantage.

## Interfaces

### Interface vs Abstract Class

- We saw that an abstract class requires its subclasses, to implement its abstract methods.
- An `interface` is similar to an abstract class, although it **isn't a class** at all.
- It's a `special` type, that's more like a `contract` between the class and client code, that the compiler enforces.
- By declaring it's using an interface, your class must implement all the abstract methods, on the interface.
- A class agrees to this, because it wants to be **known by that type**, by the outside world, or the client code.
- An `interface` lets **classes that might have little else in common**, be recognized as a special reference type.

### Declaring an interface

```java
public interface FlightEnabled {}
```

- Declaring an interface is similar to declaring a class, using the keyword `interface`, where you would use `class`.
- An interface is usually name, according to the set of behaviors it describes.
- Many interfaces will end in `able`, like Comparable, and Iterable, again meaning something is capable, or can do, a given set of behaviors.

### Using an interface

```java
public class Bird implements FlightEnabled {}
```

- A class is associated to an interface, by using the `implement` clause in the class declaration.
- In this example, the class Bird implements the FlightEnalbed interface.
- Because of this declaration, we can use FlightEnabled as the reference type, and assign it as instance of bird.
- In this code sample, we create a new Bird object, but we assign it to the FlightEnabled varaible named filter.
  ```java
  FlightEnabled flier = new Bird();
  ``
  ```

### A class can use extends and implements in same declaration

```java
public class Bird extends Animal implements FlightEnabled, Trackable {
}
```

- A class can only `extend` a `single class`, which is why Java is called single inheritance.
- But a class can `implement many interfaces`. This give us **plug and play functionality**, which is what make them so powerful.
- A class can `both extend` another class, and `implement` one or more interfaces.
- We can describe Bird by what it is, and what it does.

### The abstract modifier is implied on an interface

```java
// abstract modifier here is unnecessary and redundant
abstract interfcae FlightEnabled {}
```

- We don't have to declare the interface type abstract, because this modifier is implicitly declared, for all interfaces.
- Likewise, we don't have to declare any method abstract.
- In fact, any method declared without a body, is really **implicitly declared both public and abstract**.
- The three declarations result in the same thing, under the covers:

  ```java
  public abstract void fly(); // public and abstract modifiers are redundant, meaning unnecessary to declare

  abstract void fly(); // abstract modifier is redundant, meaning unnecessary to declare

  void fly(); // This is PREFERRED declaration, public and abstract are implied.
  ```

### All members on an interface are implicitly public

- If we omit an access modifier on a `class member`, it's **implicitly package priavet**.
- If we omit an access modifier on an `interface member`, it's **implicitly public**.
- This is an important difference, and one you need to remember.
- Changing the access modifier of a method to `protected`, on an interface, is `a compiler error`, whether the method is concrete or abstract.
- Only a concrete method can have private access.

### THe final modifier in Java

- **When we use the final modifier, we prevent any further modifications to that component.**
  - a final method means it can't be overridden by a subclass.
  - a final field means an object's field that can't be reassigned, or given a different value, after the class's initialization process.
  - a final class can't be overridden, meaning no class can use it, in the extends clause.
  - a final variable, in a block of code, means that once it's assigned a value, any remaining code in the block can't change it.
  - a final method parameter means, we can't assign a different value to that parameter in the method code block.
- The final static field, is what you're really creating, when you declare a field on an interface.

### A field declared on an Interface is always public, static and final

```java
double MILES_TO_KM = 1.60934;
final double MILES_TO_KM = 1.60934;
public final double MILES_TO_KM = 1.60934;
public static final double. MILES_TO_KM = 1.60934;
```

- Java let's us specify these like an ordinary field on an interface, which might be kind of confusing, and misleading to a new Java programmer.
- But we can declare them with any combination of those modifiers, or none at all, with the same result.
- These all mean the same thing on an interface.

### Extending Interfaces

```java
interface OrbitEarch extends FlightEnalbed, Trackable {}
```

- Interfaces can be extended, similar to classes, using the `extends` keyword.
- This interface requires all classes to implement both the OrbitEarth, and the FlightEnabled abstract methods.
- Unlike a class, an interface can use the extends expression with multiple interfaces:

### Implements is invalid on an interface

```java
interface OrbitEarch implements FlightEnalbed {} // INVALID, implements is invalid clause for interfaces
```

- An interface doesn't implement another interface, so the code won't compile.

### Abstracted Types - Coding to an Interface

- Both interfaces and abstract classes are **abstracted reference types**.
- Reference types can be used in code, as variable types, method parameters, and return types, list types, and so on.
- When you use an abstracted reference type, this is referred to as **coding to an interface**.
- This means your code doesn't use specific types, but more generalized ones, usually an interface type.
- **This technique is preferred**, because it allows many runtime instance of various classes, to be processed uniformly, by the same code.
- It also allows for substitutions of some other class or object, that still implements the same interface, without forcing a major refactor of your code.
- Using interface types as the reference type is considered a best practice.

### Coding to an Interface

- Coding to an interface scales well, to support new subtypes, and it helps when refactoring code.
- The downside though, is that alterations to the interface may wreak havoc, on the client code.
- Imagine that you have 50 classes using your interface, and you want to add an extra abstract method, to support new functionality.
- As soon as you add a new abstract method, all 50 classes won't compile.
- Your code isn't backwards compatible, with this knd of change to an interface.
- Interfaces haven't been easily extensible in the past.
- But Java has made several changes to the Interface type over time, to try to address this last problem.

## Interfaces, what's new since JDK 8 (default methods &\* public static methods)

### What's happend to the Interface since JDK 8

- Before JDK 8, the interface type could only have public abstract methods.
- JDK 8 introduced the `default` method and public `static` methods, and JDK 9 introduced `private` methods, both static and non-static.
- All of these new method types (on the interface) are concrete methods.

### The Interface Extension Method - the default method (as of JDK8)

- An extension method is identified by the modifier `default`, so it's more commonly known as the default method.
- This method is a `concrete` method, meaning it has a code block, and we can add statments to it.
- In fact, it has to have a method body, even just an empty set of curly braces.
- It's a lot like a method on a superclass, because we can override it.
- Adding a default method doesn't break any classes currently implementing the interface.

### Overriding a default method

- So like overriding a method on a class, you have three choices, when you override a default method on an interface.
  - You can choose not to override it at all.
  - You vsn override the method and write code for it, so that the interface method isn't executed.
  - Or you can write your own code, and invoke the method on the interface, as part of your implementation.

## Interfaces, new since JDK8 (public static & private methods)

### public static methods on an interface (as of JDK8)

- Another enhancement that Java included in JDK 8, was support for public static methods on the interface.
- Static methods don't need to specify a public access modifier, because it's implied.
- When you call a pblic static method on an interface, you must use the interface name as a qualifier.
- In the ArrayList lectures, you may remember I used two static helper methods, on the Comparator interface, which were added in JDK 8.
- These were Comparator.naturalOrder() and Comparator.reverseOrder().

### Private methods (JDK 9)

- JDK 9 gave us private methods, both static and not static.
- This enhancement primarily addresses the problem of re-use of code, within concrete methods on an interface.
- A private static method can be accessed by either a public static method, a default method, or a private non-static method.
- A private non-static method is used to support default methods, and other private methods.

## Interfaces vs Abstract Class

### Abstract Class

- Abstract classes are very similar to interfaces. You can't instantiate either of them. Both types may contain a mix of methods declared with, or without a method block.
- With abstract classes, you can declare fields that aren't static and final, instance fields in other words.
- Also with abstract classes, you can use any of the four access modifiers for its concrete methods.
- You can also use all but the private access modifier, for its abstract methods.
- An abstract class can extend only one parent class, but it can implement multiple interfaces.
- When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its parent class.
- However, if it doesn't, then the subclass must also be declared abstract.

### Use an Abstract class when ...

> Summary: An abstract class provides a common definition, as a base class, that multiple, derived classes can share.

- You want to share code, among several closely related classes (Animal for example, with fields, name, age, ...).
- You expect classes that extend your abstract class, to have many common methods or fields, or requrie access modifiers other than public.
- You want to declare non-static or non-final fields (for example, name, age), so this enables you to define methods, that can access and modify the state of an object (getName, setName).
- You have a requirement for your base class, to provide a default implementation of certain methods, but other methods should be open to being overridden by child classes.

### Interface

> Summary: The interface decouples the "what", from the "how", and is used to make different types, behave in similar ways.

- An interface is just the declaration of methods, which you want some classes to have, it's not the implementation.
- In an interface, we define what kind of operation an object can perform. These operations are defined by the classes that implement the interface.
- Interfaces from a contract between the class, and the outside world, and this contract is enforced at build time, by the Java compiler.
- You can't instantiate interfaces, but they may contain a mix of methods declared with, or without an implementation.
- All methods on interfaces, declared without a method body, are automatically `public` and `abstract`.
- An interface can extend another interface.
- Interfaces are more flexable, and can deal with a lot more stress on the design of your program, because they aren't part of the class hierarchy.
- A best practice way of coding, is commonly called Coding to an Interface.
- By introducing interfaces into your program, you're really introducing points of variation, at which you can plug in different implementations for that interface.
- Since Java 8, interfaces can now contain default methods, so in other words methods with implementation. The keyword `default` is used mostly for backwards compatibility. Public static methods were also introduced in Java 8.
- Since Java 9, an interface can also contain private methods, commonly used when default methods share common code.

### Use an Interface when...

- You expect that unrelated classes will implement your interface. For example, two of Java's own interfaces, Comparable and Cloneable, can be implemented by many unrelated classes.
- You want to specify the behavior of a particular data type, but you're not concerned about who implements its behavior.
- You want to separate different behavior.

### Interfaces are the used in many of Java's own features

- I've briefly discussed some iterfaces, like List and Queue, and their implementations, `ArrayList` and `LinkedList`. These are part of what Java calls it's `Collections Framework`.
- Interfaces are also the basis for many of the features that are coming up, for example `lambda expressions`, which were introduced in JDK 8.
- Another example is `Java's database connectivity support, or JDBC`, built almost entirely with interfaces. The concrete implementation of methods, is different for each database vendor, and comes in the form of JDBC drivers. This enables you to write all database code, without being concerned about the details of the database, you're connected to.

### Interface vs Abstract Class

interfaces and abstract classes are both abstracted `types`, `and` abstracted types are used as reference types in code.

|                                                              | Abstract Class         | Interface                                |
| ------------------------------------------------------------ | ---------------------- | ---------------------------------------- |
| An instance can be created from it                           | No                     | No                                       |
| Has a constructor                                            | Yes                    | No                                       |
| Implemented as part of the Class Hierarchy. Uses Inheritance | Yes(in extends clause) | No (in implements clause)                |
| records and enums can extend or implement?                   | No                     | Yes                                      |
| Inherits from java.lang.Object                               | Yes                    | No                                       |
| Can have both abstract methods and concrete methods          | Yes                    | Yes (as of JDK 8)                        |
| Abstract methods must include abstract modifier              | yes                    | No (Implicit)                            |
| Supports default modifier for it's methods                   | No                     | Yes (as of JDK 8)                        |
| Can have instance fields (non-static instance fields)        | Yes                    | No                                       |
| Can have static fields (class fields)                        | yes                    | Yes - (implicitly `public static final`) |
