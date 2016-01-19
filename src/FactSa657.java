import java.math.BigInteger;
import java.util.Scanner;


public class FactSa657 {

	public static void main(String[] args){
		
		{
			   int num;
			   Scanner input=new Scanner(System.in);
			   System.out.println("Enter the number: ");
			   num=input.nextInt();

				   BigInteger bignum11 = new BigInteger(String.valueOf(num));
				   BigInteger fact = Fact(bignum11);
				   System.out.println("The result is :" +fact );
			}

		}
	private static BigInteger Fact(BigInteger bignum11) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BigInteger i= new BigInteger("1");
		if(bignum11 == BigInteger.valueOf(0)){
			return BigInteger.valueOf(1);
		}
		else{
			return bignum11.multiply(Fact(bignum11.subtract(i)));
		}
	}
	
}



		
		
	
		

	
	

