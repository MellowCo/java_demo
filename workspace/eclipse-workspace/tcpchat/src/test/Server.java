package test;

import server.TCPServer;

public class Server {
    public static void main(String[] args) {
        TCPServer ts = new TCPServer();
        ts.setVisible(true);
    }
}
