package demo2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
	JButton comJbt ;
	JTextField hua,she;
	
	
	public void init(){
		this.add(new JLabel("华氏度"));
		hua = new JTextField(10);
		this.add(hua);
		this.add(new JLabel("摄氏度"));
		
		she = new JTextField(10);
		this.add(she);
		
		comJbt = new JButton("确定");
		this.add(comJbt);
		this.add(new JButton("取消"));
		
		
	}
	
	public Window(){
		init();
		this.setBounds(100,100,200,150);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Window();
	}

}
