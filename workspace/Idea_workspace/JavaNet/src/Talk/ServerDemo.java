package Talk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerDemo implements Runnable {
    private Socket cilent;
    private static CopyOnWriteArrayList<ServerDemo> sa = new CopyOnWriteArrayList<>();
    private String msg;
    String name;
    private DataInputStream dis; //输入流
    private DataOutputStream dos;//输出流
    private boolean isRuntime = true;

    public ServerDemo(Socket cilent) {
        this.cilent = cilent;
        addCilent();
        try {
            //创建流
            dis = new DataInputStream(cilent.getInputStream());
            dos = new DataOutputStream(cilent.getOutputStream());
            //接收name
            serverName();
            //加入欢迎
            popular();
        } catch (IOException e) {
            System.out.println("ServerDemo 1 异常");
            abnormal();
        }
    }

    //接收name
    void serverName() {
        try {
            this.name = dis.readUTF();
            System.out.println("name:" + name);
        } catch (IOException e) {
            System.out.println("ServerDemo serverName 异常");
            abnormal();
        }
    }


    //接收消息
    void serverRecive() {
        try {
            msg = dis.readUTF();
            System.out.println(name + ":" + msg);
        } catch (IOException e) {
            System.out.println("ServerDemo 接收消息 异常");
            abnormal();
        }

    }

    //加入欢迎
    void popular() {
        for (ServerDemo other : sa) {
            other.serverSend("欢迎" + name + "加入聊天室");
        }
    }

    //离开聊天室
    void leave() {
        for (ServerDemo other : sa) {
            other.serverSend(name + "离开聊天室");
        }
    }

    //群发消息 , 私聊 @xxx：
    void serverSendOther() {
        if (msg.startsWith("@")) {
            //私聊
            msg = msg.substring(1);
            String b[] = msg.split(":");
            for (ServerDemo other : sa) {
                if (other.name.equals(b[0])) {
                    other.serverSend(name + "私聊:" + b[1]);
                }
            }
        } else {
            for (ServerDemo other : sa) {
                if (other == this) {
                    continue;
                } else {
                    //转发消息
                    other.serverSend(name + ":" + msg);
                }
            }
        }


    }


    //转发消息
    void serverSend(String s) {
        try {
            dos.writeUTF(s);
            dos.flush();
        } catch (IOException e) {
            System.out.println("ServerDemo serverSend 异常");
            abnormal();
        }
    }

    //释放资源
    void release() {
        sa.remove(this);
        leave();
        msg = null;
        Release.close(dis, dos, cilent);
        System.out.println(name + "离开");
    }

    //出现异常，关闭流，isRuntime FALSE
    void abnormal() {
        isRuntime = false;
        release();
    }

    //增加cilent
    void addCilent() {
        sa.add(this);
    }

    // 多线程
    public void run() {
        while (isRuntime) {
            //接收消息
            serverRecive();
            if (msg == null || msg.equals("")) {
                continue;
            }
            //群发消息 , 私聊 @xxx：
            serverSendOther();
        }
    }
}
