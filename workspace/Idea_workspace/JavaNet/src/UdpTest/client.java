package UdpTest;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


//接收方
public class client {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方++++++++++");
        boolean flag = true;
        DatagramSocket cds = new DatagramSocket(9999);
        while (flag) {
            byte data[] = new byte[1024 * 60];
            DatagramPacket cdp = new DatagramPacket(data, data.length);
            cds.receive(cdp);

            //提取数据
            data = cdp.getData();

            String msg = new String(data, 0, cdp.getLength());
            System.out.println(msg);
            if (msg.equals("exit")) {
                cds.close();
                System.out.println("接受结束");
                break;
            }

        }
    }
}
