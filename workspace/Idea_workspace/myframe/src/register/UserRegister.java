package register;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Font;


/*
 * 用户注册
 */
public class UserRegister extends JFrame {

    private JPanel contentPane; 
    private final ButtonGroup sexRb = new ButtonGroup();//性别按钮组
    private JTextField id; //id输入框
    private JPasswordField pwd;//密码输入框
    private JPasswordField comfirmPwd;//密码确认框
    private JTextField age;//年龄输入框
    private JTextField income;//收入输入框

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegister frame = new UserRegister();
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
    public UserRegister() {
        setTitle("用户注册");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 374, 390);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("帐号");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        id = new JTextField();
        id.setColumns(10);
        
        JLabel label = new JLabel("密码");
        label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        JLabel label_1 = new JLabel("确认密码");
        label_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        JLabel label_2 = new JLabel("年龄");
        label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        JLabel label_3 = new JLabel("性别");
        label_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        JLabel label_4 = new JLabel("收入");
        label_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
        
        pwd = new JPasswordField();
        
        comfirmPwd = new JPasswordField();
        
        age = new JTextField();
        age.setColumns(10);
        
        income = new JTextField();
        income.setColumns(10);
        
        JRadioButton male = new JRadioButton("男");
        sexRb.add(male);
        
        JRadioButton female = new JRadioButton("女");
        sexRb.add(female);
        
        JButton comfirmBut = new JButton("注册");
        
        JButton cancelBut = new JButton("取消");
        
        //添加确定按钮事件
        comfirmBut.addActionListener(new ActionListener() {
            
            //按下确定按钮，将注册信息提交到Login窗口，并根据文本框的值弹出警告框
            public void actionPerformed(ActionEvent e) {
                //用户名不能为空
                if(id.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空");
                }else if(pwd.getText().length() < 6) {
                  //密码长度不能小于6位
                    JOptionPane.showMessageDialog(null,"密码长度不能小于6位!!!");

                }else if(!pwd.getText().equals(comfirmPwd.getText())) {
                    //两次输入的密码不同
                    JOptionPane.showMessageDialog(null,"两次输入的密码不同！！！");
                }else if(!male.isSelected() && !female.isSelected()){
                    //必须选择性别
                    JOptionPane.showMessageDialog(null,"请选择性别!!");
                }else {
                    String sex = male.isSelected() ? male.getText() :female.getText();
                    String info = "帐号:" + id.getText() + "\n密码:" + pwd.getText() +
                            "\n性别:" + sex + "\n年龄:" + age.getText() + "\n收入:" + income.getText();  
                    new Login(info);
                }
               
            }
        });
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(44)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addGap(42)
                            .addComponent(male)
                            .addGap(18)
                            .addComponent(female))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(age, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(comfirmPwd))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(pwd))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(id, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addComponent(comfirmBut)
                                .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(income, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(51)
                                    .addComponent(cancelBut)))))
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(33)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comfirmPwd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(age, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(female)
                        .addComponent(male))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(income, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(comfirmBut)
                        .addComponent(cancelBut))
                    .addContainerGap(46, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
