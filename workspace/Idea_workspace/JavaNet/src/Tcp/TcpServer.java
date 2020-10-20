package Tcp;

//服务器端

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1.ServerSocket创建服务器
        System.out.println("服务器");
        ServerSocket ss = new ServerSocket(9999);

        //2. accept 返回 Socket 对象
        Socket cilent = ss.accept();
        System.out.println("客户端已连接");

        //3. 建立 IO 流
        BufferedInputStream bis = new BufferedInputStream(cilent.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("fdcopy.html"));

        byte datas[] = new byte[1024];
        int len = -1;

        while ((len=bis.read(datas))!=-1){
            bos.write(datas,0,len);
        }
        bos.flush();

        //4.释放资源
        bos.close();
        bis.close();
        cilent.close();
        ss.close();
    }
}
