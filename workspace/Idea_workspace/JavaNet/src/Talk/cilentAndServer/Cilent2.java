package Talk.cilentAndServer;

import Talk.CilentReceive;
import Talk.CilentSend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cilent2 {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("请输入名称");
                String name = br.readLine();
                //向本地 9999
                Socket cilent = new Socket("localhost", 9999);
                new Thread(new CilentReceive(cilent)).start();
                new Thread(new CilentSend(cilent, name)).start();

        }
}
