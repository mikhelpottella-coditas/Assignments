package handsOn.threading;

public class PingPong {
    public static void main(String[] args) {
        Game game = new Game();
        new Thread(()->{
            for (int i = 0; i < 6; i++) {
                game.ping();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 6; i++) {
                game.pong();
            }
        }).start();
    }
}

class Game{
    private boolean isPing = true;

    synchronized void ping(){
        while (!isPing){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Ping");
        isPing = false;
        notify();

    }

    synchronized void pong(){
        while (isPing){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Pong");
        isPing = true;
        notify();

    }
}