package myprog.single;
/*
 *  @author Sneha Priya Ale 
 *  Contact: sa657@njit.edu
 */
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class Calculator_Interface extends Frame implements ActionListener
{

Label l0,l1;
Frame f;
Panel p0,p1,p2,p3,p4;
TextField text_field_input, text_field_output;
JButton b_equal,b_clear,b_exit;
JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_dot;

String value="",fvalue="";
char opr;
Double answer;

	Calculator_Interface()
	{
		f=new Frame("FACTORIAL CALCULATOR");
		
		//assigning names for the Buttons.
		b_equal = new JButton("Calculate");
		b_clear=new JButton("Clear");
		b_exit=new JButton("Exit");
		b0=new JButton("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b_dot=new JButton(".");
		
		//Setting the font for the Buttons.
		b0.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b1.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b2.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b3.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b4.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b5.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b6.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b7.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b8.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b9.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b_clear.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b_equal.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b_exit.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		b_dot.setFont(new Font("Sans Serif", Font.PLAIN,30));
		
		//Text Field size
		text_field_input=new TextField(100);
		text_field_output=new TextField(100);
		
		//Setting the panel
		p0=new Panel(new GridLayout(1,3,2,2) );
		p1=new Panel(new GridLayout(1,3,2,2) );
		p2=new Panel(new GridLayout(1,3,2,2) );
		p3=new Panel(new GridLayout(1,3,2,2) );
		p4=new Panel(new GridLayout(1,3,2,3) );
	
	}


	public void launch_frame()
	{
		text_field_input.setText("");
		text_field_output.setText("");
		
		p0.add(b1);
		p0.add(b2);
		p0.add(b3);
		
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		
		p3.add(b0);
		p3.add(b_dot);
		
		p4.add(b_equal);
		p4.add(b_clear);
		p4.add(b_exit);
		
		f.setLayout(new GridLayout(9,1,3,3));
		f.setResizable(false);
		f.setSize(500,500);
		
		f.add(text_field_input);
		f.add(text_field_output);
		f.add(p2);
		f.add(p1);
		f.add(p0);
		f.add(p3);
		f.add(p4);
		
		f.setVisible(true);
		
		//Action Listener
		
		b_exit.addActionListener(this);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b_dot.addActionListener(this);
		b_clear.addActionListener(this);
		b_equal.addActionListener(this);
		
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}				);
	}

	public void actionPerformed(ActionEvent a_event)
	{
	
		try
		{
			if (a_event.getSource()==b_exit) System.exit(0);
			if (a_event.getSource()==b_clear) { value=""; text_field_input.setText(""); text_field_output.setText("");}
			if(a_event.getSource()==b_dot){value=value+"."; text_field_input.setText(".");}
			if (a_event.getSource()==b0) { value=value+0; text_field_input.setText(value); }
			if (a_event.getSource()==b1) { value=value+1; text_field_input.setText(value); }
			if (a_event.getSource()==b2) { value=value+2; text_field_input.setText(value); }
			if (a_event.getSource()==b3) { value=value+3; text_field_input.setText(value); }
			if (a_event.getSource()==b4) { value=value+4; text_field_input.setText(value); }
			if (a_event.getSource()==b5) { value=value+5; text_field_input.setText(value); }
			if (a_event.getSource()==b6) { value=value+6; text_field_input.setText(value); }
			if (a_event.getSource()==b7) { value=value+7; text_field_input.setText(value); }
			if (a_event.getSource()==b8) { value=value+8; text_field_input.setText(value); }
			if (a_event.getSource()==b9) { value=value+9; text_field_input.setText(value); }
			if (a_event.getSource()==b_equal) { equals();}
		}
	
		//Exception Handling
		catch(NumberFormatException exception)
		{
				JOptionPane.showMessageDialog(null, "Please enter an integer.");
		}
	}
	//Calculate the Factorial of a number
	void equals()
	{
		BigInteger bignum1 = new BigInteger(String.valueOf(value));
		BigInteger answer = Fact(bignum1);
		String value3 = answer.toString();
		value3=""+value3;
		text_field_input.setText("Input: "+value);
		text_field_output.setText("Output: "+value3);
	}
	private BigInteger Fact(BigInteger bignum11) 
	{
		// TODO Auto-generated method stub
		BigInteger i= new BigInteger("1");
		if(bignum11.equals(BigInteger.ZERO) )
		{
			return BigInteger.valueOf(1);
		}
		else{
				return bignum11.multiply(Fact(bignum11.subtract(i)));
			}
	}

}

public class Fact_Calculator
{
	public static void main(String args[])
	{
		Calculator_Interface t=new Calculator_Interface();
		t.launch_frame();
	}

}












