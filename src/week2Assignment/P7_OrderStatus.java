package week2Assignment;

import java.util.Locale;
import java.util.Scanner;

/*
* 7.Create an enum OrderStatus with values: -
• PLACED - SHIPPED - DELIVERED - CANCELLED
• Each enum constant should have a message (example: “Order has been
placed”).
• Add a method inside the enum to return the message.
• Use the enum in a class and print order status details.*/

enum Status { // creating Enums and the function to show the status
    PLACED,
    SHIPPED,
    DELIVERED,
    CANCELLED;


    public String message() {
        return "Order has been " + name(); // return with the name of the caller
    }
}

public class P7_OrderStatus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the status from the following: ");
        System.out.println("PLACED, SHIPPED, DELIVERED, CANCELLED");
        String request = scanner.next().toUpperCase(Locale.ROOT);
//        for (Status status : Status.values()) {// it to get all the enum constants
//            if (status.name().equals(request))System.out.println(status.message()); // to print the status based on the request
//            // is the request doesn't match this case run.
//        }
           try{
               System.out.println(Status.valueOf(request.toUpperCase()).message()); // to check the request exists
           }catch (IllegalArgumentException e){
               System.out.println("it is not a valid request : "+ e.toString()); // to catch if the request not exist
           }
    }


    /*
    * output:
    * case 1:  input
               it is not a valid request : java.lang.IllegalArgumentException: No enum constant week2Assignment.Status.INPUT

    * case 2:  placed
    *           Order has been PLACED
    *
    * case 3:  PLACED, SHIPPED, DELIVERED, CANCELLED
                delivered
                Order has been DELIVERED
    * */
}
