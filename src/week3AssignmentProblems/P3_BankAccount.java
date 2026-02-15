package week3AssignmentProblems;

import java.time.LocalDateTime;

//    Problem: Write a program to simulate a bank account system where multiple threads
//    can deposit and withdraw money. Ensure that the balance updates correctly when
//    multiple transactions happen concurrently.
//
//    Objective: Understand how to use the synchronized keyword to avoid race conditions
//    and ensure thread safety.

public class P3_BankAccount {
    public static void main(String[] args) {


        Subscription appleMusic = new Subscription();
        Subscription prime = new Subscription();
        Thread appleMusicThread = new Thread(appleMusic);
        Thread primeThread = new Thread(prime);

        appleMusicThread.setName("Apple Music");
        primeThread.setName("Amazon prime");

        appleMusicThread.start();
        primeThread.start();

        new Thread(() -> {
            Subscription.deposit();
        }).start();
    }

}


//      in this method we are implementing multiple thread.
//      we are going to access the static variable where the amount is stored using diff
//      threads by using the synchronized method so there be a lock and one thread access at a time
class Subscription implements Runnable{
    static double amount = 5000;
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            withDraw();
        }
    }

   static synchronized void   withDraw(){
        // implemented in such a way so it look like a bank mini statement
       System.out.println(LocalDateTime.now()); //  used to print the time stamp.
       System.out.println("amount with drawn 200 by " + Thread.currentThread().getName());
       System.out.println("Remaining balance : "+amount+"\n");
       amount-=200;
    }

    static synchronized void   deposit(){
        // implemented in such a way so it look like a bank mini statement
        System.out.println(LocalDateTime.now()); //  used to print the time stamp.
        System.out.println("amount deposit 200 by " + Thread.currentThread().getName());
        System.out.println("Current balance : "+amount+"\n");
        amount+=2000;
    }
}

/*
 output:
 2026-02-12T22:02:43.794147600
amount with drawn 200 by Apple Music
Remaining balance : 5000.0

2026-02-12T22:02:43.817084600
amount with drawn 200 by Amazon prime
Remaining balance : 4800.0

2026-02-12T22:02:44.319740600
amount with drawn 200 by Apple Music
Remaining balance : 4600.0

2026-02-12T22:02:44.323730500
amount with drawn 200 by Amazon prime
Remaining balance : 4400.0

2026-02-12T22:02:44.833368100
amount with drawn 200 by Apple Music
Remaining balance : 4200.0

2026-02-12T22:02:44.833368100
amount with drawn 200 by Amazon prime
Remaining balance : 4000.0

2026-02-12T22:02:45.334028400
amount with drawn 200 by Apple Music
Remaining balance : 3800.0

2026-02-12T22:02:45.342007
amount with drawn 200 by Amazon prime
Remaining balance : 3600.0

2026-02-12T22:02:45.848227800
amount with drawn 200 by Amazon prime
Remaining balance : 3400.0

2026-02-12T22:02:45.848227800
amount with drawn 200 by Apple Music
Remaining balance : 3200.0
*/