package UdpTest;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//发送方
public class server {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方——————————————");
        Scanner sca = new Scanner(System.in);
        while (sca.hasNext()) {
            String msg = sca.nextLine();
            serverSend(msg);
            if(msg.equals("exit")){
                sca.close();
                System.out.println("发送结束");
                break;
            }
        }


    }

    static void serverSend(String msg) throws IOException {
        byte datas[] = msg.getBytes();
        InetAddress a = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(datas, 0, datas.length, a, 9999);

        //创建DatagramSocket 发送（send）数据
        DatagramSocket ds = new DatagramSocket(8882);
        ds.send(dp);
        ds.close();
    }
}
