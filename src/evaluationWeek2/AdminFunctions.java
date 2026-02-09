package evaluationWeek2;


/*
 *  this class is to implement methods and functionalities that are required for the admin
 * */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Book{
    String id;
    String name;
    int quantity;
    double price;

    public Book(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity =quantity;
        this.price = price;
    }

}

public class AdminFunctions {
    static File bookfile = BookData.getBookmethod();


    // this method is used by admin panel to sort the data and to show in console
    static void viewBooks( int sortOrder){ // method for view books for case 3
        try {
            System.out.println("hello from viewBook");
            Scanner Reader = new Scanner(bookfile);
            ArrayList<Book> datalist = new ArrayList<>();

            // Traversing File Data
            while (Reader.hasNextLine()) {
                String [] book = Reader.nextLine().split(",");
                int quantity =Integer.parseInt(book[2]);
                double price = Double.parseDouble(book[3]);
                datalist.add(new Book(book[0],book[1], quantity,price));
            }
//            datalist.forEach((item)-> System.out.println(item.name));
            switch (sortOrder){
                case 1: {
                    datalist.sort((Book b1, Book b2) -> b1.id.compareTo(b2.id));
                    datalist.forEach((item) ->
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    item.id, item.name, item.quantity, item.price)
                    );
                    break;
//                    datalist.forEach((item)-> System.out.println("%-7s %-25s %-10d %-10.2f%n",item.id,item.name,item.quantity,item.price));
                }
                case 2:{
                    datalist.sort((Book b1, Book b2) -> b1.name.compareTo(b2.name));
                    datalist.forEach((item) ->
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    item.id, item.name, item.quantity, item.price)
                    );
                    break;
                }
                case 3:{
                    datalist.sort((Book b1, Book b2) -> b1.quantity - b2.quantity);
                    datalist.forEach((item) ->
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    item.id, item.name, item.quantity, item.price)
                    );
                    break;
                }
                case 4:{
                    datalist.sort(Comparator.comparingDouble((b->b.price)));
                    datalist.forEach((item) ->
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    item.id, item.name, item.quantity, item.price)
                    );
                    break;
                }
                default:{
                    System.out.println("invalid sort order");
                }
            }

            Reader.close();
        }
        catch (RuntimeException | FileNotFoundException e) {
            for(StackTraceElement i:e.getStackTrace()) System.out.println(i);
        }
    }


    // this method is it add new record to the data
    static boolean addBook(String line){
        String[] fileds = line.split(",");
        if(fileds.length!=4) return false;
        // TODO: make sure that total capacity is 200
        if( !fileds[2].matches("^[0-9]+$") || !fileds[3].matches("^[0-9]+(\\.[0-9]+)?$")) return false;

        try(FileWriter writer = new FileWriter(bookfile, true)) {
            writer.write( line+System.lineSeparator());
            System.out.println("book details added to the data");
        } catch (IOException e) {
            System.out.println("input format is not followed");
            throw new RuntimeException(e);
        }
        return true;
    }

    // this methos is to remove particular book data. for case 2 in admin panel
    static boolean removeBook(String removeId){

        try {

            Scanner Reader = new Scanner(bookfile);
            ArrayList<Book> datalist = new ArrayList<>();

            // Traversing File Data
            int counter=0;
            while (Reader.hasNextLine()) {
                String [] book = Reader.nextLine().split(",");
                int quantity =Integer.parseInt(book[2]);
                double price = Double.parseDouble(book[3]);
                datalist.add(new Book(book[0],book[1], quantity,price));
            }
            boolean isRemoved = datalist.removeIf(book -> book.id.equals(removeId));

            if(isRemoved){
                try(FileWriter writer = new FileWriter(bookfile,false)){
                    for(Book book:datalist)
                        writer.write(book.id + "," + book.name + "," + book.quantity + "," + book.price + System.lineSeparator());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else return false;
      } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    // this is the method to find a particular book based on the clue. for case 4 in admin panel
    static boolean findBook(String clue, int searchBy){
        try {

            Scanner Reader = new Scanner(bookfile);
            ArrayList<Book> datalist = new ArrayList<>();

            // Traversing File Data
            int counter = 0;
            while (Reader.hasNextLine()) {
                String[] book = Reader.nextLine().split(",");
                int quantity = Integer.parseInt(book[2]);
                double price = Double.parseDouble(book[3]);
                datalist.add(new Book(book[0], book[1], quantity, price));
            }
            switch (searchBy){
                case 1: {
                    for(Book book:datalist){
                        if(book.id.toLowerCase().contains(clue)){
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    book.id, book.name, book.quantity, book.price);
                        }
                    }
                }
                case 2:{
                    for(Book book:datalist){
                        if(book.name.toLowerCase().contains(clue)){
                            System.out.printf("%-7s %-40s %-10d %-10.2f%n",
                                    book.id, book.name, book.quantity, book.price);
                        }
                    }
                }
                default:
                    System.out.println("no Found");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
