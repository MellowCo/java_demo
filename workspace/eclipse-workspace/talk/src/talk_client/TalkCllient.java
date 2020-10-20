package talk_client;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkCllient extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TalkCllient frame = new TalkCllient();
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
    public TalkCllient() {
        setTitle("客户端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 630, 538);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblip = new JLabel("服务器IP");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel label = new JLabel("端口");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        JLabel label_1 = new JLabel("用户名");
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        
        JButton button = new JButton("连接服务器");
        
        JLabel label_2 = new JLabel("输入消息");
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        
        JButton button_1 = new JButton("发送");
        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                            .addGap(20)
                            .addComponent(scrollPane))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                            .addGap(18)
                            .addComponent(lblip)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(label_2)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                    .addGap(37)
                                    .addComponent(button_1))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(label)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(35)
                                    .addComponent(label_1)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(button)))))
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblip)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_1)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button))
                    .addGap(28)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_2)
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_1))
                    .addGap(22)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addContainerGap())
        );
        
        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        contentPane.setLayout(gl_contentPane);
    }

}
