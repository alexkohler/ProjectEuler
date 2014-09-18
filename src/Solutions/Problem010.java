package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem010 {
/*
 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
 */
	//Metrics - slow
	
	static boolean isPrime (long n)
	{
		if (n ==2) 
			return true;
		else
		{
			long i = 2l;
			for (; i < n; i++)
			{
				if ((n % i) !=0)
					continue;
				else
					break;
			}
			
			if (i == n)
				return true;
			else
				return false;
			
		}
		
	}

	static long sumPrimesBelowTwoMillion()
	{
		//how to salvage a lack of common sense
		long n = 1900001l;
		//long sum = 0l;
		long sum = 129451433482l; //whoops...
		while (n < 2000000)
		{
			if (isPrime(n))
				{
				sum = sum + n;
				}
			int k = 100000;
			for (int i = 1; i < 21; i ++)
			if (n == ( i * k) )
				System.out.println(i + ": sum -> " + sum);
			
			n++;
		}
		return sum;
	}
	
	
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(sumPrimesBelowTwoMillion());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
