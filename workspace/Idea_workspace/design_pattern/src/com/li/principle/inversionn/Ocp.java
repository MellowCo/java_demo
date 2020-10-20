package com.li.principle.inversionn;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-27 10:19
 */
public class Ocp {
    public static void main(String[] args) {
        new GraphicEditor().drawShape(new Circle());
    }
}

//这是一个用于绘图的类 [使用方]
class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }

}

abstract class Shape {
    int m_type;

    abstract public void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("正方形");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("圆");
    }
}
