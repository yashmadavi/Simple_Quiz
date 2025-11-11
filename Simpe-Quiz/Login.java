package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	JLabel name ,  heading;
	JButton rules , exit;
	JTextField field;
	
	Login(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);  
		
		//icon
		ImageIcon icon = new ImageIcon("C:\\Users\\yashm\\OneDrive\\Desktop\\E-Commerce\\Practice\\quiz\\src\\image\\login.jpeg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,600,500);
		add(label);
		
	
		//heading
		heading = new JLabel("Simple Quiz");
		heading.setBounds(750 , 60, 300 ,75);
	 	heading.setFont(new Font("Viner Hand ITC" , Font.BOLD ,40));
	 	heading.setForeground(new Color(30,144,252));
		add(heading);
		
		
		//label
		name = new JLabel("Enter your name");
		name.setBounds(800,150,300,20);
		name.setFont(new Font("Mongolian Baiti" , Font.BOLD ,18));
		heading.setForeground(new Color(30,144,252));
		add(name);
		
		
		//field for name
		field = new JTextField();
		field.setBounds(735,200,300,25);
		field.setFont(new Font("Times New Roman" , Font.BOLD , 16));
		add(field);
		
		
		rules = new  JButton("Rules");
		rules.setBounds(735,270,120,25);
		rules.setBackground(new Color(30,144,252));
		rules.setForeground(Color.white);
		rules.addActionListener(this);
		add(rules);
		
		
		exit = new  JButton("Exit");
		exit.setBounds(915,270,120,25);
		exit.setBackground(new Color(30,144,252));
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		add(exit);
		
		
		setVisible(true);
		setSize(1200 , 500);
		setLocation(200 , 200);
	}
	
	
	public static void main(String[] args) {
		 new Login();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rules) {
			String name = field.getText();
			new Rules(name);
			setVisible(false);
		}else {
			setVisible(false);
		}
		
	}
}
