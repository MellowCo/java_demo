package Stream;

import java.io.*;

public class TestStream {
    public static void reader(File i){
        FileReader fr = null;

        try {
            fr = new FileReader(i);
            int len = -1;
            char a[] = new char[1024];
            while ((len=fr.read(a))!=-1) {
                String s = new String(a,0,len);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void input(File i){
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(i);
            int len = -1;
            byte flush[] = new byte[1024];

            while ((len=fis.read(flush))!=-1){
                String s = new String(flush,0,len,"utf8");
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static void output(File i){
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(i,true);
            String msg = "发送到很快就收到房间数量肯定积分发货速度快发挥科技1";
            byte flush[] = msg.getBytes();

            fos.write(flush,0,flush.length);
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fos!=null){
                fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("li.text");
        output(file);
        input(file);
    }
}
