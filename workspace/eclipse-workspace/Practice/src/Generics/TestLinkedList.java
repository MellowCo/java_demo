package Generics;

import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList <String> l= new LinkedList<String>();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");     
       
        //1
        Iterator<String> iterator = l.iterator();
        while(iterator.hasNext()) {
            Object a = iterator.next();
            System.out.println("+++"+a);
            System.out.println(iterator.next());
//            if(a.equals("aa")) {
//                iterator.remove();
//            }else {
//                System.out.println(a);
//            }
    }

        System.out.println("+++++++++++++++++++++");
        
        
        //2
        for(String temp : l) {
            System.out.println(temp);
        }
  
     String z[] = new String[10];
     z[0] = "a";
     z[1]= "v";
     System.out.println(z);
        
      
}
}
