package Safe;

public class Ticket {
    public static void main(String[] args) {
        car c = new car(20,"huijia");

        new person1(c,"li",12).start();
        new person1(c,"wang",2).start();
        new person1(c,"qian",5).start();
        new person1(c,"zhao",8).start();

    }
}



class person1 extends Thread {
    int selts;

    public person1(Runnable target, String name, int selts) {
        super(target, name);
        this.selts = selts;
    }


}



class car implements Runnable{
    int tickets;
    String name;
    boolean flag;

    public car(int tickets, String name) {
        this.tickets = tickets;
        this.name = name;
    }



    @Override
    public synchronized void run() {
        person1 t = (person1)Thread.currentThread();
        String name = t.getName();
        flag = selt(t.selts);
        if(flag){
            System.out.println(name + "购票成功");
            System.out.println("剩余票数:"+tickets);
            System.out.println("-----------");
        }else{
            System.out.println(name + "购票失败");
            System.out.println("-----------");
        }

    }

    boolean selt(int selts){
        System.out.println("剩余票数:"+tickets);
        if (tickets - selts <0){
            return false;
        }else{
            tickets-=selts;
            return true;
        }
    }

}