package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener{

	JButton playAgain;
	public Score(String name, int score) {
		
		setLayout(null);
		setBounds(600,150,750,550);
		setLocation(400 , 150);
		getContentPane().setBackground(Color.white);

		ImageIcon image = new ImageIcon("C:\\Users\\yashm\\OneDrive\\Desktop\\E-Commerce\\Practice\\quiz\\src\\image\\score.png");
		// used to set the height and width of image
		Image image2 = image.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
		ImageIcon image3 = new ImageIcon(image2);
		JLabel icon = new JLabel(image3);
		icon.setBounds(0,200,300,250);
		add(icon);
		
		JLabel heading = new JLabel("Thank you " + name + " for playing Simple Quiz");
		heading.setBounds(45,30,700,30);
		heading.setFont(new Font("Tahoma" , Font.PLAIN , 26));
//		heading.setForeground(Color.red);
		add(heading);
		
		
		JLabel result = new JLabel("Your score is " + score );
		result.setBounds(350,200,300,30);
		result.setFont(new Font("Tahoma" , Font.PLAIN , 26));
		add(result);
		
		
		playAgain = new  JButton("Play Again");
		playAgain.setBounds(380 , 270,120,30);
		playAgain.setBackground(new Color(30,144,252));
		playAgain.setForeground(Color.white);
		playAgain.addActionListener(this);
		add(playAgain);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		
		new Score("user" , 0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== playAgain) {
			new Login();
			setVisible(false);
		}
		
	}
}
