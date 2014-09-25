package Solutions;

public class Problem017UF {

	/*
	 *If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
	 */
	
	
	static String writtenOutInWords(int n)
	{
		String wordBuffer = "";
		String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		//this variable will pull off each value individually
		
		int separatedVal = n % 10;
		int currentStanding = 1; //ones, tens. hundreds, thousands, etc
		while (n > 0) // i.e. has more than one place
		{
			separatedVal = n % 10;
			System.out.println(separatedVal);
			n = n / 10;
		}
	//	System.out.println(separatedVal);
		
		
		return wordBuffer;
	}
	
	
	
	public static void main(String[] args) {
	
		System.out.println(writtenOutInWords(312));
/*		int n = 4122;
		System.out.println(n);
		System.out.println(n % 10); // pull off end digit
		n = n / 10;
		System.out.println(n);
		System.out.println(n % 10);
		n = n / 10;
		System.out.println(n);
		System.out.println(n % 10);
		n = n / 10;
		System.out.println(n);
		System.out.println(n % 10);
		n = n / 10;
		System.out.println(n);
		System.out.println(n % 10);
		n = n / 10;
		System.out.println(n);
		System.out.println(n % 10);*/
	}

}
