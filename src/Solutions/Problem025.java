package Solutions;

import java.math.BigInteger;

public class Problem025 {
	
	/*The Fibonacci sequence is defined by the recurrence relation:

		Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
		Hence the first 12 terms will be:

		F1 = 1
		F2 = 1
		F3 = 2
		F4 = 3
		F5 = 5
		F6 = 8
		F7 = 13
		F8 = 21
		F9 = 34
		F10 = 55
		F11 = 89
		F12 = 144
		The 12th term, F12, is the first term to contain three digits.*/
		//What is the first term in the Fibonacci sequence to contain 1000 digits?
	
	//Metrics - 426ms
	
	static BigInteger fibonacci(BigInteger n) //not even needed. oh well
	{
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		if (n.compareTo(one) == 0) //if equal
			return new BigInteger("1");
		else if (n.compareTo(zero) == 0)
			return new BigInteger("0");
		else
			return fibonacci(n.subtract(new BigInteger("2"))).add(fibonacci(n.subtract(new BigInteger("1"))));
	}
	
	static int getNumberOfDigits(BigInteger n)
	{
		return n.toString().length();
	}
	
	static String findFirstThousandDigitFibonacci()
	{
	//	BigInteger numberOfDigits = new BigInteger("0");
		int numberOfDigits = 0;
		int termCounter = 2; //count what term of the fibonacci sequence we are on
		BigInteger seedOne = new BigInteger("1");
		BigInteger seedTwo = new BigInteger("1");
		BigInteger fib = new BigInteger("0");
			while (numberOfDigits < 1000)
				{
				fib = seedOne.add(seedTwo);
				seedTwo = seedOne;
				seedOne = fib;
				numberOfDigits = getNumberOfDigits(fib);
				termCounter++;
				}
			
			if (numberOfDigits == 1000)
				return String.valueOf(termCounter);
			else
				return "404 fibonacci not found";
	}



	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(findFirstThousandDigitFibonacci());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
