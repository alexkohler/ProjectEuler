package Solutions;
/*
 * Author Alexander Kohler
 */
import java.util.ArrayList;

public class Problem046 {
/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*/
	
	//metrics 2178ms
	static void goldBachAntiConjecture()
	{
		ArrayList<Long> primes = new ArrayList<Long>();
		ArrayList<Long> composites = new ArrayList<Long>();
		for (long i = 2; i < 100000; i++)
		{
			if (isPrime(i))
				primes.add(i);
			else if ( i % 2 != 0) //then we have an odd composite
				composites.add(i);
		}
		
		for (long k: composites)
		{
			boolean found = false;
			for (long prime : primes)
			{
				if (prime > k)
				{
					break;
				
				}
				else
				{
					for (int i = 1; i < prime; i++)
					{
						long sum = prime + 2 * (i * i );
					
					if (sum == k)
					{//assert: prime is less than k  
						//System.out.println("Found solution for " + k + " with " + prime + " + " + " 2(" + i + "^2)");
						found = true;
						break;
					}
					}
					if (found)
						break;
					
				}
			}
			if (!found)
			{
			System.out.println("Failed to find solution for " + k);
			break;
			}
		}
		
	}
	
	
	static boolean isPrime(long n)
	{
		if (n == 1)
			return false;
		for (long o = 2; o <= (n / 2); o++)
		{
			if (n % o == 0)
				return false;
			
		}
		
		return true;
	}
	
	

		
		
		
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		goldBachAntiConjecture();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");

	}

}
