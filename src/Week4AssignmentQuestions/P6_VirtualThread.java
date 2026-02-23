package Week4AssignmentQuestions;

//    Write a program that demonstrates the creation of virtual threads for concurrent
//    execution using the Thread.ofVirtual().start().

public class P6_VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) { // careting the virtual thread
            Thread thread = Thread.ofVirtual().start(() -> System.out.println(Thread.currentThread().getName() + " is running."));
            thread.join();
        }
    }
}


//    output:
//
//    Thread-0 is running.
//    Thread-1 is running.
//    Thread-2 is running.
//    Thread-3 is running.
//    Thread-4 is running.
//    Thread-5 is running.
//    Thread-6 is running.
//    Thread-7 is running.
//    Thread-8 is running.
//    Thread-9 is running.