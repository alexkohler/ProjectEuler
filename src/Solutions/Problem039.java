package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem039 {

	/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
	 */
	
	//Metrics - 588ms
	static int findSolutionsFor(int p)
	{
		double hyp = 0;
		int numberOfSolutions = 0;
		for (int legOne = 1; legOne < (p /2); legOne++)
		{
			for (int legTwo = 1; legTwo < (p /2); legTwo++)
			{
				if (legTwo > legOne)
				{
					hyp = Math.sqrt((legOne * legOne) + (legTwo * legTwo));
					if (hyp % 1 == 0) // see if hyponotenuse is whole (an integer)
					{
						if ((legOne + legTwo + hyp) == p)
						{
							//System.out.println("Found solution: " + "{" + legOne+ "," + legTwo + "," + "," + hyp + "}");
							numberOfSolutions++;
						}
					}
				}
			}
			
		}
		
		return numberOfSolutions;
	}
	
	
	static int maximizeNumberOfSolutions()
	{
		int greatest = 0;
		int current = 0;
		int greatestPVal = 0;
		for (int p = 1; p < 1001; p++)
		{
			current = findSolutionsFor(p);
			if (current > greatest)
			{
				greatest = current;
				greatestPVal = p;
//				System.out.println("Found new greatest number of solutions with p=" + p);
			}
		}
		
		return greatestPVal;
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(maximizeNumberOfSolutions());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
	}

}
