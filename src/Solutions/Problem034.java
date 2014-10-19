package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem034 {

	/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 */
	
	//Metrics 1332ms
	
	static long sumCuriousNumbers()
	{
		long sum = 0;
		for (long i = 3; i < 10000000; i++)
		{
			if (isCuriousNumber(i))
				sum += i;
		}
		
		return sum;
	}
	
	
	static boolean isCuriousNumber (long n)
	{
		char[] nCharArray = String.valueOf(n).toCharArray();
		long sum = 0;
		for (char c : nCharArray)
		{
			sum += factorial(Character.getNumericValue(c));
		}
		
		if (sum == n)
			{
			System.out.println("Found curious number: " + n);
			return true;
			}
		else
			return false;
	}
	
	static long factorial(long n)
	{
		if (n == 1 || n == 0 )
			return 1;
		else
			return n * factorial (n -1);
	}
	
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(sumCuriousNumbers());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");

	}

}
