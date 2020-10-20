package 装饰类;

public class Project2 {
    public static void main(String[] args) {
        person p = new person();
        p.setVoice(10);
        p.say();

        big b = new big(p);
        b.say();
    }
}

interface say{
    void say();
}

class person implements say{
    private int voice;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    @Override
    public void say() {
        System.out.println("声音" + voice);
    }
}

class big implements say{
    private person p;

    public big(person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("声音" + p.getVoice()*10);
    }
}
