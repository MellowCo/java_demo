package Safe;

public class waitModle {
    public static void main(String[] args) {
        WareHouse wh = new WareHouse();

        new Thread(new consumer(wh)).start();
        new Thread(new producer(wh)).start();
    }
}


class WareHouse {
    Object a[] = new Object[10];
    shoper s;
    int count = 0;

    synchronized void produce(shoper s) throws InterruptedException {
        this.s = s;
        if (a.length == count) {
            this.wait();
        } else {
            notifyAll();
            a[count] = s;
            count++;
            System.out.println("消费者" + s.id);
        }
    }

    synchronized void shopping() throws InterruptedException {
        if (count != 0) {
            notifyAll();
            count--;
            System.out.println("生产者" + s.id);

        } else {
            this.wait();
        }

    }


}

class shoper {
    int id;

    public shoper(int id) {
        this.id = id;
    }
}

class consumer implements Runnable {
    WareHouse w;

    public consumer(WareHouse w) {
        this.w = w;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                w.shopping();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class producer implements Runnable {
    WareHouse w;

    public producer(WareHouse w) {
        this.w = w;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                w.produce(new shoper(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}