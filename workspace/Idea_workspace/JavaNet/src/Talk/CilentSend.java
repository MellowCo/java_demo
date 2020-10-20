package Talk;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端发送消息
 */
public class CilentSend implements Runnable {
    private Socket cilent;
    private String msg;

    private boolean isRuntime = true;
    private BufferedReader br;
    private DataOutputStream dos;

    public CilentSend(Socket cilent,String name) {
        this.cilent = cilent;

        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(cilent.getOutputStream());
            sendName(name);
        } catch (IOException e) {
            System.out.println("CilentSend 1 异常");
            abnormal();
        }
    }

    //发送name
    void sendName(String name){
        try {
            dos.writeUTF(name);
            dos.flush();
        } catch (IOException e) {
            System.out.println("CilentSend sendName 异常");
            abnormal();
        }
    }

    //从键盘得到字符信息
    void acquire() {
        try {
            msg = br.readLine();
        } catch (IOException e) {
            System.out.println("CilentSend acquire 异常");
            abnormal();
        }
    }

    //发送到服务器端
    void send() {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("CilentSend send 异常");
            abnormal();
        }

    }

    //释放资源
    void release() {
        Release.close(dos, br, cilent);
    }

    //出现异常，关闭流，isRuntime FALSE
    void abnormal() {
        isRuntime = false;
        release();
    }

    public void run() {
        while (isRuntime) {
            //从键盘得到字符信息
            acquire();
            //发送到服务器端
            send();
        }
    }
}
