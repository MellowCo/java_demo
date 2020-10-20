package UnSafe;

public class UnSafeTicket {
    public static void main(String[] args) {
        TestTicket t = new TestTicket();

        new Thread(t,"li").start();
        new Thread(t,"wang").start();
        new Thread(t,"qian").start();

    }
}

class TestTicket implements Runnable{
    private int tickets = 10;
    private boolean flag = true;

    public void run() {
        while (flag){
            if(tickets > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"--->"+tickets--);
            }else {
                flag=false;
                break;
            }
        }
    }
}