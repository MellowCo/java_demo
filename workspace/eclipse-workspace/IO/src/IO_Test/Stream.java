package IO_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Stream {
    public static void main(String[] args) {
     File fs = new File("l.text");
     FileInputStream fis = null;
     byte b[] = new byte[1024];
     
     
         try {
             fis = new FileInputStream(fs);
             int len = -1;
             
             while((len=fis.read(b))!=-1) {
                 String s = new String(b,0,len,"utf8");
                 System.out.println(s);
             }
             
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(fis!=null) {
                    fis.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
     
    
    }
}
