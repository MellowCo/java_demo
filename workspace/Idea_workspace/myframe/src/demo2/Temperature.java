package demo2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 实现温度转换
 * 继承JFrame
 */
public class Temperature extends JFrame {

    private JPanel contentPane;
    private JTextField fahrenheit;  //华氏度文本框
    private JTextField centigrade;  //摄氏度文本框

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Temperature frame = new Temperature();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Temperature() {
        //设置窗口属性
        setTitle("温度转换");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 189);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        //添加华氏度文本框
        JLabel lblNewLabel = new JLabel("请输入华氏温度值");
        fahrenheit = new JTextField();
        fahrenheit.setColumns(10);
        
        //添加摄氏度文本框
        JLabel label = new JLabel("转换后的摄氏温度值");
        centigrade = new JTextField();
        centigrade.setColumns(10);
        
        //添加转换按钮
        JButton convert = new JButton("开始转换");
        //设置转换按钮监听事件，实现温度转换
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fh = Integer.parseInt(fahrenheit.getText());
                int ct = (fh - 32) * 5 /9;
                centigrade.setText(Integer.toString(ct));
            }
        });
        
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(28)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(20)
                                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(fahrenheit, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(centigrade, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(84)
                            .addComponent(convert, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(46, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(fahrenheit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(centigrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(convert)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
