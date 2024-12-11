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
        int ans = -1;
        //Check if Input is null or empty.
        if (num == null || num.isEmpty()) {
            return ans;
        }
        //find the index 'b', which separates the number and the base
        int bIndex = num.indexOf("b");
        if (bIndex == -1 || bIndex == 0 || bIndex == num.length() - 1) {
            return ans;
        }
        //Split the string into the numPart, and the base part
        String numPart = num.substring(0, bIndex);
        String basePart = num.substring(bIndex + 1);

        int base;
        try {
            //Parse the base
            base = Integer.parseInt(basePart, 16);
        } catch (NumberFormatException e) {
            return ans;
        }
        //Validate the base is within the range [2,16]
        if (base < 2 || base > 16) {
            return ans;
        }
        //Check that all characters in the number part are valid for the base
        for (char c : numPart.toCharArray()) {
            if (Character.digit(c, base) == -1) {
                return ans;
            }
        }
        try {
            //Convert the number part to a decimal integer using the base
            ans = Integer.parseInt(numPart, base);
        } catch (NumberFormatException e) {
            return ans;
        }
        return ans;
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
            return false;
        }
        //Find the index 'b', which separates the number and the base
        int bIndex = a.indexOf("b");
        if (bIndex == -1 || bIndex == 0 || bIndex == a.length() - 1) {
            return false;
        }
        //Split the sting Into the number part and the base part.
        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        int base;
        try {
            //Parse the base
            base = Integer.parseInt(basePart);
        } catch (NumberFormatException e) {
            return false; //Invalid base format
        }
        //validate the base is within the range [2,16]
        if (base < 2 || base > 16) {
            return false;
        }
        //Check that all characters in the numberPart are valid for the base.
        for (char c : numberPart.toCharArray()) {
            if (Character.digit(c, base) == -1) {
                return false;
            }
        }
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
            return ans;
        }
        //Convert the number to a string in the given base
        String numPart = Integer.toString(num, base).toUpperCase();
        //Construct the final string in the format <numPart>b<base>
        ans = numPart + "b" + Integer.toString(base, 16).toUpperCase();

        return ans; //Return to final formatted string
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
        //Check if one of the strings is null
        if (n1 == null || n2 == null || !isNumber(n1) || !isNumber(n2)) {
            ans = false;
        } else {
            int decimal1 = number2Int(n1);
            int decimal2 = number2Int(n2);
            ans = (decimal1 == decimal2);
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
        //If the array is null or empty, return -1
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int maxValue = number2Int(arr[0]);
        if (maxValue == -1) {
            return -1;//If the first element is invalid, return -1
        }
        //Iterate through the rest of the array to find the index of the maxValue
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null) {
                int currentValue = number2Int(arr[i]);
                if (currentValue != -1 && currentValue > maxValue) {
                    maxValue = currentValue;
                    ans = i; //Update the index if a higher valid value is found
                }
            }
        }
        return ans; //return the index of the maxValue found
    }
}

