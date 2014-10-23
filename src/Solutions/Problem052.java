package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem052 {

	/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
	 */
	//Metrics - 90ms (Squad)
	static boolean containsSameDigits(long x)
	{
		String s1 = String.valueOf(x);
		String s2 = String.valueOf(x * 2);
		String s3 = String.valueOf(x * 3);
		String s4 = String.valueOf(x * 4);
		String s5 = String.valueOf(x * 5);
		String s6 = String.valueOf(x * 6);
		int l1 = s1.length();
		int l2 = s2.length(); 
		int l3 = s3.length();
		int l4 = s4.length();
		int l5 = s5.length();
		int l6 = s6.length();
		if (l1 == l6)// just check if 6x is same length - obviously all others will be is 6 is
		{
			boolean[] occurences = new boolean[10]; //for zero to 9
			for (int c1 = 0; c1 < l1; c1++) //s1
			{
				occurences[Character.getNumericValue(s1.charAt(c1))] = true;
			}
			for (int c2 = 0; c2 < l2; c2++)
			{
				if (occurences[Character.getNumericValue(s2.charAt(c2))] != true)
					return false;
			}
//			System.out.println("Doubles contain same val...");
			for (int c3 = 0; c3 < l3; c3++)
			{
				if (occurences[Character.getNumericValue(s3.charAt(c3))] != true)
					return false;
			}
//			System.out.println("Triples contain same val...");
			for (int c4 = 0; c4 < l4; c4++)
			{
				if (occurences[Character.getNumericValue(s4.charAt(c4))] != true)
					return false;
			}
//			System.out.println("Quads contain same val...");
			for (int c5 = 0; c5 < l5; c5++)
			{
				if (occurences[Character.getNumericValue(s5.charAt(c5))] != true)
					return false;
			}
//			System.out.println("Pents contain same val...");
			for (int c6 = 0; c6 < l6; c6++)
			{
				if (occurences[Character.getNumericValue(s6.charAt(c6))] != true)
					return false;
			}
			
			return true;
		}
		else
			return false;

	}
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (long i = 100000; i < 200000; i++)
		{
			
			if (containsSameDigits(i))
			{
			System.out.println(i);
			break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
		
	}

}
