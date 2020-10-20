package Stream;

import java.io.*;
import java.net.URL;

public class InputStreamWandR {
    public static void main(String[] args) {
        String path = "https://www.jb51.net/article/113442.htm";
        StreamWandR sw = new StreamWandR();
        FileRandW fr = new FileRandW();
          sw.copy(path);
        //fr.copy(path);
    }


}

class StreamWandR {

    public void copy(String path) {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bis = null;

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            is = new URL(path).openStream();
            isr = new InputStreamReader(is,"gbk");
            bis = new BufferedReader(isr);

            os = new FileOutputStream("li.text");
            osw = new OutputStreamWriter(os,"utf8");
            bw = new BufferedWriter(osw);
            String mag = null;

            while ((mag = bis.readLine()) != null) {
                bw.append(mag);
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bw != null) {
                    bw.close();
                }

                if (osw != null) {
                    osw.close();
                }

                if (os != null) {
                    os.close();
                }

                if (bis != null) {
                    bis.close();
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

class FileRandW {

    void copy(String path) {
        InputStream is = null;
        BufferedInputStream bis = null;

        OutputStream os = null;
        BufferedOutputStream bos = null;

        try {
            is = new URL(path).openStream();
            bis = new BufferedInputStream(is);

            os = new FileOutputStream("li.text");
            bos = new BufferedOutputStream(os);

            byte a[] = new byte[3];
            int len = -1;
            while ((len = bis.read(a)) != -1) {
                bos.write(a, 0, len);
                bos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            try {

                if (bos != null) {
                    bos.close();
                }

                if (os != null) {
                    os.close();
                }

                if (bis != null) {
                    bis.close();
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