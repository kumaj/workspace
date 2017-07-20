import java.util.ArrayList;


/**
 *  DP --> 62. Unique Paths
 * @author kumaj04
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
public class UniquePaths {
	// construct a n*m matrix to store the no of paths at [i][j]
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
     
        int[][] dp = new int[m][n];
     
        //left column
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
     
        //top row
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
     
        //fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
     
        return dp[m-1][n-1];
    }
    
    // Interview Bit question must see
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		
	    int m = a.size();
	    ArrayList<Integer> rowItem = a.get(0);
	    int n = rowItem.size();
        
	    //convert into matrix
	    int[][] grid = new int[m][n];
	    for(int i = 0; i < m; i++) {
			 rowItem = a.get(i);
			 for(int j = 0; j < n; j++) {
                grid[i][j] = rowItem.get(j);
			 }
		}
	    
        if(m==0 && n==0) return 0;
        if(m==1 && n==1 && grid[0][0] == 0) return 1;
        if(m==1 && n==1 && grid[0][0] == 1) return 0;
	    
	    // if the 0th location is an obstacle then return 0
	    if(grid[0][0] == 1)
	    	return 0;
	    
	    // if it has found an obstacle then put 0 at that location
        //left column
	    boolean flag = false;
        for(int i=0; i<m; i++){
        	if(grid[i][0] == 1 || flag == true) {
        		grid[i][0] = 0;
        		flag = true;
        	}
        	else
        		grid[i][0] = 1;
        }
     
        //top row
        flag = false;
        for(int j=1; j<n; j++){
        	if(grid[0][j] == 1 || flag == true) {
        		grid[0][j] = 0;
        		flag = true;
        	}
        	else
        		grid[0][j] = 1;
        }
        
        //fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
            	if(grid[i][j] == 1)
            		grid[i][j] = 0;
            	else
            		grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
	}
}

class Solution {
	public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		
		ArrayList<Integer> inner = new ArrayList<Integer>();
		inner.add(0); inner.add(0); 
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(inner);
		
		System.out.println(u.uniquePathsWithObstacles(arr));
	}
}
