package server;

import utils.CloseStream;
import utils.TableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainServer implements Runnable{
    private Socket s = null;
    private JTextArea area;
    private  DefaultTableModel dt;
    private JScrollPane jp;
    private static CopyOnWriteArrayList<MainServer> clients = new CopyOnWriteArrayList<>();
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private String loginTime;
    private String msg = null;
    private String name;
    private boolean flag = true;

    //初始化
    public MainServer(Socket s, JTextArea area, DefaultTableModel dt,JScrollPane jp) {
        this.s = s;
        this.area = area;
        this.dt = dt;
        this.jp = jp;
        try {
            dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
            //保存登陆时间
            loginTime = timeFormat();
            //向容器中添加对象
            clients.add(this);
            //接收客户端的用户名
            receName();
            //发送欢迎语句
            welcome();
            //更新表格的信息
            updateTable();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("初始化异常");
            release();
        }
    }

    //接收客户端信息
    void receive() {
        try {
            msg = dis.readUTF();
            System.out.println("msg:"+msg);
        } catch (IOException e) {
            //客户端退出，会有异常
            // e.printStackTrace();
            // System.out.println("receive异常");
            release();
        }
    }

    //接收name
    void receName() {
        try {
            name = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("receName异常");
            release();
        }
    }

    //群聊格式 time-xx说msg
    String publicMsg() {
        return timeFormat() + "-" + name + "说\n" + msg;
    }

    //群聊发送方: time-你说msg
    String publicMsg(int type) {
        return timeFormat() + "-你" + "说\n" + msg;
    }

    //私聊格式:time-xx悄悄对你说msg
    String privateMsg() {
        return timeFormat() + "-" + name + "悄悄对你说\n" + msg;
    }

    //服务器端私聊格式: time-xx悄悄对xx说msg
    String privateMsg(String name) {
        return timeFormat() + "-" + this.name + "悄悄对" + name + "说\n" + msg;
    }

    //私聊发送方: time-你悄悄对xx说msg
    String privateMsg(String name, int type) {
        return timeFormat() + "-你" + "悄悄对" + name + "说\n" + msg;
    }

    //发送消息
    void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("send异常");
            release();
        }
    }


    //向所有用户转发欢迎消息,并发送所有的在线用户
    void welcome() {
        sendOther("服务器消息:欢迎" + name + "来到聊天室!!!!&" + TableUtils.listToString(clients, 2));
    }

    //向所有用户转发离开,并重新发送所有的在线用户
    void leave() {
        sendOther("服务器消息:" + name + "离开聊天室&" + TableUtils.listToString(clients, 2));
    }

    //处理时间,转换时间格式
    String timeFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    //异常，释放资源
    //模拟退出
    void release() {
            //停止循环
            flag = false;
            msg = null;
            //从容器中移除这个对象
            clients.remove(this);
            //退出后，更新表格的用户信息
            updateTable();
            //转发离开
            leave();
            //关闭所有流
            CloseStream.closeAll(dis, dos, s);
    }


    //关闭所有线程
    public void destory(){
        for (MainServer client : clients) {
            client.release();
        }
    }

    //更新登陆表格的用户
    void updateTable() {
        TableUtils.listToTable(dt, clients, 1);
    }

    //文本区添加信息，滚动条自动保持在下方
    void append(String msg){
        TableUtils.append(area,jp,msg);
    }

    //向所有客户端发送消息
    void sendOther(String msg) {
        //msg为空或""不转发
        if (msg != null && !"".equals(msg)) {
            //私聊
            //客户端发送的格式为 @ id : msgxxxxx
            //如果接收到的消息以@开头,启动私聊
            if (msg.startsWith("@")) {
                //根据 @ 将msg分为2部分
                //0 @
                //1 id : msgxxxxx
                String[] one = msg.split("@");

                //再根据 : 将 id 和 msg消息分离
                //0 id
                //1 msgxxxxx
                String[] two = one[1].split(":");
                int id = -1;

                try {
                    //如果id不为数字，id=aaa，则无法转换，会报NumberFormatException异常
                    id = Integer.parseInt(two[0]);
                } catch (NumberFormatException e) {
                    //异常处理:向发送方，发出提示
                    send("错误:私聊格式错误!!!");
                }

                //如果id != -1，则id转换成功
                if (id != -1) {
                    //如果msg为空，这two[1]不存在，会报ArrayIndexOutOfBoundsException异常

                    this.msg = null;
                    try {
                        this.msg = two[1];
                    }catch (ArrayIndexOutOfBoundsException e){
                        //异常处理:向发送方，发出提示
                        send("错误:私聊信息为空!!!");
                    }

                    //msg 不为null 向对方发送消息
                    if(this.msg != null){
                        String name = clients.get(id).getName();

                        //向自己转发私聊消息
                        send(privateMsg(name, 1));

                        for (MainServer client : clients) {
                            //在容器中，找到对应下标的对象
                            if (clients.indexOf(client) == id) {
                                //以私聊的格式,单发给他
                                client.send(privateMsg());
                                //找到私聊对象，跳出循环
                                break;
                            }
                        }
                        //将私聊消息 在服务器上显示
                        append(privateMsg(name));
                    }
                }

            } else if (msg.startsWith("服务器")) {
                //服务器消息,不添加相应的格式
                for (MainServer client : clients) {
                    client.send(msg);
                }
                append(msg.split("&")[0]);
            } else {
                //群聊，以群聊的格式发送给所有人
                for (MainServer client : clients) {
                    //对自己和其他人，使用不同格式
                    if(client == this){
                        send(publicMsg(1));
                    }else{
                        client.send(publicMsg());
                    }
                }
                append(publicMsg());
            }
        }
    }

    @Override
    public void run() {
        while (flag) {
            receive();
            sendOther(msg);
        }
    }


    public Socket getS() {
        return s;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getName() {
        return name;
    }

    public MainServer() {
    }
}
