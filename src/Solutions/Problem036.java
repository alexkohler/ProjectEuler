package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem036 {

	/*

	 *The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
	 *
	 */
	//metrics 1120ms
	
	static boolean isPalindrome (String s)
	{
		StringBuilder sb = new StringBuilder(s);
		return sb.toString().intern() == sb.reverse().toString().intern();
	}
	
	static long sumPalindromicBinaries()
	{
		long sum = 0;
		for (int i = 0; i < 1000000; i++)
			if (isPalindrome(Integer.toBinaryString(i)) && isPalindrome(String.valueOf(i)))
				sum += i;	
		return sum;
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(sumPalindromicBinaries());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime ) + "ms");
	}

}
