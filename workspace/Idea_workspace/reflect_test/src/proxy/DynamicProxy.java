package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-24 11:42
 */
interface People {
    String setName(String name);

    void eat(String food);
}


//被代理类
class Man implements People {

    @Override
    public String setName(String name) {
        return name;
    }

    @Override
    public void eat(String food) {
        System.out.println("eat:" + food);
    }
}

//动态代理
class ProxyFactory {
    public static Object getProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnVal = null;

                //执行代理的方法
                System.out.println("代理工厂做一些准备工作");
                //执行被代理类的方法
                returnVal = method.invoke(obj, args);

                //执行代理的方法
                System.out.println("代理工厂做一些后续的收尾工作");
                return returnVal;
            }
        });
    }
}

public class DynamicProxy {

    public static void main(String[] args) {
        People people = (People) ProxyFactory.getProxy(new Man());

        System.out.println(people.setName("li"));
        people.eat("aaa");
    }
}
