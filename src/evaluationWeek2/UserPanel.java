package evaluationWeek2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 *   this class is to create a console based interface fo the User.
 *
 * */

public class UserPanel {
    static void userPanel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("user login success\n\n\n");

        while (true) {
            System.out.println("please select your operation from the following : ");
            System.out.println("1.view Books  2.Add Books 3.remove Book 4.Cart  5.Find  Exit:0  ");
            int entry = sc.nextInt();
            sc.nextLine();
            if (entry == 0) break;
            switch (entry) {
                case 1: {
                    System.out.println("Please select how ou want to see the order: ");
                    System.out.println("1.id wise  2.Name wise 3.quantity wise  4.Price wise ");
                    int sortOrder = sc.nextInt();
                    if (sortOrder > 4 || sortOrder < 1) break;
                    System.out.println("Here are the list of all book:");

                    AdminFunctions.viewBooks(sortOrder);
                    break;
                }
                case 2: {
                    System.out.println("please enter one ID of the book at a time.");
                    String idString = sc.nextLine();
                    boolean status = UserFunctions.addBooktoCart(idString);
                    if(status) System.out.println("item added successfully");
                    else System.out.println("that item is not avalable");
                    break;
                }
                case 3: {
                    System.out.println("please enter one ID of the book at a time.");
                    String idString = sc.nextLine();
                   boolean status =  UserFunctions.removeBookFromCart(idString);
                   if(status) System.out.println("item removed from the cart ");
                   else System.out.println("that item is not available in the cart to remove ");
                    break;
                }
                case 4: {
                    UserFunctions.viewCart();
                }
                case 5:{
                    System.out.println("tell me by which you want to search the book: ");
                    System.out.println("1.ByID 2.ByName");
                    int findBy = sc.nextInt();
                    sc.nextLine();
                    System.out.println("please enter it");
                    String clue = sc.nextLine();
                    AdminFunctions.findBook(clue, findBy);
                    break;
                }
                case 6:{
                    boolean status = UserFunctions.checkout();
                    if (status) System.out.println("your books are successfully checked out");
                    else System.out.println("your cart is empty. please shop before checkout");
                }

            }
        }
    }
}

