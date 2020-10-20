package IO_Uilts;

import java.io.*;

public class IO_Test {
    public static void main(String[] args) {
        IO_Uilts i = new IO_Uilts();
        //文件到文件
        /*
        try {
            InputStream is = new FileInputStream("li.text");
            OutputStream os = new FileOutputStream("dest.text",true);
            i.copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */

        //文件到字节数组
        InputStream is = null;
        ByteArrayOutputStream os = null;
        byte a[] = null;
        try {
            is = new FileInputStream("plane.png");
            os = new ByteArrayOutputStream();
            i.copy(is, os);
            a = os.toByteArray();
            System.out.println(a.length);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        //字节数组到文件
        ByteArrayInputStream is2 = new ByteArrayInputStream(a, 0, a.length);
        try {
            OutputStream os2 = new FileOutputStream("plane-copy.png");
            i.copy(is2, os2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
