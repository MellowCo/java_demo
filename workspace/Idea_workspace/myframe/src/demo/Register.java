package demo;

import util.JfUtil;

import javax.swing.*;
import java.awt.*;

/* 
 * 注册
 */
public class Register {
    public static void main(String[] args) {
        //设置窗口属性
        JFrame jf = JfUtil.setJf("注册",250,200,200,200);

        //流式布局
        jf.setLayout(new FlowLayout());
        jf.add(new JLabel("帐号"));
        jf.add(new JTextField(10));
        jf.add(new JButton("确定"));

        jf.add(new JLabel("姓名"));
        jf.add(new JTextField(10));
        jf.add(new JButton("取消"));

        //设置关闭
        JfUtil.close(jf);
    }
}
