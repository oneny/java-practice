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

## Arrays, ArrayList & LinkedList - (Memory and Big O Notation)

### Array of primitive values

| Index | Value | Address |
| ----- | ----- | ------- |
| 0     | 34    | 100     |
| 1     | 18    | 104     |
| 2     | 91    | 108     |
| 3     | 57    | 112     |
| 4     | 453   | 116     |
| 5     | 65    | 120     |
| 6     | 6     | 124     |

- When an array of primitive types is allocated, space is allocated for all of it's elements contiguously, as shown here.
- You can see from this table, thatn we have an array of `seven integers`.
  - The index position is in the left column, and that's the number we use, to access a specifc array value.
- So the first element, when we use index position 0, this will retrieve the value 34.
- When we use index position 1, this gets the value of 18, and so on.
- The address we show here are memory addresses, represented by these numbers.
- If 100 is the address of an integer, and we know an integer is 4 bytes, then the address of the next integer, if it's contiguous would be 104, as we show here, for the second element.
- Java can use simple math, using the index, and the address of the initial element in the array, to get the address, and retrieve the value of the element.

### Arrays and ArrayLists of reference types

- For reference types (meaning anything that's not a primitive type), like a String, or any other object, the array elements aren't the values, but the addresses of the referenced object or String.
- We've learned that ArrayLists are really implemented with arrays, under the covers.
- This means our objects aren't stored contiguously in memory, but their addresses are, in the array behind the ArrayList.
- And again, the addresses can be easily retrieved with a bit of math, if we know the index of the element.
- This is a `cheap` lookup, and doesn't change, no matter what size the ArrayList is.
- But to remove an element, the referenced addresses have to be re-indexed, or shifted, to remove an empty space.
- And when adding an element, the array that backs the ArrayList might be too small, and might need to be reallocated.
- Either of these operations can be an `expensive` process, if the number of elements is large.

### ArrayList capacity

```java
ArrayList<Integer> intList = new ArrayList<>(10);
for (int i = 0; i < 7; i++) {
  intList.add((i + 1) * 5);
}

intList.add(40);
intList.add(45);
intList.add(50);

// This add exceeds the ArrayList capacity,
// assuming an initial capacity of 10, as an example
intList.add(55);
```

| Index | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  | 14  |
| ----- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| value | 5   | 10  | 15  | 20  | 25  | 30  | 35  | 40  | 45  | 50  | 55  |     |     |     |     |

- An ArrayList is created with an initial capacity, depending on how many elements we create the list with, or if you specify a capacity when creating the list.
- But if the number of elements exceeds the current capacity, Java needs to reallocate memnory, to fit all the elements, and this can be a costly operation, especially if your ArrayList contains a lot of items.
- So now, if our code simply calls add on this ArrayList, the next operation is going to create a new array, with more elements, but copy the exising 10 elements over.
- Then the new eleemnt is added. You can imagine this add operation cost more, in both time and memory, than the previous add methods did.
- When Java re-allocates new memory for the ArrayList, it automatically sets the capacity to a grater capacity.
- But the Java language doesn't really specify exactly how it determines the new capacity, or promise that it will continue to increase the capacity in the same way in future versions.
- We can't actually get this capacity size, from teh ArrayList.
- From their own documentation, Java states that, "The details of the growth policy, are not specified beyond the fact that adding an element, has constant amortized time cost".
- Ok, maybe you're interested in waht constant amortized time is.
- Let's start with how to determine cost, which in this case is generally considered in term of time, but may include memory usage and processing costs, etc.

### Big O Notation

- There are a couple of concepts that are fairly easy to grasp, and will help us understand how `cheap` or `expensive` an operation is, in terms of time and memory usage, as the operation scales.
- This means it's a way to express how well the operation performs, when applied to more and more elements.
- Big O approximates the cost of an operation, for a certina number of elements, called `n`.
- Cost is usually determined by the time it takes, but it can include memory usage, and complexity for example.
- As `n` (the number of elements) gets bigger, an operation's cost can stay the same.
- But cost often grows, as the number of elements grow.
- Costs can grow linearly, meaning the cost stays in step, with the magnitude of the number of elements.
- Or costs can grow exponentially, or by some other non-linear fashion.
- In a perfect world, an operation's time and complexity would never change. This ideal world, in Big O Notation is O(1), sometimes called constant time.
- In many situations, an operaion's cost is in direct correlation to the number of elements, n. In Big O Notation that is O(n), sometimes called linear time.

### Constant Amortized Time Cost

- Another scenario, is the one the Java docs declared for the growth of the ArrayList, that adding an element has constant amortized time cost.
- In our case, we'll designate this constant amortized time as `O(1)*`.
- This means that in the majority of cases, the cost is close to O(1), but at certain intervals, the cost is O(n).
- If we add an element to an ArrayList, where the capacity of the LIst is already allocated, and space is avaiable, the cost is the same each time, regradless of how many eklements we add.
- But as soon as we reach the capacity, and all the elements (all n elements) need to be copied in memory, this single add would have a maximum cost of O(n).
- After this operation, that forced a realloation, any additional add operations go back to O(1), until the capacity is reached again.
- As the expensive intervals decrease, the cost gets closer to `O(1)`, so we give it the notation `O(1)*`.

### ArrayList Operations - Big O

| Operaion                  | Worst Case | Best Case |
| ------------------------- | ---------- | --------- |
| add(E element)            | O(1)\*     |           |
| add(int index, E element) | O(n)       | O(1)\*    |
| contains(E element)       | O(n)       |           |
| get(int index)            | O(1)       |           |
| indexOf(E Element)        | O(n)       | O(1)      |
| remove(int index)         | O(n)       | O(1)      |
| remove(E Element)         | O(n)       |           |
| set(int index, E element) | O(1)       |           |

- O(1) - contant time - operation's cost (time) should be constant regradless of number of elements.
- O(n) - linear time - operation's cost (time) will increase linearyly with the number of elements in.
- O(1)\* - constant amortized time - somewhere between O(1) and O(n) but closer to O(1) as efficiencies are gained.

- It could find a match at the very first index, this is the best case scenario, so it's O(1).
- It might not find a match until the last index, this is the worst case scenario, so it's O(n).
- IT only gets costly with indexed add or remove methods, if the ArrayList needs to be re-indexed, or re-sized.

### LinedList

- The LinedList is not indexed at all.
- There is no array, storing the addresses in a neat ordered way, as we saw with the ArrayList.
- Instead, each element that's added to a linked list, forms a chain, and the chain has links to the previous element, and the next element.

### LinkedList - Retrieval of an Element costs more than an ArrayList retrieval

- Getting an element from the list, or setting a value of element, isn't just simple math anymore, with the LinkedList type.
- To find an element, we'd need to start at the head or tail, and check if the element matches, or keep track of the number of elements traversed, if we are matching by an index, because the index isn't stored as part of the list.
- For example, even if you know, you want to find the 5th element, you'd stil have to travers the chain this way, to get that fifth element.
- This type of retrieval is considered expensive in computer currency, which is processing time and memory usage.
- On the other hand, inserting and removing an element, is much simpler for this type of collection.

### LinkedList - Inserting or Removing an Element may be less costly than using an ArrayList

- In contrast ot an ArrayList, inserting or removing an item in a LinkedList, is just a matter of breaking two links in the chain, and re-establishing two different links.
- No new array needs to be created, and elements don't need to be shifted inot different positions.
- A reallocation of memory to accommodate all existing elements, is never required.
- So for a LinkedList, inserting and removing elements, is generally considered `cheap` in computer currency, compared to doing these functions in an ArrayList.

### LinkedList Operaions - Big O

| Operaion                  | Worst Case | Best Case |
| ------------------------- | ---------- | --------- |
| add(E element)            | O(1)       |           |
| add(int index, E element) | O(n)       | O(1)      |
| contains(E element)       | O(n)       | O(1)      |
| get(int index)            | O(n)       | O(1)      |
| indexOf(E Element)        | O(n)       | O(1)      |
| remove(int index)         | O(n)       | O(1)      |
| remove(E Element)         | O(n)       | O(1)      |
| set(int index, E element) | O(1)       | O(1)      |

- When removing elemnts, a LinkedList wil be more efficient, because it doesn't require re-indexing, but the element still needs to be found, using the traversal mechanism, which is why it is `O(n)`, as the worst case.
- Removing elements form the start or end of the List, will be more efficient for a LinkedList.

### Things to Remember when considering whethere to use an ArrayList vs LInkedList

- The ArrayList is usually the better default choice for a List, especially if the List is used predominantly(주로) for storing and reading data.
- If you know the maximum number of possible items, then it's probably better to use an ArrayList, but set it's capacity.
- This code demonstrates how to set the capacity of your ArrayList to `500_000`.
  ```java
  int capacity = 500_000;
  ArrayList<String> stringArray = new ArrayList<>(capacity);
  ```
- An ArrayList's index is an int type, so an ArrayList's capacity is limited to the maximum number of elements an int can hold, Integer.MAX_VALUE = 2,147,483,647.
- You may want to consider using a LinkedList if you're adding and processing or manipulating a large amount of elements, and the maximum element isn't known, but may be great, or if your number of elements may exceed Integer.MAX_VALUE = 2,147,483,647.
- A LinkedList can be more efficient, when items are being processed predominantly from either the head or tail or the list.

## LinkedList

### A Queue is a First-In, First-Out (FIFO) Data Collection

- When you think of a queue, you might think of standing in line.
- When you get in a line or a queue, you expect that you'll be processed, in relationship to the first person in line.
- If you want to remove an item, you poll the queue, getting the first element or person in the line.
- If you want to add an item, you offer it onto the queue, sending it to the back of the line.
- Single-ended queues always process elements form the start of the queue.
- A double-ended queue allows access to both the start and end of the queue.
- A LinkedList can be used as a double ended queue.

### A Stack is a Last-In, First-Out (LIFO) Data Collection

- When you think of a stack, you can think of a vertical pile of elements, one on top of another.
- When you add an item, you push it onto the stack
- If you want to get an item, you'll take the top item, or pop it from the stack.
 
## Iterators

### What's an Iterator?

- So far, we've mainly used for loops to traverse, or step through elements, in an array or list.
- We can use the traditional for loop and an index, to index into a list.
- We can use the enhanced for llop and a collection, to step through the elements, one at a time.
- But Java provides other means to traverse lists.
- Two alternatives are the Iterator, and the ListIterator.

### How does an Iterator work?

- If you're familiar with databases, you might be familiar with a database cursor, which is a mechanism that enables traversal, over records in a database.
- An iterator can be thought of as similar to a dababase cursor.
- The kind of cursor we're referring to here, can be described as an object, that allows traversal over records in a collection.

### How does an Iterator work?

- The Iterator is pretty simple.
- When you get an instance of an iterator, you can call the `next` method, to get the next element in the list.
- You can use the `hasNext` method, to check if any elements remain to be processed.
- In the code, you can see a while loop, which uses the iterator's `hasNext` method, to determine if it should continue looping.
- In the loop, the `next` method is called, and its value assigned to a local variable, and the local variable printed out.

```java
System.out.println("Trip starts at " + list.getFirst());
String previousTown = list.getFirst();
ListIterator<String> iterator = list.listIterator(1);
System.out.println(list);

while (iterator.hasNext()) {
  String town = iterator.next();
  if (town.equals("Brisbane")) list.remove();
  System.out.println("--> From: " + previousTown + " to " + town);
  previousTown = town;
}
```

#### java.util.ConcurrentModificationException

- 위 예제(`LinkedList 폴더 확인`)는 리스트를 순회하는 중 요소를 삭제한다.
  - 순회하면서 요소를 삭제하기 때문에 index가 변경되어 일부 요소를 순회하지 않을 수 있다.
  - List에서 문제가 발생할 수 있는 것을 감지하여 `ConcurrentModificationException`를 발생시킬 수 있다.
- Iterator는 순회 중에 요소를 삭제해도 java.util.ConcurrentModificationException가 발생하지 않도록 설계되었다.
  ```java
  if (town.equals("Brisbane")) iterator.remove(); // 이렇게 해야 에러 발생하지 않음
  ```

### Iterator vs ListIterator

- An Iterator is forwards only, and only supports the `remove` method.
- A ListIterator can be used to go both forwards and backwards, and in addition to the `remove` method, it also supports the `add` and `set` methods.
  ```java
  while (iterator.hasPrevious()) System.out.println(iterator.previous());
  ```

### Iterator position vs Element position

It's really important to understand that the iterator's cursor positions, are **between** the elements.

```
0               1          2         <- Iterator (Cursor) Positions
  Alice Springs   Brisbane   Darwin
       0             1         2     <-  Element Positions
```
```java
var iterator = list.listIterator();

String fist = iterator.next(); // Alice Springs returned, cuusor moved to
// cursor position 1
String second = iterator.next(); // Brisbane returned, cursor moved to cursor
// cursor position 2

// Reversing Directions
String reversed = iterators.previous(); // Brisbane returned, cursor moved to
// cusor position 1
```

## Autoboxing and Unboxing

### Why does Java have primitive data types?

- Some object-oritented languages, don't support any primitive data types at all, meaning everything is an object.
- But most of the more popular object oriented languages of the day, support both primitive types and objects, as does Java.
- Primitive types generally represent the way data is stored on an operating system.
- Primitive have some advantages over objects, especially as the manitude, or number of elements increase.
- Objects take up additional memory, and may require a bit more processing power.
- We know we can create objects, with primitive data types as field types, for example, and we can also return primitive types from methods.

### Why don't all of Java's collection types support primitives?

```java
LinkedList<int> myIntegers = new LinkedList<>();
```

- But when we look at classes like the ArrayList, or the LinkedList, which we've reviewed in a lot of detail in this section, these classes don't support primitive daeta types, as the collection type.
- In other words, **we can't do the following**, creating a LinkedList, using the int primitive type.
- More importantly, we can't easily use primitives, in some of the features we'll be learning about in the future, like generics.
- But Java, as we know, gives us wrapper classes for each primitive type.
- And we can go from a primitive to a wrapper, which is called boxing, or a wrapper to a primitive, which is called unboxing, with relative ease in Java.

### What is Boxing?

```
          ↙️    Wrapper types   ↘️
java.lang.Integer         java.lang.Double
      int                      double
          ↖️   primitive types  ↗️
```

- Wrapper Classes
  - Boolean, Byte, Character, Double, Float, Integer, Long, Short
- A primitive is boxed, or wrapped, in a containing class, whose main data is the primitive value.
- Each primitive data type has a wrapper class, as shown on the list, which we've seen before.
- Each wrapper type boxes a specific primitive value.

### How do we box?

```java
Integer boxedInt = Integer.valueOf(15);
```

- Each wrapper has a static overloaded factory method, `valueOf()`, which take s a primitive, and returns an instance of the wrapper class.
- This code returns an instance of the `java.lang.Integer` class, to the boxedInt variable, with the value 15 in it.
- We can say this code **manually boxes** a primitive integer.

### Deprecated Boxing using the wrapper constructor

```java
Integer boxedInt = new Integer(15);
```

- Another manual way of boxing, which you'll see in older code, is by creating a new instance of the wrapper class, using the `new` keyword, and passing the primitive value ot the constructor.
- If you try this in IntelliJ, with any Java version greater than JDK-9, IntelliJ will tell you, this is deprecateed code.
- Java own documentation states the following:
  - It is rarely appropriate to use this constructor.
  - The static factory `valueOf(int)` is generally a better choice, as it is **likely to yield significantly better space and time performance**.
- This deprecation applies to all the constructors of the wrapper classes, not just the Integer class.
- In truth, we rarely have to manually box primitives, because Java supports something called `autoboxing`.

### What is autoboxing?

```java
Integer boxedInteger = 15;

int unboxedInt = boxedInteger.intValue();
```

- We can simply assign a primitive to a wrapper variable.
- Java allows this code, and it's actually preferred, to manually boxing.
- Underneath the covers, Java is doing the boxing. In other words, an instance of Integer is created, and it's value is set to 15.
- Allowing Java to autobox, is preferred to any other method, because Java will provide the best mechanism to do it.
- Every wrapper class supports a method to return the primitive value it contains.
- This is called unboxing.
- In the example, we've autoboxed the integer value 15, to a variable called boxedInteger.
- This gives us an object which is an Integer wrapper class, and has the valueof 15.
- To unbox this, on an Integer class, we can use the intValue method, which returns the boxed value, the primitive int.

### Automatic unboxing

```java
Integer boxedInteger = 15;

int unboxedInt = boxedInteger.intValue();
```

- Automatic unboxing is really just referred to as unboxing in most cases.
- We can assign an instance of a wrapper class, directly to a primitive variable.
- We're assigining an object instance to a primitive variable, in the second statement.
- This is allowed, because the object instance is an Integer wrapper, and we're assigning it to an int primitive type variable.
- Again, this is the preferred way to unbox a wrapper instance.

## Enumeration

### Enumeration

- THe enum type is Java's type to supoort something called an enumeration.
- Wikipedia defines enumeration as, "A complete ordered listing of `all the items` in a collection."
- Java describes the enum type as: A special data type that contains predefined constants.
- A constant is a variable whose value can't be changed, once it's value has been assigned.
- So an enum is a little like an array, except it's elements are known, not changeable, and each element can be referred to by a constant name, instead of an index position.

### The enum type

```java
public enum DayOfTheWeek {
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

- An enum, in its simplest form, is described like a class, but the keyword enum, replaces the keyword class.
- You can name the enum with any valid identifier, but like a class, Upper CamelCase is the preferred style.
- Within the enum body, you declare a list of constant identifiers, separated by commas. By convention, these are all uppercase labels.
- An enum is ordered, by the way you declare the constants.
- The enum type is used to declare a limited set of constants, and sometimes, there is a natural order to the listing, as in the case of days of the week.
- Underneath the covers, the enum type is a special type of class, which contains fields to support the constants.
- Once you get used to how this type works, you may find many places to use an enum.
- They simplify your code, and make it more readable in many ways.
