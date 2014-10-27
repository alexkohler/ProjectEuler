package Solutions;
/*
 * Author Alexander Kohler
 */
import java.math.BigInteger;

public class Problem056 {

	/*
	 A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: 
	 one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
	 
	 */
	
	//metrics - 172ms
	static int sumDigits(String s)
	{
		int sum = 0;
		char[] arr = s.toCharArray();
		for (char c : arr)
		{
			sum += Character.getNumericValue(c);
			
		}
		
		return sum;
	}
	
	static int findMaxDigitalSum()
	{
		int a = 1;
		BigInteger b = new BigInteger("1");
		int  sum = 0;
		int greatestSum = 0;
		BigInteger ceil = new BigInteger("101");
		
		while (a < 101)//less than
		{
			
			while (b.compareTo(ceil) == -1) //less than
			{
				sum = sumDigits(b.pow(a).toString());
				if (sum > greatestSum )
				{
					greatestSum = sum;
					//System.out.println("Found new greatestSum :" + greatestSum + " with " + b.toString() + "^" + a);
				}
				//inc b
				b = b.add(new BigInteger("1"));
			}
			
			
			//inc a
			a++;
			b = new BigInteger(String.valueOf(a));
		}
		
		return greatestSum;		
	}
	
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		findMaxDigitalSum();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		
	}

}
