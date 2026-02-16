package handsOn.polymorphism;

public class Account {
     String accountNumber;
     String holderName;
     Double balance;

    public Account(String accountNumber, String holderName, Double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        System.out.println("Account creation successful");
    }

    boolean Deposit(double amount){ // to add amount to the account
        if(amount<0) return false;
        balance+= amount;
        System.out.println("Deposit successful and you current balance : "+balance);
        return true;

    }

    boolean withDraw(double amount){
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


    void displayAccountInfo(){
        System.out.println("Account no. :"+accountNumber+"\nHolderName:"+holderName+"\nCurrent Balance:"+balance);

    }


}
