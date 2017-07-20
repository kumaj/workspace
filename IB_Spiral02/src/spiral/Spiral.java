package spiral;

import java.util.ArrayList;

public class Spiral {

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		//a is the number of rows and columns
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			int row, col;
			row = col = 2*a - 1;
			
			int left = 0;
			int right = row-1;
			int top = 0;
			int bottom = col-1;
			int dir = 0; // 0-> left to right, 1-> top to bottom, 3-> right to left, 4-> bottom to top
			int[][] matrix = new int[row][col];
			Boolean flag = false;
			
			while(left <= right && top <= bottom)
			{
				//left to right
				flag = false;
				if(dir == 0)
				{
					for(int i = left; i<= right; i++)
						matrix[top][i] = a;
					dir = 1;
					top++;
				}
				//top to bottom
				else if(dir == 1)
				{
					for(int i = top; i<= bottom; i++)
						matrix[i][right] = a;
					dir = 2;
					right--;
				}
				//right to left
				else if(dir == 2)
				{
					for(int i = right; i>= left; i--)
						matrix[bottom][i] = a;
					dir = 3;
					bottom--;
				}
				//bottom to top
				else if(dir == 3)
				{
					for(int i = bottom; i>= top; i--)
						matrix[i][left] = a;
					dir = 0;
					left++;
					flag = true;
				}
				if(flag) a--;
			}
			
			//iterate the matrix and put it in arraylist
			ArrayList<Integer> temp = null;
			for(int i= 0; i < row; i++)
			{
				temp = new ArrayList<Integer>();
				for(int j = 0; j< col ;j++)
				{
					temp.add(matrix[i][j]);
				}
				result.add(temp);
			}
			return result;
		}
}

class Solution
{
	public static void main(String[] args)
	{
		Spiral sprl = new Spiral();
		System.out.println(sprl.prettyPrint(3));
	}
}
