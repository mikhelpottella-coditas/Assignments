package handsOn.polymorphism;

import java.util.Scanner;

public class SavingAccount extends Account{

    public SavingAccount(String accountNumber, String holderName, Double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    boolean withDraw(double amount){
        if(amount>10000){
            System.out.println("the max withDraw limit is 10000");
            return false;
        }
        if(amount>balance) {
            System.out.println("Insufficient Funds");
            return false;
        }
        else{
            balance-=amount;
            System.out.println("WithDraw successful and you current balance : "+balance);
            return true;
        }
    }

    static SavingAccount savingAccount;
    static boolean createobject(String acc,String name,double amount){
        if(amount<0 ) {
            System.out.println("not a valid deposit");
            return false;
        }
//        if(!name.matches("[^[a-zA-Z\\\\s]*$]")) return false;
        savingAccount = new SavingAccount(acc,name,amount);
        return true;
    }

    static boolean requestManagement(){
        while(true) {
            System.out.println("\nPlease select your operation: \n 1.Deposit 2.withDraw 3.AccountInfo Exit: 0 ");
            Scanner sc = new Scanner(System.in);
            int request = sc.nextInt();
            if(request==0) break;
            switch (request){
                case 1:{
                    System.out.println("Please enter the amount:");
                    double amount = sc.nextDouble();
                    boolean status = savingAccount.Deposit(amount);
                    if(!status) System.out.println("request failed");
                    break;
                }
                case 2:{
                    System.out.println("Please enter the amount:");
                    double amount = sc.nextDouble();
                    boolean status = savingAccount.withDraw(amount);
                    if(!status) System.out.println("request failed");
                    break;
                }
                case 3:{
                    savingAccount.displayAccountInfo();
                    break;
                }
                default: {
                    System.out.println("please select the correct request");
                }
            }
        }
        return true;
    }
}
