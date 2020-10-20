package Stream;

import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args) {
        Testa t = new Testa();
        File file = new File("plane.png");

        byte b[] = t.fileToByteArray(file);
        t.byteArrayToFile(b,"111.png");
    }

}


class Testa{

    byte[] fileToByteArray(File i){
        byte a[] = new byte[102];
        FileInputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            is = new FileInputStream(i);
            int len = -1;

            while((len=is.read(a))!=-1){
                baos.write(a,0,len);
            }
            baos.flush();
            return baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    void byteArrayToFile(byte ob[],String path){
        FileOutputStream fos = null;
        File o = new File(path);

        try {
            fos = new FileOutputStream(o,true);
            fos.write(ob,0,ob.length);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
