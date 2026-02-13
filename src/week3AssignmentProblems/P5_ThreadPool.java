package week3AssignmentProblems;

//        Problem: Create a program that processes a list of tasks (e.g., file downloads, image
//                processing) using a thread pool. The program should dynamically allocate a fixed
//        number of worker threads to complete the tasks.
//        Objective: Implement a thread pool using ExecutorService and understand the
//        benefits of reusing threads for multiple tasks.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MultipleTask implements Runnable{
    String name;

    public MultipleTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("the current processing thread is"+name);
        try {
            // just to understand how it's working by slowing it dowm
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}


public class P5_ThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3); // create 3 threads and a queue that maintenance the below added tasks

        for (int i = 1; i <= 5; i++) { // adding 5 image process stimulation
            pool.execute(new MultipleTask("  image: "+i));
        }
        for (int i =1; i <= 5; i++) { // adding 5 file processing stimulation
            pool.execute(new MultipleTask(" file process: "+i));
        }

        try{
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)){ // wait for 60 secs or wait till all the tasks are completed
                pool.shutdown();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}




/*
output:
the current processing thread is  image: 1
the current processing thread is  image: 2
the current processing thread is  image: 3
the current processing thread is  image: 4
the current processing thread is  image: 5
the current processing thread is file process: 1
the current processing thread is file process: 2
the current processing thread is file process: 3
the current processing thread is file process: 4
the current processing thread is file process: 5

*/