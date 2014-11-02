package Solutions;
/*
 * Author Alexander Kohler
 */
import java.math.BigInteger;

public class Problem063 {

/*
  The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
  
  
*/
	//Just remember that no nth power of 10 or above can ever have fewer than n + 1 digits.
	static void powerfulDigitCounts()
	{
		BigInteger i = new BigInteger("1");
		BigInteger inc = new BigInteger("1");
		BigInteger limit = new BigInteger("10");
		int matches = 0;
		while (i.compareTo(limit) == -1)// less than
		{
			int power = 1;
			while (power < 25) //less than
			{
				BigInteger exp = i.pow(power);
				if (exp.toString().length() == power)
				{
					matches++;
				//	System.out.println("Found match with " + exp.toString() + " and " + i.toString() + "^" + power + "(" + matches + ")");
				}
				
				power++;
			}
			
			
			//inc i
			i = i.add(inc);
		}
		System.out.println(matches);
	}
	
	
	
	public static void main(String[] args) {
	
		long startTime = System.currentTimeMillis();
		powerfulDigitCounts();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
 	} //may have to add one for 1 because I think it gets skipped
   
}
