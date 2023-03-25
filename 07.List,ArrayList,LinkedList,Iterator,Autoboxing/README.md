# 07.List, ArrayList, LinkedList, Iterator, Autoboxing

## List and ArrayList

### Java Array vs Java List

- An array is mutable, and we saw, that we could set or change values in the array, but we could not resize it.
- Java gives us several classes that let us add and remove items, and resize a sequence of elements.
- These classes are said to **implement** a `List`'s behavior.

### So what is a List?

- List is a special type in Java, called an Interface.
- For now, I'll say a List Interface describes a set of method signatures, that all List classes are expected to have.
- https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#method-summary

### The ArrayList

- The ArrayList is a class, that really maintains an array in memory, that's actually bigger than what we need, in most cases.
- It keeps track of the capacity, which is the actual size of the array in memory.
- But it also keeps track of the elements that've been assigned or set, which is the size of the ArrayList.
- As elements are added to an ArrayList, its capacity may need to grow. THis all happens automatically, behind the scenes.
  - This is why the ArrayList is resizable.

## Arrays vs ArrayLists

### Arrays vs ArrayLists

This table demonstrates that arrays and ArrayLists have more in common, than they don't

| Feature                        | array | ArrayList |
| ------------------------------ | ----- | --------- |
| primitives types suported      | Yes   | `No`      |
| indexed                        | Yes   | Yes       |
| ordered by index               | Yes   | Yes       |
| duplicates allowed             | Yes   | Yes       |
| nulls allowed                  | Yes   | Yes       |
| resizable                      | `No`  | Yes       |
| mutable                        | Yes   | Yes       |
| inherits from java.util.Object | Yes   | Yes       |
| implements List interface      | No    | `Yes`     |

### Instantiating without Values

- Instantiating Arrays
  ```java
  String[] array = new String[10];
  ```
  - An array of 10 elements is created, all with null references.
  - The compiler will only permit Strings to be assigned to the elements.
- Instantiating ArrayLists
  ```java
  ArrayList<String> arrayList = new ArrayList<>();
  ```
  - An empty ArrayList is created.
  - The compiler wil check that only Strings are added to the ArrayList.
- An array requires square brackets in the declaration.
  - In the new instance, square brackets are also required, with a size specified inside.
- An ArrayList should be declared, with the type of element in the ArrayList, in angle brackets.
  - We can use the diamond operator, when creating a new instance in a declaration statement.
  - You should use a specific type, rather than just the Object class, because Java can then perform compile-time type checking.


### Creating Special Kinds of Lists

```java
var newList = Arrays.asList("Sunday", "Monday", "Tuesday");
String[] days = new String[] {"Sunday", "Monday", "Tuesday"};
List<String> newList = Arrays.asList(days);

var listOnew = List.of("Sunday", "Monday", "Tuesday");
String[] days = new String[] {"Sunday", "Monday", "Tuesday"};
List<string> newList = List.of(days);
```

- Both are static factory methods on types.
- The first is the `asList` method on the Arrays class, and it returns a special instance of a List, that is not resizable, but is mutable.
- The second is the `of` method on the LIst interface, and it returns a special instance of a List, that is muttable.
- Both support variable arguments, so you can pass a set of arguments of one type, or you can pass an array.
- We show examples of both here, first using variable arguments, and second, passing an array.

### Crating Arrays from ArrayLists

```java
ArrayList<String> stringLists = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
String[] stringArray = stringLists.toArray(new String[0]);
```

- This shows the most common method to create an array, from an ArrayList, using the method `toArray()`.
- This method takes on argument, which should be an instance of a typed array.
- This method returns an array of that same type.
- If the length of the array you pass, has more elements than the list, extra elements will be filled with the default values from that type.
- If the length of the array you pass, has less elements than the list, the method will still return an array, with the same number of elements in it, as the list.
- In the example shown here, we pass a String array with zero as the size, but the array returned has three elements, which is the number of elements in the list.
