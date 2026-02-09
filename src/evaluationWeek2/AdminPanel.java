package evaluationWeek2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

/*
*   this class is to create a console based interface fo the Admin.
*
* */


public class AdminPanel {

    public static int adminPanel() {
        Scanner sc = new Scanner(System.in);

        File bookfile = BookData.getBookmethod(); // to get the file data

        System.out.println("admin login success \n");
        System.out.println("please select your method of operation : \n");
        int entry = 1;
        while (true) {

            System.out.println("1.Add Books  2.Remove Books  3.View Books  4.Find Book  ToExit:0 ");
            entry = sc.nextInt();
            sc.nextLine();
            if (entry == 0) break;
            switch (entry) {
                case 1: {
                    System.out.println("please enter the the data you want to add in the following format");
                    System.out.println("Note: only one book at a time!!!\n");
                    System.out.println("bookId,bookName,bookQuantity,bookPrice");
                    String oneBook = sc.nextLine();
                    //TODO: here to call a method that check if the total quantity does not exit 200.
                    boolean isDataStored = AdminFunctions.addBook(oneBook);
                    System.out.println(isDataStored + " hello from case 1");

                    break;

                }
                case 2: {
                    System.out.println("please enter ID of the book you want to remove ");
                    String removeId = sc.next();
                    sc.nextLine();

                    boolean isRemoved = AdminFunctions.removeBook(removeId);
                    if (isRemoved) System.out.println("the item removed successfully");
                    else System.out.println("invalid id");

                    //TODO: here we have to call a method that check the avalabity and remove the book
                    break;
                }
                case 3: {
                    System.out.println("Please select how you want to see the order: ");
                    System.out.println("1.id wise  2.Name wise 3.quantity wise  4.Price wise");
                    int sortOrder = sc.nextInt();
                    if (sortOrder > 4 || sortOrder < 1) break;
                    System.out.println("Here are the list of all book:");

                    AdminFunctions.viewBooks(sortOrder);
                    break;
                }
                case 4: {
                    System.out.println("tell me by which you want to search the book: ");
                    System.out.println("1.ByID 2.ByName");
                    int findBy = sc.nextInt();
                    sc.nextLine();
                    System.out.println("please enter it");
                    String clue = sc.nextLine();
                    AdminFunctions.findBook(clue, findBy);
                    break;
                }
                default: {
                    System.out.println("Invalid Entry");
                    System.out.println("please select only in the above option");
                }
            }
        }
        return 0;
    }
}


