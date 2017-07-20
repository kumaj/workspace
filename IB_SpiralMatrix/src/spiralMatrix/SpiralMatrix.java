
//Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
//Example:
//Given the following matrix:
//[
//    [ 1, 2, 3 ],
//    [ 4, 5, 6 ],
//    [ 7, 8, 9 ]
//]
// a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
//You should return
//[1, 2, 3, 6, 9, 8, 7, 4, 5]

package spiralMatrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrix
{
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 // Populate result;
		 
		 //get the count of rows and columns
		 int row = a.size();
		 ArrayList<Integer> subArray = a.get(0);
		 int col = subArray.size();
		 int[][] matrix = new int[row][col];
		 
		 //Store all the result into the single arraylist
		for (ArrayList<Integer> subArr : a) 
		{
			result.addAll(subArr);
		}
		//fill the matrix
		int k = 0;
		 for(int i = 0; i< row; i++)
		 {
			 for(int j = 0; j< col; j++)
				 matrix[i][j] = result.remove(0);
		 }
		 
		 //Take four pointers 
		 int top = 0;
		 int bottom = row - 1;
		 int left = 0;
		 int right = col - 1;
		 
		 //Take a direction pointer which use to denote the current 
		 //direction of the print 0->right, 1->bottom, 2->left, 3->up
		 int dir = 0;
		 
		 while(top <= bottom && left <= right)
		 {
			 //Move towards right
			 if(dir == 0)
			 {
				 for(int i = left; i<= right; i++)
				 {
					 result.add(matrix[top][i]);
				 }
				 top++;
				 dir = 1;
			 }
			 //Move towards bottom now
			 else if(dir == 1)
			 {
				 for(int i = top; i<=bottom; i++)
				 {
					 result.add(matrix[i][right]);
				 }
				 right--;
				 dir = 2;
			 }
			 //Move towards left
			 else if(dir == 2)
			 {
				 for(int i = right; i >=left; i--)
				 {
					 result.add(matrix[bottom][i]);
				 }
				 bottom--;
				 dir = 3;
			 }
			 //Move towards upward
			 else if(dir == 3)
			 {
				 for(int i = bottom; i>= top; i--)
				 {
					 result.add(matrix[i][left]);
				 }
				 left++;
				 dir = 0;
			 }
		 }
		 return result;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		SpiralMatrix sprl = new SpiralMatrix();	
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		ArrayList<Integer> r3 = new ArrayList<Integer>();
		
		List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		r1.add(1); r1.add(2); r1.add(3);
		r2.add(4); r2.add(5); r2.add(6);
		r3.add(7); r3.add(8); r3.add(9);
		
		arr.add(r1); arr.add(r2); arr.add(r3);
		
		System.out.println(arr);
		//find the size of the arr
		System.out.println(arr.size());
		
		int row = arr.size();
		 Iterator<ArrayList<Integer>> subArrItr = arr.iterator();
		 ArrayList<Integer> subArr = subArrItr.next();
		 int col = subArr.size();
		 System.out.println("row : " + row);
		 System.out.println("col : " + col);
		 
		 System.out.println(sprl.spiralOrder(arr));
		
	}
}