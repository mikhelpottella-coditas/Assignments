package handsOn.threading;

public class Sychronize {
    public static void main(String[] args) {
        Thread s1 = new Thread(new Seller(), "s1");
        Thread s2 = new Thread(new Seller(), "s2");
        Thread s3 = new Thread(new Seller(), "s3");
        s1.start();
        s2.start();
        s3.start();
    }
}

class Seller implements Runnable {
    static int totalTickets = 100;
    static int counter = 0;

    @Override
    public void run() {
        while (totalTickets > 0) {
            saleTicket();
        }
    }

     static synchronized void saleTicket() {
        if (totalTickets > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalTickets--;
            counter++;
            System.out.println(Thread.currentThread().getName() + " is sold a ticket no. " + counter);
        }
    }
}
