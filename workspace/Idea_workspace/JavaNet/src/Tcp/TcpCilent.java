package Tcp;


import java.io.*;
import java.net.Socket;

//客户端
public class TcpCilent {
    public static void main(String[] args) throws IOException {
        //1.创建客户端 + 服务器地址和端口号
        Socket s = new Socket("localhost", 9999);

        //2.建立 IO 流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jd.html"));
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        byte flush[] = new byte[1024];
        int len = -1;
        while ((len = bis.read(flush)) != -1) {
            bos.write(flush, 0, len);
        }
        bos.flush();

        //3.释放资源
        bos.close();
        bis.close();
        s.close();
    }
}
