# 12. Naming Conventions and Packages.static and final keywords

## Naming Conventions

### Java Naming Convetions

- Adopting the accepted conventions for naming variables, methods and objects in Java makes your code easier for others to read.
- "Others" here also includes you when you come to look at your code weeks of months after you wrote it.
- The things you will name in Java are:
  - Packages
  - Classes
  - Interfaces
  - Methods
  - Constants
  - Variables
  - Type Parameters

### Packages

- Always lower case.
- Package names should be unique.
- Use your internet domain name, reversed, as a prefix for the package name.
- Oracle specify a convention for package names at http://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7

#### Invalid domain name components

- Replace invalid characters (i.e.-) in domain name with an underscore.
- Domain name components starting with a number should instead start with an underscore_.
- Domain name components that are Java keywords should have that component start with an underscore.
- Examples with replacements
  - Switch.supplier.com -> com.supplier._switch
  - 1world.com -> com._1world
  - Experts-exchange.com -> com.experts_exchange

#### Example package names

- java.lang
- java.io
- org.xml.sax.helpers
- com.timbuchalka.autoboxing

### Class Names

- CamelCase
- Class names should be nouns(they represent things).
- Should start with a capital letter.
- Each world in the name should also start with a capital (e.g. LinkedList)
- ArrayList
- LinkedList
- String
- TopSong
- GearBox
- Main

#### Interface names

- Capitalized like class names(CamelCase).
- Consider what objects implementing the interface will become of what they will be able to do
- Examples:
  - List
  - Comparable
  - Serializeable

#### Method names

- mixedCase
- Often verbs
- Reflect the function performed or the result returned.
- Examples:
  - size()
  - getName()
  - addPlayer()

### Constants

- ALL UPPER_CASE
- Separate words with underscore_.
- Declared using the final keyword.
- Examples:
  - Static final int MAX_INT
  - Static final shorts SEVERITY_ERROR
  - Static final double P1 = 3.141592653

### Variable names

- mixedCase
- Meaningful and indicatitve.
- Start with lower case letter.
- Do not use underscore _.
- Examples:
  - i
  - league
  - SydneySwans
  - BoxLength

### Type Parameters

- Single Character, capital letters.
- Guidlines given at https://docs.oracle.com/javase/tutorial/generics/typs.html
- E - Element(used extensively by the Java Collections Framework)
- K - Key
- T - Type
- V - Value
- S, U, V, etc. - 2nd, 3rd, 4th types

## Packages

### Packages

- Over 9 million Java developers worldwide.
- Class or Interface name conflicts are inevitable.
- Mechanism is needed to fully specify class.
- Allow use of classes with the same name in the same project (or, even, the same class)
- Some reasons to use packages are:
  - Programmers can easily determine that the classes are related.
  - It is easy to know where to find the classes and interfaces that can provide the functions provided by the package.
  - Because the package creates a new namespace, class and interface name conflicts are avoided.
  - Classes within the package can have unrestricted access to one another while still restrciting access for classes outside the package.

## Access Modifiers

### Top Level

- Only classes, interfaces and enums can exit at the top level, everything else must be included within one of these.
- `public`: ths object is visible to all classes everywhere, whether they are in the same package or have imported the package containing the public class.
- `Package-private`: the object is only available within tis own package (and is visible to every class within the same package). Package-private is specified by not specifyiong, i.e it is the default if you do not specify public. There is not a "package-private" keyword.

### Member Level

- `public`: at the member level, `public` has the same meaning as at top level. A public class member (or field) and public method can be accessed from any other class anywhere, even in a different package.
- `Package-priavte`: this also has the same meaning as it does at the top level. An object with no access modifier is visible to every class within the same package (but not to classes in external packages).
- `private`: ths object is only visible within the class it is declared. It is not visible anywhere else (including in subclasses of its class).
- `protected`: the object is visible anywhere in its own package (like package-private) but also in subclasses even if they are in another package.

