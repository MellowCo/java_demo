package InnerClass;

public class TestInnerClass {
    public static void main(String[] args) {
        OutClass.InnerClass a=new OutClass().new InnerClass();
        a.TestInnerClass();
    }
}

class OutClass{
    private int age=10;
    
    class InnerClass{
        int age=20;
        public void TestInnerClass() {
            int age=30;
           System.out.println("OutClass age="+OutClass.this.age);
           System.out.println("InnerClass age="+this.age);
           System.out.println("TestInnerClass age="+age);
        }
    }
    
}
