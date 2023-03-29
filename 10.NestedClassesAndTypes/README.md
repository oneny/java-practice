# Nested Classes and Types

## Nested Classes

- The four different types of nested classes you can use in Java are: the `static` nested class, the `inner` class, and the `local` and `anonymous` classes.

| Type                    | Description                                                                                                   |
| ----------------------- | ------------------------------------------------------------------------------------------------------------- |
| static nested class     | declared in class body. Much like a `static` field, access to this class is through the Class name identifier |
| instance or inner class | declared in class body. This type of class can only be accessed through an instance of the outer class.       |
| local class             | declared within a method body.                                                                                |
| anonymous class         | unnamed class, declared and instantiated in same statement.                                                   |

## Static Nested Classes

### Static Nested Class

- The static nested class is a class enclosed in the structure of another class, declared as `static`.
- This means the class, if accessed externally, requires the outer class name as part of the qualifying name.
- This class has the advantage of being able to access private attributes on the outer class.
- The enclosing class can access any attributes on the static nested class, also including private attributes.

## Inner Classes

### Inner Classes

- Inner classes are non-static classes, declared on an enclosing class, at the member level.
- Inner classes can have any of the four valid access modifiers.
- An inner class has access to instance members, including private memebers, of the enclosing class.
- Instantiating an inner class from external code, is a bit tricky, and I'll cover that shortly.
- **As of JDK 16, static members of all types are supported on inner classes.**
- To create an instance of an inner class, you first must have an instance of the Enclosing Class
  ```java
  EnclosingClass outerClass = new EnclosingClass();
  EnclosingClass.InnerClass innerClass = outerClass.new InnerClass();
  ```
  - From that instance you call `.new`, followed by the inner class name and the parentheses, taking any constructor arguments.

## Local Classes

- Local classes are inner classes, but declared directly in a code block, usually a method body.
- Because of that, **they don't have access modifiers**, and are only accessible to that method body while it's executing.
- Like an inner class, they have access to all fields and methods on the enclosing class.
- They can also access local variables and method arguments, that are final or effectively final.

### Local Class's 'Captured Variables'

- When you create an instance of a local class, referenced variables used in the class, from the enclosing code, are `captured`.
- This means a copy is made of them, and the copy is stored with the instance.
- This is done because the instance is stored in a different memory area, than the local variables in the method.
- For this reason, if a local class uses local variables, or method arguments, from the enclosing code, these must be final or effectively final.

### Final Variables and Effectively Final

```java
class ShowFinal {
  private void doThis(final int methodArgument) {
    final int Field30 = 30;
  }
}
```

- A method parameter, called `methodArgument` in the `doThis` method, declared as final.
- And a local variable, in the method block, `Field30`, also declared with the key word final.
- In both these cases, this means you can't assign a different value, once these are initialized.
  - 둘 모두 초기화하면 다른 값을 할당할 수 없다는 것을 의미한다.
- These are `explicitly final`, and any of these could be used in a local class, because of this.

### Effectively Final

- In addition to explicitly final variables, you can also use `effectively final` variables in your local class.
  - 명시적으로 `final variables`이라는 것 뿐만 아니라 로컬 클래스 안의 효과적으로 `final variables`를 사용할 수 있다.
- A local variable or a method argument are effectively final, if a value is assigned to them, and then never changed after that.
- Effectively final variables can be used in a local class.

### Additional Local Types

- As of JDK 16, you can also create a local record, interface and enum type, in your method block.
- These are all implicitly static types, and therefore aren't inner classes, or types, but static nested types.
- The record was introduced in JDK 16.
- Prior to that release, there was no support for a local interface or enum in a method block either.

## Anonymouse Classes

- An anonymous class is a local calss that doesn't have a name.
- All the nested clases we've looked at so far have been created with a class declaration.
- The anonymous class is never created with a class declaration, but it's always instantiated as part of an expression.
  - 익명의 클래스는 클래스 선언으로 생성되는 일이 없다. 하지만 항상 표현의 일부로 인스턴스화된다.
- Anonymous classes are used a lot lss, since the introduction of Lambda Expressions in JDK 8.
- But there are still some use cases where an anonymous class might be a good solution.

### Anonymous class creation

```java
var c4 = new Comparator<StoreEmployee>() {};
```

- An anonymous class is instantiated and assigned in a single statement.
- The `new` keyword is used followed by any type.
- This is `NOT` the type of the class being instantiated.
- It's the super class of the anonymous class, or it's the interface this anonymous class will implement as I'm showing here.
- In the first example, the anonymous unnamed class will implement the Comparator interface.
  ```java
  var c4 = new Comparator<StoreEmployee>() {};
  ```
- In the second example, the anonymous class extends the Employee class, meaning it's a subclass of Employee.
  ```java
  var e1 = new Employee {};
  ```
- In both cases, it's important to remember the semi-colon after the closing bracket, because this is an expression, not a declaration.
