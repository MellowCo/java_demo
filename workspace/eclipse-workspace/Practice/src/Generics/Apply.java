package Generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Apply {
    public static void main(String[] args) {
        User user1 = new User("li",12,"1992-2-23");
        User user2 = new User("wang",15,"1996-2-23");
        User user3 = new User("cheng",122,"2002-2-23");
        
        LinkedList<User> list = new LinkedList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        
        for(User temp : list) {
            System.out.println(temp);
        }
        
        System.out.println("++++++++++++++++++++++");
        
        HashMap<Integer,User> map = new HashMap<>();
        map.put(1, user1);
        map.put(2, user2);
        map.put(3, user3);
        
        for(Integer temp : map.keySet()) {
            System.out.println(temp  + "-----" + map.get(temp));
        }
        
        System.out.println("++++++++++++++++++++++");
        
       Set<Entry<Integer,User>> s = map.entrySet();
       Iterator<Entry<Integer, User>> iter = s.iterator();
       while(iter.hasNext()) {
           System.out.println(iter.next());
       }
       
       System.out.println("++++++++++++++++++++++");
       
       for(Entry<Integer,User> temp : map.entrySet()) {
           System.out.println(temp.getKey() + "====" + temp.getValue());
       }
       
     }
}


class User{
    private String name;
    private int age;
    private String date;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    public User(String name, int age, String date) {
        super();
        this.name = name;
        this.age = age;
        this.date = date;
    }
    
    public User() {
        super();
    }
   
    
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", date=" + date + "]";
    }
    
    
}