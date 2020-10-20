package ThreadTest;


import java.util.Date;

public class StartThread extends Thread {
    private String name;

    public StartThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+"==="+name);

    }

    public static void main(String[] args) {
        StartThread s = new StartThread("aa");
        s.setName("bb");
        s.start();
        Thread s2 = new Thread(s,"li");
        s2.start();

//        new Thread(()-> System.out.println("ccccccccccccccccc"));
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println("bbbbbbbbbbbbb");
//        }



    }
}
