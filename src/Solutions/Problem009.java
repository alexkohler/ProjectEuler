package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem009 {
	/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

	a2 + b2 = c2
	For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.*/
	
	//Metrics - 18ms
	static int square (int n)
	{
		return n * n;
	}
	
	static double root (int n)
	{
		
		return Math.sqrt((double) n);
	}
	
	static double findPythagoreanTriplet()
	{
		int asquared = 0;
		int bsquared  = 0;
		int csquared  = 0;
		double c = 0;
		for (int a = 10; a < 1000; a++)
		{
			asquared = square (a);
			for (int b = 10; b < 1000; b++)
			{
				bsquared = square (b);
				csquared = asquared + bsquared;
				c = root(csquared);
				if ((a + b + c) == 1000)
					return (a * b * c);
			}
			
		}
		
		return -1;
		
	}
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(findPythagoreanTriplet());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
