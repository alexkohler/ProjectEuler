package Solutions;

/*
 * Written by Alexander Kohler
 */
public class Problem027 {

	/*
	 * Euler discovered the remarkable quadratic formula:
	 * 
	 * n^2 + n + 41
	 * 
	 * It turns out that the formula will produce 40 primes for the consecutive
	 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41
	 * is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly
	 * divisible by 41.
	 * 
	 * The incredible formula n^2 - 79n + 1601 was discovered, which produces 80
	 * primes for the consecutive values n = 0 to 79. The product of the
	 * coefficients, -79 and 1601, is -126479.
	 * 
	 * Considering quadratics of the form:
	 * 
	 * n^2 + an + b, where |a| < 1000 and |b| < 1000
	 * 
	 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |-4| = 4
	 * Find the product of the coefficients, a and b, for the quadratic
	 * expression that produces the maximum number of primes for consecutive
	 * values of n, starting with n = 0.
	 */

	// Metrics
	static boolean isPrime(int n)
	{
		n = Math.abs(n);
		if (n == 1)
			return true;

		for (int i = 2; i < (n / 2); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static int findLongestChainFromFormula() {
		int longestPrimeChain = 0;
		int longAVal = 0;
		int longBVal = 0;

		for (int a = -999; a < 1000; a++)
		{
			int primeChain = 0;
			for (int b = -999; b < 1000; b++)
			{
				primeChain = 0;
				for (int n = 0; n < 2000; n++)
				{
					if (isPrime((n * n) + (a * n) + b))
						primeChain++;
					else
						break;
				}
				if (primeChain > longestPrimeChain) {
					longestPrimeChain = primeChain;
					longAVal = a;
					longBVal = b;
				}
			}
		}

		// System.out.println("Longest prime chain was with values " + longAVal
		// + " and " + longBVal +
		// " with a length of " + longestPrimeChain +
		// " and coefficient product of " + (longAVal * longBVal));
		return longAVal * longBVal;

	}

	public static void main(String args[])

	{

		long startTime = System.currentTimeMillis();

		findLongestChainFromFormula();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " ms");

	}

}