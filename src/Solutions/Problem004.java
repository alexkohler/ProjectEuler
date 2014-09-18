package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
public class Problem004 {

	/*A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

			Find the largest palindrome made from the product of two 3-digit numbers.*/
	

	//Metrics: 230 miliseconds
	
	
			static void palindromeFinder()
			{
				
				int largest = 0;
				int product = 0;
				String intString;
				StringBuilder reversedString;
				for (int i = 100; i < 1000; i++)
				{
					for (int j = 100; j < 1000; j++)
					{
						product = i * j;
						intString = String.valueOf(product);
						if (intString.length() % 2 == 0)
						{
							reversedString = new StringBuilder(intString.substring(3, 6));
						if (intString.substring(0, 3).equals(reversedString.reverse().toString()))
						{
//							System.out.println(i + " x " + j + " = " + intString);
							if (Integer.valueOf(intString) > largest)
								largest = Integer.valueOf(intString);
						}
								
						}
					}
					System.out.println(largest);
					
					
				}
				
				
			}
	
	
	
	public static void main (String args[])
	{
		long startTime = System.currentTimeMillis();
		palindromeFinder();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	
}
