package Generics;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap <Integer,Empleoo>map = new HashMap<>();
        
        Empleoo e1 = new Empleoo("li",111,12);
        Empleoo e2 = new Empleoo("li2",112,13);
        Empleoo e3 = new Empleoo("li3",113,15);
        
        map.put(111,e1);
        map.put(112,e2);
        map.put(113,e3);
      //第一种遍历
        for(Integer temp : map.keySet()) {
            System.out.println(temp + "---" + map.get(temp));
        }
        
        System.out.println("=============");
        
        //第二种遍历
        Set<Entry<Integer,Empleoo>> s = map.entrySet();
        Iterator<Entry<Integer,Empleoo>> l  = s.iterator();
        while(l.hasNext()) {
            System.out.println(l.next());
        }
        
        System.out.println("=============");
        
        //第三种遍历
        for(Map.Entry<Integer,Empleoo> entry :  map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        
    }
}

class Empleoo{
    private String name;
    private int sno;
    private int age;
    
    public String getName() {
        return name;
    }
    public int getSno() {
        return sno;
    }
    public int getAge() {
        return age;
    }
    
    public Empleoo(String name, int sno, int age) {
        super();
        this.name = name;
        this.sno = sno;
        this.age = age;
    }
    
    public String toString() {
        return "Empleoo [name=" + name + ", sno=" + sno + ", age=" + age + "]";
    }
    
}
    
    
    
