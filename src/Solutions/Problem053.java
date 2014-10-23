package Solutions;

import java.math.BigInteger;

public class Problem053 {
/*
 There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 
 ....
 https://projecteuler.net/problem=53
 
 */
	//Metrics - 270ms
	static BigInteger factorial (BigInteger n)
	{
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		if (n.compareTo(one) == 0 || n.compareTo(zero) == 0)
			return new BigInteger("1");
		else
			return n.multiply(factorial(n.subtract(one)));
		
	}
	
	
	static BigInteger nChooseR(BigInteger n, BigInteger r)
	{
		return (factorial(n)).divide((factorial(r).multiply(factorial(n.subtract(r)))));
	}
	
	static int findMils ()
	{
		int milCount = 0;

		BigInteger n = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger onehundy = new BigInteger("100");
		BigInteger r = new BigInteger("0");
		BigInteger oneMil = new BigInteger("1000000");
		while (n.compareTo(onehundy) == -1 || n.compareTo(onehundy) == 0) //while n is less than or equal to one hundy
		{
			
			while (r.compareTo(n) == -1 || r.compareTo(n) == 0) // while r is less than or equal to n 
			{
//				System.out.println(n + " choose " + r + " is " + nChooseR(n, r).toString());
				if (nChooseR(n, r).compareTo(oneMil) == 1) //if nchooser is greater than one million 
					milCount++;
				//inc r
				r = r.add(one);
			}
			r = new BigInteger("0");
			//inc n
			n = n.add(one);
		}
		
		
		return milCount;
	}
	
	
	//use a biginteger
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(findMils());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
	}

}
