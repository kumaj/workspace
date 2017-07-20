import java.util.List;


/**
 * 
 * @author kumaj04
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class MinSum {
	 public int minimumTotal(List<List<Integer>> triangle) {
		 int min = Integer.MAX_VALUE;
		 int sum = 0;
		 for (List<Integer> list : triangle) {
			for(Integer num : list) {
				if(num < min)
					min = num;
			}
			sum = sum + min;
			min = Integer.MAX_VALUE;
		}
		 return sum;
	 }
}

class Solution {
	public static void main(String[] args) {
		MinSum m = new MinSum();
		
		List<Integer> list = 
		System.out.println();
	}
}