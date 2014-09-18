package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem020 
{
/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100! 
*/

//Metrics - ~0ms
	static void problemTwenty()
	{
		String decimalString = "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";
		char[] decStringArray = decimalString.toCharArray();
		int sum = 0;
		for (char c: decStringArray)
		{
			sum = sum + Character.getNumericValue(c);
		}
		System.out.println(sum);
	}
	
	
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		problemTwenty();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	
}
