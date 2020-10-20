package demo;

import util.JfUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    
/*
 * 实现大小写转换
 */
public class Alpha {
    public static void main(String[] args) {
        //设置窗口属性
        JFrame jf = JfUtil.setJf("字母大小写转换", 370, 130, 200, 200);

        //设置网格布局 3行2列
        jf.setLayout(new GridLayout(3, 2));

        //添加组件
        jf.add(new JLabel("请输入一串英文字母"));
        final JTextField oldAlpha = new JTextField();
        jf.add(oldAlpha);

        jf.add(new JLabel("转换后的结果是"));
        final JTextField newAlpha = new JTextField();
        jf.add(newAlpha);


        //添加按钮
        JButton upperAlpha = new JButton("大写字母按钮");
        JButton lowerAlpha = new JButton("小写字母按钮");
        jf.add(upperAlpha);
        jf.add(lowerAlpha);

        //设置大写事件
        upperAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldStr = oldAlpha.getText();
                newAlpha.setText(oldStr.toUpperCase());
            }
        });

        //设置小写事件
        lowerAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldStr = oldAlpha.getText();
                newAlpha.setText(oldStr.toLowerCase());
            }
        });

        //设置关闭
        JfUtil.close(jf);
    }
}
