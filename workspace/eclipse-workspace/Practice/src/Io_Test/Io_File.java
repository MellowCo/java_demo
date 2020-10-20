package Io_Test;

import java.io.File;

public class Io_File {
    public static void main(String[] args) {
        File f = new File("Io_Test");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());
        System.out.println(f.exists());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f.length());
        
    }
}
