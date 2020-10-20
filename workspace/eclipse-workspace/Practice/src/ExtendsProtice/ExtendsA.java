package ExtendsProtice;

public class ExtendsA {
    int i;
    public int f(int a,int b) {

         int min;
        
        if(a>b) {
            min=a;
        }else {
            min=b;
        }
   
        for(i=min;i>2;i--) {
            if(a%i==0&&b%i==0) {
                break;
            }
        }
        return i;//最大公约数
    }
}
