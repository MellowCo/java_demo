package client;

import server.MainServer;
import utils.CloseStream;
import utils.TableUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientReceive implements Runnable {
    private JTextArea area;
    private Socket s = null;
    private DataInputStream dis = null;
    private String msg;
    private DefaultTableModel dtc;
    private CopyOnWriteArrayList<MainServer> clients = null;
    private boolean flag = true;
    private JButton startBu;
    private JButton sendBu;
    private JButton closeBu;
    private JScrollPane jp;

    public ClientReceive(JTextArea area, Socket s, DefaultTableModel dtc,JButton startBu,JButton sendBu,JButton closeBu,JScrollPane jp) {
        this.area = area;
        this.s = s;
        this.dtc = dtc;
        this.startBu = startBu;
        this.sendBu = sendBu;
        this.closeBu = closeBu;
        this.jp = jp;
        try {
            dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ClientReceive 异常");
            release();
        }
    }



    //更新登陆表格的用户
    void updateTable(String s) {
        TableUtils.stringToTable(dtc, s, 2);
    }

    //异常释放资源
    void release() {
        flag = false;
        CloseStream.closeAll(dis, s);
    }

    //文本区添加信息，滚动条自动保持在下方
    void append(String msg){
        TableUtils.append(area,jp,msg);
    }

    //接收服务器转发的消息
    void receive() {
        try {
            String msg = dis.readUTF();
            System.out.println(msg);
            if (msg.startsWith("服务器消息")) {
                String[] s = msg.split("&");
                updateTable(s[1]);
                append(s[0]);
            } else {
                append(msg);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"与服务器断开连接");
            //使连接按钮重新启用,发送按钮不可用
            startBu.setEnabled(true);
            sendBu.setEnabled(false);
            closeBu.setEnabled(false);
            area.setText("");

            //清空在线用户表格
            TableUtils.updateTable(dtc,null,2);
            release();
        }
    }

    @Override
    public void run() {
        while (flag) {
            receive();
        }
    }
}
