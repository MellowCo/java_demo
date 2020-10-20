package Tcp.Muilt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        String msg = "";

        while (true) {
            Socket cilent = ss.accept();
            System.out.println("+++++");
            new Thread(new Server(cilent, msg)).start();
        }

    }

}


class Server implements Runnable {
    private Socket cilent;
    private String msg;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean pass;

    public Server(Socket cilent, String msg) {
        this.cilent = cilent;
        this.msg = msg;
        try {
            dis = new DataInputStream(cilent.getInputStream());
            dos = new DataOutputStream(cilent.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            msg = dis.readUTF();
            System.out.println(msg);
            pass = pass(msg);
            if(pass){
                dos.writeUTF("登陆成功！！！");
                dos.writeBoolean(true);
                dos.flush();
            }else{
                dos.writeUTF("登陆失败！！！");
                dos.writeBoolean(false);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (pass) {
            try {
                 msg= dis.readUTF();
                System.out.println(msg);
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    boolean pass(String msg) {
        String a[] = msg.split("&");
        String uname = "";
        String password = "";

        for (String word : a) {
            String b[] = word.split(":");

            if (b[0].equals("uname")) {
                uname = b[1];
            } else if (b[0].equals("password")) {
                password = b[1];
            }
        }

        if (uname.equals("li") && password.equals("qwer1234")) {
            return true;
        } else {
            return false;
        }
    }

}