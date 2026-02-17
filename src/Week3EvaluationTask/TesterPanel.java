package Week3EvaluationTask;

import java.util.Scanner;

public class TesterPanel {
    Scanner sc = new Scanner(System.in);

    Tester tester = new Tester();

    void panel(){
        while (true){
            System.out.println("\nplease select from following:\n");
            System.out.println("1.Task List  2.Send for Review  3.Forward to test  Exit:0");
            int input = sc.nextInt();
            if(input == 0) break;
            switch (input){
                case 1: {
                    tester.taskList();
                    break;
                }
                case 2:{
                    tester.sendReview();
                    break;
                }
                case 3: {
                    tester.markCompleted();
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
