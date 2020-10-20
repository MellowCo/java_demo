package Safe;

import java.util.ArrayList;

public class Movies {
    public static void main(String[] args) {
        ArrayList<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(12);
        available.add(6);
        available.add(5);
        available.add(77);
        available.add(55);
        available.add(3);
        available.add(4);
        available.add(18);

        ArrayList<Integer> selt1 = new ArrayList<>();
        selt1.add(1);
        selt1.add(6);
        selt1.add(55);
        selt1.add(5);

        ArrayList<Integer> selt2 = new ArrayList<>();
        selt2.add(1);
        selt2.add(4);
        selt2.add(3);
        selt2.add(55);
        selt2.add(5);

        Film f = new Film(available,"fff");
        new Thread(new custommer(f,selt1),"li").start();
        new Thread(new custommer(f,selt2),"wang").start();
    }
}


class custommer implements Runnable {
    Film film;
    ArrayList<Integer> selt;
    boolean flag;

    public custommer(Film film, ArrayList<Integer> selt) {
        this.film = film;
        this.selt = selt;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (film) {
            flag = film.selt(this.selt);
            if (flag) {
                System.out.println(name + ":购票成功！！！！");
            } else {
                System.out.println(name + ":购票失败！！！！");
                return;
            }
        }
    }
}


class Film {
    ArrayList<Integer> available;
    String name;

    public Film(ArrayList<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    boolean selt(ArrayList<Integer> selt) {
        System.out.println("可用位置:" + available.toString());

        ArrayList<Integer> copy = new ArrayList<>();
        copy.addAll(available);
        copy.removeAll(selt);

        if (available.size()-copy.size()!=selt.size()) {
            return false;
        } else {
            available = copy;
            return true;
        }
    }
}
