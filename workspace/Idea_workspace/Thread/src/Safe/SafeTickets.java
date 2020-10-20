package Safe;

public class SafeTickets {
    public static void main(String[] args) {
        TestTickets tt = new TestTickets();

        new Thread(tt,"li").start();
        new Thread(tt,"wang").start();
        new Thread(tt,"qian").start();
    }



}


class TestTickets implements Runnable {
    private static int tickets = 10;
    private static boolean flag = true;


    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Test();

        }
    }

     synchronized void Test() {
        if (tickets>0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tickets--);
        } else {
            flag = false;
        }

    }
}