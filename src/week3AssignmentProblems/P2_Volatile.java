package week3AssignmentProblems;

// problem statement:
/*
Problem: Implement a counter that can be accessed by two threads: one thread
increments the counter, and another thread reads its value.
*
Objective: Demonstrate the effect of the volatile keyword in ensuring variable
visibility between threads.
*/


class Write implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            P2_Volatile.counter+=1;
        }
    }
}
class Read implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(990);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("from reader thread"+P2_Volatile.counter );
        }
    }
}

public class P2_Volatile {
    volatile static int counter =0;  // the volatile variable helps to read and write directly to and
    // from memory. using this we are going to access the same data in diff threads

    public static void main(String[] args) {
        Write write = new Write();
        Read read = new Read();
        Thread writeThread = new Thread(write);
        Thread readThread = new Thread(read);
        writeThread.start();
        readThread.start();
    }
}


/*
out put:
from reader thread  0
from reader thread  1
from reader thread  2
from reader thread  3
from reader thread  4
from reader thread  5
from reader thread  6
from reader thread  7
from reader thread  8
from reader thread  9
*/