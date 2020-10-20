package Tcp;


import java.io.*;
import java.net.Socket;

//客户端
public class TwoWayCilent {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);


        System.out.println("客户端");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入用户名:");
        String uname = br.readLine();
        System.out.println("输入密码:");
        String password = br.readLine();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("uname=" + uname + "&" + "password=" + password);
        dos.flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        System.out.println(dis.readUTF());

        dis.close();
        dos.close();
        s.close();

    }
}
