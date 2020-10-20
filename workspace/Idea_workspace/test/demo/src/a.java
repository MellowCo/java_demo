import java.text.DecimalFormat;

public class a {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;
        System.out.println(b/a);

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(0.987));

        System.out.println(String.format("%.2f",0.987));
        double c = 0;
        System.out.println(String.format("%.2f",c/23));
    }
}
