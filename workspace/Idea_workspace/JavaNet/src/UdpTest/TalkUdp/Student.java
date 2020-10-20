package UdpTest.TalkUdp;

public class Student {
    public static void main(String[] args) {
        //发送
        new Thread(new serverPort(8888,"localhost",7777)).start();
        //接收
        new Thread(new cilentPort(9999,"teacher")).start();
    }
}
