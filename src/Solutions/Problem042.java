package Solutions;
/*
 * Author Alexander Kohler
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem042 {

/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/
	
	
	
	//assert - largest word was around the size of "Beautiful" which is 8 letters, let's assume it has a all alphabetical positions of z, meaning largest triangle number we should need to compute
	//is 8 * 26 = ~208, so we'll compute triangle numbers up to 500 :) 
	
	//metrics - 99ms
	
	static ArrayList<String> populateTriangleNumbers()
	{
		ArrayList<String> triangleNumbers = new ArrayList<String>();
		for (int n = 1; n < 19; n++) //optimize by shortening this in a second...
		{
			int triNum = ((n) * (n + 1)) / 2;
			triangleNumbers.add(String.valueOf(triNum));
			System.out.println(triNum);
		}
		return triangleNumbers;
	}
	
	static void processWords() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("src/Resources/Problem042Resource.txt"));
		String line;
		ArrayList<String> trilist = populateTriangleNumbers();
		int triCount = 0;
		while ((line = br.readLine()) != null) {
			line.replaceAll("\"|,", "");
			char[] ch = line.toLowerCase().toCharArray();
			int charSum = 0;
			for(char c : ch)
			{
			int temp = (int)c;
				if(temp<=122 & temp>=97)
				{
				charSum += (temp - 96);
				}
			}

			for (String tri : trilist)
			{
				if (tri.intern().equals(String.valueOf(charSum).intern()))
				{
				triCount++;
				}
			}
		}
		br.close();
		System.out.println("There were " + triCount + " matches");
	}
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		processWords();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
		
	}

}
