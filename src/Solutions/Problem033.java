package Solutions;
/*
 * Author Alexander Kohler
 */
public class Problem033 {

	/*
	 *
The fraction 49/98 is a curious fraction, as an ineperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, 
is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial eamples.

There are eactly four non-trivial eamples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the productDenom of these four fractions is given in its lowest common terms, find the value of the denominator.
	 */
	
	
	//function that checks if the two numbers share like terms
		
	
	//if a set of two numbers shares like terms (we will include 1-10 for sake of one reduction), remove those values from the set of two, then get the fraction value,
	//compare that to the oiginal fraction value you get
	
	static void badMathReductionComparison ()
	{
		int productDenom = 1;
		int productNumer = 1;
		for (int numer = 1; numer < 100; numer++)
		{
			for (int denom = 1; denom < 100; denom ++)
			{

		
				StringBuilder numerS = new StringBuilder(String.valueOf(numer));
				StringBuilder denomS = new StringBuilder(String.valueOf(denom));
				boolean reduced = false;
				try
				{
				if (numerS.length() > 2 || numerS.length() > 2)
					{
					System.out.println("These numbers do not meet our 2 numbered criteria");
					}
				if (numerS.charAt(0) == denomS.charAt(0)) //remove these characters
				{
					numerS.setCharAt(0, 'x');
					denomS.setCharAt(0, 'x');
					reduced = true;
				}
				
				else if (denomS.length() > 1 && numerS.charAt(0) == denomS.charAt(1))
				{
					numerS.setCharAt(0, 'x');
					denomS.setCharAt(1, 'x');
					reduced = true;
				}
				
				else if (numerS.length() > 1 && numerS.charAt(1) == denomS.charAt(0) )
				{
					numerS.setCharAt(1, 'x');
					denomS.setCharAt(0, 'x');
					reduced = true;
				}
				
				else if (denomS.length() > 1 && numerS.length() > 1 && numerS.charAt(1) == denomS.charAt(1) && numerS.charAt(1) != '0')
				{
					numerS.setCharAt(1, 'x');
					denomS.setCharAt(1, 'x');
					reduced = true;
				}
				}
				catch (StringIndexOutOfBoundsException e)
				{
					System.out.println("Funkiness occured with " + numer + " and " + denom);
				}
				
				String reducedNumer = numerS.toString().replaceAll("x", "");
				String reducedDenom = denomS.toString().replaceAll("x", "");
				if (reducedNumer.equals(""))
					reducedNumer = "1";
				if (reducedDenom.equals(""))
					reducedDenom = "1";
				
				double decimalVal = (double) numer / denom;
				double psuedoDecimalVal = ((Double.valueOf(reducedNumer)  / Double.valueOf(reducedDenom)));
		

				if (decimalVal == psuedoDecimalVal && reduced && psuedoDecimalVal < 1 && decimalVal < 1)
				{
					//System.out.println("match with " + numer  + "/" + denom);
					//System.out.println("Real decimal value is " + decimalVal);
					//System.out.println("(Psuedo)Reduced value is " + reducedNumer + "/" + reducedDenom + "(" + psuedoDecimalVal + ")");
					productDenom = productDenom * Integer.valueOf(reducedDenom);
					productNumer = productNumer * Integer.valueOf(reducedNumer);
			
				}
			}//end demoninator loop
		}//end numerator lop
		System.out.println("Numerator product is " + productNumer);	
		System.out.println("Denominator product is " + productDenom);	

	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		badMathReductionComparison();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + "ms");
	}

}
