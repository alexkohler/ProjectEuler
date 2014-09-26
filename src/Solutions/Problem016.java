package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.math.BigDecimal;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem016 
{
/*	215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

			What is the sum of the digits of the number 21000?*/
	
	//Metrics - 10ms
	
	static void problemSixteen()
	{
		String decimalString = new BigDecimal(Math.pow(2, 1000)).toPlainString();
		char[] decStringArray = decimalString.toCharArray();
		int sum = 0;
		for (char c: decStringArray)
		{
			sum = sum + Character.getNumericValue(c);
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		problemSixteen();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	
}
