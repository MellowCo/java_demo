package Tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class TwoWayServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);

        Socket cilent = ss.accept();
        System.out.println("客户端连接成功");
        DataInputStream dis = new DataInputStream(cilent.getInputStream());
        String msg = dis.readUTF();

        String a[] = msg.split("&");
        String uname="";
        String password="";

        for (String temp : a) {
            String b[] = temp.split("=");
            if(b[0].equals("uname")){
                uname = b[1];
            }else if (b[0].equals("password")){
                password = b[1];
            }
        }


        if(uname.equals("li")&&password.equals("qwer1234")){
            DataOutputStream dos = new DataOutputStream(cilent.getOutputStream());
            dos.writeUTF("登陆成功!!!");
            dos.flush();
            dos.close();
        }else{
            DataOutputStream dos = new DataOutputStream(cilent.getOutputStream());
            dos.writeUTF("登陆失败!!!");
            dos.flush();
            dos.close();
        }

        dis.close();
        cilent.close();
        ss.close();
    }
}
