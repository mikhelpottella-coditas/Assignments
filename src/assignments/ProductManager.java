package assignments;

// problem statement:
//Class name: Product
//Fields: id, name, price, gst (in %), available_quantity
//
//Initialize above from a txt/dat file into an array of Product.
//
//Format of file:
//<id> <name> <price> <gst> <available_quantity>
//
//Write a menu driven program to let customers select products until he selects the Checkout option
//and then show the total amount he has to pay after calculating the GST.

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

// this is the product class to store each product as an object.
class Products {
    int id;
    String productName;
    double price;
    double gst;
    int availablity;

    Products(int id, String productName, double price, double gst, int availablity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.gst = gst;
        this.availablity = availablity;
    }
}


public class ProductManager {
    public static void main(String[] args) {

        Products[] productArr = new Products[10]; // creating  a array of products to store all the products in a array.
        int count = 0;

        try {
            Scanner fileScanner = new Scanner(new File("src/assignments/productMenu.txt")); // to access file that hold the menu

            while (fileScanner.hasNextLine() && count < productArr.length) {
                String line = fileScanner.nextLine();
                String[] data = line.split(" "); // Splits by space

                // Convert each data to its own type since we have the srings and store this data in the new object and store that object in the array
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                double gst = Double.parseDouble(data[3]);
                int qty = Integer.parseInt(data[4]);

                // Creating an object products and assign in to the array based on the count as index.
                productArr[count] = new Products(id, name, price, gst, qty);
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        System.out.println(productArr[0].productName);
        {//in the scope we are displaying the products to the user
            System.out.println("here is the menu of product that are avalable:");
            System.out.println();
            System.out.printf("%-5s %-15s %-10s %-5s %-10s%n", "ID", "Name", "Price", "GST", "Stock");

            for (Products p : productArr) {
                System.out.printf("%-5s %-15s %-10s %-5s %-10s%n", p.id, p.productName, p.price, p.gst, p.availablity);
            }
        }


            Scanner productSelected = new Scanner(System.in); // new scanner to access the user produc selection
            double grandTotal = 0;
            int choice = -1;
// so here is the main logic:
//        we are taking the user input and calculating the gst and adding it to the grand total.
            while (choice != 0) {
                System.out.println("\nEnter Product ID to add to cart (or 0 to Checkout): ");
                choice = productSelected.nextInt();

                if (choice == 0) break; // if he choose to check out then we end the while loop and print the grand total

                boolean flag = false; // this flag is to check the item id is valid
                for (Products p : productArr) {
                    if (p != null && p.id == choice) {
                        flag = true;
                        if (p.availablity > 0) {
                            // Calculate Price + GST
                            double itemTotal = p.price + (p.price * p.gst / 100); // formula to add the gst and finding th efinal price
                            grandTotal += itemTotal;
                            p.availablity--; // Reduce stock

                            System.out.println("Added to cart.");
                        } else {
                            System.out.println("Sorry is out of stock!"); // if the item is out of stock
                        }
                        break;
                    }
                }
                if (!flag) System.out.println("Invalid ID. Please try again.");
            }

            System.out.printf("%nFinal Bill Amount: %.2f%n", grandTotal); // to print the grand total.


    }
}
