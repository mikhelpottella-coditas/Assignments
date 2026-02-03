package week2Assignment;

public class P4_InnerClass {
    private float amount = 0;

    public class Transactions{
        void Deposit(float entry){
            amount+=entry;
            System.out.println("amount deposited successfully and the balance: "+amount);
        }

        void withdraw(float entry){
            if(amount>entry){
                amount-=entry;
                System.out.println("amount withdraw successful and the remaining balance : "+amount);
            }
            else{
                System.out.println("you dont have sufficient amount. the balance is "+amount);
            }
        }

    }
}
