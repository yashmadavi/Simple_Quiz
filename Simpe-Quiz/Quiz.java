package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Quiz extends JFrame implements ActionListener{

	String [][] questions = new String[10][5];    
	String[][] answers = new String[10][2];
	
	String[][] answerGiven = new String[10][1];
	
	
	JLabel qno , question;
	JButton next , submit , lifeLine;
	JRadioButton opt1, opt2, opt3,opt4;
	ButtonGroup group;
	
	int count=0;
	int score =0;
	int time = 15;
	int ans_given = 0;
	
	String name ;
	Quiz(String name){
		this.name = name;
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\yashm\\OneDrive\\Desktop\\E-Commerce\\Practice\\quiz\\src\\image\\quiz.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0, -50, 1140, 380);
		add(label);
		
		
		qno = new JLabel();
		qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		qno.setBounds(70, 350, 50, 50);
		add(qno);

		question = new JLabel();
		question.setFont(new Font("Tahoma" , Font.PLAIN , 20));
		question.setBounds(100,350,900,50);
		add(question);
		
//		 questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
		
        
        opt1 = new JRadioButton();
        opt1.setBounds(100,400,550,50);
        opt1.setFont(new Font("Dialog" , Font.PLAIN , 18));
        opt1.setBackground(Color.white);
		add(opt1);
		
		opt2 = new JRadioButton();
        opt2.setBounds(100,435,550,55);
        opt2.setFont(new Font("Dialog" , Font.PLAIN , 18));
        opt2.setBackground(Color.white);
		add(opt2);
		
		opt3 = new JRadioButton();
        opt3.setBounds(100,470,550,55);
        opt3.setFont(new Font("Dialog" , Font.PLAIN , 18));
        opt3.setBackground(Color.white);
		add(opt3);
		
		opt4 = new JRadioButton();
        opt4.setBounds(100,505,550,55);
        opt4.setFont(new Font("Dialog" , Font.PLAIN , 18));
        opt4.setBackground(Color.white);
		add(opt4);
		
		// ButtonGroup internally manages the radio selections
		group = new ButtonGroup();
		group.add(opt1);
		group.add(opt2);
		group.add(opt3);
		group.add(opt4);
		
		lifeLine = new  JButton("50-50 Life Line");
		lifeLine.setBounds(950 , 430,120,25);
		lifeLine.setBackground(new Color(30,144,252));
		lifeLine.setForeground(Color.white);
		lifeLine.addActionListener(this);
		add(lifeLine);
		
		next = new  JButton("Next");
		next.setBounds(950 , 480,120,25);
		next.setBackground(new Color(30,144,252));
		next.setForeground(Color.white);
		next.addActionListener(this);
		add(next);
		
		submit = new  JButton("Submit");
		submit.setBounds(950 , 530,120,25);
		submit.setBackground(new Color(30,144,252));
		submit.setForeground(Color.white);
		submit.setEnabled(false);
		submit.addActionListener(this);
		add(submit);
		
		
		start(count);
		
		setBounds(50,0,1140,650);
		setLocation(180 , 120);
		setVisible(true);
	
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		String timer = "Time Left - " + time + " seconds" ;
		g.setColor(Color.RED);
		g.setFont(new Font("tahoma" , Font.BOLD , 20));
		
		if(time>0) {
			g.drawString(timer, 900, 380);
		}else {
			g.drawString("Times Up!", 900, 380);
		}
		
		time--;
		
		try {
			Thread.sleep(1000);
			// calling paint method again
			repaint();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// if user selects the answer or not
		if(ans_given ==1) {
			ans_given = 0;
			time = 15;
		}else if(time<0) {
			time = 15;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			// if automatically goes to 10th question without selecting the options
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			// check and store the option selected by user
			
			if(count  ==9) { // automatically submit 
				
				// to get the last selected option
				if(group.getSelection() == null) {
					answerGiven[count][0] = "";
				}else {
					answerGiven[count][0] = group.getSelection().getActionCommand();
				}
				
				for(int i =0 ; i<answers.length ; i++) {
					if(answerGiven[i][0].equals(answers[i][1])) {
						score+=10;
					}
				}
				
				setVisible(false);
				new Score(name, score);
			}else { // manually submit
				if(group.getSelection() == null) {
					answerGiven[count][0] = "";
				}else {
					answerGiven[count][0] = group.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
		}
	}
	
	public void start(int count) {
		qno.setText((count+1) + ". ");
		question.setText(questions[count][0]);
		
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);
		
		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);
		
		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);
		
		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);
		
		group.clearSelection();
	}
	
	public static void main(String[] args) {
		 new Quiz("user");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == next) {
			ans_given=1;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			if(group.getSelection() ==null) {
				answerGiven[count][0] = "";
			}else {
				answerGiven[count][0] = group.getSelection().getActionCommand();
			}
			
			repaint();
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++;
			start(count);
		}else if(e.getSource() == lifeLine) {
			
			if(count==2 || count==4 || count==6 || count==8 || count==9) {
				opt2.setEnabled(false);
				opt4.setEnabled(false);
			}else {
				opt1.setEnabled(false);
				opt3.setEnabled(false);
			}
			
			lifeLine.setEnabled(false);
			
		}else {
			ans_given = 1;
			if(group.getSelection() == null) {
				answerGiven[count][0] = "";
			}else {
				answerGiven[count][0] = group.getSelection().getActionCommand();
			}
			
			for(int i =0 ; i<answers.length ; i++) {
				if(answerGiven[i][0].equals(answers[i][1])) {
					score+=10;
				}
			}
			setVisible(false);
			
			new Score(name , score);
		}
		
	}
}
