package handsOn.polymorphism;

import java.util.Scanner;

public class CurrentAccount extends Account{
    public CurrentAccount(String accountNumber, String holderName, Double balance) {
        super(accountNumber, holderName, balance);
    }

    static CurrentAccount currentAccount;
    static boolean createobject(String acc,String name,double amount){
        if(amount<0 ) {
            System.out.println("not a valid deposit");
            return false;
        }
//        if(!name.matches("[^[a-zA-Z\\\\s]*$]")) return false;
        currentAccount = new CurrentAccount(acc,name,amount);
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
                    boolean status = currentAccount.Deposit(amount);
                    if(!status) System.out.println("request failed");
                    break;
                }
                case 2:{
                    System.out.println("Please enter the amount:");
                    double amount = sc.nextDouble();
                    boolean status = currentAccount.withDraw(amount);
                    if(!status) System.out.println("request failed");
                    break;
                }
                case 3:{
                    currentAccount.displayAccountInfo();
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
