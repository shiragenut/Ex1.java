import java.util.Locale;

/**
 * This class represents a simple solution for Ex1.
 * As defined here:
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,- G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     **/
    public static int number2Int(String num) {
        int ans = -1; //Initialize the answer to -1, representing an invalid number.
        //Check if input is null or empty
        if (num == null || num.isEmpty()) {
            return ans; //If input is null\empty, return -1
        }
        try {
            String regex = "b"; //Define the 'b' character to split the string into two parts
            String[] myArray = num.split(regex); //Split the string into two parts - before the 'b' and after the 'b'
            String baseString; //Variable to hold the second part of the string (basePart)
            int basePart; //Variable to hold the base value
            // If the array resulting from the split contains only one element,it means that no 'b' was found
            if (myArray.length < 2) {
                basePart = 10; // If no 'b' was found, the default base is 10.
            } else {
                baseString = myArray[1]; //If 'b' was found, the second part after 'b' is the baseString
                basePart = Integer.parseInt(baseString, 17); //Convert the basePart to an integer using base 17
            }
            //Check if the base is outside the valid range [2,16]
            if (basePart < 2 || basePart > 16) {
                return ans; //If the base is invalid, return -1
            }
            String numPart = myArray[0]; // The first part (before the 'b') is the numPart
            if (numPart.matches(".*[a-z].*")){
                throw new NumberFormatException(); //Throw exceptions for invalid characters
            }
            ans = Integer.parseInt(numPart, basePart);//Convert the number part of the integer to the given base
            if (ans < 0){
                throw new NumberFormatException(); //Negative numbers are invalid
            }
        }catch (NumberFormatException e) {
            return ans; //Return -1 if parsing fails
        }
        return ans; //Return the converted number
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        //Call number2Int to check if the string can be converted to a valid number
        int i = number2Int(a);
        //If number2Int returns -1, the string is not valid number format
        if (i == -1) {
            ans = false; //If the input isn't a valid number, return false
        }
        return ans; //Otherwise, the input is a valid number, return true
    }



    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = ""; //Initialize the result variable as an empty string
        //Check if the input is invalid: num must be non-negative,and base within the range [2,16]
        if (num < 0 || base < 2 || base > 16) {
            return ans; //If invalid input, return an empty string
        }
        //Convert the number to the specified base and format it
        ans = Integer.toString(num, base).toUpperCase();
        if (base < 10) {
            return ans + "b" + base;
        } else {
            //Map base values 10-16 to custom suffixes 'A'-'G'
            switch (base){
                case 10: return ans + "b" + "A";
                case 11: return ans + "b" + "B";
                case 12: return ans + "b" + "C";
                case 13: return ans + "b" + "D";
                case 14: return ans + "b" + "E";
                case 15: return ans + "b" + "F";
                case 16: return ans + "b" + "G";
            }
        }
        return ans; //Return the final result
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        //Check if one of the input numbers is null or empty
        if (n1 == null || n2 == null || n1.isEmpty() || n2.isEmpty()) {
            ans = false; // If one of them null or empty, they are not equal
        } else {
            int num1 = number2Int(n1); //Convert n1 to int
            int num2 = number2Int(n2); //Convert n2 to int
            //Check for invalid or not-equal numbers
            if (num1 == -1 || num2 == -1 || num1 != num2) {
                ans = false; //If the numbers are not equal or not invalid, set 'ans' to false
                }
            }
        return ans; //If the two numbers have the same value
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0; //Initialize the answer to the first index
        int tempMax = 0;
        //Iterate through the rest of the array to find the largest value
        for (int i = 0; i < arr.length; i++) {
            int currentNum = number2Int(arr[i]); //Convert each element to an integer
            if (currentNum > tempMax) {
                ans = i; //Update the index of the maximum value
                tempMax = currentNum; //Update the maximum value
            }
        }
        return ans; //return the index with the largest value
    }
}

