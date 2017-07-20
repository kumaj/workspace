package SettoZero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/*
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
Do it in place.
Example
Given array A as
1 0 1
1 1 1 
1 1 1
On returning, the array A should be :
0 0 0
1 0 1
1 0 1
 */
import java.util.Set;

public class SetZero {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int size = a.size();
		ArrayList<Integer> rowItem = null;
		Set<Integer> rowWithZeros = new HashSet<Integer>();
		Set<Integer> colWithZeros = new HashSet<Integer>();
		for(int i = 0; i < size; i++) {
			 rowItem = a.get(i);
			 for(int j = 0; j < rowItem.size(); j++) {
				 if(rowItem.get(j) == 0) {
					 //store the row and column
					 rowWithZeros.add(i);
					 colWithZeros.add(j);
				 }
			 }
		}
		
		for (Integer rowNo : rowWithZeros) {
			//set this row to zero
			ArrayList<Integer> row = a.get(rowNo);
			for(int k = 0; k < row.size(); k++) {
				row.set(k, 0);
			}
		}
		
		//set the col to zero now
		for (Integer colNo : colWithZeros) {
			for(int k = 0; k < a.size(); k++) {
				ArrayList<Integer> row = a.get(k);
				row.set(colNo, 0);
			}
		}
	}
}

class Solution {
	public static void main(String[] args) {
		SetZero st = new SetZero();
		/*  [0, 0]
		  [1, 1] */
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(0); row1.add(0); 
		
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(1); row2.add(1);
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(row1);
		matrix.add(row2);
		
		st.setZeroes(matrix);
		
		for (ArrayList<Integer> array : matrix) {
			System.out.println(array);
		}
	}
}
