# Control Flow

## The Switch Statement

### The switch statement

```java
switch(value) {
  case x:
    // Code for value == x
    break;
  case y:
    // Code for value == y
    break;
  default:
    // Code for value not equal to x or y
}
```

### Switch Value Types

| Valid Switch Value Types        |
| ------------------------------- |
| byte, short, int, char          |
| Byte, Short, Integer, Character |
| String                          |
| enum                            |

- Important: Cannot use long, float, double or boolean or their wrappers.

### Fall through in switch statement

- Once a switch case label matches the switch variable, no more cases are checked.
- Any code after the case label where there was a match found, will be executed, until a break statement, or the end of the switch statement occurs.
- Without a break statement, execution will continue to fall through any case labels declared below the matching one, and execute each case's code.

## More switch statement

### Inhanced Switch Statement

```java
 public static void main(String[] args) {
    int switchValue = 3;

    switch (switchValue) {
        case 1:
            System.out.println("Value was 1");
            break;
        case 2:
            System.out.println("Value was 2");
            break;
        case 3: case 4: case 5:
            System.out.println("Was a 3, a 4, or a 5");
            System.out.println("Acually it was a " + switchValue);
            break;
        default:
            System.out.println("Was not 1, 2, 3, 4, or 5");
            break;
    }
}

public static void main(String[] args) {
    int switchValue = 3;

    switch (switchValue) {
        case 1 -> System.out.println("Value was 1");
        case 2 -> System.out.println("Value was 2");
        case 3, 4, 5 -> {
            System.out.println("Was a 3, a 4, or a 5");
            System.out.println("Acually it was a " + switchValue);
        }
        default -> System.out.println("Was not 1, 2, 3, 4, or 5");
    }
}
```

### When to use yield in a switch

- Your switch statement is being used as a switch expression returning a value.

| This code | is implicitly translated to |
| --------- | --------------------------- |
| -> "1st"; | -> { yield "1st"; }         |

```java
public static String getQuarter(String month) {
    return switch(month) {
        case "JANUARY", "FEBRUARY", "MARCH" -> { yield "1st"; }
        case "APRIL", "MAY", "JUNE" -> "2nd";
        case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
        case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
        default -> {
            yield month + " is bad";
        }
    };
}
```

## The for Statement

### Looping

- Looping lets us execute the code a multiple number of times.
- Java supports several statements for looping, or executing code repetitively.

### Java supports three

| Statements | Explanation                                                                                              |
| ---------- | -------------------------------------------------------------------------------------------------------- |
| for        | The for loop is more complex to set up but is commonly used when you are iterating over a set of values. |
| while      | The while loop executes until a specified condition becomes false.                                       |
| do while   | The do while loop always executes at least one and continues until a specified condition becomes false.  |

```java
public class Main {
  public static void main(String[] args) {
    System.out.println("997 is " + isPrime(977));

    for (int i = 10; i <= 50; i++) {
      if (isPrime(i)) System.out.println("number " + i + " is a prime number");
    }
  }

  public static boolean isPrime(int wholeNumber) {
    if (wholeNumber <= 2) return wholeNumber == 2;
    if (wholeNumber % 2 == 0) return false;

    for (int divisor = 3; divisor <= wholeNumber / 2; divisor += 2) {
      if (wholeNumber % divisor == 0) return false;
    }

     return true;
  }
}
```

### Digit Sum Challenge

```java
public static void main(String[] args) {
    System.out.println("The sum of the digits in number 1234 is " + sumDigits(1234));
    System.out.println("The sum of the digits in number 1234 is " + sumDigits(-125));
    System.out.println("The sum of the digits in number 1234 is " + sumDigits(4));
    System.out.println("The sum of the digits in number 1234 is " + sumDigits(32123));
  }

  public static int sumDigits(int number) {
    if (number < -1) return -1;
    int sum = 0;

    while (number > 9) {
      sum += (number % 10);
      number = number / 10;
    }

    sum += number;

    return sum;
  }
```

### Continue and Break

- The continue and break statements both interrupt normal loop processing.
- The continue statement starts a new iteration, but continues to iterate through the loop.
- The break statement exits the loop, at the point it's executed, and no longer completes any code in the loop, and won't continue iterating any longer.

## Local Variables and Scope

- A local variable si called local, because it is avaiable for use by the code block in which it was declared.
- It is also available to code blocks that are contained by a declaring block.

  ```java
  { //Starts on outer block - for exmple a method block
    int firstVariable = 5;
    int secondVariable = 10;

    if (firstVariable > 0) { // flow statement block starts inner block
      // Inner block code has access to outer block's vasriables
      System.out.println(secondVariable);
    }
  }
  ```

### Scope

- Scope describes the accessibility of a variable.
- 'In scope' means the variable can be used by an executing block or any nested blocks.
- 'Out of scope' means the variable is no longer avaiable.

### When are Local Variables in Scope?

- Local variables are always in scope, in the block they are declared.
- They are also in scope for any nested blocks, or blocks contained within the outer block.

### When are Local Variables out of Scope?

- Local variables are always out of scope, for outer blocks, or the containing blocks they are declared in.
  ```java
  public static void aMethod(boolean aBoolean) {
    if (aBoolean) {
      int myCounter = 10; // myCounter is local to this if block
    }
    System.out.println(myCounter); // myCOunter is out of scope here
  }
  ```

### Local Variables and the For Statement

- In this `for` statement, as part of the declaration, there is an initialization part, as we've described.
- In this case, we declared a variable, `i`, that isn't accessible outside of the loop.

  ```java
  {
    for (int i = 1; i <= 5; i++) { // i declared in for loop declaration
      System.out.println(i);
    }

    System.out.println(i); // ERROR! i is out of scope
  }
  ```

- This is becuase any variabels declared in the init section, are local to the loop, meaning they exist and are accessible in memory, only while the loop is executing, and only to the loop code block.

### Declaring variables in a switch statement block

However, the `switch` statement is different from the if then else statement blocks.

```java
public static void aMethod(int value) {
  switch (value) {
    case 1:
      int i = 10;
      break;
    default:
      i = value; // this is ok
      System.our.println(i); // this is ok
      break;
  }

  System.out.println(i); // ERROR: i is out of scope outside of the switch
}
```

## The class, the object, static & instance fields and methods

### A Class

- A class can be described as:
  - a custom data type.(사용자 지정 데이터 타입)
  - a special code block that contains methods.

### An Object

- An object is called an instance of a particular class.

### Declaring and instantiating a new object from a Class

- The most common way to create an object, is to use the new keyword.
- The new keyword crewates an instance, and you can sometimes pass data, when creating an instance, to set up data on that object.
- The String is special becuase we can create a String, just by using a literal which we've seen.
  ```java
  String s = "Hello";
  ```
- But we could also use new:
  ```java
  String s = new String("Hello");
  ```

### static and instance fields

| Static Field                                                                   | Instance Field                                                                               |
| ------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------- |
| Requires 'static' keyword when declared on the class.                          | Omits 'static' keyword when declared on the class.                                           |
| Value of the field is stored in special memory location and only in one place. | Value of the field is not allocated any memory and has no value until the object is created. |
| value is accessed by ClassName.fieldname                                       | Objectvariable.fieldname                                                                     |

## Parsing Values and Reading Input using System.console()

### Reading data from the console

| Technique              | Description                                                                                                                                                                                                  |
| ---------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| System.in              | Like `System.out`, Java provides `System.in` which can read input from the console or terminal, It's not easy to sue for beginners, and lots of code has been built around it, to make it easier.            |
| System.console         | This is Java's solution for easier support for reading a single line and prompting user for information. Although this is easy to use, it doesn't work with I.D.E.'s becuase these environments disables it. |
| Command Line Arguments | This is calling the Java program and specifying data in the call. This is very commonly used but doesn't let us create an interactive application in a loop in Java.                                         |
| Scanner                | The Scanner class was built to be a common way to read input, either using `System.in` or a file. For beginners, it's much easier to understand than the bare bones `System.in`                              |

