package myprog.single;
/*
 *  @author Sneha Priya Ale 
 *  Contact: sa657@njit.edu
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Email 
	{
		public static void main(String[] args)
			{
				Scanner scan = new Scanner(System.in);
				File student_email_file= new File("//Users//Mannu//Documents//workspace//FactorialSa657//src//studentemail.txt"); //Information About the Output File
				BufferedReader file_reader = null;
				int i=1;
				String[] records = null;
				System.out.println("Please enter the filename for creating Student Email IDs:"); //Providing the file name which has Student's data.
			 
					try
						{
							if(!student_email_file.exists())
								{
									student_email_file.createNewFile();// If the output file is not found, creates a new file called studentemail.txt
								}
				FileInputStream input = new FileInputStream("//Users//Mannu//Documents//workspace//FactorialSa657//src//"+ scan.next());
				file_reader = new BufferedReader(new InputStreamReader(input));
				String line=null;
				FileWriter file_writer = new FileWriter(student_email_file.getAbsoluteFile());
				BufferedWriter buffer_file_writer = new BufferedWriter(file_writer);
				while(true)
					{
						line = file_reader.readLine();
						if(line==null) break;
						System.out.print("The Student["+(i++)+"] record is ");
						records = line.split(":"); //Split the data into Record Array
						buffer_file_writer.write(Character.toLowerCase(records[0].charAt(0))+""+Character.toLowerCase(records[1].charAt(0))+""+records[2].charAt(5)+""+records[2].charAt(6)+""+records[2].charAt(7)+""+records[2].charAt(8)+"@"+"se.depaul.edu");//writes the data in the output file
						buffer_file_writer.write("\n");
						for (String record1: records)	System.out.print(record1+" "); //Prints the data from the input file
						System.out.println();
					}
				buffer_file_writer.close();
				file_reader.close();
				} 
		       catch(FileNotFoundException file_not_found){
	        	   System.out.println(file_not_found.getMessage() + "You have an Error! The file is not found.");
	        	   System.exit(0);
	           } 			 
				catch (final IOException| NullPointerException in_out_exception) {
					// TODO Auto-generated catch block
					System.out.println("You have an Error! The file cannot be read! Please check.");
				}
			
		}
}

