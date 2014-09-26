package Solutions;

public class Problem017 {

	/*
	 *If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
	 */
	
	
	static String writtenOutInWords(int n)
	{
		StringBuilder wordBuffer = new StringBuilder("");
		String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; //1
		String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; //2 - double case
		String[] tens = {"ignore", "ignore", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		//this variable will pull off each value individually
		int separatedVal = n % 10;
		int currentStanding = 0; //ones, tens. hundreds, thousands, etc
		int onesVal = 0; //we can assert that this will change based on the incrementing of currentStanding and hitting case 1
		int tensVal = 0;
		int tensChunk = n % 100;
		int hundredsVal = 0;
		while (n > 0) // i.e. has more than one place
		{
			separatedVal = n % 10;
			//System.out.println(separatedVal);
			n = n / 10;
			currentStanding++;
			switch (currentStanding)
			{
			case 1://only ones
			{
				if ((tensChunk > 19 || tensChunk < 10) && (tensChunk % 10) != 0)
				{
				wordBuffer.append(ones[separatedVal]);
				}
				onesVal = separatedVal;
				break;
				
			}
			
			case 2: //Tens, either we have irregulars (teens array), or our traditional tens (tens array)
				tensVal = separatedVal;
				if (separatedVal == 1)// then we are in the teens
					wordBuffer.append(teens[onesVal]); //no need to append here either, still a base case
				else if (separatedVal != 0)//we have normal numbers
					wordBuffer.insert(0, tens[tensVal]);
				break;
			case 3: //hundreds
				hundredsVal = separatedVal;
				if (tensChunk != 0)
				wordBuffer.insert(0, ones[hundredsVal] + "hundredAnd");
				else
					wordBuffer = new StringBuilder(ones[hundredsVal] + "hundred");	
				break;
			}
		}
	//	System.out.println(separatedVal);
		
		
		return wordBuffer.toString();
	}
	
	
	static int findWrittenOutTotal()
	{
		int total = 0;
		String t = "onethousand"; //:) 
		for (int i = 1; i < 1000; i++)
		{
		 total += writtenOutInWords(i).length();
		// System.out.println(i + ": " + writtenOutInWords(i));
		}
		
		
		return total + t.length();
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
			System.out.println(findWrittenOutTotal());
			long endTime = System.currentTimeMillis();
			System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
