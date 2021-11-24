import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private static JTextField textField;
	double result;
	String operation;
	String answer;
	static ArrayList<String> expression = new ArrayList<String>();
	
	/**
	 * Launch the Calculator.
	 * Calculator textField get the expression and evaluate in this program and out the answer
	   again to the text field. And also the each and every steps involve with the calculator is 
	   expressed in the console as well to get more clear idea about the previous entered expression
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Default constructor
	 */
	public Calculator() {
		initialize();
	}
	
	/**
	 * At the beginning of the program Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scientific Calculator");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(23, 10, 358, 42);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setBounds(10, 62, 371, 89);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/*
		 * Below are the button configurations. Each button variables named as according 
		 * to its function. (example:- Equal Button = btnEqual)
		*/
		JButton btn0 = new JButton("0");
		btn0.setEnabled(false);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn0.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn0.setBounds(10, 515, 142, 60);
		frame.getContentPane().add(btn0);
		
		
		JButton btnDot = new JButton(".");
		btnDot.setEnabled(false);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnDot.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDot.setBounds(162, 515, 66, 60);
		frame.getContentPane().add(btnDot);
		
		
		JButton btnEqual = new JButton("=");	
		btnEqual.setEnabled(false);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String data = textField.getText(); 
		            System.out.println(data);
		            
		            //eval function of the of the CalculatorEvaluator is called in here.
		            String displayAnswer = String.valueOf(CalculatorEvaluator.eval(data));
		            textField.setText(displayAnswer);
				}catch(Exception f) {
					textField.setText("MATH ERROR");
				}
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEqual.setBounds(238, 515, 66, 60);
		frame.getContentPane().add(btnEqual);
		
		
		JButton btn1 = new JButton("1");
		btn1.setEnabled(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn1.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn1.setBounds(10, 445, 66, 60);
		frame.getContentPane().add(btn1);
		
		
		JButton btn2 = new JButton("2");
		btn2.setEnabled(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn2.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn2.setBounds(86, 445, 66, 60);
		frame.getContentPane().add(btn2);
		
		
		JButton btn3 = new JButton("3");
		btn3.setEnabled(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn3.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn3.setBounds(162, 445, 66, 60);
		frame.getContentPane().add(btn3);
		
		
		JButton btn4 = new JButton("4");
		btn4.setEnabled(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn4.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn4.setBounds(10, 375, 66, 60);
		frame.getContentPane().add(btn4);
		
		
		JButton btn5 = new JButton("5");
		btn5.setEnabled(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn5.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn5.setBounds(86, 375, 66, 60);
		frame.getContentPane().add(btn5);
		
		
		JButton btn6 = new JButton("6");
		btn6.setEnabled(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn6.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn6.setBounds(162, 375, 66, 60);
		frame.getContentPane().add(btn6);
		
		
		JButton btn7 = new JButton("7");
		btn7.setEnabled(false);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn7.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn7.setBounds(10, 305, 66, 60);
		frame.getContentPane().add(btn7);
		
		
		JButton btn8 = new JButton("8");
		btn8.setEnabled(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn8.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn8.setBounds(86, 305, 66, 60);
		frame.getContentPane().add(btn8);
		
		
		JButton btn9 = new JButton("9");
		btn9.setEnabled(false);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btn9.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn9.setBounds(162, 305, 66, 60);
		frame.getContentPane().add(btn9);
		
		
		JButton btnSinIn = new JButton("asin");
		btnSinIn.setEnabled(false);
		btnSinIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnSinIn.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnSinIn.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSinIn.setBounds(10, 235, 66, 60);
		frame.getContentPane().add(btnSinIn);
		
		
		JButton btnCosIn = new JButton("acos");
		btnCosIn.setEnabled(false);
		btnCosIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnCosIn.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnCosIn.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnCosIn.setBounds(86, 235, 66, 60);
		frame.getContentPane().add(btnCosIn);
		
		
		JButton btnTanIn = new JButton("atan");
		btnTanIn.setEnabled(false);
		btnTanIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnTanIn.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnTanIn.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnTanIn.setBounds(162, 235, 66, 60);
		frame.getContentPane().add(btnTanIn);
		
		
		JButton btnPlus = new JButton("+");
		btnPlus.setEnabled(false);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnPlus.getText();
				textField.setText(number);
				operation = "+";
				expression.add(number);
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlus.setBounds(315, 445, 66, 130);
		frame.getContentPane().add(btnPlus);
		
		
		JButton btnSin = new JButton("sin");
		btnSin.setEnabled(false);
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnSin.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnSin.setBounds(10, 165, 66, 60);
		frame.getContentPane().add(btnSin);
		
		
		JButton btnCos = new JButton("cos");
		btnCos.setEnabled(false);
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnCos.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnCos.setBounds(86, 165, 66, 60);
		frame.getContentPane().add(btnCos);
		
		
		JButton btnTan = new JButton("tan");
		btnTan.setEnabled(false);
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnTan.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnTan.setBounds(162, 165, 66, 60);
		frame.getContentPane().add(btnTan);
		
		
		JButton btnLeftParan = new JButton("(");
		btnLeftParan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnLeftParan.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnLeftParan.setEnabled(false);
		btnLeftParan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLeftParan.setBounds(238, 235, 66, 60);
		frame.getContentPane().add(btnLeftParan);
		
		
		JButton btnDel = new JButton("DEL");
		btnDel.setEnabled(false);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				
				if(textField.getText().length() > 0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backspace = str.toString();
					textField.setText(backspace);
				}
			}
		});
		btnDel.setBackground(new Color(255, 102, 0));
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDel.setForeground(Color.BLACK);
		btnDel.setBounds(238, 305, 66, 60);
		frame.getContentPane().add(btnDel);
		
		
		JButton btnMin = new JButton("-");
		btnMin.setEnabled(false);
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnMin.getText();
				textField.setText(number);
				operation = "-";
				expression.add(number);
			}
		});
		btnMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMin.setBounds(238, 445, 66, 60);
		frame.getContentPane().add(btnMin);
		
		
		JButton btnMultip = new JButton("*");
		btnMultip.setEnabled(false);
		btnMultip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnMultip.getText();
				textField.setText(number);
				operation = "*";
				expression.add(number);
			}
		});
		btnMultip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMultip.setBounds(238, 375, 66, 60);
		frame.getContentPane().add(btnMultip);
		
		
		JButton btnDevide = new JButton("/");
		btnDevide.setEnabled(false);
		btnDevide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number = textField.getText() + btnDevide.getText();
					textField.setText(number);
					operation = "/";
					expression.add(number);
				}catch(Exception g) {
					textField.setText("MATH ERROR");
				}
			}
		});
		btnDevide.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDevide.setBounds(315, 375, 66, 60);
		frame.getContentPane().add(btnDevide);
		
		
		JButton btnModulas = new JButton("%");
		btnModulas.setEnabled(false);
		btnModulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnModulas.getText();
				textField.setText(number);
				operation = "%";
				expression.add(number);
			}
		});
		btnModulas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModulas.setBounds(315, 305, 66, 60);
		frame.getContentPane().add(btnModulas);
		
		
		JButton btnRightParan = new JButton(")");
		btnRightParan.setEnabled(false);
		btnRightParan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText() + btnRightParan.getText();
				textField.setText(number);
				expression.add(number);
			}
		});
		btnRightParan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRightParan.setBounds(315, 235, 66, 60);
		frame.getContentPane().add(btnRightParan);
		
		
		JToggleButton btnON = new JToggleButton("OFF");		//ON/OFF toggle button
		ItemListener itemListener = new ItemListener() {
		    public void itemStateChanged(ItemEvent itemEvent) {
		    	btn1.setEnabled(false);
		        int state = itemEvent.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	// If the ON button clicked explicitly enabled all the buttons
		            btnON.setText("ON");
		            btn0.setEnabled(true);
		            btn1.setEnabled(true);
		            btn2.setEnabled(true);
		            btn3.setEnabled(true);
		            btn4.setEnabled(true);
		            btn5.setEnabled(true);
		            btn6.setEnabled(true);
		            btn7.setEnabled(true);
		            btn8.setEnabled(true);
		            btn9.setEnabled(true);
		            btnDot.setEnabled(true);
		            btnEqual.setEnabled(true);
		            btnPlus.setEnabled(true);
		            btnMin.setEnabled(true);
		            btnMultip.setEnabled(true);
		            btnDevide.setEnabled(true);
		            btnModulas.setEnabled(true);
		            btnSin.setEnabled(true);
		            btnCos.setEnabled(true);
		            btnTan.setEnabled(true);
		            btnSinIn.setEnabled(true);
		            btnCosIn.setEnabled(true);
		            btnTanIn.setEnabled(true);
		            btnDel.setEnabled(true);
		            btnLeftParan.setEnabled(true);
		            btnRightParan.setEnabled(true);
		            btnDel.setEnabled(true);
		            textField.setEnabled(true);
		        } else { 
		        	// If the OFF button clicked explicitly disabled all the buttons
		            btnON.setText("OFF");  
		            btn0.setEnabled(false);
		            btn1.setEnabled(false);
		            btn2.setEnabled(false);
		            btn3.setEnabled(false);
		            btn4.setEnabled(false);
		            btn5.setEnabled(false);
		            btn6.setEnabled(false);
		            btn7.setEnabled(false);
		            btn8.setEnabled(false);
		            btn9.setEnabled(false);
		            btnDot.setEnabled(false);
		            btnEqual.setEnabled(false);
		            btnPlus.setEnabled(false);
		            btnMin.setEnabled(false);
		            btnMultip.setEnabled(false);
		            btnDevide.setEnabled(false);
		            btnModulas.setEnabled(false);
		            btnSin.setEnabled(false);
		            btnCos.setEnabled(false);
		            btnTan.setEnabled(false);
		            btnSinIn.setEnabled(false);
		            btnCosIn.setEnabled(false);
		            btnTanIn.setEnabled(false);
		            btnDel.setEnabled(false);
		            btnLeftParan.setEnabled(false);
		            btnRightParan.setEnabled(false);
		            textField.setEnabled(false);
		        }
		    }
		};
		btnON.addItemListener(itemListener);
		btnON.setBackground(new Color(255, 102, 0));
		btnON.setForeground(Color.BLACK);
		btnON.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnON.setBounds(315, 163, 66, 60);
		frame.getContentPane().add(btnON);
		
		
		JButton btnAC = new JButton("AC");	//all clear button
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnAC.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAC.setBounds(238, 165, 66, 60);
		frame.getContentPane().add(btnAC);
	}
}



