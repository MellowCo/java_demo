package NetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress a = InetAddress.getLocalHost();
        System.out.println(a.getHostAddress());
        System.out.println(a.getHostName());

        InetAddress b = InetAddress.getByName("www.baidu.com");
        System.out.println(b.toString());
        System.out.println(b.getHostAddress());
        System.out.println(b.getHostName());

        InetAddress c = InetAddress.getByName("61.135.169.125");
        System.out.println(c.toString());
        System.out.println(c.getHostAddress());
        System.out.println(c.getHostName());
    }
}
