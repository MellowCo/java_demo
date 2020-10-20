package register;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

/*
 * 注册信息显示
 */
public class Login extends JFrame {

    private JPanel contentPane;
    private String info;
   

    /**
     * Create the frame.
     */
    public Login(String info) {
        setTitle("注册信息");
        this.info = info;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JTextArea registerIfno = new JTextArea();
        registerIfno.setFont(new Font("微软雅黑", Font.BOLD, 20));
        registerIfno.setText("注册成功!\r\n注册信息为：\r\n");
        registerIfno.append(info);
        this.setVisible(true);
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(registerIfno, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(registerIfno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        contentPane.setLayout(gl_contentPane);
    }

}
