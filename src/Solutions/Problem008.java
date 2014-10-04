package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Problem008 {

//The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.	
//Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	static String readFileAndCreateThousandDigit() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("/home/alex/workspace/ProjectEuler/src/Resources/Problem008Resource.txt"));
		String line;
		String thousandDigitNumber = "";
		while ((line = br.readLine()) != null)
			thousandDigitNumber = thousandDigitNumber + line;
		
		br.close();
		return thousandDigitNumber;
	}
	
	static long parseNumbersAndFindGreatestProduct() throws IOException
	{
		String thousandDigitNumber = readFileAndCreateThousandDigit();
		int startFwd = 0;
		int endFwd = 13;
		String currentChunk = "";
		long greatest = 0;
		long current = 0;
		while (endFwd != 1000)
		{
			currentChunk = thousandDigitNumber.substring(startFwd, endFwd);
			if (currentChunk.length() != 13)
				System.out.println("shit");
			current = getStringProduct(currentChunk);
			if (current > greatest)
				greatest = current;
			
			startFwd++;
			endFwd++;
			
		}
		
		return greatest;
	}
	
	static long getStringProduct(String chunk) 
	{
		char[] arr = chunk.toCharArray();
		long total = 1;
		for (char c : arr)
		{
			total *= Character.getNumericValue(c);
		}
		
return total;
	}
	
	
	public static void main (String args[]) throws IOException
	{
		long startTime = System.currentTimeMillis();
		System.out.println(parseNumbersAndFindGreatestProduct());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	//Lesson learned : don't forget about integer overflow.
}