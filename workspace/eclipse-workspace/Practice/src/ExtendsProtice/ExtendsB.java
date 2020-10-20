package ExtendsProtice;

public class ExtendsB extends ExtendsA {
    public int f(int a,int b) {
        int j=(a*b)/super.f(a,b);
        System.out.println(j);
        int max,i;
        
        if(a>b) {
            max=a;
        }else {
            max=b;
        }
   
        for(i=2;i<max;i++) {
            if(a%i==0&&b%i==0) {
                break;
            }
        }
        return i;//最小公约数
    }
}
