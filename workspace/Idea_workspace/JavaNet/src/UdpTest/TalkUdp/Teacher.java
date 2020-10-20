package UdpTest.TalkUdp;

public class Teacher {
    public static void main(String[] args) {
        //发送
        new Thread(new serverPort(4444,"localhost",9999)).start();
        //接收
        new Thread(new cilentPort(7777,"student")).start();
    }
}
