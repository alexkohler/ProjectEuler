package Solutions;
/*
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

	21 22 23 24 25 26    //0
	20  7  8  9 10 27	 	//1
	19  6  1  2 11 28	//2
	18  5  4  3 12 29		//3
	17 16 15 14 13 30		//4
	36 35 34 33	32 31
It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
//1-500
//501
//502 - 1001

public class Problem028 {
	
	static int[][] generateXByXGrid(int x)
	{
		int middle = ((x - 1) / 2);
		int endNum = x * x;
		System.out.println(middle);
		int[][] grid = new int[x][x];
		
		int iter = 1;
		int v = middle;
		int h = middle;
		grid[v][h] = iter;
		iter++;
		int odd = 1;
		int even = 2;
		int currentPosV = middle;
		int currentPosH = middle;
		
		while (iter <= endNum)
		{
			for (int i = 1; i <= odd; i++)
			{
				if(iter <= endNum)
				{
				grid[currentPosV][currentPosH + i] = iter;
				iter++;
				}
				else
					break;
			}
			currentPosH = currentPosH + odd;
			
			for (int i = 1; i <= odd; i++)
			{ 
				if (iter <= endNum)
				{
					grid[currentPosV + i][currentPosH] = iter;
					iter++;
				}
				else
					break;
			}
			currentPosV = currentPosV + odd;
			
				for (int i = 1; i <= even; i++)
				{
					if (iter <= endNum)
					{
					grid[currentPosV][currentPosH - i] = iter;
					iter++;
					}
					else
						break;
				}
				currentPosH = currentPosH - even;
			

				for (int i = 1; i <= even; i++)
				{
					if (iter <= endNum)
					{	
					grid[currentPosV - i][currentPosH] = iter;
					iter++;
					}
					else
						break;
				}
				currentPosV = currentPosV - even;

			
			odd = odd + 2;
			even = even + 2;
			
		}
		
		return grid;
	}
	
	  static int traverseGridDiagonallyLeftCorner(int x) 
	  {
		  int[][] grid = generateXByXGrid(x);
			int sum = 0;
			//down one left one
			int v = 0;
		 for (int i = x -1; i >= 0; i--)
		 {
			 sum += grid[i][v]; 
			 v++;
		 }
		 return sum;
	  }
	  
		
	  static int traverseGridDiagonallyRightCorner(int x) 
	  {
		  int[][] grid = generateXByXGrid(x);
			int sum = 0;
			//down one left one
		 for (int i = 0; i < x; i++)
		 {
			 sum += grid[i][i]; 
		 }
		 return sum -1; //dont count middle
	  }

	public static void main(String[] args) {
		//generateXByXGrid(1001);
		System.out.println();
		System.out.println(traverseGridDiagonallyRightCorner(1001) + traverseGridDiagonallyLeftCorner(1001));
		
	}

}
