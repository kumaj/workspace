import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.
Example:
If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:
[
    [3, 1],
    [4, 2]
]
 */
public class Clockwise {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	 //covert it into matrix first
		int size = a.size();
		if(size > 1) {
			Integer[][] matrix = new Integer[size][size];
			
			int i = 0;
			for (ArrayList<Integer> rows : a) {
				int j = 0;
				for(Integer no : rows) {
					matrix[i][j] = no;
					j++;
				}
				i++;
			}
			
			int g_top = 0;
			int g_down = size-1;
			int g_left = 0;
			int g_right = size-1;
	
			int top = 0;
			int down = size-1;
			int left = 0;
			int right = size-1;
			
			//start the logic
			while((g_left <= g_right) && (g_top <= g_down)) {
				
				int temp0 = matrix[g_top][left];
				int temp1 = matrix[top][g_right];
				int temp2 = matrix[g_down][right];
				int temp3 = matrix[down][g_left];
				
				//swap the elements in clockwise fashion
				matrix[top][g_right] = temp0;
				matrix[g_down][right] = temp1;
				matrix[down][g_left] = temp2;
				matrix[g_top][left] = temp3;
				
				left++; 
				right--;
				top++;
				down--;
				
				if(left == g_right){
					g_left++; 
					g_right--;
					g_top++;
					g_down--;
					
					left = g_left;
					right = g_right;
					top = g_top;
					down = g_down;
				} // if
			} //while
			
			//convert the matrix into array of arraylist
			//first clear the existing arraylist
			a.clear();
			for (Integer[] array : matrix) {
				List list = new ArrayList(Arrays.asList(array));
				a.add((ArrayList<Integer>) list);
			}
		}
	} //end of function
}

class Solution {
	public static void main(String[] args) {
		
		Clockwise c = new Clockwise();
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		
		//test case 1
//		row1.add(1); row1.add(2); row2.add(3); row2.add(4);
//		a.add(row1);
//		a.add(row2);
		
		//test case 2
//		row1.add(1);
//		a.add(row1);
		
		//test case 1
		row1.add(1); row1.add(2); row1.add(3);
		row2.add(4); row2.add(5); row2.add(6);
		row3.add(7); row3.add(8); row3.add(9);
		a.add(row1);
		a.add(row2);
		a.add(row3);
		
		//test case 4
//		row1.add(1); row1.add(2); row1.add(3); row1.add(4);
//		row2.add(5); row2.add(6); row2.add(7); row2.add(8);
//		row3.add(9); row3.add(10); row3.add(11); row3.add(12);
//		row4.add(13); row4.add(14); row4.add(15); row4.add(16);
//		a.add(row1);
//		a.add(row2);
//		a.add(row3);
//		a.add(row4);
		
		c.rotate(a);
	}
}
