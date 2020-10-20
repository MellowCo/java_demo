package utils;

import server.MainServer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class TableUtils {
    public static void deleteTable(DefaultTableModel dt) {
        int row;
        //���Ƴ�����������û���Ϣ
        //��������������0���Ƴ���һ��
        while ((row = dt.getRowCount()) > 0) {
            dt.removeRow(0);
        }
    }

    //���µ�½�����û�
    public static void updateTable(DefaultTableModel dt, ArrayList<String[]> datas, int type) {
        deleteTable(dt);

        if (datas != null) {
            //type Ϊ 1 ���·������ı��
            if (type == 1) {
                //�Ƴ��󣬸�����������Ϣ���±����Ϣ
                for (String[] data : datas) {
                    dt.addRow(data);
                }
            } else {
                //type Ϊ 2 ���¿ͻ��˵ı��
                for (String[] data : datas) {
                    dt.addRow(data);
                }
            }
        }
    }

    public static String listToString(CopyOnWriteArrayList<MainServer> clients, int type) {
        StringBuffer s = new StringBuffer();

        if (type == 1) {
            for (MainServer client : clients) {
                s.append(clients.indexOf(client) + "@" + client.getName() + "@" + client.getS().getInetAddress().getHostAddress() + "@" + client.getS().getPort() + "@" + client.getLoginTime() + "#");
            }
        } else {
            for (MainServer client : clients) {
                s.append(clients.indexOf(client) + "@" + client.getName() + "#");
            }
        }

        System.out.println(s.toString());

        return s.toString();
    }

    public static ArrayList<String[]> stringToStrings(String s) {
        ArrayList<String[]> datas = new ArrayList<>();

        String[] one = s.split("#");
        System.out.println(Arrays.toString(one));
        int i = 0;
        for (String ones : one) {
            datas.add(ones.split("@"));
            System.out.println(Arrays.toString(datas.get(i++)));
        }

        return datas;
    }

    public static void listToTable(DefaultTableModel dt, CopyOnWriteArrayList<MainServer> clients, int type) {
        updateTable(dt, stringToStrings(listToString(clients, type)), type);
    }

    public static void stringToTable(DefaultTableModel dt, String s, int type) {
        updateTable(dt, stringToStrings(s), type);
    }

    //�����Ϣ��ʹ�������Զ����������·�
    public static void append(JTextArea area, JScrollPane jp, String msg) {
        area.append(msg + "\n");

        int maxHeight = jp.getVerticalScrollBar().getMaximum();
        jp.getViewport().setViewPosition(new Point(0, maxHeight));
        jp.updateUI();
    }

}
