package Talk;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端接收消息
 */
public class CilentReceive implements Runnable {
    private Socket cilent;
    private String msg;
    private boolean isRuntime = true;
    private DataInputStream dis;

    public CilentReceive(Socket cilent) {
        this.cilent = cilent;
        try {
            dis = new DataInputStream(cilent.getInputStream());
        } catch (IOException e) {
            System.out.println("CilentReceive 1 异常");
            abnormal();
        }
    }

    //接收服务器的信息
    void receive() {
        try {
            msg = dis.readUTF();
            System.out.println(msg);
        } catch (IOException e) {
            System.out.println("CilentReceive receive 异常");
            abnormal();
        }

    }

    //释放资源
    void release() {
        Release.close(dis, cilent);
    }

    //出现异常，关闭流，isRuntime FALSE
    void abnormal() {
        isRuntime = false;
        release();
    }


    public void run() {
        while (isRuntime) {
            receive();
        }
    }
}
