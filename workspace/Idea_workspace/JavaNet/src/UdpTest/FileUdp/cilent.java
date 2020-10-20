package UdpTest.FileUdp;


import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


//接收方
public class cilent {

    public static void main(String[] args) throws IOException {
        File file = new File("I:/Java/eclipse-workspace/JavaNet/文件/cilent/cilent.text");
        DatagramSocket cilds = new DatagramSocket(9999);
        byte data[] = new byte[1024*100];

        DatagramPacket dp = new DatagramPacket(data,data.length);
        cilds.receive(dp);
        data = dp.getData();
        int len = dp.getLength();
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(file));
        bis.write(data,0,len);
        bis.close();
        cilds.close();


    }
}
