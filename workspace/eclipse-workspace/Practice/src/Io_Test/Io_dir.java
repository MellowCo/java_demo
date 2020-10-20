package Io_Test;

import java.io.File;

public class Io_dir {
    
    static void TestDir(File f,int i) {
        for(int j=0;j<i;j++) {
            System.out.print("+");
        }
        System.out.println(f.getName());
        if(!f.exists()) {
           return;
        }else if(f.isDirectory()){
            
            for(File file:f.listFiles()) {           
                TestDir(file,i+1);
            }
        }
    }
    static long i;
    static void count(File f) {
        if(f.exists()) {
          if(f.isFile()) {
              i=i+f.length();
          }else {
              for(File s : f.listFiles()) {
                  count(s);
              }
          }
        }
    }
    
    public static void main(String[] args) {
        File newFile = new File("I:\\作业");
        TestDir(newFile,0);
        count(newFile);
        System.out.println(i);
        File f = new File("I:\\新建文件夹 (2)");
       if (f.delete()) {
           System.out.println("true");
       }else {
           System.out.println("false");
       }
    }
}

