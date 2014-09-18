package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.math.BigInteger;

public class Problem003 {
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * 
 */
	//Metrics - Slow

	
	static BigInteger findLargestPrimeFactorOf(BigInteger n)
	{
		if (isPrime(n))
			return n;
	
		BigInteger largest = new BigInteger("0");
		BigInteger i = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		for (; i.compareTo(n) == -1; i.add(one))
		{
			
			if (n.mod(i).equals(zero)) //if it divides evenly (has no remainder)
			{
			if (isPrime(i))
				{
				
					if (i.compareTo(largest) == 1)
					{
						largest = i;
						System.out.println(largest);
					}
				
				}
			}
			i = i.add(one);
			
		}
		
		return largest;
		
		
	}
	static boolean isPrime (BigInteger n)
	{
		BigInteger zero = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		BigInteger inc = new BigInteger("1");
		if (n.compareTo(two) == 0)  //is they are equal
			return true;
		else
		{
			BigInteger i = new BigInteger("2");
			for (; i.compareTo(n) == -1; i.add(inc)) //less than = -1
			{
				if (!(n.mod(i).equals(zero)))
					{
					i = i.add(inc);
					continue;
					}
				else
					break;
				
			}
			
			if (i.compareTo(n) == 0)
				return true;
			else
				return false;
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(findLargestPrimeFactorOf(new BigInteger("600851475143")));

	}

}
