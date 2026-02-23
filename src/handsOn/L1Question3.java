package handsOn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Problem Statement: Create a banking system where multiple deposit and withdrawal
// transactions are processed concurrently using a fixed-size thread pool. There is a single
// shared BankAccount object. A list of transactions (deposit and withdraw) should be processed
// using ExecutorService with a fixed number of worker threads. Each transaction runs as a separate
// task. Ensure that balance updates are thread-safe and no race condition occurs. The final balance
// should always be correct after all transactions are completed. 🎯 Objectives: Use
// ExecutorService to create and manage a thread pool. Implement task processing using Runnable
// or Callable. Use synchronized to ensure thread-safe balance updates. Understand thread lifecycle
// management (shutdown(), awaitTermination()). Demonstrate how thread pools improve performance by
// reusing threads. 💡 Example Scenario: Initial balance = 1000 Transactions: Deposit 500 Withdraw
// 300 Deposit 200 Withdraw 700 Deposit 400 All transactions should be
// submitted to a fixed thread pool of size 3. After all tasks complete, print the final balance.
public class L1Question3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            pool.execute(() -> account.deposit(200));
        }

        for (int i = 0; i < 5; i++) {
            pool.execute(() -> account.withdraw(200));
        }

        pool.execute(() -> account.withdraw(200));

        pool.execute(() -> account.deposit(200));

        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) { // wait for 60 secs or wait till all the tasks are completed
                pool.shutdown();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



class BankAccount {
    static private double balance = 10000;
    final Object lock = new Object();

    void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Amount deposit successful by " + Thread.currentThread().getName() + " the updated balance is " + balance);

        }
    }

    void withdraw(double amount) {
        synchronized (lock) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;

            System.out.println("Amount withdraw successful by " + Thread.currentThread().getName() + " the updated balance is " + balance);

        }
    }

}


// output:
/*
Amount deposit successful by pool-1-thread-1 the updated balance is 10200.0
Amount deposit successful by pool-1-thread-3 the updated balance is 10400.0
Amount deposit successful by pool-1-thread-2 the updated balance is 10600.0
Amount deposit successful by pool-1-thread-3 the updated balance is 10800.0
Amount deposit successful by pool-1-thread-1 the updated balance is 11000.0
Amount withdraw successful by pool-1-thread-3 the updated balance is 10800.0
Amount withdraw successful by pool-1-thread-2 the updated balance is 10600.0
Amount withdraw successful by pool-1-thread-3 the updated balance is 10400.0
Amount withdraw successful by pool-1-thread-1 the updated balance is 10200.0
Amount withdraw successful by pool-1-thread-3 the updated balance is 10000.0
Amount withdraw successful by pool-1-thread-2 the updated balance is 9800.0
Amount deposit successful by pool-1-thread-1 the updated balance is 10000.0
*/