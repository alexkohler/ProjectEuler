package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem006 {

	// PROBLEM 6

	/*
	 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 +
	 * ... + 10^2 = 385
	 * 
	 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
	 * 10)2 = 552 = 3025
	 * 
	 * 
	 * Hence the difference between the sum of the squares of the first ten
	 * natural numbers and the square of the sum is 3025 − 385 = 2640.
	 * 
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 */
	//Metrics - 1ms
	static int square(int n) 
	{
		return n * n;
	}

	static int sumSquares() 
	{
		int sum = 0;
		for (int i = 0; i < 101; i++)
		{
			sum = sum + square(i);
		}

		return sum;
	}

	static int squareSums()
	{
		int sum = 0;
		for (int i = 0; i < 101; i++)
		{
			sum = sum + i;
		}
		return square(sum);

	}

	static int sumDifferences() 
	{
		return squareSums() - sumSquares();
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(sumDifferences());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
