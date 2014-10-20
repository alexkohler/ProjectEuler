package Solutions;
/*
 * Author Alexander Kohler
 */
import java.util.ArrayList;
/*
 * Author Alexander Kohler
 */
public class Problem050 {

	/*
 The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
	 */
	
	
	//Metrics 18000ms... :) that's iterating through all combinations, actually finding solution takes under 2 seconds

static boolean isPrime(long n)
	{
		if (n == 1) 
			return false;
	
		for (long i = 2; i <= (n /2); i++)
		{
			if (n % i == 0)//something went in evenly 
				return false;
		}
		return true;

}


static ArrayList<Long>  getListOfPrimes()
	{
		ArrayList<Long> primelist = new ArrayList<Long>();
		for (long i = 1; i < 4000; i++)
		{
				if (isPrime(i))
					primelist.add(i);
		}
		
		return primelist;
	}
	
	static long findLargestConsecutiveSum()
	{
		ArrayList<Long> primelist = getListOfPrimes();
		long sum = 0;
		long longestChainPrimeSum = 0;
		int primeChain = 0;
		int largestPrimeChain = 0;
		//first - keep track of primeChain
	
for (int k = 0; k < primelist.size(); k++)
		{
			for (int i = k; i < primelist.size(); i++)
			{
				sum += primelist.get(i);
				if (sum < 1000000)
				{
						primeChain++;
				//	System.out.println("Added " + primelist.get(i) + " to sum " + sum);
					if (isPrime(sum))
					{
					//	System.out.print(" Sum is prime! \n Chain is " + primeChain + "\n");
						if (primeChain > largestPrimeChain)
						{
							largestPrimeChain = primeChain;
							longestChainPrimeSum = sum;
							System.out.println("Longest prime sum is now " + longestChainPrimeSum);
						}
					}
				}

			}
			sum = 0;
			primeChain = 0;
		}
		return longestChainPrimeSum;
	}
	
	
	
	public static void main (String[] args)
	{
		long startime = System.currentTimeMillis();
		System.out.println(findLargestConsecutiveSum());
		long endtime = System.currentTimeMillis();
		System.out.println("That took " + (endtime - startime) + "ms");
	}
	
}