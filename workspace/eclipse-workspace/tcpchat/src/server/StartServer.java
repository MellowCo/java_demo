package server;

import utils.CloseStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer implements Runnable{
    private ServerSocket ss = null;
    private int port;
    private boolean flag = true;
    private DefaultTableModel dt = null;
    private JTextArea area;
    private JScrollPane jp;

    public StartServer() {
    }

    public StartServer(ServerSocket ss,DefaultTableModel dt, JTextArea area,JScrollPane jp) {
        this.ss = ss;
        this.dt = dt;
        this.area = area;
        this.jp = jp;
    }

    //�쳣�ͷ���Դ
    void release() {
        flag = false;
        CloseStream.closeAll(ss);
    }

    @Override
    public void run() {
        while(flag){
            try {
                Socket s = ss.accept();
                new Thread(new MainServer(s,area,dt,jp)).start();
            } catch (IOException e) {
                //����������close��ť,�رշ�����ʱ�����쳣
                // e.printStackTrace();
                // System.out.println("StartServer run�쳣");

                //����MainServer�ر�ʹ���̵߳ķ���
                new MainServer().destory();
                release();
                area.setText("�������ѹر�!!!\n");
            }
        }
    }


}
