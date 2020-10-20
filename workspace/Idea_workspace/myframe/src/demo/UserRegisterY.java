package demo;

import util.JfUtil;

import javax.swing.*;
import java.awt.*;


/*
 * 用户注册
 * box y
 */
public class UserRegisterY {
    public static void main(String[] args) {
        //设置窗口属性
        JFrame jf = JfUtil.setJf("用户注册", 300, 250, 500, 500);

        JPanel basePanel = new JPanel();
        basePanel.setLayout(null);

        //左边标签区
        Box labelBox = Box.createVerticalBox();
        labelBox.add(new JLabel("帐号"));
        labelBox.add(Box.createVerticalStrut(8));
        labelBox.add(new JLabel("密码"));
        labelBox.add(Box.createVerticalStrut(8));
        labelBox.add(new JLabel("确定密码"));
        labelBox.add(Box.createVerticalStrut(8));
        labelBox.add(new JLabel("年龄"));
        labelBox.add(Box.createVerticalStrut(15));
        labelBox.add(new JLabel("性别"));
        labelBox.add(Box.createVerticalStrut(10));
        labelBox.add(new JLabel("收入"));
        labelBox.setBounds(40,5,100,150);
        basePanel.add(labelBox);

        //右边文本框
        Box textBox = Box.createVerticalBox();
        textBox.add(new JTextField(10));

        textBox.add(new JTextField(10));
        textBox.add(new JTextField(10));
        textBox.add(new JTextField(10));

        //性别单选按钮
        JPanel checkPanel = new JPanel();
        ButtonGroup sexRb = new ButtonGroup();
        JRadioButton maleRb = new JRadioButton("男");
        JRadioButton femaleRb = new JRadioButton("女");

        sexRb.add(maleRb);
        sexRb.add(femaleRb);

        checkPanel.add(maleRb);
        checkPanel.add(femaleRb);

        textBox.add(checkPanel);
        textBox.add(new JTextField(10));
        basePanel.add(textBox);
        textBox.setBounds(140,5,100,150);

        //按钮
        JPanel buPanel = new JPanel();
        buPanel.add(new JButton("确定"));
        buPanel.add(new JButton("取消"));

        jf.add(basePanel,BorderLayout.CENTER);
        jf.add(buPanel, BorderLayout.SOUTH);


        //关闭
        JfUtil.close(jf);
    }
}
