package client;

import utils.CloseStream;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient extends JFrame {

    private JPanel contentPane;
    private JTextField ipText;
    private JTextField portText;
    private JTextArea showArea;
    private JTextArea msgArea;
    private JButton startBu;
    private DefaultTableModel dtc;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField name;
    private JRadioButton group;
    private JRadioButton priva;
    private Socket s = null;
    private DataOutputStream dos = null;
    private JTable table;
    private JButton sendBu;
    private JButton closeBu;
    private JScrollPane jp;
    private JScrollPane showJp;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TCPClient frame = new TCPClient();
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
    public TCPClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblip = new JLabel("\u670D\u52A1\u5668IP");

        ipText = new JTextField();
        ipText.setColumns(10);

        JLabel label = new JLabel("\u7AEF\u53E3");

        portText = new JTextField();
        portText.setColumns(10);

        startBu = new JButton("\u8FDE\u63A5");

        closeBu = new JButton("\u9000\u51FA");
        closeBu.setEnabled(false);

        showJp = new JScrollPane();

        JLabel label_1 = new JLabel("\u5728\u7EBF\u7528\u6237");

        JScrollPane scrollPane_1 = new JScrollPane();

        group = new JRadioButton("\u7FA4\u804A");
        buttonGroup.add(group);
        group.setSelected(true);

        priva = new JRadioButton("\u79C1\u804A");
        buttonGroup.add(priva);

        sendBu = new JButton("\u53D1\u9001");
        sendBu.setEnabled(false);

        jp = new JScrollPane();

        JLabel label_2 = new JLabel("\u7528\u6237\u540D");

        name = new JTextField();
        name.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblip, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(ipText, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(label)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(portText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(label_2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(showJp, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                        .addComponent(jp))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_1)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(startBu)
                                                        .addComponent(group))
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(closeBu)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(4)
                                                                .addComponent(priva)
                                                                .addPreferredGap(ComponentPlacement.RELATED))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(sendBu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGap(72))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ipText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label)
                                        .addComponent(portText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startBu)
                                        .addComponent(closeBu))
                                .addGap(10)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(21)
                                                .addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE))
                                        .addComponent(showJp, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(group)
                                                        .addComponent(priva))
                                                .addGap(18)
                                                .addComponent(sendBu, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(jp, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(41)
                                .addComponent(label_1)
                                .addContainerGap(376, Short.MAX_VALUE))
        );

        table = new JTable();


        dtc = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "用户名"
                }
        );

        table.setModel(dtc);
        scrollPane_1.setViewportView(table);

        msgArea = new JTextArea();
        jp.setViewportView(msgArea);

        showArea = new JTextArea();
        showJp.setViewportView(showArea);
        contentPane.setLayout(gl_contentPane);

        ipText.setText("localhost");
        portText.setText("9999");
        name.setText("li");


        //开启客户端
        startBu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBuAction(e);
            }
        });

        //发送消息
        sendBu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendBuAction(e);
            }
        });

        //关闭当前连接，可以重新选择服务器
        closeBu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeBuAction(e);
            }
        });
    }

    //向服务器端发送name
    void sendName() {
        try {
            dos.writeUTF(name.getText());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            release();
            System.out.println("TCPServer sendName error");
        }
    }

    void startBuAction(ActionEvent e) {
        String ip = ipText.getText();
        int port = Integer.parseInt(portText.getText());
        try {
            s = new Socket(ip, port);
            //连接上服务器后，将连接按钮置为不可用
            startBu.setEnabled(false);
            sendBu.setEnabled(true);
            closeBu.setEnabled(true);
            dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

            sendName();

            //多线程启动接收消息
            new Thread(new ClientReceive(showArea, s, dtc, startBu, sendBu,closeBu,showJp)).start();
        } catch (IOException ex) {
            release();
            JOptionPane.showMessageDialog(null, "服务器未开启");
        }

    }

    void sendBuAction(ActionEvent e) {
        String msg = msgArea.getText();

        //群发
        if (group.isSelected()) {
            send(msg);
        } else {
            int row = table.getSelectedRow();

            if (row == -1) {
                //row等于-1,未选择发送对象
                JOptionPane.showMessageDialog(null, "请选择发送对象");
            } else {
                int id = Integer.parseInt((String) table.getValueAt(row, 0));
                msg = "@" + id + ":" + msg;
                System.out.println(msg);
                send(msg);
            }
        }
    }

    void closeBuAction(ActionEvent e) {
        release();
    }

    void send(String msg) {
        try {
            dos.writeUTF(msg);
            System.out.println(msg);
            dos.flush();
            msgArea.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
            release();
            System.out.println("send 异常");
        }
    }

    //异常释放资源
    void release() {
        CloseStream.closeAll(dos, s);
    }
}
