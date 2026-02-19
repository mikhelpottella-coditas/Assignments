package week2Assignment;

/*
 *  Write a Java program that:-
 * • Takes two integers from the user.
 * • Performs division of the first number by the second.
 * • Handles the following exceptions: -
 * o ArithmeticException (division by zero)
 * o InputMismatchException (non-integer input) -
 * o Uses multiple catch blocks and a finally block to print: “Program execution
 * completed”.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class P1_ZeroProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // object of the scanner to take the input from the keyBoard.

        try {
            int divident = sc.nextInt();
            int divaisor = sc.nextInt();

            int answer = divident/divaisor;

            System.out.println(answer);

        } catch (ArithmeticException e) { // this is to catch if the division is not possible.
            System.out.println("you entered '0'.To do division which is not possible");
            throw new ArithmeticException();
        } catch (InputMismatchException e){ // this to catch is the input is not valid
            System.out.println("invalid input. please enter only numbers");
            throw new InputMismatchException();
        }
        finally {
            System.out.println("Program execution completed");
        }
    }
}
