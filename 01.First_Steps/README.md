# First Steps

## Variables

### Variables

**variables are a way to store information in our computer.**

- Variables that we define in a program, can be **accessed by a name we give them**, and the computer does the hard work, of figuring out where they get stored, in the computer's **random access memory**, or RAM.
  - 임의 액세스 메모리 즉, 램 어딘가에 저장되는 힘든 작업을 한다.

### Data type

- There are lots of different types of data, that we can define for our variables, some of which I've shown you in the keyword list previously.
- Collectively, these are knwon as data types.
- As you may have guessed, some data types are [keywords](https://docs.oracle.com/javase/specs/jls/se17/html/jls-3.html#jls-3.9) in Java. When we get to the Object Oriented features of Java, you will see that we have a lot of flexivility for creating our own data types, but in the next couple of videos, we'll expolore primitive data types, which are built into the Java language.

### Declaration Statement

- A declaration statement is used to define a variable by indicating the data type, and the anme, then optionally to set the variable to a specific value.
- Expressions
  - An expression is a coding **construct, that evaluates to a single value.**
  ```java
  int myFirstNumber = 5;
  ```

## Primitive Types

- In Java, primitive types are the most basic data types.
- The eight primitive data types in Java are shown in the table below, listed by the type of data stored for each:
  - **Whole number:** byte, short, int, long
  - **Real number(floating point or decimal):** float, double
  - **Single character:** char
  - **Boolean value:** boolean

### Classes

- A class is a building block for object-oriented programming, and allows us to build custom data types.

### Wrapper Classes

- Java uses the concept of a wrapper class, for all of its eight primitive data types.
- A wrapper class provides simple operations, as well as some basic information about the primitive data type, which cannot be stored on the primitive itself.
  - 래퍼 클래스는 간단한 연산과 원시 데이터 유형에 대한 기본 정보를 제공한다.
  - 원시 데이터 유형에는 저장할 수 없다.
- We saw that `MIN_VALUE`, and `MAX_VALUE`, are elements of this basic information, for the int data type.
  ```java
  int myMinIntValue = Integer.MIN_VALUE; // -2147483647
  int myMaxIntValue = Integer.MAX_VALUE: // 2147483647
  ```
- The primitive types, and their respective wrapper classes, are shown in the table below.

  | Primitive | Wrapper Class |
  | --------- | ------------- |
  | byte      | Byte          |
  | short     | Short         |
  | char      | Character     |
  | int       | Integer       |
  | long      | Long          |
  | float     | Float         |
  | double    | Double        |
  | boolean   | Boolean       |

### Overflow and Underflow in Java

- If you try and put a value larger than the maximum value into an int, you'll create something called an Overflow situation.
- And similarly, if you try to put a value smaller than the minimum value into an int, you cause an Underflow to occur.
- These situations are also known as **integer wraparounds.**(정수 랩어라운드)
- The maximum value, when it overflows, wrap s around to the minimum value, and just continues processing without an error.
- The minimum value, when it underflows, wraps around to the maximum value, and continues processing.
- This is not usually behavior you really want, and as a developer, you need to be aware that this can happen, and choose the appropriate data type.

### When will you get an overflows? When will you get an error?

- An integer wraparound event, either an overflow or underflow, can occur in Java when you are using expressions that are not a simple literal value.
- The Java compiler doesn't attempt to evaluate the expression to determine its value, so it **DOES NOT** give you an error.
- Here are two more examples that will compile, and result in an overflow. The second example may be surprising. Even though we are using numeric literals in the expression, the compiler still won't try to evaluate this expression, and the code will compile, resulting in an overflow condition.
  ```java
  int willThisCompile = (Integer.MAX_VALUE + 1);
  int willThisCompile = (2147483647 + 1);
  ```
- If you assign a numeric literal value to a data type that is outside of the range, the compiler **DOES** give you an error. We looked at a similar example previously.
  ```java
  int willThisCompile = (2147483648);
  ```

### What does an underscore mean in a numeric literal?

- In Java, you cannot put commas in a numeric literal.
- For example, the following is not valid syntax.
  ```java
  int myMaxIntTest = 2,147,483,647;
  ```
- So Java provided an alternative way to improve readability, the underscore.
  ```java
  int myMaxIntTest = 2_147_483_647;
  ```

## byte, short, long and width

### byte, short, int, long

- We've. previously said that Java has four primitive data types used to store whole numbers, these are the byte, the short, the int, and the long.

  | Whole number Data Type | Wrapper Class | What's noteworthy                          |
  | ---------------------- | ------------- | ------------------------------------------ |
  | byte                   | Byte          | Has the smallest range                     |
  | short                  | Short         |                                            |
  | int                    | Integer       | Java's default data type for whole numbers |
  | long                   | Long          | Has the largest range                      |

- They are listed here in this table, by the range of values the type will support, the byte supports the smallest range, and the long supports the largest range.

### The byte data type

- -128 ~ 127
- Givben its small range, you probably won't be using the byte data type a lot.
- The byte wrapper class is the Byte with a capital B.

### The short dataa type

- -32768 ~ 32767
- The short wrapper class is the Short with a capical S.

### byte and short overflow/underflow

- Both the byte and the short, have the smae overflow and underflow issue as the int data type has, but obviouly with their own range of numbers.
  - MAX_VALUE 이후 예상치 못하게 음수가 나올 수도 있다.

### Size of Primitive Types and Width

- Size, or Width, is the amount of space that determines (or limits) the range of values we've been discussing:

  | Data Type | Width(in bits) | Min Value   | Max Value  |
  | --------- | -------------- | ----------- | ---------- |
  | byte      | 8              | -128        | 127        |
  | short     | 16             | -32768      | 32767      |
  | int       | 32             | -2147483648 | 2147483647 |

- A byte, can store 256 numbers and occupies eight bits, and has a width of 8.
- An int, has a much larger range as we know, and occupies 32 bits, and has a width of 32.
- 핵심은 각 프리미티브 유형마다 메모리의 양이 다르다는 것이다.
  - int는 byte 보다 4배나 많은 공간이 필요하다.

### Using a numeric literal character suffix

- THe number 100,by default, is an int.
- Java allows certain numeric literals to have a suffix appended to the value, to force it to be a different data type from the default type.
  - Java는 특정 숫자 리터럴에 접미사를 갖도록 한다. 값에 접미사를 추가해 기본 유형에서 다른 데이터 유형이 되도록 한다.
- The long is one of these types and it's suffix is an `L`.
- This is one of the few instances Java is not caase sensitive, a lowercase `l` or an uppercase `L` at the end of a whole number mean the smae thing - the number is a long.
  - Java는 대소문자를 구별하지 않는다. 변수에 값을 할당할 땐 끝에 `L`을 붙여줘야 한다. long 값이란 것을 컴퓨터에게 알려주기 위해 Java는 문자 그대로 모든 숫자를 정수 데이터 타입으로 설정하기 때문이다.

```java
long myLongValue = 100L;
```

### How big is the difference between an int and a long?

- How big is the difference, in the range of values that a long can store, compared to the int?
- You can see, from this table, that the difference is quite significant.

  | Data Type | Width(in bits) | Min Value            | Max Value           |
  | --------- | -------------- | -------------------- | ------------------- |
  | int       | 32             | -2147483648          | 2147483647          |
  | long      | 62             | -9223372036854775808 | 9223372036854775807 |

### When is `L` required?

- A numeric literal that exceeds Integer.MAX_VALUE must use the `L` suffix.
- We cannot create a numeric literal in Java, that exceeds Integer.MAX_VALUE, without using the `L` suffix, we'll always get the error 'integer number too large'.

## Casting in Java

### Assigning expressions to variables with data types that don't match

- The Java compiler does not attempt to evaluate the value, in a variable, when it's used in a calculation, so it doesn't know if the value fits, and throws an error.
  - Java 컴파일러는 계산에 사용될 때 변수에서 값을 평가하는 시도를 하지 않는다. 그래서 값이 맞는지 모르고 오류를 발생시킨다.
  ```java
  byte myNewByteValue = (myMinByteValue / 2);
  ```
- If your calculation uses literal values, Java can figure out the end result at compile time, and whether it fits into the variable, and won't throw an error if it does.
  - 문자 그대로의 값으로 계산한다면 Java는 컴파일 시간에서 최종 결과를 파악해 변수에 들어맞는지 확인하고 들어맞아도 에러를 발생시키지 않는다.
  ```java
  byte myNewByteValue = (-128 / 2);
  ```
- In both examples, an int result is being returned from the calculation, but in the second exam0ple, Java knows the returned value can fit into a byte.
  - 두 예제 모두 계산에서 int 결과를 반환한다. 하지만 두 번째 예제에서 Java는 반환된 값이 바이트에 맞는다는 것을 알고 있다.
  - 하지만 위 예제는 2로 나뉜 변수를 의미한다. 문자 그대로의 값으로 작업한 것과 비교했을 때 그정도의 차이이다.
  - Java는 변수로 표현하지 못하는 문자 그대로의 값을 추측할 수 있다.
  - 이 문제는 Java가 사용하는 모든 기본 숫자가 `int`이기 때문에 오류가 발생하는 것이다. 그래서 기본적으로 괄호 안에 있는 것이 컴퓨터에서는 int로 취급되어 오류가 발생한다.
  - 하지만 그 표현의 결과가 맞는 숫자라는 것이 확실하다면 자바에게 어떻게 알릴까?
    - `Casting(캐스팅)`이라는 개념을 사용할 수 있다.

### Casting in Java

- Casting means to treat or convert a number, from one type ot anoter. We put the type we want the number to be, in parentheses like this:
  ```java
  (byte) (myMinByteValue / 2);
  ```
- Other languages have casting too, this is common practice and not just a Java thing.

### What does it mean when Java defaults tha data type to an int?

- Looking at the scenarios we just looked at in summary, we know the following:
- This statement works because the result is an int, and assigning it to an int variable is fine.
  ```java
  int myTotal = (myMinIntValue / 2);
  ```
- The statement doesn't work, because the expression (myMinShortValue / 2) is an int, and an int can't be assigned to a short, because the compiler won't guess the result.
  ```java
  short myNewShortValue = (myMinShortValue / 2);
  ```
  - `(myMinShortValue / 2)`는 int이기 때문에 int는 short에 할당될 수 없기 떄문에 위 문장은 작동하지 않는다.
  - 컴파일러가 결과를 추측하지 못한다.
- This statement works, because the result of `(-128 / 2)` is an int, but when calculations use only literal values, the compiler can determine the result immediately, and knows the value fits into a short.
  - 문자 그대로의 값만 사용할 때 컴파일러는 즉시 결과를 결정할 수 있고 값을 short로 맞출 수 있다는 것을 안다.
  ```java
  short myNewSHortValue = (-128 / 2);
  ```
- And finally, this code works because we tell the compiler we know what we're doing by using this cast, and the comnpiler doesn't give an error.
  ```java
  short myNewShortValue = (short) (myMinShortValue / 2);
  ```
  - 끝으로 이 코드가 작동하는 이유는 컴파일러에게 무엇을 하는지 알려주기 때문이다.
  - 일반적으로 많은 경우에 정수를 가장 많이 사용하게 된다.
  - 정수를 하지 말아야 할 타당한 이유가 없다면 항상 정수를 사용하길 권장한다.

## Float and Double Primitives

### Floating-point Numbers

- Unlike whole numbers, floating-point numbers have fractional parts that we express with a decimal point.
- In this table, you can see some examples of both whole numbers and floating point numbers, in comparison.

  | Whole number Examples | Floating Point Examples |
  | --------------------- | ----------------------- |
  | 3                     | 3.14159                 |
  | 100000                | 10.0                    |
  | -214743649L           | -0.66666666666667       |

- Floating-point numbers are also known as real numbers.

### Floating-point Number Data Types

- We use a floating-point number when we need more precision in calculations.
- There are two primitive types in Java for expressing floating-point numnbers, the float and the double.
- The `double` is Java's default type for any decimal or real number.

### Single and Double Precision

- Precision refers to the format and amount of space occupied by the relevant type.
- This table shows the width of each of the floating point types and their ranges.
- The ranges are shown in Java's scientific notation, which we show below in table.

  | Data Type | Width(in bits) | Min Value | Max Value              |
  | --------- | -------------- | --------- | ---------------------- |
  | float     | 32             | 1.4E-45   | 3.4028235E38           |
  | double    | 64             | 4.9E-324  | 1.7976931348623157E308 |

- You can see the e-notation followed by either a positive or negative number.

### Java's Scientific Notation

- Scientific notation can be translated into more familiar terms, by replacing the `E` in the number, with the phrase `times 10 to the power of`.
- `1.4E-45` is the same as `1.4 x 10^-45` and `3.4E38` is the same as `3.4 x 10^38`
- Imagine writing out the double data type's minimum value in decimal format! That would be a lot of zeros after the decimal.
- I hope you can see that a double, when compared to a float, can represent both a much smaller decimal value, and a much larger decimal value. This is why its called more precies.
- Because it's more precise, the double is the default type of rfloating point numbers.

### float and double and numeric literal suffixes

- Important: The double data type is Java's default type for real numbers.
  - For example, any number with a decimal is a double.
  - So, `10.5` is a double by default in Java.
- The double data type can be specified as a numeric literal with a suffix or either lowercase `d`, or uppercase `D`, but because doubles are the default in Java, the suffix is optional to use.
- On the other hand, the float data type can be specified as a numeric literal with a suffix of lowercase `f`, or uppercase `F`. This suffix is required if you are assigning a real number to a variable that was declared with a float type.

### Certification Exam Pointer

- Not everyone realizes that Java's default data type for a decimal literal is a double, which is larger and more precise than a float.
- Java likes to put a similar line of code in its code segments on examp questions, to what we saw earlier, omitting that `f` suffix. Without a computer to check, this statement can look fairly innocuous.
  ```java
  float myOtherFloatValue = 5.25;
   float myOtherFloatValue = 5.0f / 2;
   float myOtherFloatValue = 5.0 / 2; // 5.0은 Double이기 때문에 myOtherFloatValue에 할당할 수 없다.
  ```
- The number `5.25` is a double, **so assigning it to a float will raise an error.**
- This is a gift question to an exam taker, if you can easily spot this compiler error.

### Why is the double a better choice in most circumstances?

- Why should we choose double?
  - Fist, it's actually faster to process on many modern computers.
    - That's because computers have, at the chip level, the functionality to actually deal with these double numbers faster than the equivalent float.
  - Second, the Java libraries that we'll get into later in the course, particularly math functions, are often written to process doubles and not floats, and to return the result as a double.
    - The creator of Java selected the double because it's more precise, and it can handle a larger range of number.

### Floating Point Number Precision Tips

- In general, float and double are great for general floating point operations.
- But neither should be used when precise calculations are required - this is due to a limitation with houw floating point numbers are stored, and not a Java problem as such.
- Java has a class called BigDecimal that overcomes this.

## The char and boolean Primitive Data Types

### Comparing the char to the String

- This table is a quick summary of the differences between the char and the String.

  | char                               | String                            |
  | ---------------------------------- | --------------------------------- |
  | Holds one, and only one, character | Can hold multiple characters      |
  | Literal enclosed in Single Quotes  | Literal enclosed in Double Quotes |

### Is there a good use for the char data type in today's computing world?

- Why would you want to use a variable that only allows you to store one character?
- One example might be to store the last key pressed by a user in a game.
- Another example might be to loop programmatically through the letters in an alphabet.

### char Data Type

- A char occupies two bytes of memory, or 16 bits, and thus has a width of 16.
- The reason it's not just a single byte, is that a char is stored as a 2 byte number, similar to the short.
- This number gets mapped to a single character by Java.
  - So, when you print a char, you will see the mapped character, and not the representative number.
  - And you can use single quotes and a character literal to asdsign a value to a char, which is much simpler than looking up the representative number.

### Unicode

- Unicode is an international encoding standard for use with different languages and scripts by which each letter, digit, or symbol is assigned a unique numeric vlaue that applies across different platforms and programs.
- In the English alphabet, we've got the letters A through Z, meaning only 26 characters are needed in total to represent the entire English alphabet.
- But other languages need more characters, and often a lot more.

### Assigning values to a char variable

- There are three ways to assign a value to a char: Each of these methods, represents storing the letter, capital D, in memory.

  | Assignment Type     | Example Code            |
  | ------------------- | ----------------------- |
  | a literal character | char myChar = 'D';      |
  | a Unicode value     | char myChar = '\u0044'; |
  | an integer value    | char myChar = 68;       |

### Boolean Primnitive Type

- A boolean value allows for two opposite choices, true or false, yes or no, one or zero.
- In Java terms, we've got a boolean primitive type, and it can be set to two values only, either true or false.
- The wrapper for boolean is Boolean with a capital B.

### Why would you start your boolean variable name with the prefix 'is'?

- Developers will often use the word, is, as a prefix for a boolean variable name.
- This creates a name that seems to ask a question, which makes reading the code more intuitive.
- But other prefixes can be just as valid.

## Primitive Types Recap and the String Data Type

- In the previous video, we looked at the **char**, and alos the **boolean** types, which were Java's seventh and eighth data types.
- So at this point, you should be familiar with all eight of Java's primitives.

### Java's 8 Primitive Data Types

- Whole number
  - byte, short, int, long
- Real Number(floating point or decimal)
  - float, double
- Single character
  - char
- Boolean value
  - boolean

### So What is a String?

- A String is a class that contains a sequence of characters.

### String concatenation

- In Java, the `+` symbol is an operator which can mean addition, if used for numbers.
- But it also means concatenation when applied to a String.
- A String `+` anything else, gives us a String as a result, concatenating anything after the String as text to the initial String.

### Strings are Immutable

- Immutable means that you can't change a String after it's created.
- So in the case of the code we've written, the value 120.47 is technically not appended to the current contents of **lastString**.
  ```java
  lastString = lastString + myInt;
  ```
- Instead, a new String is created automatically by Java. The new String consists of the previous value of **lastString**, plus a textual representation of the double value 120.47.
- The net result, is taht our variable, **lastString**, has the concatenated value. However, Java created a new String in the process, and the old one will get discarded from memory automatically.
  - 따라서 위 코드는 상당히 비효율적이다. 새 String이 매 작업마다 생산되기 때문이다. 이러한 값을 추가하는 것은 비효율적이고 권장하지 안흔다.
  - 따라서 Java는 다른 클래스를 제공하는데 여러 개의 문자열이나 값을 덧붙일 경우에 보다 효율적이다.

### String vs StringBuilder

- The String class is immutable, but can be used much like a primitive data type.
- The StringBuilder class is mutable, but does not share the String's special features, such as being able to assign it a String literal or use the `+` operator on it.
- Both are classes, but the String class is in a special category in the Java language.

### The String

- The String is so intrinsic to the Java language, it can be used like a 9th primitive type.
- But it's not a primitive type at all, it's a class.

## Operators, Operands and Expressions

### The `+` Operator on character data types

- char
  - Holds one, and only one, character
  - Literal enclosed in Single Quotes
- Can hold multiple characters
  - Literal enclosed in Double Quotes

```java
char firstChar = 'A', secondChar = 'B';
System.out.print(firstChar + secondChar); // 131 <- 65 + 66 (*unicode 참고) <- "AB"가 아니야??????????????????????
System.out.print("" + firstChar + secondChar); // AB <- ""는 유요한 문자열
```

### The `+` Operator on char

- You might remember that we said chars are stored as 2 byte numbers in memory.
  - char는 메모리에 2바이트 숫자로 저장된다.
- When you use the plus operator with chars, it is these numbers in memory that get added together.
  - 플러스 연산자를 사용하면 메모리에 있는 숫자들이 함께 추가된다.
- The character values don't get concatenated.
  - 문자값은 연결되지 않는다.

### Summary of Operators

| Operator | Numeric types      | char               | boolean | String        |
| -------- | ------------------ | ------------------ | ------- | ------------- |
| +        | Addition           | Addition           | n/a     | Concatenation |
| -        | Subtraction        | Subtraction        | n/a     | n/a           |
| \*       | Multiplication     | Multiplication     | n/a     | n/a           |
| /        | Division           | Division           | n/a     | n/a           |
| %        | Remainder(Modulus) | Remainder(Modulus) | n/a     | n/a           |

## Abbreviating Operators
