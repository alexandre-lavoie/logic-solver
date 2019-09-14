# Logic Solver
This is a boolean logic solver for Java. The solver automatically finds the variables in the proposition. It then generates a truth table with all possible inputs and outputs.

## Getting Started

### Requirements
- Java IDE (we use Visual Studio Code)
- JDK 1.8^

### Note
You will have to manually change the JDK version in the [.classpath](.classpath) file.

```

...

<classpathentry kind="con" path=".../JavaSE-*version*"/>

...


```

## How to Use

Input your equation using non-reserved variable names. Your variable names should also exclude operators.

### Operators
- NOT (negation): !
- AND (conjunction): &
- OR (disjunction): |
- XOR (exclusive or): ^
- Conditional (uses equivalence): (!p|q) 
- Biconditional: ==
- Parentheses (for order of operations): ()

### Functions
- exit -> Exits the program.

## Sample Input and Output

Given the propopostion:

![equation](https://latex.codecogs.com/gif.latex?%28%5Clnot%20p%20%5Clor%20q%29%20%5Cland%20%28p%20%5Coplus%20r%29%20%5Cleftrightarrow%20%28p%20%5Clor%20q%20%5Clor%20r%29)

The proposition can be input and the truth table will be generated:

```
Equation: (!p|q) & (p^r) == (p | q | r)

P       Q       R
false   false   false   => true
false   false   true    => true
false   true    false   => false
false   true    true    => true
true    false   false   => false
true    false   true    => false
true    true    false   => true
true    true    true    => false
```

## Authors
- **Alexandre Lavoie** - [Concordia University](http://www.concordia.ca/)

## License
This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details.
