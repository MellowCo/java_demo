package Safe;

public class SafeBank {
    public static void main(String[] args) {
        Account a = new Account(100, "li");

        new Thread(new person(20, a), "li").start();
        new Thread(new person(30, a), "wang").start();
        new Thread(new person(34, a), "qian").start();
    }

}


class person implements Runnable {
    private int quMoney;
    private int pageMoney = 0;
    private Account a;

    public person(int quMoney, Account a) {
        this.quMoney = quMoney;
        this.a = a;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    void test() {
        if (a.money==0){
            return;
        }

        synchronized (a) {
            if (a.money - quMoney < 0) {
                return;
            } else {
                a.money -= quMoney;
                pageMoney += quMoney;
                System.out.println(Thread.currentThread().getName() + "-->" + pageMoney + "-->" + a.money);
            }
        }


    }
}