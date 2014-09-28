package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Problem013 {

	/*
	 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers. (Given in Problem014Resource.txt)
	 */
	
	//Metrics - 8ms (maybe my linux machine is a little faster than little old mac or work computer :) )
	
	static String readAndSum() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("src/Resources/Problem013Resource.txt"));
		String line;
		BigInteger currentSum = new BigInteger("0");
		while ((line = br.readLine()) != null) 
		{
			currentSum = currentSum.add(new BigInteger(line.toString()));
		}
		br.close();
		
		
		return currentSum.toString().substring(0, 10);
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(readAndSum());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
