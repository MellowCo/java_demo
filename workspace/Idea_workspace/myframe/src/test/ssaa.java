/*
 * Created by JFormDesigner on Sun Mar 10 11:09:37 CST 2019
 */

package test;

import java.awt.*;
import javax.swing.*;



/**
 * @author Brainrain
 */
public class ssaa extends JFrame {
    public ssaa() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu3 = new JMenu();
        menu4 = new JMenu();
        panel4 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("text");

                //---- menuItem3 ----
                menuItem3.setText("text");
                menu1.add(menuItem3);

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("text");
                menu1.add(menuItem2);

                //======== menu2 ========
                {
                    menu2.setText("text");

                    //---- menuItem4 ----
                    menuItem4.setText("text");
                    menu2.add(menuItem4);

                    //---- menuItem5 ----
                    menuItem5.setText("text");
                    menu2.add(menuItem5);

                    //---- menuItem6 ----
                    menuItem6.setText("text");
                    menu2.add(menuItem6);
                }
                menu1.add(menu2);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("text");
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("text");
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout());

            //---- button2 ----
            button2.setText("text");
            panel4.add(button2);

            //---- button3 ----
            button3.setText("text");
            panel4.add(button3);
        }

        //======== panel3 ========
        {
            panel3.setAlignmentX(29.5F);
            panel3.setMinimumSize(new Dimension(200, 150));
            panel3.setPreferredSize(new Dimension(200, 200));
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {110, 200};
            ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {60, 60, 60, 0};

            //---- label1 ----
            label1.setText("text");
            panel3.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 10), 0, 0));
            panel3.add(textField1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 0), 0, 0));

            //---- label2 ----
            label2.setText("text");
            panel3.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 10), 0, 0));
            panel3.add(textField4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 0), 0, 0));

            //---- label5 ----
            label5.setText("text");
            panel3.add(label5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 10), 0, 0));
            panel3.add(textField5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 10, 0), 0, 0));
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(140, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33))
        );
        setSize(600, 350);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenu menu4;
    private JPanel panel4;
    private JButton button2;
    private JButton button3;
    private JPanel panel3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
