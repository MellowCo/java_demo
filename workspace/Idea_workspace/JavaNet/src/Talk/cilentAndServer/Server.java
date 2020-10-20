package Talk.cilentAndServer;

import Talk.ServerDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //建立9999的服务器端
        ServerSocket ss = new ServerSocket(9999);

        int i = 0;
        while (true) {
            //接收客户端的连接
            i++;
            Socket cilent = ss.accept();
            System.out.println(i + "个客户端建立连接");
            new Thread(new ServerDemo(cilent)).start();
        }

    }

}
