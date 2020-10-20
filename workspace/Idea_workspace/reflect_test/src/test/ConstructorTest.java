package test;

import domain.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-24 10:25
 */
public class ConstructorTest {

    @Test
    public void tet1(){
        Class<Person> personClass = Person.class;

        //获取 public 的构造方法
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //获取所有的构造方法
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
}
