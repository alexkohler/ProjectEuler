package test;

public class Problem014 
{
/*The following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?*/
	
	//Metrics - 506 ms
	
	static long collatzLengthOfChainStartingWith(long i)
	{
		int chainLength = 1;
		while (i != 1)
		{
			if (i % 2 == 0){ // even case
				i = i / 2;
				chainLength++;
			}
			else{
				i = (3 * i) + 1;
				chainLength++;
			}
			
		}
		
		return chainLength;
	}
	
	static long findLargestStartingNumberUnderOneMillionThatProducesLongestChain()
	{
		long currentLongest = 0;
		long currentLongestGivenBy = 0;
		for (long startingNum = 1; startingNum < 1000000; startingNum++)
		{
			long collatzLength = collatzLengthOfChainStartingWith(startingNum);
			if (collatzLength > currentLongest)
			{
				currentLongest = collatzLength;
				currentLongestGivenBy = startingNum;
			}
		}
		
		return currentLongestGivenBy;
	}
	
	
	
	
	public static void main (String args[])
	{
		long startTime = System.currentTimeMillis();
		System.out.println(findLargestStartingNumberUnderOneMillionThatProducesLongestChain());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	
}
