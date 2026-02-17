package Week3EvaluationTask;

import java.util.Scanner;

public class TestLeadPanel {
    Scanner sc = new Scanner(System.in);

    TestingLead techLead = new TestingLead();

    void panel(){
        while (true){
            System.out.println("\nplease select from following:\n");
            System.out.println("1.Task List  2.Developers List  3.Assign Task  4.Pending Review  Exit:0");
            int input = sc.nextInt();
            if(input == 0) break;
            switch (input){
                case 1: {
                    techLead.taskList();
                    break;
                }
                case 2:{
                    techLead.testerList();
                    break;
                }
                case 3: {
                    techLead.assignTask();
                    break;
                }
                case 4: {
                    techLead.pendingReview();
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
