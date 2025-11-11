package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.ButtonUI;

public class Rules extends JFrame implements ActionListener{

	JLabel heading , rulesLable;
	JButton back , start;
	
	String name ;
	Rules(String name){
		
		this.name = name;
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		//heading
		heading = new JLabel("Welcome " + name + " To Simple Quiz");
		heading.setBounds(50 , 30, 700 ,50);
	 	heading.setFont(new Font("Viner Hand ITC" , Font.BOLD ,28));
	 	heading.setForeground(new Color(30,144,252));
		add(heading);
		
		String rules = "<html>"
		        + "<h2>📋 Quiz Rules & Guidelines</h2>"
		        + "<ol>"
		        + "<li>Each question carries <b>10 mark</b>. No negative marking for wrong answers.</li> <br>"
		        + "<li>You must answer each question within the given <b>time limit</b>.</li><br>"
		        + "<li>Once you move to the next question, you <b>cannot go back</b> to the previous one.</li> <br>"
		        + "<li>Do not refresh or close the quiz window during the attempt.</li><br>"
		        + "<li>Ensure a <b>stable internet connection</b> or system runtime before starting.</li><br>"
		        + "<li>All questions are <b>mandatory</b>.</li><br>"
		        + "<li>Click on the <b>Submit</b> button after completing all questions.</li><br>"
		        + "<li>Your final score will be displayed at the end of the quiz.</li><br>"
		        + "</ol>"
		        + "<p style='color:blue;'><b>Good luck and do your best!</b></p>"
		        + "</html>";

		rulesLable = new JLabel(rules);
		rulesLable.setBounds(70,40,700,350);
		rulesLable.setSize(600 , 500);
		rulesLable.setFont(new Font("Tahoma" , Font.PLAIN , 16));
		add(rulesLable);
		
		//button
		
		back = new JButton("Back");
		back.setBounds(250,530,120,25);
		back.setBackground(new Color(30,144,252));
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		start = new JButton("Start");
		start.setBounds(400,530,120,25);
		start.setBackground(new Color(30,144,252));
		start.setForeground(Color.white);
		start.addActionListener(this);
		add(start);
		
		
		
		setSize(800 , 650);
		setVisible(true);
		setLocation(350,100);
	}
	
	public static void main(String[] args) {
		
		new Rules("user");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == start) {
			System.out.println("yash");
			new Quiz(name);
			setVisible(false);
		}else {
			new Login();
			setVisible(false);
		}
		
	}
}
