# Ex1 - Number Base Converter and Calculator

My name is Shira Feld, and I am a first-year computer science student. This is my first GitHub project, which deals with solving Exercise 1 in the "Introduction to Computer Science" course at Ariel University.

This project was created to convert numbers between different bases and perform basic calculations (addition and multiplication) on them. The program is written in Java and allows converting numbers between binary to hexadecimal bases and performing operations on them.

## Main Features

- Convert numbers between different bases (binary, octal, decimal, hexadecimal).
- Perform arithmetic operations (addition and multiplication) on numbers in different bases.
- Display results in the desired base, supporting bases from 2 to 16.
- Support for custom number formats, such as "1011b2" for binary or "123bA" for hexadecimal.

## Key Functions

1. **Base Conversion**: Converts numbers between different bases (2 to 16) and displays results in the desired base.
2. **Error Checking**: The program checks for invalid input and displays appropriate error messages.
3. **Max Value Calculation**: Given two numbers, the program calculates their sum and product, and finds the maximum value among them.

## How to Use

1. **Input Format**:
   - Enter a number in the format `<number><b><base>`, e.g., `1011b2` (binary) or `123bA` (hexadecimal).
   - Type "quit" to exit the program.

2. **Sample Interaction**:
   - Enter number #1: `1011b2`
   - Enter number #2: `1001b2`
   - Enter output base: `10`
   - The program will calculate the sum and product and display them in the requested base.

3. **Valid Bases**:
   - Bases between 2 and 16 are supported.
   - The program supports hexadecimal characters (A-G) for bases above 10.
