package IO_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamApply {
    public static void main(String[] args) {
        Apply a = new Apply();
        File i = new File("I:\\作业\\寒假作业之《网站系统设计与架构技术》");
        File o = new File("I:\\作业\\IO");
        a.copyDir(i,o);
    }
}

class Apply{
    
    //copy文件内容
    void copy(File i,File o) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            fis = new FileInputStream(i);
            byte[] flush = new byte[1024];
            int len = -1;
            
            while((len=fis.read(flush))!=-1){
                fos = new FileOutputStream(o,true);           
                fos.write(flush, 0, len);
                fos.flush();
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
                    if(fos!=null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
    
    //copy 文件和文件内容
    public void copyDir(File i,File o) { 
        //System.out.println("loading");
        if(i==null || !i.exists()) {
            System.out.println("111111111111111");
        }else if(i.isDirectory()) {
            o = new File(o,i.getName());
            o.mkdirs();
            for(File file : i.listFiles()) {
                copyDir(file,o);                
            }
        }else if(i.isFile()) {
            o = new File(o,i.getName());
            copy(i,o);
        }          
    }   
}