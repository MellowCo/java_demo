import java.io.*;
import java.net.URL;

public class car {
    public static void main(String[] args) {
        InputStream is = null;
        BufferedReader isr = null;
        BufferedWriter bos = null;
        try {
            is = new URL("https://passport.zuche.com/memberManage/xtoploginMember.do").openStream();
            isr = new BufferedReader(new InputStreamReader(is));

            bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("car.html")));


            String str = null;
            while (((str = isr.readLine())) != null) {
                bos.write(str, 0, str.length());
                bos.newLine();
            }
            bos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }

                if (isr != null) {
                    isr.close();
                }

                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
