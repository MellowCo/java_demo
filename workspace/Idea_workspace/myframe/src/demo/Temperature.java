package demo;

import util.JfUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 实现温度转换
 */
public class Temperature {
    public static void main(String[] args) {
        //设置窗口大小，属性
//		JFrame jf = new JFrame("温度转换");
//		jf.setSize(400,120);
//		jf.setLocation(100, 100);
//		jf.getContentPane().setBackground(Color.orange);

        JFrame jf = JfUtil.setJf("温度转换", 400, 120, 100, 100);

        /**

         //创建一个JLabel box
         Box labelBox = Box.createVerticalBox();
         labelBox.add(new JLabel("请输入华氏温度值"));
         labelBox.add(new JLabel("转换后的摄氏温度值"));

         //创建一个JTextField box
         Box textBox = Box.createVerticalBox();
         textBox.add(new JTextField(10));
         textBox.add(new JTextField(10));

         //创建一个box 添加上面的文本box
         Box topBox =  Box.createHorizontalBox();
         topBox.add(labelBox);
         topBox.add(textBox);

         //添加button，完成布局
         Box baseBox = Box.createVerticalBox();
         baseBox.add(topBox);
         baseBox.add(new JButton("开始转换"));

         //将baseBox 添加到 jf窗口中
         jf.add(baseBox);
         *
         */

        //创建JPanel添加上部文本框
        JPanel jp = new JPanel();
        //设置网格布局，2行2列
        jp.setLayout(new GridLayout(2, 2));

        //添加华氏度
        jp.add(new JLabel("请输入华氏温度值"));
        final JTextField fahrenheit = new JTextField();
        jp.add(fahrenheit);

        //添加摄氏度
        jp.add(new JLabel("转换后的摄氏温度值"));
        final JTextField centigrade = new JTextField();
        jp.add(centigrade);

        //添加按钮
        jf.add(jp);
        JButton convert = new JButton("开始转换");
        //设置按钮事件
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fh = Integer.parseInt(fahrenheit.getText());
                int ct = (fh - 32) * 5 /9;
                centigrade.setText(Integer.toString(ct));
            }
        });


        jf.add(convert, BorderLayout.SOUTH);




        //设置关闭 窗口可见
        JfUtil.close(jf);
    }
}
