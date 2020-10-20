package UdpTest.TalkUdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

class Utils {

}

//发送端
class serverPort implements Runnable {
    private int serPort;
    private String serIp;
    private int toPort;
    DatagramPacket dr;
    DatagramSocket ds;

    public serverPort(int serPort, String serIp, int toPort) {
        this.serPort = serPort;
        this.serIp = serIp;
        this.toPort = toPort;
        try {
            ds = new DatagramSocket(serPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void run() {
        String msg = null;
        byte a[] = null;
        while (true) {
            try {
                if ((msg = br.readLine()) != null) {
                    a = msg.getBytes();
                }
                dr = new DatagramPacket(a, 0, a.length, new InetSocketAddress(serIp, toPort));
                ds.send(dr);
                if (msg.equals("exit")) {
                    System.out.println("发送端下线中");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ds.close();
    }
}

//接收端
class cilentPort implements Runnable {
    private int ciltPort;
    private String name;
    DatagramSocket ds;

    public cilentPort(int ciltPort,String name) {
        this.ciltPort = ciltPort;
        this.name = name;
        try {
            ds = new DatagramSocket(ciltPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        byte datas[] = new byte[1024 * 10];
        String msg = null;
        while (true) {
            DatagramPacket dp = new DatagramPacket(datas, 0, datas.length);
            try {
                ds.receive(dp);
                msg = new String(dp.getData(), 0, dp.getLength());
                System.out.println(name+":"+msg);
                if (msg.equals("exit")) {
                    System.out.println("接收端下线中");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ds.close();
    }


}