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
        //Check if Input is null or empty.
        if (num == null || num.isEmpty()) {
            return ans; //If input is null or empty, return -1
        }
        //find the index 'b', which separates the number from the base
        int bIndex = num.indexOf("b");
        if (bIndex == -1) {
            return ans; //If 'b' is not found, return -1.
        }
        //Split the string into the numPart, and the base part
        String numPart = num.substring(0, bIndex);
        String basePart = num.substring(bIndex + 1);
        //Parse the base as an integer, base should be in range [2,16]
        int base;
        try {
            base = Integer.parseInt(basePart, 16);//Try to parse the base as a hexadecimal base
        } catch (NumberFormatException e) {
            return ans; //If parsing the base fails, return -1
        }
        //Validate the base is within the range [2,16]
        if (base < 2 || base > 16) {
            return ans;//If the base outside the runge, return -1
        }
        try { //Try to parse the numPart in the given base
            ans = Integer.parseInt(numPart, base);
        } catch (NumberFormatException e) {
            return ans; //If parsing the number fails, return -1
        }
        //return the final result (the number in decimal)
        return ans; //If everything is valid, return the converted number
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        //Check if input is null or empty
        if (a == null || a.isEmpty()) {
            return false; //If the input is null or empty, it's not a valid number
        }
        //Find the index 'b', which separates the number from the base
        int bIndex = a.indexOf("b");
        if (bIndex == -1 || a.indexOf('b', bIndex +1) !=- 1) {
            return false;
        }
        //Split the sting Into the number part (before 'b') and the base part (after 'b').
        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);
        //Check if the base part is a valid integer and within the valid range
        int base;
        try {
            //Parse the base
            base = Integer.parseInt(basePart, 16); //Try to parse the base as a hexadecimal base
        } catch (NumberFormatException e) {
            return false; //If the base can't be parsed, it's not a valid base
        }
        //validate the base is within the range [2,16]
        if (base < 2 || base > 16) {
            return false; //If the base is outside the range,return false
        }
        //Check if the numPart is valid in the specified base
        try {
            Integer.parseInt(numberPart, base); //Try to parse the number in the given base
            } catch (NumberFormatException e) {
            return false; //If the number can't be pars, return false
        }
        //If all checks pass, return true
         return ans; //The input is valid "number" format
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
        String ans = ""; //Initialize the answer variable as an empty string
        //Check if the input is invalid: num must be non-negative,base within the range [2,16]
        if (num < 0 || base < 2 || base > 16) {
            return ans; //If invalid input, return an empty string
        }
        //Edge case - if num=0, return "0" as a result
       if (num==0){
           return "0b"+base;
       }
       //use the stringBuilder to build the number in the specified base
       StringBuilder result;
        result = new StringBuilder();
        //convert the number to the specified base
        while (num > 0) {
            int reminder = num % base; //Get the reminder when divided by the base
            if (reminder < 10){
                result.insert(0,(char) ('0'+reminder)); //For reminders 0-9, add the digit as a character
            } else {
                result.insert(0,(char) ('A'+reminder-10)); //For reminders 10-16, use the letters A-G
            }
            num = num/base; //Reduce the number by dividing it by the base
        }
        //Add the base information to the result string
        ans = result.toString() +'b'+ base; // Append 'b' and the base to the number representation
        // Return the final result
        return ans; //Return the number in the specified base, including the base information
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
            //If either of the numbers is invalid, they are not equal
            if (num1 == -1 || num2 == -1) {
                ans = false;
            } else {
                //compare the two numbers
                if (num1 != num2) {
                    ans = false; //If the numbers are not equal, set 'ans' to false
                }
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
        int ans = 0;
        //Check if the array is valid and non-empty
        if (arr == null || arr.length == 0) {
            return -1; //If the array is null or empty, return -1
        }
        //Check if the first element is a valid number
        int maxValue = number2Int(arr[0]);
        if (maxValue == -1) {
            return -1; //Return -1 if the first number is invalid
        }
        //Iterate through the rest of the array to find the largest value
        for (int i = 1; i < arr.length; i++) {
            int currentNum = number2Int(arr[i]);
            //If the current number is valid and larger than the previous one
                if (currentNum != -1 && currentNum > maxValue) {
                    ans = i; //Update 'ans' to a new index with the larger number
                    maxValue = currentNum;
                }
            }
        return ans; //return the index with the largest value
    }
}

