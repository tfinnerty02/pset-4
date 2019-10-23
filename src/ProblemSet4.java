/*
 * Copyright (c) 2019. UCVTS and its affiliated.
 */

/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.*;

public class ProblemSet4 {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        // comment out or uncomment as needed

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

        in .close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
        int lowerBound;
        int upperBound;
        int sum = 0;

        System.out.print("\nLower bound: ");
        lowerBound = in .nextInt();
        System.out.print("Upper bound: ");
        upperBound = in .nextInt();

        while (lowerBound > upperBound) {
            System.out.print("Lower bound: ");
            lowerBound = in .nextInt();
            System.out.print("Upper bound: ");
            upperBound = in .nextInt();
        }

        for (int i = lowerBound; i <= upperBound; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        String sumAsString = String.format("%,d", sum);

        System.out.println("\n" + sumAsString + ".");
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
        int integer;
        String separatedDigits = "";
        String digit = "";
        System.out.print("\nPositive integer: ");
        integer = in .nextInt();

        while (integer <= 0) {
            System.out.print("Positive integer: ");
            integer = in .nextInt();
        }

        String intAsString = String.format("%d", integer);

        for (int i = intAsString.length(); i >= 0; i--) {
            if (i > 0 && i != 1) {
                digit = intAsString.substring(i - 1, i);
                separatedDigits = separatedDigits + digit + ", ";
            } else if (i == 0) {
                digit = intAsString.substring(i, i + 1);
                separatedDigits = separatedDigits + digit + ".";
            }
        }

        System.out.println("\n" + separatedDigits);

    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
        int integer;
        int intDigit;
        int sum = 0;
        System.out.print("\nPositive integer: ");
        integer = in .nextInt();

        while (integer <= 0) {
            System.out.print("Positive integer: ");
            integer = in .nextInt();
        }

        String intAsString = String.format("%d", integer);
        char[] digitsArray = intAsString.toCharArray();

        for (int i = 0; i < intAsString.length(); i++) {
            if (digitsArray[i] % 2 == 1) {
                intDigit = Character.getNumericValue(digitsArray[i]);
                sum += intDigit;
            }
        }
        System.out.println("\n" + sum + ".\n");
    }


    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
        ArrayList < Integer > arrayOfIntegers = new ArrayList < Integer > ();
        int numberEntered;
        int i = 0;
        int sum = 0;
        arrayOfIntegers.add(0);
        while (arrayOfIntegers.get(i) >= 0) {
            System.out.print("Non-negative integer: ");
            numberEntered = in .nextInt();
            arrayOfIntegers.add(numberEntered);
            i++;
        }

        for (int j = 0; j < arrayOfIntegers.size() - 1; j++) {
            sum += arrayOfIntegers.get(j);
        }
        int arraySize = arrayOfIntegers.size() - 2;
        double average = (double) sum / (double) arraySize;
        System.out.printf("\n%,.2f\n", average);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
        int numberTested;
        boolean prime = true;
        System.out.print("\nNon-negative integer: ");
        numberTested = in .nextInt();

        while (numberTested <= 0) {
            System.out.print("Non-negative integer: ");
            numberTested = in .nextInt();
        }

        for (int i = 2; i <= numberTested / 2; i++) {
            if (numberTested % i == 0) {
                prime = false;
            }
        }
        if (prime) {
            System.out.println("\nPrime.");
        } else {
            System.out.println("\nNot prime.");
        }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
        int fibonacciN;
        System.out.print("\nPositive integer: ");
        fibonacciN = in .nextInt();

        while (fibonacciN <= 0 || fibonacciN > 92) {
            System.out.print("Positive integer: ");
            fibonacciN = in .nextInt();
        }

        long base1 = 0;
        long base2 = 1;
        long fibonacci = 0;

        for (int i = 2; i <= fibonacciN; i++) {
            fibonacci = base1 + base2;
            base1 = base2;
            base2 = fibonacci;
        }
        System.out.println("\n" + base2 + ".");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
        System.out.print("\nPositive integer: ");
        int testValue = in .nextInt();

        while (testValue <= 0) {
            System.out.print("Positive integer: ");
            testValue = in .nextInt();
        }

        System.out.print("\n");

        for (int i = 1; i <= testValue / 2; i++) {
            if (testValue % i == 0) {
                if (i > testValue / i) {
                    System.out.print(".\n\n");
                    return;
                } else {
                    if (i == 1) {
                        System.out.print(i + ", " + (testValue / i));
                    } else {
                        if (i != (testValue / i)) {
                            System.out.print(", " + i + ", " + (testValue / i));
                        } else {
                            System.out.print(", " + i + ".\n\n");
                            return;
                        }
                    }
                }
            }
        }
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
        System.out.print("Height: ");
        int height = in .nextInt();

        while (height < 1 || height > 24) {
            System.out.print("Height: ");
            height = in .nextInt();
        }

        System.out.print("\n");

        String output = "";
        int x = height;
        String y = " ";
        String z = "#";

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x - (i + 1); j++) {
                output = output + y;
            }
            for (int k = 0; k < i + 2; k++) {
                output = output + z;
            }
            output = output + '\n';
        }
        System.out.print(output);

    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
        System.out.print("\nHeight: ");
        int height = in .nextInt();

        while (height < 1 || height > 24) {
            System.out.print("Height: ");
            height = in .nextInt();
        }

        System.out.print("\n");

        String output = "";
        int x = height;
        String y = " ";
        String z = "#";

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - (i + 1); j++) {
                output += y;
            }
            for (int j = 0; j <= i + 1; j++) {
                output += z;
            }
            output += y;
            output += y;
            for (int j = 0; j <= i + 1; j++) {
                output += z;
            }
            output += "\n";
        }

        System.out.print(output);
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() { in .nextLine();
        System.out.print("\nNumber: ");
        String number = in .nextLine();
        int sumEveryOtherDigit = 0;
        int digitToMultiply;
        int finalSum = 0;

        for (int i = number.length() - 2; i >= 0; i -= 2) {
            digitToMultiply = Character.getNumericValue(number.charAt(i));
            sumEveryOtherDigit = digitToMultiply * 2;
            if (sumEveryOtherDigit >= 10) {
                finalSum += (int)((sumEveryOtherDigit / Math.pow(10, 0)) % 10) + (int)((sumEveryOtherDigit / Math.pow(10, 1)) % 10);
            } else {
                finalSum += sumEveryOtherDigit;
            }
        }

        for (int i = number.length() - 1; i >= 0; i -= 2) {
            digitToMultiply = Character.getNumericValue(number.charAt(i));
            finalSum += digitToMultiply;
        }

        String stringEveryOtherDigit = Integer.toString(finalSum);
        if (stringEveryOtherDigit.charAt(stringEveryOtherDigit.length() - 1) == '0') {
            if (number.charAt(0) == '3' && (number.charAt(1) == '4' || number.charAt(1) == '7')) {
                System.out.println("\nAmex.\n");
            } else if (number.charAt(0) == '5' && (number.charAt(1) == '1' || number.charAt(1) == '2' || number.charAt(3) == '3' || number.charAt(4) == '4' || number.charAt(5) == '5')) {
                System.out.println("\nMastercard.\n");
            } else if (number.charAt(0) == '4') {
                System.out.println("\nVisa.\n");
            }
        } else {
            System.out.println("\nInvalid.\n");
        }
    }
}
