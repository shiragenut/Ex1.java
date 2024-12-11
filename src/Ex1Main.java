import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialized scanner for input
        String num1 = "", num2 = "", quit = "quit";
        //Loop continues until one of the numbers is "quit"
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next(); //Read input for num1
            //Check if the user wants to quit
            if (!num1.equals("quit")) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next(); //Read  input for num2
                //Check if the user wants to quit
                if (!num2.equals("quit")) {
                    System.out.println();
                    //Check if numbers are valid
                    boolean isValidNum1 = Ex1.isNumber(num1);
                    boolean isValidNum2 = Ex1.isNumber(num2);
                    //Print validity messages
                    if (!isValidNum1) {
                        System.out.println("Number#1 (" + num1 + ") is NOT valid. The base should be in the range [2,16]");
                    } else {
                        System.out.println("Number#1 (" + num1 + ") is valid.");
                    }
                    if (!isValidNum2) {
                        System.out.println("Number#2 (" + num2 + ") is NOT valid.The base should be in the range [2,16]");
                    } else {
                        System.out.println("Number#2 (" + num2 + ") is valid.");
                    }
                    //If both numbers are valid, process them
                    if (isValidNum1 && isValidNum2) {
                        int decimalNum1 = Ex1.number2Int(num1); //Convert num1 to decimal
                        int decimalNum2 = Ex1.number2Int(num2); //Convert num2 to decimal
                        System.out.println("decimal value of Number#1: " + decimalNum1);
                        System.out.println("decimal value of Number#2: " + decimalNum2);
                        //Check if the two numbers are equal
                        boolean areEqual = Ex1.equals(num1, num2);
                        System.out.println("Are the two numbers equal?: " + areEqual);
                        //Display the numbers in their original base
                        System.out.println("Number#1 in its original base:"+num1);
                        System.out.println("Number#2 in its original base:"+num2);
                    }
                }
            }
        }
        System.out.println("quiting now...");
        sc.close();
    }
}

