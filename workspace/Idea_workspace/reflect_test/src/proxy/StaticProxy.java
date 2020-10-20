package proxy;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-24 11:05
 */

interface ClothFactory{
    void produceCloth();
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike 工厂.....");
    }
}

//代理类
class ProxyClothFactory implements ClothFactory {

    ClothFactory clothFactory;

    //通过构造方法，传入被代理对象
    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        //执行代理的方法
        System.out.println("代理工厂做一些准备工作");

        //执行被代理类的方法
        clothFactory.produceCloth();

        //执行代理的方法
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        new ProxyClothFactory(new NikeClothFactory()).produceCloth();
    }
}
