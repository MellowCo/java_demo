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
        //先移除表格中所有用户信息
        //如果表格行数大于0，移除第一行
        while ((row = dt.getRowCount()) > 0) {
            dt.removeRow(0);
        }
    }

    //更新登陆表格的用户
    public static void updateTable(DefaultTableModel dt, ArrayList<String[]> datas, int type) {
        deleteTable(dt);

        if (datas != null) {
            //type 为 1 更新服务器的表格
            if (type == 1) {
                //移除后，根据容器中信息更新表格信息
                for (String[] data : datas) {
                    dt.addRow(data);
                }
            } else {
                //type 为 2 更新客户端的表格
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

    //添加信息后，使滚动条自动保持在最下方
    public static void append(JTextArea area, JScrollPane jp, String msg) {
        area.append(msg + "\n");

        int maxHeight = jp.getVerticalScrollBar().getMaximum();
        jp.getViewport().setViewPosition(new Point(0, maxHeight));
        jp.updateUI();
    }

}
