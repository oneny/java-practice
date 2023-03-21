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
