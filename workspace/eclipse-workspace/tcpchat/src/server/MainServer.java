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

    //��ʼ��
    public MainServer(Socket s, JTextArea area, DefaultTableModel dt,JScrollPane jp) {
        this.s = s;
        this.area = area;
        this.dt = dt;
        this.jp = jp;
        try {
            dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
            //�����½ʱ��
            loginTime = timeFormat();
            //����������Ӷ���
            clients.add(this);
            //���տͻ��˵��û���
            receName();
            //���ͻ�ӭ���
            welcome();
            //���±�����Ϣ
            updateTable();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("��ʼ���쳣");
            release();
        }
    }

    //���տͻ�����Ϣ
    void receive() {
        try {
            msg = dis.readUTF();
            System.out.println("msg:"+msg);
        } catch (IOException e) {
            //�ͻ����˳��������쳣
            // e.printStackTrace();
            // System.out.println("receive�쳣");
            release();
        }
    }

    //����name
    void receName() {
        try {
            name = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("receName�쳣");
            release();
        }
    }

    //Ⱥ�ĸ�ʽ time-xx˵msg
    String publicMsg() {
        return timeFormat() + "-" + name + "˵\n" + msg;
    }

    //Ⱥ�ķ��ͷ�: time-��˵msg
    String publicMsg(int type) {
        return timeFormat() + "-��" + "˵\n" + msg;
    }

    //˽�ĸ�ʽ:time-xx���Ķ���˵msg
    String privateMsg() {
        return timeFormat() + "-" + name + "���Ķ���˵\n" + msg;
    }

    //��������˽�ĸ�ʽ: time-xx���Ķ�xx˵msg
    String privateMsg(String name) {
        return timeFormat() + "-" + this.name + "���Ķ�" + name + "˵\n" + msg;
    }

    //˽�ķ��ͷ�: time-�����Ķ�xx˵msg
    String privateMsg(String name, int type) {
        return timeFormat() + "-��" + "���Ķ�" + name + "˵\n" + msg;
    }

    //������Ϣ
    void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("send�쳣");
            release();
        }
    }


    //�������û�ת����ӭ��Ϣ,���������е������û�
    void welcome() {
        sendOther("��������Ϣ:��ӭ" + name + "����������!!!!&" + TableUtils.listToString(clients, 2));
    }

    //�������û�ת���뿪,�����·������е������û�
    void leave() {
        sendOther("��������Ϣ:" + name + "�뿪������&" + TableUtils.listToString(clients, 2));
    }

    //����ʱ��,ת��ʱ���ʽ
    String timeFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    //�쳣���ͷ���Դ
    //ģ���˳�
    void release() {
            //ֹͣѭ��
            flag = false;
            msg = null;
            //���������Ƴ��������
            clients.remove(this);
            //�˳��󣬸��±����û���Ϣ
            updateTable();
            //ת���뿪
            leave();
            //�ر�������
            CloseStream.closeAll(dis, dos, s);
    }


    //�ر������߳�
    public void destory(){
        for (MainServer client : clients) {
            client.release();
        }
    }

    //���µ�½�����û�
    void updateTable() {
        TableUtils.listToTable(dt, clients, 1);
    }

    //�ı��������Ϣ���������Զ��������·�
    void append(String msg){
        TableUtils.append(area,jp,msg);
    }

    //�����пͻ��˷�����Ϣ
    void sendOther(String msg) {
        //msgΪ�ջ�""��ת��
        if (msg != null && !"".equals(msg)) {
            //˽��
            //�ͻ��˷��͵ĸ�ʽΪ @ id : msgxxxxx
            //������յ�����Ϣ��@��ͷ,����˽��
            if (msg.startsWith("@")) {
                //���� @ ��msg��Ϊ2����
                //0 @
                //1 id : msgxxxxx
                String[] one = msg.split("@");

                //�ٸ��� : �� id �� msg��Ϣ����
                //0 id
                //1 msgxxxxx
                String[] two = one[1].split(":");
                int id = -1;

                try {
                    //���id��Ϊ���֣�id=aaa�����޷�ת�����ᱨNumberFormatException�쳣
                    id = Integer.parseInt(two[0]);
                } catch (NumberFormatException e) {
                    //�쳣����:���ͷ���������ʾ
                    send("����:˽�ĸ�ʽ����!!!");
                }

                //���id != -1����idת���ɹ�
                if (id != -1) {
                    //���msgΪ�գ���two[1]�����ڣ��ᱨArrayIndexOutOfBoundsException�쳣

                    this.msg = null;
                    try {
                        this.msg = two[1];
                    }catch (ArrayIndexOutOfBoundsException e){
                        //�쳣����:���ͷ���������ʾ
                        send("����:˽����ϢΪ��!!!");
                    }

                    //msg ��Ϊnull ��Է�������Ϣ
                    if(this.msg != null){
                        String name = clients.get(id).getName();

                        //���Լ�ת��˽����Ϣ
                        send(privateMsg(name, 1));

                        for (MainServer client : clients) {
                            //�������У��ҵ���Ӧ�±�Ķ���
                            if (clients.indexOf(client) == id) {
                                //��˽�ĵĸ�ʽ,��������
                                client.send(privateMsg());
                                //�ҵ�˽�Ķ�������ѭ��
                                break;
                            }
                        }
                        //��˽����Ϣ �ڷ���������ʾ
                        append(privateMsg(name));
                    }
                }

            } else if (msg.startsWith("������")) {
                //��������Ϣ,�������Ӧ�ĸ�ʽ
                for (MainServer client : clients) {
                    client.send(msg);
                }
                append(msg.split("&")[0]);
            } else {
                //Ⱥ�ģ���Ⱥ�ĵĸ�ʽ���͸�������
                for (MainServer client : clients) {
                    //���Լ��������ˣ�ʹ�ò�ͬ��ʽ
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
