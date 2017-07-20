import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
Example:
Given n = 3,
You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
 */
public class Spiral {
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		
		int top = 0;
		int down = a-1;
		int left = 0;
		int right = a-1;
	
		Integer num = 1;
		Integer[][] matx = new Integer[a][a];
		
		while((left <= right) || (top <= down)) {
			//traverse left to right
			for(int i = left; i <= right; i++) {
				matx[top][i] = num;
				num++;
			}
			top++;
			
			//traverse top to down
			for(int j = top; j <= down; j++) {
				matx[j][right] = num;
				num++;
			}
			right--;
			
			//traverse right to left
			for(int k = right; k>= left; k--) {
				matx[down][k] = num;
				num++;
			}
			down--;
			
			//traverse from bottom to up
			for(int l = down; l >= top; l--) {
				matx[l][left] = num;
				num++;
			}
			left++;
		}// end of while
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (Integer[] array : matx) {
			List list = new ArrayList(Arrays.asList(array));
			matrix.add((ArrayList<Integer>) list);
		}
		return matrix;
	}
}

class Solution {
	public static void main(String[] args) {
		Spiral s = new Spiral();
		
		int a = 3;
		System.out.println(s.generateMatrix(a));
	}
}
