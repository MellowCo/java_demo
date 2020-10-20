package UdpTest.FileUdp;


import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

//发送方
public class server {

    public static void main(String[] args) throws IOException {
        File file = new File("I:/Java/eclipse-workspace/JavaNet/文件/server/li.text");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        DatagramSocket serds = new DatagramSocket(6666);

        int len = -1;
        byte datas[] = new byte[1024];

        while ((len = bis.read(datas)) != -1) {
            baos.write(datas,0,len);
        }
        byte flush[] = baos.toByteArray();

        DatagramPacket dp = new DatagramPacket(flush,flush.length,new InetSocketAddress("localhost",9999));
        serds.send(dp);
        serds.close();
        bis.close();
    }
}
