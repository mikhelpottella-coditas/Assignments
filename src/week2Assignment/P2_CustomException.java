package week2Assignment;

import java.util.Scanner;

/*
* Create a custom runtime exception called InvalidAgeException.
• Throw this exception if age is less than 18 while creating a User object.
• Catch the exception and print a meaningful error message.
• Demonstrate why this exception is treated as a runtime exception.
* */

class InvalidAgeException extends RuntimeException{ // creating own exception to validate Age.
    public InvalidAgeException(String message){
        super(message); // forwarding the message to the parent class (RuntimeException) to handle the message.
    }
}
public class P2_CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();

//        try{ // checking if the age is valid
            if(age<18 || age>150) throw new InvalidAgeException("the age you enterd is "+age+". and it is not valid if it is less than 18 or greater than 150." );
            else System.out.println("you are aligible");
//        } catch (InvalidAgeException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
            System.out.println("the code execution id complete ");
//        }

    }
}


// why we treated as the run time exception:
/*
*   so basically according to the compiler the code is right.
*   but we created our own exception to check if the age is
*   greater than 18 or not. so this kind of logical errors can
*   consider as the run time exception because the compiler
*   does not bother about it and code compiles successfully but
*   the JVM throws the error and send the Stack Trace to the console.
*
*   hence, when ever it comes to runtime exception we have to be more careful and handle it properly:).
*
* */