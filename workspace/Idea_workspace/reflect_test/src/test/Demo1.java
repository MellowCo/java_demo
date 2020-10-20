package test;

import domain.Person;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-22 16:25
 */
public class Demo1 {

    @Test
    //使用反射之前
    public void test1() throws Exception{
        //1 通过构造器，创建对象
        Person person = new Person(1,"li",12);
        //2 调用对象的方法，无法调用私有方法
        person.pubMe("name");
        System.out.println(person);
    }

    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;

        //1 通过反射，创建对象
        Constructor<Person> constructor = personClass.getDeclaredConstructor(Integer.class, String.class,Integer.class);
        Person person = constructor.newInstance(1, "li",11);
        System.out.println(person);

        //2 调用对象指定的属性和方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        //设置public的属性
        age.set(person, 2);
        System.out.println(person);

        //调用方法
        Method setId = personClass.getDeclaredMethod("setId", Integer.class);
        setId.invoke(person, 11);
        System.out.println(person);


        //3 调用私有构造器,方法,属性
        //私有构造器
        Constructor<Person> con1 = personClass.getDeclaredConstructor(Integer.class, String.class);
        con1.setAccessible(true);
        Person wang = con1.newInstance(2, "wang");
        System.out.println(wang);

        //私有方法
        Method priMe = personClass.getDeclaredMethod("priMe", String.class);
        priMe.setAccessible(true);
        //方法返回值使用obj接收
        Object o = priMe.invoke(wang, "wang");
        System.out.println(o);

        //私有属性
        Field id = personClass.getDeclaredField("id");
        id.setAccessible(true);
        id.set(wang,11);
        System.out.println(wang);
    }


    //获取Class的4种方法
    @Test
    public void test3() throws ClassNotFoundException {
        //1 调用运行类的属性 .class
        Class<Person> per1 = Person.class;

        //2 通过运行时类的对象,getClass()
        Person person = new Person();
        Class per2 = person.getClass();

        //3 调用Class类的静态方法
        Class per3 = Class.forName("domain.Person");

        //4 使用类加载器(不常用)
        ClassLoader classLoader = Demo1.class.getClassLoader();
        Class per4 = classLoader.loadClass("domain.Person");

        System.out.println(per1 == per2);
        System.out.println(per1 == per3);
        System.out.println(per1 == per4);

    }

    @Test
    public void test4() throws Exception {
        Properties properties = new Properties();
        //1 普通
        properties.load(new FileInputStream("src\\user.properties"));

        //2 通过classloader
        InputStream is = Demo1.class.getClassLoader().getResourceAsStream("user.properties");
        properties.load(is);

        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));

    }

    @Test
    public void test5() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    @Test
    public void test6() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        //获取 public 成员变量
        Field[] fields = personClass.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("------------------");
        //获取当前类的所有变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //获取权限修饰符
            int modifiers = declaredField.getModifiers();
            //权限修饰符默认为int,转换成相应的String
            System.out.println(Modifier.toString(modifiers));

            //数据类型
            Class<?> type = declaredField.getType();
            System.out.println(type);

            //变量名
            String name = declaredField.getName();
            System.out.println(name);

            System.out.println(declaredField);
        }

    }


}
