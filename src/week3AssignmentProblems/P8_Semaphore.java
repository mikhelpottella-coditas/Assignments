package week3AssignmentProblems;

import java.util.concurrent.*;

//    Problem: Create a traffic control system where only 3 cars can pass through a tunnel at
//    the same time. Use a semaphore to limit the number of cars that can be in the tunnel
//    concurrently.
//            Objective: Learn how to use Semaphore to control access to a limited number of
//    resources in a multithreaded environment.


public class P8_Semaphore {
    Semaphore tunnel = new Semaphore(3);

    public static void main(String[] args) {

        P8_Semaphore p8Semaphore = new P8_Semaphore();

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(p8Semaphore::travel); // creating new threads 10 threads here.
            t1.setName("car" + i);
            t1.start();
        }

    }

    void travel() {
        try {
            System.out.println("ready to go in the tunnel " + Thread.currentThread().getName());
            Thread.sleep(2000);
            tunnel.acquire(); // acts as a gate and allows only permitted no.of threads
            System.out.println("inside the tunnel " + Thread.currentThread().getName());
            Thread.sleep(10000);
            tunnel.release(); //  exiting outside so others can come
            System.out.println("out of the tunnel " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

//outPut:

/*
ready to go in the tunnel car1
ready to go in the tunnel car0
ready to go in the tunnel car3
ready to go in the tunnel car4
ready to go in the tunnel car2
ready to go in the tunnel car5
ready to go in the tunnel car6
ready to go in the tunnel car7
ready to go in the tunnel car9
ready to go in the tunnel car8

(even if all the threads cam only 3 threads can go inside the tunnel at a time.)

inside the tunnel car1
inside the tunnel car0
inside the tunnel car7
inside the tunnel car4
out of the tunnel car1
out of the tunnel car0
out of the tunnel car7
inside the tunnel car9
inside the tunnel car3
out of the tunnel car4
inside the tunnel car2
out of the tunnel car9
inside the tunnel car6
inside the tunnel car8
out of the tunnel car3
inside the tunnel car5
out of the tunnel car2
out of the tunnel car6
out of the tunnel car8
out of the tunnel car5

*/
