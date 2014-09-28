package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Problem022 {

/*	Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

	What is the total of all the name scores in the file?*/
	
	//Metrics - ~98ms


static int calculateNameScoreTotal() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("src/Resources/Problem022Resource.txt"));
		String line;
		int lineNumber = 0;
		int total = 0;
		line = br.readLine();
		br.close();
		line = line.replace("\"", "");
		String[] nameArr = line.split(",");
		 List<String> nameList = Arrays.asList(nameArr);
		java.util.Collections.sort(nameList);
		for (String name : nameArr)
		{
			lineNumber++;
			
			total += (lineNumber * calculateNameScore(name));
		}
		return total;
	}
	
	//Convert each character to its ASCII code, subtract the ASCII code for "a" and add 1.
	//ascii code for a is 96
	static int calculateNameScore(String name)
	{
	name = name.toLowerCase(); //don't need to worry about uppercase ascii values
	char[] charArray = name.toCharArray();
	int score = 0;
		for (char c : charArray)
		{
		int temp = (int) c;
			score += (temp-96);
		}
		
		return score;
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{
		long startTime = System.currentTimeMillis();
		System.out.println(calculateNameScoreTotal());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}

