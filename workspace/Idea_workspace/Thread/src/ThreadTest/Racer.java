package ThreadTest;

public class Racer implements Runnable {
    private  String winner;

    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            System.out.println(Thread.currentThread().getName() + "---" + steps);
            boolean flag = w(steps);
            if (flag) {
                break;
            }

        }
    }

    boolean w(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner=" +winner );
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Racer r = new Racer();

        new Thread(r, "li").start();
        new Thread(r, "wang").start();


    }
}
