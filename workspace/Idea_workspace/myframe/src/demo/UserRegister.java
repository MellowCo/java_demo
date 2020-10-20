package demo;

import util.JfUtil;

import javax.swing.*;
import java.awt.*;

/*
 * 用户注册
 * box x
 */
public class UserRegister {
    public static void main(String[] args) {
        //设置窗口属性
        JFrame jf = JfUtil.setJf("用户注册", 300, 350, 500, 500);

        jf.setLayout(new BoxLayout(jf.getContentPane(),BoxLayout.Y_AXIS));

        //id标签
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("帐号"));
        idPanel.add(new JTextField(10));
        jf.add(idPanel);

        //密码
        JPanel pwdPanel = new JPanel();
        pwdPanel.add(new JLabel("密码"));
        pwdPanel.add(new JTextField(10));
        jf.add(pwdPanel);

        //确认密码
        JPanel comfirmPwdPanel = new JPanel();
        comfirmPwdPanel.add(new JLabel("确定密码"));
        comfirmPwdPanel.add(new JTextField(10));
        jf.add(comfirmPwdPanel);

        //年龄
        JPanel agePanel = new JPanel();
        agePanel.add(new JLabel("年龄"));
        agePanel.add(new JTextField(10));
        jf.add(agePanel);

        //性别
        JPanel sexPanel = new JPanel();
        sexPanel.add(new JLabel("性别"));
        ButtonGroup sexRb = new ButtonGroup();

        //男 单选按钮
        JRadioButton maleRb = new JRadioButton("男");
        sexPanel.add(maleRb);
        sexRb.add(maleRb);

        //女 单选按钮
        JRadioButton femaleRb = new JRadioButton("女");
        sexPanel.add(femaleRb);
        sexRb.add(femaleRb);

        jf.add(sexPanel);

        //收入
        JPanel incomePanel = new JPanel();
        incomePanel.add(new JLabel("收入"));
        incomePanel.add(new JTextField(10));
        jf.add(incomePanel);

        //按钮
        JPanel btPanel = new JPanel();
        btPanel.add(new JButton("确定"));
        btPanel.add(new JButton("取消"));
        jf.add(btPanel);

        //关闭
        JfUtil.close(jf);
    }

}
