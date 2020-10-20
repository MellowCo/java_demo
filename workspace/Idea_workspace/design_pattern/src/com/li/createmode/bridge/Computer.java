package com.li.createmode.bridge;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 14:55
 */
public class Computer {
    Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    void sale(){
        brand.sale();
    }
}

class Desktop extends Computer{

    public Desktop(Brand brand) {
        super(brand);
    }

    void sale(){
        super.sale();
        System.out.println("台式机");
    }
}

class Laptop extends Computer{

    public Laptop(Brand brand) {
        super(brand);
    }

    void sale(){
        super.sale();
        System.out.println("笔记本");
    }

}
