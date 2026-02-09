package evaluationWeek2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserPanel {
    static void userPanel() {
        System.out.println("user login success\n\n\n");
        System.out.println("please select your operation from the following : ");
        System.out.println("1.view Books  2.Add Books  3.Cart  4.Find");
        int entry = -1;
        while (entry != 0) {
            switch (entry) {
                case 1: {
                    System.out.println("Please select how ou want to see the order: ");
                    System.out.println("1.id wise  2.Name wise 3.quantity wise  4.Price wise");
                    int sortOrder = sc.nextInt();
                    if(sortOrder>4 || sortOrder<1) break;
                    System.out.println("Here are the list of all book:");

                    ManpulateBooks.viewBooks(sortOrder);
                    break;
                }
                case 2:

            }
        }
    }
}

