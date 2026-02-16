package Week3EvaluationTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        System.out.println("what are you:");
        System.out.println("1.TechLead  2.Developer  3.TestingLead  4.Tester");
        int input = sc.nextInt();
        switch (input){
            case 1:{
                TechLeadPanel techLeadPanel = new TechLeadPanel();
                techLeadPanel.panel();
                break;
            }
            case 2:{
                DeveloperPanel developerPanel = new DeveloperPanel();
                developerPanel.panel();
                break;
            }
            case 3:{
                TestLeadPanel testLeadPanel = new TestLeadPanel();
                testLeadPanel.panel();
                break;
            }
            case 4:{
                TesterPanel testerPanel = new TesterPanel();
                testerPanel.panel();
                break;
            }
        }


    }
}
