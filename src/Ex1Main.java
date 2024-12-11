import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialized scanner for input
        sc.useDelimiter("\\n");
        String num1 = "", num2 = "", quit = "quit";
        //Loop continues until one of the numbers is "quit"
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            //Getting input for num1
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next(); //Read input for num1
            //Check if the user wants to quit
            if (!num1.equals("quit")) {
                //Check if num1 is valid
                int value1 = Ex1.number2Int(num1);
                if (value1 != -1) {
                    System.out.println("num1=" + num1 + "is number:true, value):" + value1);
                } else {
                    System.out.println("num1=" + num1 + "is number:false, value=-1");
                }
                //Getting input for num2
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next(); //Read  input for num2
                //Check if the user wants to quit
                if (!num2.equals("quit")) {
                    //Check if num1 is valid
                    int value2 = Ex1.number2Int(num2);
                    if (value2 != -1) {
                        System.out.println("num2=" + num2 + "is number:true, value):" + value2);
                    }else{
                        System.out.println("num2=" + num2 + "is number:false, value=-1");
                    }
                    //Ask for output base
                    System.out.println("Enter a base for output: (a number [2,16]");
                    int outPutBase = sc.nextInt();
                    // Calculate sum and product
                    String sum = Ex1.int2Number(value1 + value2, outPutBase);
                    String product = Ex1.int2Number(value1 * value2, outPutBase);
                    //Print the result
                    System.out.println(num1 + "+" + num2 + "=" + sum);
                    System.out.println(num1 + "*" + num2 + "=" + product);
                    //Find and print the maximum number
                    //Find the max value
                    int maxIndex = Ex1.maxIndex(new String[]{num1, num2, sum, product});
                    String maxNum = new String[]{num1, num2, sum, product}[maxIndex];
                    System.out.println("max number over[" + num1 + " " + num2 + " " + sum + " " + product + "]is:" + maxNum);
                }
            }
        }
        System.out.println("quiting now...");
        sc.close();
    }
}

