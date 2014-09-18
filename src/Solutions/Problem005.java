package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem005 {

	/*2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?*/
	
	
	//Metrics: 2747ms 
	
	static int smallestPosTwentyDiv() //we love cryptic function names
	{
		int divisor = 1;
		int number = 2700;
		for (; number < 2000000000; number++)
		{
			divisor = 1;
			for (; divisor < 21; divisor++)
			{
				if (number % divisor == 0)
					continue;
				else
					break;
				
			}
			
			if (divisor == 21)
				return number;
		}	

		return -1;
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(smallestPosTwentyDiv());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

	}

}
