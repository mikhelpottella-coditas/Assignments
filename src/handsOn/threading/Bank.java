package handsOn.threading;
//      . Problem: Write a program to simulate a bank account system where multiple threads
//        can deposit and withdraw money. Ensure that the balance updates correctly when
//        multiple transactions happen concurrently.
//        Objective: Understand how to use the synchronized keyword to avoid race conditions
//        and ensure thread safety.
public class Bank {
    int balance = 2000;
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread apple = new Thread(()->{ bank.withdraw(200); });
        Thread self = new Thread(()->{ bank.deposit(2000); });
        Thread amazon = new Thread(()->{ bank.withdraw(200); });
        Thread mac = new Thread(()->{ bank.withdraw(200); });
        apple.start();
        self.start();
        amazon.start();
        mac.start();
    }
    synchronized void withdraw(int amount){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(amount<balance) balance-=amount;
        System.out.println("with draw successful and the remaining balance is "+ balance);
    }
    synchronized void deposit(int amount){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance+=amount;
        System.out.println("amout added "+balance);
    }
}
