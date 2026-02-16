package Week3EvaluationTask;

import java.util.Scanner;

public class DeveloperPanel {
    Scanner sc = new Scanner(System.in);

    Developer developer = new Developer();

    void panel(){
        while (true){
            System.out.println("\nplease select from following:\n");
            System.out.println("1.Task List  2.Send for Review  3.Forward to test  Exit:0");
            int input = sc.nextInt();
            if(input == 0) break;
            switch (input){
                case 1: {
                    developer.taskList();
                    break;
                }
                case 2:{
                    developer.sendReview();
                    break;
                }
                case 3: {
                    developer.forwardToTest();
                    break;
                }
                default:{
                    System.out.println("please select valid operation: ");
                    break;
                }
            }

        }
    }
}
