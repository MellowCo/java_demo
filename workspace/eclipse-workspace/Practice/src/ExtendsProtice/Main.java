package ExtendsProtice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
         int i=sca.nextInt();
         int j=sca.nextInt();
        ExtendsA a=new ExtendsA();
        ExtendsB b=new ExtendsB();
        System.out.println(a.f(i,j));
       System.out.println(b.f(i,j));
        sca.close();
    }
}
