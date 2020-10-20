package IO_Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {

    static void reader(File i) {
        FileReader fr = null;
        
        try {
            fr = new FileReader(i);
            char c[] = new char[1024]; 
            int len = -1;
            while((len=fr.read(c))!=-1) {
                System.out.println(new String(c,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    static void writer(File o) {
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(o,true);
            fw.append("aaaaaaaaaaaaaaa").append("fffffffffffffffff").append("assssssssssss");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        File i = new File("li.text");
        reader(i);
        File o = new File("dest.text");
        writer(o);
    }
    
}

