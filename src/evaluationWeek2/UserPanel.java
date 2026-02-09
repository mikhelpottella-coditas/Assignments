package evaluationWeek2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserPanel {
    static void userPanel(){
        System.out.println("user login success\n\n\n");
        System.out.println("please select your operation from the following : ");
        System.out.println("1.view Books  2.Add Books  3.Cart  4.Find");
        int entry=-1;
        while (entry !=0){
            switch (entry){
                case 1:{
                    System.out.println("Here is the list of all Book available");
                    try {
                        File bookfile = BookData.bookmethod();
                        Scanner Reader = new Scanner(bookfile);

                        // Traversing File Data
                        while (Reader.hasNextLine()) {
                            String data = Reader.nextLine();
                            System.out.println(data.replace(",","  "));
                        }
                        Reader.close();
                    } catch (RuntimeException | FileNotFoundException e) {
                        System.out.println("roor");
                    }
                    break;
                }
            }
        }
    }
}
