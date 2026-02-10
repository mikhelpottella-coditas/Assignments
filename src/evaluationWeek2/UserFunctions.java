package evaluationWeek2;

/*
 *  this class is to implement methods and functionalities that are required for the user
 * */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserFunctions {
    static File bookfile = BookData.getBookmethod(); // this hold the meta Data of the data file
    static ArrayList<Book> cart = new ArrayList<>(); // this store the Book objects

    // this method is to add the books to the cart
    static boolean addBooktoCart(String id) {


        try {
            Scanner Reader = new Scanner(bookfile);
            ArrayList<Book> datalist = new ArrayList<>();

            // Traversing File Data
            while (Reader.hasNextLine()) {
                String[] book = Reader.nextLine().split(",");
                int quantity = Integer.parseInt(book[2]);
                double price = Double.parseDouble(book[3]);
                datalist.add(new Book(book[0], book[1], quantity, price));
            }


            // from here we are going to check the entered id exists or not if yes
            // then we have to add them to the cart
            for (Book book : datalist) {
                if (book.id.equalsIgnoreCase(id)) {
                    cart.add(book);
                    return true;
                }
            }


        } catch (NumberFormatException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    // this method is to remove books fro the cart
    static boolean removeBookFromCart(String id) {


        return cart.removeIf(book1 -> book1.id.equalsIgnoreCase(id));

    }

    // this method is to view the cart items to the user
    static void viewCart() {
        if (cart.isEmpty()) System.out.println("Cart is empty");
        else cart.forEach(book -> System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                book.id, book.name, book.quantity, book.price));
    }

    // this method actually clear the cart in the name of checkout.
     static boolean checkout() {
        if (cart.isEmpty()) return false;
        cart.clear();
        return true;
    }

}
