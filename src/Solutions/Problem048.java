package Solutions;
/*
 * Author Alexander Kohler
 */
import java.math.BigInteger;

public class Problem048 {
/*
  The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */
	//metrics - 104ms
	static String lastTen()
	{
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i < 1001; i++)
			sum = sum.add(new BigInteger(String.valueOf(i)).pow(i));
		 return sum.toString().substring(sum.toString().length() - 10, sum.toString().length());
	}
	
	
	//Metrics = 84ms
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		System.out.println(lastTen());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");

	}

}
