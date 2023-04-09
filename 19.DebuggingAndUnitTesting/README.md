# Debugging and Unit Testing

## Overview

- `assertNotEquals()`
  - we can use this instead of `assertEquals()` when we don't want the actual value to be equal to a specific value.
- `assertArrayEquals()`
  - when we want to verify the value of an array, we have to use the `assertArrayEquals()` method.
  - The `assertEquals()` method won't work, because it will only consider two arrays equal if they are the same instance.
  - The `assertArrayEquals()` method considers two arrays equal when their lengths are the same, and every element in both arrays is the same (and in the same order).
- `asserNull()` and `assertNotNull()`
  - we can use this method to check for null (and non-null) values.
  - We can use `assertEquals()` to check for null, but as with `assertTrue()` and `assertFalse()` methods, using `assertNull()` and `assertNotNull()` makes the intention clearer, and we only have to pass the actual value to the method.
- `assertSame()` and `assertNotSame()`
  - we use this when we want to check whether two instances are the exact same instance.
  - Remember that the `assertEquals()` method uses the `equals()` method to test for equality.
  - The `assertSame()` method compares the object references.
- `assertThat()`
  - this method compares the actual value against a matcher (not the Matcher in the JDK, but a JUnit matcher class).
  - This is more powerful than the other assert methods, since we can compare the actual value against a range of values.
  - Note that this method only became available in JUnit 4.4.
  