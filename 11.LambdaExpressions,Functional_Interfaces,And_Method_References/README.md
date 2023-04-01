# 11. LambdaExpressions, Functional Interfaces, And Method References

## Introduction to Lambda Expressions

- Lambda expressions let you pass around snippets of custom code, giving you so much more functionality than you might otherwise be able to achieve, and with very little effort.
- It's sometimes confusing to understand these expressions, or how much power is in their punch, and sometimes with just a single statement.

## Inrodecution to the Lambda Expression, and Functional Interfaces

```java
// The generated Lamdba Exprssion
(o1, o2) -> o1.lastName().compareTo(o2.lastName())

// Comparator's Abstract Method
int compare(T o1, T o2)
```

- This was passed directly as a method argument, for a parameter type that was Comparator.
- The Comparator's abstract emthod, `compare`, is shown here on the right side.
- The lambda expression parameters are determined by the associated interface's method, the functional method.
- In the case of a Comparator, and it's compare emthod, there are two arguments.
- This is why we get `o1`, and `o2` in parentheses, in the generated lambda expression.
- These arguments can be used in the expression, which is on the right the arrow token.

### The Syntax of a Lambda Expression

```java
(parameter1, parameter2, ...) -> expression;
```

- A lambda expression consists of a formal parameter list, usually but not always declared in parentheses; the arrow token; and either an expression or a code block after the arrow token.
- Because lambda expressions are usually simple expressions, it's more common to see them written as shown on the code.
- The expression should return a value, if the associated interface's method returns a value.
- In the case of our generated expression, it returns an int, which is the result of the compare method on Comparator.
  ```java
  // LambdaIntro 참고
  (o1, o2) -> o1.lastName().compareTo(o2.lastName())
  ```

### Comparing

```java
// Anonymous Class
new Comparator<Person>() {

  @Override
  public int compare(Person o1, Person o2) {
    return o1.lastName().compareTo(o2.lastName());
  }
}

// Lambda Expression
(o1, o2) -> o1.lastName().compareTo(o2.lastName())
```

- Are you asking, where's the link between the compare method, and this lambda expression?
- It's obvious in the anonymous class, because we override the compare method, and return the result of that expression.
- We can see the two parameters and their types, and what the return value should be, in the anonymous class.

### Where's the method in the lambda expression?

- For a lambda expression, `the method is inferred` by Java.

### How can Java infer the method?

- Java takes its clue from the reference type, in the context of the lambda expression usage.
- Here, I show a simplified view, of the sort method on List.
  ```java
  void sort(Comparator c)
  ```
- And here is the call to that method passing the lambda expression.
  ```java
  people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
  ```
- From this, Java can infer that this lambda expression, resolves to a `Comparator` type, because of the method declaration.
- This means the lambda expression passed, should represent code for a specific method on the `Comparator` interface.
- But which method?
  - There's only one the lambda expression cares about, and that's `the abstract method` on Comparator.
  - Java requires types which support lambda expressions, to be something called a functional interface.
    Java는 인터페이스로 람다식을 지원하는 유형을 필요로 한다.

### What's a functional interface?

- `A functional interface` is an interfaes that has `one, and only one, abstract method`.
- This is how Java can infer the method, to derive the parameters and return type, for the lambda expression.
- You may also see this referred to as `SAM`, which is short for `Single Abstract Method`, which is called the functional method.
- A functional interface is the `target type for a lambda expression`.

```java
interface EnhancedComparator<T> extends Comparator<T> {
  int secondLevel(T o1, T o2);
}

var comparatorMixed = new EnhancedComparator<Person>() {
  @Override
  public int secondLevel(Person o1, Person o2) {
    int result = o1.lastName().compareTo(o2.lastName());
    return ((result == 0) ? secondLevel(o1, o2) : result);
  }

  @Override
  public int compare(Person o1, Person o2) {
    return o1.firstName().compareTo(o2.firstName());
  }
};
```

- 위 인터페이스는 람다로 작성할 수 있을까? No!!
  - 기능적 인터페이스는 하나의 추상적 메서드만 가질 수 있다.
  - 따라서 어떤 functional interface를 선택할 수 없기 때문에 람다로 표현할 수 없다.
- 이걸 확인하려며 또 다른 Java Anonotation을 사용할 수 있다.
  ```java
  @FunctionalInterface
  public interface Comparator<T> {}
  ```

## Lambda Expressions, syntax, and additional examples

### The Lambda Expression

- The functional interface is the framework that lets a lambda expression be used.
- Lambda expressions are also called lambdas for short.
- Many of Java's classes, use fuctional interfaces in their method signatures, which allows us to pass lambdas as arguments to them.
- You'll soon discover that lambdas will reduce the amount of code you write.
- Lambdas are Java's first step into functional programming.
- This is a programming paradigm that focuses on computing and returning results.
- And just for more information about funtional programming, there's a good wikipedia article here.
  - https://en.wikipedia.org/wiki/Functional_programming

### The Consumer Interface

- The Consumer interface is in the `java.util.function` package.
- It has one abstract method, that takes a single argument, and doesn't return anything.
  ```java
  void accept(T t)
  ```
- This doesn't seem like a very interesting interface at first, but let's see what this means in practice, as far as the lambda expressions we can use with it.

### Lambda expression variantions, for a single parameter

| Lambda Expression                                | Description                                                 |
| ------------------------------------------------ | ----------------------------------------------------------- |
| element -> System.out.println(element);          | A single parameter without a type can omit the parentheses. |
| (element) -> System.out.println(element);        | Parentheses are optional.                                   |
| (String element) -> System.out.println(element); | Parentheses required if a reference type is specified.      |
| (var element) -> System.out.println(element);    | A reference type can be var.                                |

### Lambda expression variantions, the lambda body

#### Lambda Expression 1

```java
(element) -> System.out.println(element);
```

- An expression can be a single statement.
- Like a switch expression, that does not require yield for a single statement result, the use of return is not needed and would result in a compiler error.

#### Lambda Expression 2

```java
(var element) -> {
  char first = element.charAt(0);
  System.out.println(element + " means "  + first);
}
```

- An expression can be a code block.
- Like a switch expression, that requires yield, a lambda that returns a value, would require a final return statement.
- All statement in the block must end with semi-colons.

### Streams

- Another feature of Java, makes extensive use of lambda expressions, and that's streams.
- Stream s are exciting, because they create a pipeline of work that can be formed into a chain.
- Many of the stream operations take functional interfaces as parameters, meaning we can code them with labmda expressions.

## Lambda Expressions, Continued

### Lambda expressions with multiple parameters

```java
// Parentheses are always required. Explicit types are not.
(a, b) -> a + b;

// If you use an explicit type for one parameter, you must use explicit type for all the parameters.
(Integer a, Integer b) -> a + b;

// If you use var for one parameter, you must use var for all parameters.
(var a, var b) ->  a + b;
```

### Lambda expressions that return values

```java
// when not using curly braces, the return keyword is unnecessary, and will throw a compiler error.
(a, b) -> a + b;

// If you use a statement block, meaning you use the curly braces, a return is required.
(a, b) -> {
  var c = a + b;
  return c;
}
```

## Java's Functional Interfaces, COnsumer & Predicate

### java.util.funciton

- Java provides a library of functional interfaces in the `java.util.function` package.
- We looked at one already, the `Consumer` interface.
- I'll look at another of these interfaces now, the `BinaryOperator`, in code.

### The four basic categories of Functional Interfaces in java.util.function package

| Interface Category | Basic Method Signature | Purpose                                     |
| ------------------ | ---------------------- | ------------------------------------------- |
| Consumer           | `void accept(T t)`     | execute code without returning data         |
| Function           | `R apply(T t)`         | return a result of an operation of function |
| Predicate          | `boolean test(T t)`    | test if a condition is true of false        |
| Supplier           | `T get()`              | return an instance of something             |

- It's a good idea to know the four basic types of functional interfaces in the java.util.function package.

### The Consumer interface

| Interface Name | Method Signature        |
| -------------- | ----------------------- |
| Consumer       | `void accept(T t)`      |
| BiConsumer     | `void accept(T t, U u)` |

- The Consumer interface takes one argument of any type.
- The BiConsumer interface takes two arguments, of two different types.

#### A Consumer Lambda Expression Example

```java
// Consumer Method
void accept(T t)

// Example Lambda Expression for Consumer
s -> System.out.println(s)
```

- It takes one argument and executes a single statement.
- No result is returned.

### The Predicate Interface

| Interface Name | Method Signature         |
| -------------- | ------------------------ |
| Predicate      | `boolean test(T t)`      |
| biPredicate    | `boolean test(T t, U u)` |

- The `predicate` interfaces take one or two arguments, and always returns a boolean value.
- They are used to test a condition, and if the condition is true, some operaion will be performed.

### A Predicate Lambda Expression Example

```java
// Example Lambda Expression for Consumer
s -> s.equalsIgnoreCase("Hello")
```

- In this exampe, the expression takes a String, and tests if it's equal to the literal text, `Hello` here, ignoring case, so it returns either true or false.

## Java's Functional Interfaces, Function & Supplier

| Interface Name      | Method Signature  | Interface Name    | Method Signature    |
| ------------------- | ----------------- | ----------------- | ------------------- |
| Function<T, R>      | R apply(T t)      | UnaryOperator<T>  | T apply(T t)        |
| BiFunction<T, U, R> | R apply(T t, U u) | BinaryOperator<T> | T apply(T t1, T t2) |

- Each has a return type, shown here as either T, or R, which stands for result, meaning a result is expected for any of these.
- In additino to Function and BiFunction, there is also unarayOperator and BinaryOperator.
- You can think of the UnaryOperator as a Function Interface, but where the argument type is the same as the result type.
- The Binary Operator is a BiFunction interface, where both arguments have the same type, as does the result, which is why the result is shown as T and not R.
- The reminds us that the result will be the same type as the arguments to the methods.

### A Function Interface Lambda Expression Example

| Lambda Expression for Function | Function Method | Variable Declaration for this example |
| ------------------------------ | --------------- | ------------------------------------- |
| `s -> s.split(",")`            | `R apply(T t)`  | `Function<String, String[]> f1;`      |

- This lambda expression takes a String, s, and splits that String on commas, returning an array of String.
- In this case, the argument type, `T` is a String, and the result `R`, is an array of String.

### The Supplier Interface

| Interface Name | Method Signature |
| -------------- | ---------------- |
| Supplier       | T get()          |

- The supplier interface take no arguments but return an instance of some type `T`.
- you can think of this as kind of like a factory method code.
- It will produce an instance of some object.
- However, this doesn't have to be a new or distinct result returned.

### A Supplier Lambda Expression Example

```java
// Example Lambda Expression for Consumer
() -> random.nextInt(1, 100)
```

- This method takes no argument, but lambda expressions can use final or effectively final variables in their expressions, which I'm demonstrating hrere.

### Lambda Expressions, What you need to understand

| Local Variable Declaration                                           | Method argument                             |
| -------------------------------------------------------------------- | ------------------------------------------- |
| `Function<String, String> myFunction = s -> s.concat(" " + suffix);` | `list.forEach(s -> System.out.println(s));` |

- Declare lambda variables, or pass lambdas directly to methods that are targets.
- Crate methods that can be targets for lambda expressions.

## What's a Method Reference?

- Java gives us alternative syntax to use for this second kind of lambda, that uses named methods.
- These are called method references.
- These provide a more compact, easier-to-read lambda expression, for methods that are already defined on a class.
- For the last couple of videos for example, I've been ignoring Intelli-J's warnings and hints, whenever I've used `System.out.println` in a lambda expression.
- That's because it can be replaced with a method reference.

### Why are these statements equal?

| Lambda Expression            | Method Reference      |
| ---------------------------- | --------------------- |
| `s -> System.out.println(s)` | `System.out::println` |

- At first glance, it's not really obvious why a method reference has this syntax.
- A method referenc abstracts the lambda expression even further, eliminating the need to declare formal parameters.
- We salso don't have to pass arguments to the method in question, in this case `println`.
- A method reference has double colons, between the qualifying type, or object, and the method name.
- In this example of Consumer interface, not only is the method inferred, but the parameters are as well.

### What methods can be used in method references?

- Methods which can be used, are based on the context of the lambda expression.
- This means the method reference, is again depenent on the targeted interface's method.
- You can reference a `static` method on a class.
- You can reference an instance method from either an instance external to the expression, or an instance passed as one of the arguments.
- Or you can reference a constructor, by using `new` as the method.
- Method references can be used to increase the readability of your code.

### Deferred Method Invocation

- When you create variables that are lambda expressions or method references, it's important to remember that the code isn't invoked at that point.
- The statement of code block gets invoked at the point in the code that the targeted functional method is called.

## The Most Confusing of the Method References

### Some Terminology for the next couple of Slides

- A Type Reference refers to a class name, an interface name, an enum name, or a record name.
- Remember that static methods are usually called using `Type References`, but can also be called by instances in our code.
- This is `NO` true however for method references.
- Static methods, in method references and lambda expressions, must be invoked using a reference type only.
- There are two ways to call an instance method.
- The first is when you refer to the method with an instance derived from the enclosing code.
- This instance is declared outside of the method refernce.
  - The `System.out::println` method reference is an example.
- You;ll find that some web sites call this instance a bounded receiver, and I actually like that terminology as a differentiator.
- A `Bounded Receiver` is an instance derived from the enclosing code, used in the lambda expression, on which the method will be invoked.
- The second way is where the confusion starts.
  - The instance used to invoke the method, will be the first argument passed to the lambda expression or method reference when executed.
- This is known in some places as the `Unbounded Receiver`.
- It gets dynamically bound to the first argument, which is passed to the lambda expression, when the method is executed.
- Unfortunately this looks an awful lot like a static method reference, using a reference type.
- This means there are two method references that resemble each other, but have `two very different meanings`.
  - The first actually does call a static method, and uses a reference type to do it.
  - We saw this earlier, when we used the sum method on the Integer wrapper class.
    ```java
    Integer::sum
    ```
  - This is a `Type Reference(Integer is the type)`, which will invoke a static method.
  - But there is another, which you'll see when we start working with String method refences inparticular.
  - Here I show a method reference for the `concat` method on String.
    ```java
    String::concat
    ```
  - Now, we know by now I hope, that the concat method, isn't a static method on String.
  - Why is this method reference even valid?
  - We could never call concat from the String class directly, because it needs to be called on a specific instance.
  - This is valid when we use a method reference in the context of an `unbounded receiver`.
- **Remember, the unbounded receiver means, the first argument becomes the instance used, on which the method gets invoked.**
  ```java
  String::concat
  ```
- Any method reference that uses `String::concat`, must be in the context of a two parameter functional method.
- The first parameter is the String instance on which the concat method gets invoked, and the second argument is the String argument passed to the concat method.

### Four Types of Method References

| Type                                                                     | Syntax                                                | Method Reference Example | Corresponding Lambda Expression |
| ------------------------------------------------------------------------ | ----------------------------------------------------- | ------------------------ | ------------------------------- |
| static method                                                            | `ClassName::staticMethodName(p1, p2, ... pn)`         | `Integer::sum`           | `(p1, p2) -> p1 + p2`           |
| instance method of a particular (Bounded) object                         | `ContainingObject::instanceMethodName(p1, p2, ..pn)`  | `System.out::println`    | `p1 -> Sytem.out.println(p1)`   |
| instance method of an arbitrary (Unbounded) object (as determined by p1) | `ContainingType[=p1]::instanceMethodName(p2, ... pn)` | `String::concat`         | `(p1, p2) -> p1.concat(p2)`     |
| constructor                                                              | `ClassName::new`                                      | `LPAStudent::new`        | `() -> new LPAStudent()`        |

## Convenience Methods on Functional Interfaces (Chaining lambdas)

### Convenience Methods

- The Consumer, Predicate, and Function interfcae all come with these methods, as does the Comparator, which I'll also include here.
- ChainingLambdas 확인

### Convenience Methods on functional interfaces in `java.util.function` package

| Category fo Interface | Convenience method example     | Notes                                                        |
| --------------------- | ------------------------------ | ------------------------------------------------------------ |
| Function              | `function1.andThen(function2)` | Not implemented on IntFunction, DoubleFunction, LongFunction |
| Function              | `function2.compose(function1)` | Only implemented on Function & UnaryOperator                 |
| Consumer              | `consumer1.andThen(consumer2)` |                                                              |
| Predicate             | `predicate1.and(predicate2)`   |                                                              |
| Predicate             | `predicate1.or(predicate2)`    |                                                              |
| Predicate             | `predicate1.negate()`          |                                                              |

- For `andThen`, and `compose`, on the function category of interfaces, any Interim Functions are not required to have the same type arguments.
- Instead, one function's output becomes the next function's input, and the next function's output is not constrained to any specific type, except the last function executed.
- The Consumer's `andThen` method is different, because it never returns a result, so you use this when you're chaning methods, independent of one another.
- The Predicate methods always return a boolean, which will combine the output of the two expressions, to obtain a final boolean result.

### Comparator's additional helper methods

|Type of Method|Method Signature|
|---|---|
|static|Comparator comparing(Function keyExtractor)|
|static|Comparator naturalOrder()|
|static|Comparator reverseOrder()|
|default|Comparator thenComparing(Comparator other)|
|default|Comparator thenComparing(Function keyExtractor)|
|default|Comparator reversed()|

- There is a comparing static method, and an overloaded default method named, thenComparing, and finally a default reversed method.
