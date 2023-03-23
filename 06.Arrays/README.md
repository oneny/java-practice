# Arrays

## Arrays

### Arrays

- An array is a data structure, that allows you to store a sequence of values, all of the same type.
- You can have arrays for any primitive type, like ints, doubles, booleans, or any of the 8 primitives we've learned about.
- You can also have arrays for any class.
- Elements in an array are indexed, starting at 0.
- If you have an array, storing five names, conceptually it looks as shown here.

  | index                                     | 0      | 1     | 2         | 3       | 4     |
  | ----------------------------------------- | ------ | ----- | --------- | ------- | ----- |
  | Stored values in an array with 5 elements | "Andy" | "Bob" | "Charlie" | "David" | "Eve" |

### Declaring an Array

```java
int[] integerArray;
String[] nameList;
String courseList[];
```

- When you declare an array, you first specify the type of the elements you want in the array.
- Then you include square brackets in the declaration, which is the key for Java, to identify the variable as an array.
- The square barckets can follow the type as shown in the first two examples.
  - This is much more common.
- The brackets can also be after the variable name, as shown in the last example.
- You don't specify a size, in the array declaration itself.

### Instantiating an Array

| Array Creation                    | Object Creation                          |
| --------------------------------- | ---------------------------------------- |
| int[] integerArray = new int[10]; | String Builder sb = new StringBuilder(); |

- One way to instantiate the array, is with the `new` keyword, much as we've seen, with most of the classes we've used to date, with the exception of String.
- On the table, we have an array declaration on the left of the equals sign, and then an array creation expression on the right side.
- For comparison, I'm showing you a typical array variable declaration, and a class instance, or object creation expression, using the StringBuilder class.
- They look pretty similar, but there are two major differences.
- Square brackets are required when using the `new` keyword, and a size is specified between them. So in this example, there will be 10 elements in the array.
- An array instantiation doesn't have a set of parentheses, meaning we can't pass data to a constructor for an array.
- In fact, using parentheses with an array instantiation, gives you a compiler error.
  ```java
  int[] integerArray = new int[10](); // Invalid Array Creation - Conpile Error because of ()
  ```

### An Array is NOT Resizable

```java
int[] integerArray = new int[10];
```

- The size of an array, once created, is fixed.
- In this case, integerArray will have 10 elements.
- You can't change the size of an array, after the array is instantiated.
- We can't add or delete elements, we can only assign values to one of the ten elements in this array, in this example.

### The array initializer

```java
int[] firstFivePositives = new int[] {1, 2, 3, 4, 5};
```

- In this example, you can see we still use the new keyword, and have int, with the square brackets.
- But here we specify the values, we want the array to be initialized to, in a comma delimited list, in curly braces.
- Because these values are speecified, the length of the array can be determined, so we don't specify the size in the square brackets.

### The array initializer as an anonymouse array

```java
int[] firstFivePositives = {1, 2, 3, 4, 5};
String[] names = {"Andy", "Bob", "Charlie", "David", "Eve"};
```

- Java allows us to drop `new int[]`, from the expression, as we show here.
- This is known as an anonymous array.
- An anonymouse array initializer, can only be used in a declaration statement.
- 선언문 외의 문에서 배열의 익명 버전을 사용할 수 없다.
  ```java
  int[] newArray;
  newArray = {5, 4, 3, 2, 1}; // Error
  newArray = new int[] {5, 4, 3, 2, 1}; b 
  ```

### What is an array, really?

- An array is a special class in Java.
- It's still a class.
- The array, like all other classes, ultimately inherits from java.lang.Object.

### Array initialization and default element values

- When you don't use an array initializer statement, all array elements get initialized to the default value for that type.
- For primitive types, this is `zero` for any kind of `numeric primitive`, like int, double or short.
- For `booleans`, the default value will be `false`.
- And for any `class` type, the elements will be initialized to `null`.

### The Enhanced For Loop, the For Each Loop

```java
// Enhanced For Loop
for (declaration : collection) {
  // block of statmenets
}
// Basic for Loop
for (init; expression; increment) {
  // block of statements
}
```

- This loop was designed to walk through elements in an array, or some other type of collection.
- It processes **one element at a time**, from the **first** element to the **last**.
- Here I show you the syntax for the two types of for loop statements, side by side.
- The enhanced for loop only has two components, vs 3, defined in the parentheses after the for keyword.
- It's important to notice, that the separator character between components, is a `colon`, and not a semi-colon, for the Enhanced For Loop.
- The `first` part is a `declaration expression`, which includes the type and a variable name. This is usually a local variable with the same type as an element in the array.
- And the `second` component is the `array`, or some other colleciton variable.

### java.util.Arrays

- Java's array type is very basic, it comes with very littel built-in functionality.
- It has a single property of field, named length.
- And it inherits `java.util.Object`'s funcionality.
- Java provides a helper class named `java.util.Arrays`, providing common functionality, you'd want for many array operations.
- These are static methods on Arrays, so are class methods, not instance methods.

### Printing elements in an array using Arrays.toString()

- The toString method on this helper class, prints out all the array elements, comma delimited, and contained in square brackets.
  ```java
  String arrayElementsInAString = Arrays.toString(newArray);
  ```
- The output from this method is shown here, conceptually.

## Using java.util.Arrays (sort, fill, copyOf)

### Why use arrays?

- We use arrays to manage many items of the same type.
- Some common behavior for arrays would be sorting, initializing values, copying the array, and finding an element.
- For an array, this behavior isn't on the array instance itself, but it's provided on a helper class, `java.util.Arrays`.

### sort, fill, copyOf

```java
int[] firstArray = {5, 4, 3, 2, 1};
int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);
Arrays.sort(firstArray); // [1, 2, 3, 4, 5]
// thirdArray는 [5, 4, 3, 2, 1] 그대로
int[] secondArray = new int[10];
Arrays.fill(secondArray, 5); // [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
```

## Finding a Match, Using a Binary Search and testing equality of arrays

### Finding a match

- There are different algorithms for searching and matching elements in lists.

### Searching Sequentially

- You can hopefully imagine if you were going to start writing code to do this, you might start looping from start to finish, and check each element, to see it it equals what you're looking for.
- If you find a match, you'd stop looping, and return that a match was found, either with the position you found the element at, or just a boolean value, true if it was found, and false if not.
- This is called a `linear search`, or `sequential`, because you're stepping through the elemnts, one after another.
- If your elements are sorted though, using this type of linear search, is unnecessarily inefficient.

### Using intervals to Search

- You split each section p, testing the values at the boundaries, and based on that, split again into smaller sections, narrowing the number of elements to test, each time.
  - 각각의 구역을 나눠서 경계에 있는 값을 테스트하고 그리고 그걸 바탕으로 다시 작은 구역으로 나눠서 매번 테스트할 수 있는 요소의 수를 줄인다.
- This type of searching, in sofrware, is called `interval searching`.
- Within these two categories, sequential and interval, there are numerous existing algorithms in each.
  - 순차적과 간격이라는 두 카테고리 안에 많은 알고리즘들이 존재한다.
- One of the most common interval searches, is the `binary search`, which is why Java provides this search, on so many of it's collection classes.
- 가장 흔한 간격 검색 중 하나로 `Binary Search`가 있고, 자바는 이러한 search를 제공한다.
- In this search, `intervals` are continually `split into two`, hence the world binary.

### Arrays.binarySearch

- The staic method, binarySearch, is on the Arrays class.
- We can use this method, to test if a value is already in our array, but there are some `important` things to remember.
  - First, the array has to be `sorted`.
  - Second, if there are duplicate values in the array, there's no guarantee which one it'll match on.
  - Finally, elements must be comparable. Trying to compare instances of different types, may lead to errors and invalid results.
-  THis method returns:
  - `The position of a match` if found.
  - It returns a `-1` when `no match` was found.
  - It's important to remember, that a positive number **may not be the positionof the first match**.
  - If your array has dulpicate values, and you need to find the first element, other methods should be used.

## Arrays Recap

- An array is a data structure that allows us to store multiple values, of the same type, in a single variable.
- The default values of numeric array elements are set to zero.
- Arrays are zedro indexed, so an array with n elements, is indexed from `0` to `n-1`.
- If we try to access an index that is out of range, Java will give us an `ArrayIndexOutOfBoundsException`, which indicates that the index is out of range, in other words, out of bounds.
- To access array elements, we use square braces. THis is also known as the array access operator.

## References Types vs Value Types

### References Types vs Value Types

- In a previous video, I talked about the differences between a Reference vs an Object vs an Instance vs a Class.
- I want to revisit this a little, and talk about why this matters, when we're talking about arrays.
- When you assign an object to a variable, the variable becomes a reference to that object.
- This is true of arrays, but the array has yet another level of indirection, if it's an array of objects.
- This means every array element is also a reference.
- 메모리에 배열 주소를 가리키는 레퍼런스를 생성하고 다른 레퍼런스에 할당하면 둘은 공유하게 된다.
  - 메모리의 해당 배열에 대한 참조, 레퍼런스가 두 개 생기는 것.
  - 메모리에서 각각의 참조나 변수 이름은 다르지만 같은 주소를 가리킨다.

## Variable Arguments (Varargs)

### Arrays as method parameters

```java
public static void main(String[] args) {

}
```

- Notice here that the parameter to the main method, is an array of String.
- This means we can pass an array of Strings to this method, when it's called.
- Or, if we use this method as the entry point to our application, we can pass data on the command line to this method.
- Up until now, I've only shown you this particular method signature.

### Variable arguments (varargs)

```java
public static void main(String... args) {}
```

- But this signature can be written in a slighly different way.
- We can replace the brackets after the String type, which we know tells us this method will take an array of String.
- And we can instead replace that with three periods.
- This is a special designation for Java, that means, Java will take zero, one, or many Strings, as arguments to this method, and create an array with which to prcess them, in the method.
- The array will be called args, and be of type String.
- So what's the difference then?
  - The difference is minor within the method body, but significant to the code that calls the method.

### When can you use variable arguments(VarArgs)?

```java
public class Main {
  public static void main(String... args) {
    System.out.println("Hello World again");

//    String[] splitStrings = "Hello World again".split(" ");
//    printText(splitStrings);

    System.out.println("_".repeat(20));

    //
    printText("Hello");
    printText("Hello", "World", "again");
  }

  private static void printText(String firstStr, String... textList) {
    System.out.println("Nice! " + firstStr);
    for (String t : textList) {
      System.out.println(t);
    }
  }
}
```

- There can be only one variable argument in a method.
- The variable argument must be the last argument.

### Dimensional Array

### Two-Dimensional Array

- Notice the two sets of square brackets on the left side of the assignment, in the declaration.
- Using this type of declaration, tells Java we want a two dimensional array of integers.

```java
int[][] array = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
```

### Multi-dimensional Arrays

```java
Object[] multiArray = new Object[3];
multiArray[0] = new Dog[3];
multiArray[1] = new Dog[3][];
multiArray[2] = new Dog[3][][];
```

- We can take that even further, the outer array can have references to itself.
