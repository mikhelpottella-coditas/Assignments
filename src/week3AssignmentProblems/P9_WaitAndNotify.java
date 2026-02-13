package week3AssignmentProblems;

class Game{
    boolean flag = true;

    synchronized void ping(){
        while (!flag){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ping!!");
        flag = false;
        notify();
    }

    synchronized void pong(){
        while (flag){
            try{
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

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                game.ping();
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                game.pong();
            }
        });
thread1.start();
        thread2.start();
    }
}
