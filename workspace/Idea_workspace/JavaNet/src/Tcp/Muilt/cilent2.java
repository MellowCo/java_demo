package Tcp.Muilt;

import java.io.IOException;
import java.net.Socket;

public class cilent2 {
    public static void main(String[] args) {
        try {
            Socket c2= new Socket("localhost",9999);
            cilentActul cilent2 = new cilentActul(c2);
            //cilent1.init();
            cilent2.begin();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
