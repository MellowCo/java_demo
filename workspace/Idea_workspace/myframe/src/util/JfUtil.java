package util;

import javax.swing.*;
import java.awt.*;

public class JfUtil {
    //设置窗口基本属性
    public static JFrame setJf(String title, int width, int height, int locationX, int locationY){
        JFrame jf = new JFrame(title);
        jf.setSize(width,height);
        jf.setLocation(locationX,locationY);
        return jf;
    }
    
    //设置窗口关闭 可见
    public static void close(JFrame jf){
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
