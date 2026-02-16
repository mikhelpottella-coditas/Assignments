    package week3AssignmentProblems;

    import java.util.concurrent.locks.ReentrantReadWriteLock;


    //    Problem: Write a program that simulates a resource that can be accessed by multiple
    //    threads, but only one thread at a time can modify it. Use ReentrantLock to ensure
    //    that each thread gets exclusive access to the resource.
    //            Objective: Explore the functionality of ReentrantLock compared to synchronized,
    //    including features like fairness and lock reentrancy.

    public class P7_ReadWrite {
        public static void main(String[] args) {
            ReadWrite readWrite = new ReadWrite();

            for (int i = 0; i < 5; i++) { // threads to call read method
                new Thread(readWrite::reader).start();
            }


            new Thread(()->{ //  new thread to call the write method
                readWrite.writer(100);
            }).start();

        }
    }

    class ReadWrite {
        ReentrantReadWriteLock RWLock = new ReentrantReadWriteLock(true);
        private int data = 1000;


        // here this method is to write the data which contain the write lock and can be
        // accessed by only one thread trying to write.
         void writer(int change) {
            RWLock.writeLock().lock();
            try {
                System.out.println("changing the data by " + Thread.currentThread().getName());
                Thread.sleep(2000);
                data += change;
                System.out.println("write finished " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                RWLock.writeLock().unlock();
            }
        }


        // here this method is to read the data which contain the read lock and can be
        // accessed all the threads trying to read.
        void reader() {
            RWLock.readLock().lock();
            try {
                System.out.println("read finished " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("the data is " + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                RWLock.readLock().unlock();
            }
        }


    }


    // output:

    /*
    read finished Thread-4
    read finished Thread-2
    read finished Thread-1
    read finished Thread-3
    read finished Thread-0

    (after 2 sec)

    the data is 1000
    the data is 1000
    the data is 1000
    the data is 1000
    the data is 1000
    changing the data by Thread-5
    (after 2 sec)
    write finished Thread-5

     */
