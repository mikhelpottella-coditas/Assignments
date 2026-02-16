package week3AssignmentProblems;

//    Problem: Implement a program where two separate objects represent two accounts,
//        and you need to transfer money between them. Use different locks for each account to
//        ensure thread safety without causing deadlocks.
//        Objective: Learn how to manage multiple locks and avoid deadlocks in concurrent
//        systems.


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// class to create Bank Account
class Account {
    int id;
    private int balance;
    String accountName;
    public final Lock lock = new ReentrantLock();

    public Account(int id, int balance,String accountName) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    void withDraw(int amount) {
        if (amount < balance) balance -= amount;
    }

    int getId() {
        return id;
    }

    int getBalance() {
        return balance;
    }
    String getAccountName(){
        return accountName;
    }
}


class Operation implements Runnable {
    Account from;

    Account to;
    int amount;

    public Operation(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }


    @Override
    public void run() {
        Account firstLock = (from.getId() < to.getId()) ? from : to;
        Account secondLock = (from.getId() > to.getId()) ? from : to;
        firstLock.lock.lock();
        try {
            secondLock.lock.lock();
            try {
                if (from.getBalance() >= amount) {
                    from.withDraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from Account " + from.getAccountName() + " to " + to.getAccountName());
                    System.out.println("the new balance in "+from.getAccountName()+" is "+from.getBalance());
                    System.out.println("the new balance in "+to.getAccountName()+" is "+to.getBalance()+"\n");

                }
            }finally {
                secondLock.lock.unlock();
            }
            }finally {
            firstLock.lock.unlock();
        }


        }
    }

    public class P4_Reentrantlock {

        public static void main(String[] args) {
            Account sbi = new Account(2,5000,"SBI");
            Account union = new Account(4,8000,"union");

            Thread thread1 = new Thread(new Operation(sbi,union,1000),"thread1");
            Thread thread2 = new Thread(new Operation(union,sbi,2000),"thread2");

            thread1.start();
            thread2.start();
        }

}


// output
/*
thread1 transferred 1000 from Account SBI to union
the new balance in SBI is 4000
the new balance in union is 9000

thread2 transferred 2000 from Account union to SBI
the new balance in union is 7000
the new balance in SBI is 6000
* */