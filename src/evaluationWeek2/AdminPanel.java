package evaluationWeek2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book{
    String id;
    String name;
    int quantity;
    double price;

    public Book(String id, String name, String quantity, String price) {
        this.id = id;
        this.name = name;
        this.quantity =Integer.valueOf(quantity);
        this.price = Double.valueOf(price);
    }

}

public class AdminPanel {
    static void viewBooks(File bookfile, int sortOrder){
        try {

            Scanner Reader = new Scanner(bookfile);
            ArrayList<Book> datalist = new ArrayList<>();

            // Traversing File Data
            while (Reader.hasNextLine()) {
                String [] book = Reader.next().split(" ");
                datalist.add(new Book(book[0],book[1], book[2],book[3]));
                Collections.sort(datalist, Comparator.comparTo(Book o1,Book o2)->o1-o2);
            }
            Reader.close();
        } catch (RuntimeException | FileNotFoundException e) {
            System.out.println("roor");
        }
    }

    public static int adminPanel() {
        Scanner sc = new Scanner(System.in);

        File bookfile = BookData.bookmethod(); // to get the file data

        System.out.println("admin login success \n\n\n");
        System.out.println("please select your method of operation : \n");
        int entry =1;
        while (entry != 0) {

            System.out.println("\n\n1.Add Books  2.Remove Books  3.View Books  4.Find Book  ToExit:0 ");
            entry = sc.nextInt();
                if(entry==0) break;
            switch (entry) {
                case 1: {
                    System.out.println("please enter the the data you want to add in the following format");
                    System.out.println("bookId,bookName,bookQuantity,bookPrice");
                    //TODO: here to call a method that check if the total quantity does not exit 200.
                    try {
                        FileWriter writer = new FileWriter(bookfile);
//                        String new
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2: {
                    System.out.println("please enter ID of the book you want to remove ");


                    //TODO: here we have to call a method that check the avalabity and remove the book
                break;
                }
                case 3: {
                    System.out.println("Please select how ou want to see the order: ");
                    System.out.println("1.id wise  2.Name wise 3.Price wise");
                    int sortOrder = sc.nextInt();
                    if(sortOrder>3 || sortOrder<1) break;
                    System.out.println("Here are the list of all book:");

                    viewBooks(bookfile,sortOrder);
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


