package Solutions;
/*
 * Author Alexander Kohler
 */
import java.util.HashSet;

public class Problem032 {

	/*
	 *We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
	 */
	
	//metrics - 416ms
	static int findProblemIdentities()
	{
		HashSet<Integer> pandigitalProducts = new HashSet<Integer>();
		for (int i = 1; i < 9999; i++)
		{
			for (int j = 9999; j > 0; j--)
			{
				int product = i * j;
				if (product < 100000)
				{
					String val = String.valueOf(i) + String.valueOf(j) + String.valueOf(product);
					if (isOneToNinePandigital(val))
					{
						pandigitalProducts.add(product);
					}
					
				}
			}
			
		}
		int total = 0;
		for (int pandigital : pandigitalProducts)
		{
//			System.out.println("Adding " + pandigital + " to our total");
			total += pandigital;
			
		}
//		System.out.println("Total is " + total);
		return total;
	}
	
	static boolean isOneToNinePandigital(String s)
	{
		boolean[] zeroToNine = new boolean[10];
		for (int i = 0; i < 10; i++)
			zeroToNine[i] = false;
		if (s.length() != 9)
				return false;
		else
		{
			for (int i = 0; i < 9; i++)
			{
				zeroToNine[Character.getNumericValue(s.charAt(i))] = true;
			}
		}
		return !zeroToNine[0] && zeroToNine[1] && zeroToNine[2] && zeroToNine[3] && zeroToNine[4] && zeroToNine[5] && zeroToNine[6] && zeroToNine[7] && zeroToNine[8] && zeroToNine[9];
	}
	
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		System.out.println(findProblemIdentities());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
	}

}
