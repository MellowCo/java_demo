package 装饰类;

public class Project {
    public static void main(String[] args) {
        coffee c = new coffee();
        milk m = new milk(c);
        System.out.println(m.cost() + "----" + m.info());
        suger s = new suger(m);
        System.out.println(s.cost() + "-----" + s.info());
    }
}

interface Drink{
    double cost();
    String info();
}

class  coffee implements Drink{
    private int money = 10;
    private String info = "coffee";



    @Override
    public double cost() {
        return money;
    }

    @Override
    public String info() {
        return info;
    }
}

abstract class add implements Drink{
    private Drink drink;

    public add(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

class milk extends add{

    public milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 10;
    }

    @Override
    public String info() {
        return super.info()+"加了milk";

    }
}

class suger extends add{
    public suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 5;
    }

    @Override
    public String info() {
        return super.info() + "加了suger";
    }
}
