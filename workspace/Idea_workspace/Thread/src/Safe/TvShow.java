package Safe;

public class TvShow {
    public static void main(String[] args) {
        Tv t = new Tv();

        new Thread(new player(t)).start();
        new Thread(new wacther(t)).start();

    }
}


class Tv {
    String voice;
    boolean flag = true;

    synchronized void play(String voice) throws InterruptedException {
        if(!flag){
            this.wait();
        }
        notifyAll();
        flag=false;
        this.voice = voice;
        System.out.println("player:" + voice);
    }

    synchronized void watch() throws InterruptedException {
        if(flag){
            this.wait();
        }
        notifyAll();
        flag=true;
        System.out.println("watcher:" + voice);
    }
}

class player implements Runnable {
    Tv tv;

    public player(Tv tv) {
        this.tv = tv;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    tv.play("aaaaaaaaaaaaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    tv.play("bbbbbbbbbbbbbbb");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class wacther implements Runnable {
    Tv tv;

    public wacther(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}