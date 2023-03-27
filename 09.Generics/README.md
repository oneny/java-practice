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