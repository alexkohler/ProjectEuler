package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem037 {

	/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */
	
	//Metrics - SLOW
	static boolean isPrime(long n)
	{
		if (n == 1)
			return false;
		for (int i = 2; i <= n /2; i++)
		{
			if (n % i == 0)//If i divides evenly into n (Has no remainder)
				return false; //Then n is not prime.
		}
		return true;
	}
	
	static boolean isTruncatablePrimeLeftToRight(long n)
	{
	long div = 0;	
	if (isPrime(n))
	{
//		System.out.println(n + " is prime");
		div = n / 10;
	}
	else
		return false;
//	System.out.println("div is initially " + div);
	while (div > 0)
	{

		if (isPrime(div))
		{
			div = div / 10;
	//		System.out.println("chopping.." + div);
			continue;
		}
		else
			return false;
	}
	return true;
	
	}
	static boolean isTruncatablePrimeRightToLeft(long n)
	{
		StringBuilder sb;
		if (isPrime(n))
			sb = new StringBuilder(String.valueOf(n));
		else
			return false;
		while (sb.length() > 0)
		{
			sb.deleteCharAt(0);
			if (!sb.toString().equals(""))
			if (isPrime(Long.valueOf(sb.toString())))
				continue;
			else
				return false;
		}
		return true;
	}
	
	static boolean isTruncatable(long n)
	{
		return isTruncatablePrimeLeftToRight(n) && isTruncatablePrimeRightToLeft(n) && true;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int n = 8; n < 1000000; n++)
			if (isTruncatablePrimeLeftToRight(n) == true && isTruncatablePrimeRightToLeft(n) == true)
				System.out.println(n);
		//pen and paper (google search bar) to add up
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime ) + "ms");
	
	}

}
