package myprog.single;
/*
 *  @author Sneha Priya Ale 
 *  Contact: sa657@njit.edu
 */
import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane;
 
public class Average 
{ 
     
	public static void main(String[] args)  throws IOException,FileNotFoundException
	{ 
		Scanner scan = new Scanner(System.in);
		BufferedReader file_reader = null; 
		double sum=0.0, avg=0.0;
		int j=0;
		String integers=null;

		System.out.println("Please enter the filename for finding the Average of Integers:");

		try 
			{	
				FileInputStream input_file = new FileInputStream(scan.next());
				file_reader = new BufferedReader(new InputStreamReader(input_file));
				System.out.println("The input data is:");
						while((integers= file_reader.readLine())!= null){ 
							try{
								j++;
								System.out.println(integers);
								int number = Integer.parseInt(integers);
								sum+=number;
								} 
							catch(NumberFormatException mismatch){
								j--;
							}
						}
					avg=sum/j;
					if(j==0) throw new NullPointerException();
					System.out.println("Numbers entered are:" +j);
					JOptionPane.showMessageDialog(null,"Average of the Integers entered in the file is " +avg+".");
					input_file.close();
					file_reader.close();
					
			}
			
		catch (final IOException| NullPointerException in_out_exception) 
			{
				JOptionPane.showMessageDialog(null,"You have an Error! The file cannot be read! Please check.");
			}
		scan.close();
	}
} 












