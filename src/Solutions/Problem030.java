package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem030 {
	/*Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

	1634 = 1^4 + 6^4 + 3^4 + 4^4
	8208 = 8^4 + 2^4 + 0^4 + 8^4
	9474 = 9^4 + 4^4 + 7^4 + 4^4
	As 1 = 1^4 is not a sum it is not included.

	The sum of these numbers is 1634 + 8208 + 9474 = 19316.

	Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.*/

	//Metrics - 934ms
	
static void writtenAsFourthPower()
{
	long startTime = System.currentTimeMillis();
	int[] segments = new int[4];
	boolean flagOne = false;
	boolean flagTwo = false;
		int finalSum = 0;
		for (int i = 2; i < 1000000; i++)
		{
		int sum = 0;
		int number = i;
		
		//parse segments into an array
		int length = (int)(Math.log10(i)+1);
		if (length > 4 && !flagOne)
		{
			segments = new int[5];
			flagOne = true;
		}
		if (length > 5 && !flagTwo)
		{
			segments = new int[6];
			flagTwo = true;
		}
			for (int j = length - 1; j >= 0; j--)
			{
			segments[j] = number % 10;
			number = number / 10;
			}
		
			//sum their fourth powers
			for (int segment : segments)
			{
				sum = (int) (sum + Math.pow(segment, 5)); //assert - these numbers will play nice and will not be decimals
			}
		
		//	if (i == sum)
		//	System.out.println(sum);
			if (i == sum)
			{
			finalSum = finalSum + sum;
			}

		}
		
		System.out.println(finalSum);
		long endTime = System.currentTimeMillis();

		System.out.println("That took " + (endTime - startTime) + " milliseconds");
}
	public static void main(String[] args) 
	{
		writtenAsFourthPower();
		
	}

}
