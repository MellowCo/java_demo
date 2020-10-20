package JavaProtice;

public class SuperProtice {
    public static void main(String[] args) {
        Average aver=new Average();
        aver.n=100.5678;
        double a=aver.f();
        double b=aver.g();
//        double b=aver.g();
//        double a=aver.f();
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}

class Sum{
    int n;
    public double f() {
        double sum=0;
        for (int i=1;i<=n;i++) {
            sum+=i;
        }
        return sum;
    }
}

class Average extends Sum{
    double n;
    public double f() {
        double c;
        super.n=(int)n;
        c=super.f();
        return c+n;
    }


    public double g() {
        double c;
        c=super.f();
        return c-n;
    }
}

