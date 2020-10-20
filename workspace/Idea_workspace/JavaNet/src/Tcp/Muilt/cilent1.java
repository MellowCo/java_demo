package Tcp.Muilt;

import java.io.IOException;
import java.net.Socket;

public class cilent1 {
    public static void main(String[] args) {
        try {
            Socket c1= new Socket("localhost",9999);
            cilentActul cilent1 = new cilentActul(c1);
            //cilent1.init();
            cilent1.begin();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
