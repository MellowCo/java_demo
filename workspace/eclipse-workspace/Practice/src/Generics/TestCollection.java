package Generics;

 
import java.util.ArrayList;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        MyCollection <String> s = new MyCollection<String>();
        s.set("111", 0);
        s.set("sasdasd",1);
        System.out.println(s.get(0));
        
        ArrayList<String>  a = new ArrayList<String>();
        a.add("e");
        a.add("a");
        System.out.println(a);
        System.out.println(a.size());

    }
}

class MyCollection <E>{
    
   Object obj[] = new Object[5];
   
   public void set(E e,int index) {
       obj[index] = e;
   }
   
    public E get(int index) {
           return (E)obj[index];
       }
}