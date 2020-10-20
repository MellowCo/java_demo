package InterfaceProtice;

public class ImplementsProtice {
    public static void setPaint(InterfacePaint g) {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");

        g.paint();
        
        System.out.println("4");
        System.out.println("5");
    }
    
    
    public static void main(String[] args) {
        setPaint(new paint1());
        setPaint(new paint2());
        setPaint(new paint3());
        }
}

