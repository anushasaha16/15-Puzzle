import java.util.Arrays;
import java.util.Random;
/**
 * The Game class is the back-end representation of the 15-puzzle and provides methods that allow the game to function.
 * @author anush
 *
 */
public class Game {

	private int[][] num;		//represents the current state of the puzzle
	private int[][] numOrder;	//represents the winning state of the puzzle which will terminate the game
	private int numMoves;		//number of moves the user has made

	/**
	 * Initializes the Game class and sets the number of moves numMoves to 0
	 */
	public Game()
	{
		int[][] order = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
		num = order;

		int[][] order2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
		numOrder = order2;

		numMoves = 0;
	}
	/**
	 * 
	 * @return	the 2D array which represents the current state of the puzzle
	 */
	public int[][] getNum()
	{
		return num;
	}
	
	/**
	 * 
	 * @return	number of moves the user has made
	 */
	public int getNumMoves()
	{
		return numMoves;
	}
	
	/**
	 * Randomizes the position of the numbers in the 15-puzzle at the start of the game until the all the numbers are in
	 * such a position that the puzzle is solvable.
	 * @return	2D array representing the randomized and solvable puzzle
	 */
	public int[][] scramble()
	{
		while(this.isSolvable(num) == false)
		{
			Random random = new Random();

			for(int i = num.length - 1; i > 0; i--)
			{
				for(int j = num[i].length - 1; j > 0; j--)
				{
					int m = random.nextInt(i + 1);
					int n = random.nextInt(j + 1);

					int temp = num[i][j];
					num[i][j] = num[m][n];
					num[m][n] = temp;
				}
			}
		}
		 numMoves = 0;
		 return num;
	}
	
	/**
	 * Checks to see if the given number is next to a blank spot and if it is, moves it into the blank spot and alters 
	 * the positions of the other numbers and blank spot accordingly.
	 * @param n	the number that is intended to be moved into the blank spot
	 * @return	2D array representing the new state of the puzzle after the given number was moved into the blank spot
	 */
	public int[][] move(int n)
	{
		String posOfSpace = this.indexOf(num, -1);
		String[] ps = posOfSpace.split(", ");
		int psx = Integer.parseInt(ps[0]);
		int psy = Integer.parseInt(ps[1]);
		String pos = this.indexOf(num, n);
		String[] p = pos.split(", ");
		int px = Integer.parseInt(p[0]);
		int py = Integer.parseInt(p[1]);
		if(this.isAdjacent(px, psx)^this.isAdjacent(py, psy))
		{
			if(this.isAdjacent(px, psx))
			{
				if(py == psy)
				{
					num[psx][psy] = n;
					num[px][py] = -1;
					numMoves++;

				}
			}
			if(this.isAdjacent(py, psy))
			{
				if(px == psx)
				{
					num[psx][psy] = n;
					num[px][py] = -1;
					numMoves++;

				}
			}

		}
		return num;
	}
	
	/**
	 * Given a 2D array of Integers and an Integer, returns a String with the row and column of the given Integer within
	 * the array
	 * @param num	2D array of Integers
	 * @param n		Integer which method returns the row and column of
	 * @return		Row number r and column number c of n formatted like "(r, c)"
	 */
	public String indexOf(int[][] num, int n)
	{
		for (int r = 0; r < num.length; r++)
		{
		    for(int c = 0; c < num[r].length; c++)
			if (num[r][c] == n)
		    {
		    	return r + ", " + c;
		    }
		}
		return null;
	}
	
	/**
	 * Checks to see if two given indexes are adjacent 
	 * @param p		index of one element
	 * @param ps	index of second element
	 * @return		true if 2 indexes are adjacent and false otherwise
	 */
	public boolean isAdjacent(int p, int ps)
	{
		if(ps == p-1 || ps == p+1)
			return true;
		return false;
	}
	
	/**
	 * Checks to see if all the numbers are in the correct position.
	 * @return	true if the puzzle is completed and false otherwise
	 */
	public boolean finished()
	{
		if(equal(num, numOrder))
		return true;
		return false;
	}
	/**
	 * Checks to see if the two given 2D arrays are equal, meaning that all corresponding pairs of elements in the two 
	 * arrays are equal.
	 * @param arr1	Array of Integers to be compared
	 * @param arr2	Array of Integers to be compared
	 * @return		true if the arrays are equal and false otherwise
	 */
	public static boolean equal(final int[][] arr1, final int[][] arr2)
	{
		  if (arr1 == null)
		  {
			  return (arr2 == null);
		  }
		  if (arr2 == null)
		  {
			  return false;
		  }
		  if (arr1.length != arr2.length)
		  {
			  return false;
		  }
		  for (int i = 0; i < arr1.length; i++)
		  {
			  if (!Arrays.equals(arr1[i], arr2[i]))
			  {
				  return false;
			  }
		  }
		  return true;
	}
	
	/**
	 * Checks to see if the randomized puzzle is solvable or not.
	 * @param arr	2D array representing the initial randomized puzzle
	 * @return		true if the puzzle is solvable and false if not
	 */
	public boolean isSolvable(int [][] arr)
	{
		int[] puzzle = new int[16];
		int n = 0;
		for(int r = 0; r < arr.length; r++)
		{
			for(int c = 0; c < arr[r].length; c++)
			{
				puzzle[n] = arr[r][c];
				n++;
			}
		}
		
		int parity = 0;
	    int row = 0; 
	    int blankRow = 0; 

	    for (int i = 0; i < 16; i++)
	    {
	        if (i % 4 == 0)
	            row++;
	        
	        if (puzzle[i] == -1)
	        { 
	            blankRow = row; 
	            continue;
	        }
	        
	        for (int j = i + 1; j < 16; j++)
	        {
	            if (puzzle[i] > puzzle[j] && puzzle[j] != -1)
	                parity++;
	        }
	    }

	    if (blankRow % 2 == 0)
	    	return parity % 2 == 0;
	    else
	    	return parity % 2 != 0;
	}

}



