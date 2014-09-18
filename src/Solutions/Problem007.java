package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem007 {

	// PROBLEM 7

	// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	// see that the 6th prime is 13.

	// What is the 10 001st prime number?

	// The simplest primality test is trial division: Given an input number n,
	// check whether any integer m
	// from 2 to n − 1 evenly divides n (the division leaves no remainder). If n
	// is divisible by any m then n is composite, otherwise it is prime.[1]
	
	//Metrics - 1533ms

	static boolean isPrime(int n) {
		boolean isPrime = false; // innocent until proven guilty
		for (int i = 2; i < n; i++)
		{

			if (n % i != 0) 
			{
				isPrime = true;
				continue;
			} 
			else 
			{
				isPrime = false;
				break;
			}
		}

		if (n == 2) 
		{
			isPrime = true;
		}
		return isPrime;
	}

	static int thisthPrime(int n) {
		int primeCounter = 0;
		for (int i = 0; i < 4000000; i++)
		{
			if (isPrime(i))
				primeCounter++;

			if (primeCounter == n)
				return i;

		}
		return 0;
	}

	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(thisthPrime(10001));
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		
	}

}
