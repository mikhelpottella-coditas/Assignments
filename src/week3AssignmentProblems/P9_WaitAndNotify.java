package week3AssignmentProblems;

//    Problem: You are required to implement a Ping-Pong game using two threads. One
//    thread should print "Ping" and the other should print "Pong" in a sequential and
//    synchronized manner. Your program should ensure that "Ping" is printed, then "Pong",
//    and so on, without any skipping or repeated prints.


class Game {
    boolean flag = true;

    synchronized void ping() {
        while (!flag) { // if the  flag is false then wait, if true then print "ping" and
            // change the flag to false and notify
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ping!!");
        flag = false;
        notify();
    }

    synchronized void pong() {
        while (flag) {// if the  flag is true then wait, if false then print "pong" and
            // change the flag to true and notify
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Pong!!");
        flag = true;
        notify();
    }

}

public class P9_WaitAndNotify {
    public static void main(String[] args) {


        Game game = new Game();

        Thread thread1 = new Thread(() -> { // thread to call the ping method
            for (int i = 0; i < 10; i++) {
                game.ping();
            }
        });


        Thread thread2 = new Thread(() -> { // thread to call pong method
            for (int i = 0; i < 10; i++) {
                game.pong();
            }
        });
        thread1.start();
        thread2.start();
    }
}

// output:

/*
Ping  (alternative)
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
Ping
Pong
* */
