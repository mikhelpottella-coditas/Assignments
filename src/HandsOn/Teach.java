package handsOn;

public class Teach {
     public static void main(String[] args) {
         ThreadExample t1 = new ThreadExample();
         ThreadExample t2 = new ThreadExample();
         t1.setName("--1");
         t2.setName("--2");
         t1.start();
         t2.start();
    }

}

class ThreadExample extends Thread{
    @Override
    public void run() {
       runner();
    }

    synchronized void runner(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
            if (i==40) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
