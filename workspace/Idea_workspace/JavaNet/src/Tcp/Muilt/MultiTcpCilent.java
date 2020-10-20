package Tcp.Muilt;


import java.io.*;
import java.net.Socket;

public class MultiTcpCilent {

}

class cilent {
    private BufferedReader br;
    private String uname;
    private String password;
    private boolean pass;

    private Socket cilent;
    private DataOutputStream dos;
    private DataInputStream dis;


    public cilent(Socket cilent) throws IOException {
        this.cilent = cilent;
        br = new BufferedReader(new InputStreamReader(System.in));
        dos = new DataOutputStream(cilent.getOutputStream());
        dis = new DataInputStream(cilent.getInputStream());
    }

    boolean init() throws IOException {
        System.out.println("输入用户名:");
        uname = br.readLine();
        System.out.println("输入密码:");
        password = br.readLine();
        dos.writeUTF("uname:" + uname + "&" + "password:" + password);
        dos.flush();

        System.out.println(dis.readUTF());
        boolean p = dis.readBoolean();

        return p;
    }





}

class cilentSend implements Runnable {
    private BufferedReader br;
    private String msg;
    private DataOutputStream dos;

    public cilentSend(Socket cilent) {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(cilent.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                msg = br.readLine();
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

class cilentReive implements Runnable {
    private DataInputStream dis;

    public cilentReive(Socket cilent) {
        try {
            dis= new DataInputStream(cilent.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String msg;
        while (true) {
            try {
                msg = dis.readUTF();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

class cilentActul{
    private Socket cilent;

    public cilentActul(Socket cilent) {
        this.cilent = cilent;
    }

    void begin(){
        boolean pass ;
        try {
            cilent c1 = new cilent(cilent);

            pass = c1.init();

            if (pass) {
                new Thread(new cilentReive(cilent)).start();
                new Thread(new cilentSend(cilent)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}