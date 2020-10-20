package test;

import client.TCPClient;

public class Client2 {
    public static void main(String[] args) {
        TCPClient tc = new TCPClient();
        tc.setVisible(true);

        TCPClient tc2 = new TCPClient();
        tc2.setVisible(true);

        TCPClient tc3 = new TCPClient();
        tc3.setVisible(true);
        TCPClient tc4 = new TCPClient();
        tc4.setVisible(true);
    }
}
