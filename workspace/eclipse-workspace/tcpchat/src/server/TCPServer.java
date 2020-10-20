package server;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer extends JFrame {

    private JPanel contentPane;
    private JTextField ipText;
    private JTextField portText;
    private JTable table;
    private JButton startBu;
    private JTextArea area;
    private DefaultTableModel dt;
    private JButton closeBu;
    private ServerSocket ss = null;
    private JScrollPane jp;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TCPServer frame = new TCPServer();
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
    public TCPServer() {
        setTitle("TCP\u670D\u52A1\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 511);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblip = new JLabel("本机IP");
        lblip.setFont(new Font("楷体", Font.PLAIN, 17));

        ipText = new JTextField();
        ipText.setColumns(10);

        JLabel label = new JLabel("\u7AEF\u53E3");
        label.setFont(new Font("楷体", Font.PLAIN, 17));

        portText = new JTextField();
        portText.setColumns(10);

        startBu = new JButton("\u5F00\u542F\u670D\u52A1\u5668");

        jp = new JScrollPane();

        closeBu = new JButton("\u5173\u95ED");
        closeBu.setEnabled(false);

        JScrollPane scrollPane_1 = new JScrollPane();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblip, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(ipText, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(portText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(startBu)
                                                .addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addComponent(closeBu)
                                                .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(jp, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(portText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(startBu)
                                                .addComponent(closeBu))
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ipText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(jp, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addContainerGap())
        );

        table = new JTable();
        scrollPane_1.setViewportView(table);


        dt = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "用户名 ", "主机IP", "主机端口", "登陆时间"
                }
        );

        table.setModel(dt);

        area = new JTextArea();
        jp.setViewportView(area);
        contentPane.setLayout(gl_contentPane);

        ipText.setText("localhost");
        portText.setText("9999");


        //开启服务器
        startBu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBuAction(e);
            }
        });

        closeBu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeBuAction(e);
            }
        });
    }

    void startBuAction(ActionEvent e) {

        try {
            ss = new ServerSocket(Integer.parseInt(portText.getText()));
            area.setText("开启服务器!!!\n");
            new Thread(new StartServer(ss, dt, area,jp)).start();
            startBu.setEnabled(false);
            closeBu.setEnabled(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void closeBuAction(ActionEvent e) {
        try {
            ss.close();
            startBu.setEnabled(true);
            closeBu.setEnabled(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
