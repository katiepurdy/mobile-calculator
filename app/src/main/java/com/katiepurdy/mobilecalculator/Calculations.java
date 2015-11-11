package com.katiepurdy.mobilecalculator;

/**
 * The Calculations class contains methods for providing simple calculator functionality
 * Author: Katie Purdy
 * Date: October 2nd, 2014
 */
public class Calculations {

    /**
     * Method that adds two numbers together, as a String
     *
     * @param firstString The first number to add, as a String
     * @param secondString The second number to add, as a String
     * @return The sum of the two numbers, as a String
     */
    public static String add(String firstString, String secondString) {
        double firstNum = Double.valueOf(firstString);
        double secondNum = Double.valueOf(secondString);
        String result = String.valueOf(firstNum + secondNum);
        if (containsDecimal(result)) {
            return result;
        } else {
            // Safely cast to int
            return doubleToInt(result);
        }
    }

    /**
     * Method that multiplies two numbers together, as a String
     *
     * @param firstString The first number to subtract, as a String
     * @param secondString The second number to subtract, as a String
     * @return The difference between the first number and the second number, as a String
     */
    public static String subtract(String firstString, String secondString) {
        double firstNum = Double.valueOf(firstString);
        double secondNum = Double.valueOf(secondString);
        String result = String.valueOf(firstNum - secondNum);
        if (containsDecimal(result)) {
            return result;
        } else {
            // Safely cast to int
            return doubleToInt(result);
        }
    }

    /**
     * Method that multiplies two numbers together, as a String
     *
     * @param firstString The first number to multiply, as a String
     * @param secondString The second number to multiply, as a String
     * @return The resulting of multiplying the first number by the second number, as a String
     */
    public static String multiply(String firstString, String secondString) {
        double firstNum = Double.valueOf(firstString);
        double secondNum = Double.valueOf(secondString);
        String result =  String.valueOf(firstNum * secondNum);
        if (containsDecimal(result)) {
            return result;
        } else {
            // Safely cast to int
            return doubleToInt(result);
        }
    }

    /**
     * Method that divides two numbers as Strings
     *
     * @param firstString The first operand
     * @param secondString The second operand
     * @return The resulting quotient of a and b or NaN if dividing by zero
     */
    public static String divide(String firstString, String secondString) {
        double firstNum = Double.valueOf(firstString);
        double secondNum = Double.valueOf(secondString);
        String result;
        // Check for division by zero
        if (secondNum == 0) {
            return "NaN";
        } else {
            result = String.valueOf(firstNum / secondNum);
            if (containsDecimal(result)) {
                return result;
            } else {
                // Safely cast to int
                return doubleToInt(result);
            }
        }
    }

    /**
     * Method that multiplies the number inside of string input by -1 to reverse its sign
     *
     * @param inputString The number to reverse the sign of, as a String
     * @return The String result of reversing the sign of the inputString
     */
    public static String reverseSign(String inputString) {
        double number = Double.valueOf(inputString);
        String result;
        number *= -1;
        result =  String.valueOf(number);
        if (containsDecimal(result)) {
            return result;
        } else {
            // Safely cast to int
            return doubleToInt(result);
        }
    }

    /**
     * Method that appends a decimal to a String of numbers
     *
     * @param inputString The string of number(s) to append the decimal to
     * @return The inputString with a decimal appended
     */
    public static String appendDecimal (String inputString) {
        return inputString + ".";
    }

    /**
     * Method that chooses which calculation to execute based on the last operator
     *
     * @param lastOperator The last operator key pressed
     * @param firstString The first operand
     * @param secondString The second operand
     * @return The result of the calculation
     */
    public static String calculate(char lastOperator, String firstString, String secondString) {
        String result = secondString;
        switch (lastOperator) {
            case ' ':
                result = secondString;
                break;
            case '+':
                result = add(firstString, secondString);
                break;
            case '-':
                result = subtract(firstString, secondString);
                break;
            case 'x':
                result = multiply(firstString, secondString);
                break;
            case '/':
                result = divide(firstString, secondString);
                break;
            default:
                result = secondString;
                break;
        }
        return result;
    }

    /**
     * Method that checks if the number passed in as a String contains a decimal
     *
     * @param inputString The number to check, as a String
     * @return The result of the boolean comparison
     */
    public static boolean containsDecimal(String inputString) {
        double inputNum = Double.valueOf(inputString);
        if ((inputNum != 0) && (inputNum /((int) inputNum) != 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that converts a double as a String to an int as a String
     *
     * @param inputString The number as a String to be converted
     * @return The result of typecast
     */
    public static String doubleToInt(String inputString) {
        return String.valueOf((int) Double.parseDouble(inputString));
    }
}
