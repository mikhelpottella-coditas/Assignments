package handsOn.polymorphism;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        System.out.println("Which account you want to open: \n 1.Savings  press '1' \n 2.Current press'2'");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        if(selection==1){
            System.out.println("Please enter your name:");
            String name = sc.next();
            System.out.println("Please enter the amount to deposit");
            double amount = sc.nextDouble();
//            SavingAccount savingAccount = new SavingAccount("12345678976543",name,amount);
            boolean isCreated = SavingAccount.createobject("12345678976543",name,amount);

            if(isCreated) SavingAccount.requestManagement();
            else System.out.println("Account is not created the provided details are wrong!!!");

        }
        else if(selection==2){
            System.out.println("Please enter your name:");
            String name = sc.next();
            System.out.println("Please enter the amount to deposit");
            double amount = sc.nextDouble();
//            SavingAccount savingAccount = new SavingAccount("12345678976543",name,amount);
            boolean isCreated = CurrentAccount.createobject("12345678976543",name,amount);

            if(isCreated) CurrentAccount.requestManagement();
            else System.out.println("Account is not created the provided details are wrong!!!");

        }
        else {
            System.out.println("invalid Input !!!");
        }

    }
}
