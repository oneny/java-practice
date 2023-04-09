# Sreams

```java
public static void main(String[] args) {
  List<String> someBingoNumbers = Arrays.asList(
          "N40", "N36",
          "B12", "B6",
          "G53", "G49", "G60", "G50", "g64",
          "I26", "I17", "I29",
          "O71"
  );
  someBingoNumbers
          .stream()
          .map(String::toUpperCase)
          .filter(s -> s.startsWith("G"))
          .sorted()
          .forEach(System.out::println);


}
```

## Overview

| Input                               | Method/Operation              | Output                                                                               |
| ----------------------------------- | ----------------------------- | ------------------------------------------------------------------------------------ |
| The ArrayList `someBingoNumbers`    | `stream()`                    | A Stream that contains all the items in the someBingoNumbers list, in the same order |
| Stream containing all bingo numbers | map(String::toUpperCase)      | A Stream that contains all the bingo numbers uppercased                              |
| Uppercased stream                   | filter(s -> s.startWith("G")) | A Stream containing all items beginning with "G" ("G53", "G49", "G60", "G50", "G64") |
| "G" items stream                    | sorted()                      | A Stream. containing the sorted items ("G53", "G49", "G60", "G50", "G64")            |
| Sorted "G" items stream             | forEach(System.out::println)  | Each "G" item is printed to the console. Void result. Tha chain ends."               |

Whe a chain is evaluated, a stream pipeline is created. The stream pipeline consists of a source, zero or more intermediate operations, and a terminal operation.    
In other example, we used a collection as the source, but we could also be an array or an I/O channel, and we can build streams from scratch.    
The items in the source enter the pipeline, and the chain result emerge at the other end of the pipe. As we've seen, elements may be removed from the stream as a result of an operation, so the set of elements that comes out at the other end of the pipe doesn't have to match the number that entered the pipe.

### Best Practices

Before we close off our discussion of lambda expressions, let's talk about best practices. Throughout this section, we've intentionally written lambda expressions in different ways. Here are the variantions we've used:
1. Specified the types of parameters vs letting the compiler infer them
2. Used a return statement with curly braces for on-statement lambda expressions vs not using return because it's implied (and hence not requiring curly braces)
3. Used lambda expressions that contain one statement vs Lambda expressions that have more than one statement
4. Using parenthesis when a lambda expression only has one argument vs not using parenthesis, since they're optional when there's only one argument.

If you look at the four variations, the two alternatives offer the choice between verbosity vs concisencess, which in turn, often comes down to the choice between readability and conciseness. Not all the time. Short lambda expressions are usually readable no matter how concise they are. But when striving for conciseness, we can sometimes write lambda expressions that are difficult to decipher because we've left out too much information.
