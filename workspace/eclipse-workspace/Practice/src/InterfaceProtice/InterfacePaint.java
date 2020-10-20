package InterfaceProtice;

public interface InterfacePaint {
    void paint();
}

class paint1 implements InterfacePaint{
    public void paint() {
        System.out.println("paint1");
    }
}

class paint2 implements InterfacePaint{
    public void paint() {
       System.out.println("paint2");
    }
}

class paint3 implements InterfacePaint{
    public void paint() {
        System.out.println("paint3");
    }
}