package ThreadTest;

public class StartRunnable implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("aaaaaaaaaa");
        }
    }

    public static void main(String[] args) {
        //
        new Thread(new StartRunnable()).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("bbbb");
        }


    }


}
