package test;

import domain.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @Description: 获取方法
 * @Author: li
 * @Create: 2019-09-22 21:24
 */
public class MethodRe {

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        //获取 public 方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        //获取当前类的所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }

    @Test
    public void test2() {
        Class<Person> personClass = Person.class;

        //获取当前类的所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);

            //1 获取方法的注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.print(annotation + "/t");
            }

            //2 获取权限修饰符
            System.out.println("权限:" + Modifier.toString(declaredMethod.getModifiers()));

            //3 返回值类型
            Class<?> returnType = declaredMethod.getReturnType();
            System.out.println("返回值类型:" + returnType);

            //4 方法名
            String name = declaredMethod.getName();
            System.out.println("方法名:"+name);

            //5 形参
            Parameter[] parameters = declaredMethod.getParameters();

            if(parameters.length > 0){
                for (Parameter parameter : parameters) {
                    System.out.println("形参:"+parameter);
                }
            }

            //6 异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (exceptionTypes.length > 0){
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.println("异常:"+exceptionType.getName());
                }
            }

            System.out.println();

        }
    }


}
