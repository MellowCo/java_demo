package NetAddress;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class spider {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.dianping.com/");
        HttpURLConnection con =(HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        BufferedReader bd = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf8"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("2.html")));
        String s = null;

        while ((s=bd.readLine())!=null){
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        bd.close();
    }

}
