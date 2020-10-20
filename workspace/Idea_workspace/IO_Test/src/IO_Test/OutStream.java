package IO_Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class OutStream {

    public static void main(String[] args) {
        File file = new File("dest.text");
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
            String msg = "faaaaaaaaaaaaaaaaaaaaasssssssssssss";
            byte flush[] = msg.getBytes("utf8");
            
            fos.write(flush,0,flush.length);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
