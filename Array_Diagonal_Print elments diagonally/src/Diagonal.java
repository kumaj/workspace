import java.util.ArrayList;


public class Diagonal {
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//convert it into matrix first
		int size = a.size();
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
		
		int top = 0;
		int down = size-1;
		int left = 0;
		int right = size-1;
		
		//get all the elements from first row
		ArrayList<Integer> arr;
		while(left <= right) {
			arr = getElementsDiagonally(size, top, left, matrix);
			res.add(arr);
			left++;
		}
		top++;
		
		//get all the elements from the last column
		while(top <= down) {
			arr = getElementsDiagonally(size, top, down, matrix);
			res.add(arr);
			top++;
		}
		
		return res;
	}

	private ArrayList<Integer> getElementsDiagonally(int size, int row, int col, Integer[][] matrix) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		while((row <= (size-1)) && (col >= 0)) {
			arr.add(matrix[row][col]);
			row = row + 1;
			col = col - 1;
		}
		return arr;
	} // getElementsDiagonally
}

class Solution {
	public static void main(String[] args) {
		Diagonal d = new Diagonal();
	}
}
