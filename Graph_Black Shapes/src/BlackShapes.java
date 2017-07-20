import java.util.ArrayList;
/**
 * https://www.interviewbit.com/problems/black-shapes/
 * https://github.com/nagajyothi/InterviewBit/blob/master/Graphs/Black.java
 * @author kumaj04
 *
 */

public class BlackShapes {
	private int count = 0;
    private boolean marked[][];
    private int di[] = new int[] {1, -1, 0, 0};
    private int dj[] = new int[] {0, 0, 1, -1};
    private ArrayList<String> A;
    
    public int black(ArrayList<String> A) {
        int m, n;
        
        if (A == null)
            return 0;
        
        m = A.size();
        n = A.get(0).length();
        
        marked = new boolean[m][n];
        count = 0;
        this.A = A;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(i, j, m, n);
                    count++;
                }
            }
        }
        
        return count;
    }
    
 public void dfs(int i, int j, int m, int n) {
        
        marked[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            
            int ii = i + di[k];
            int jj = j + dj[k];
            
            if (isValid(ii, jj, m, n) && !marked[ii][jj]) {
                dfs(ii, jj, m, n);   
            }
            
        }
    }
 
 public boolean isValid(int i, int j, int m, int n) {
     
     if (i < 0 || i >= m || j < 0 || j >= n)
         return false;
     
     if (A.get(i).charAt(j) != 'X')
         return false;
     
     return true;
 }
    
}

class Solution {
	public static void main(String[] args) {
		BlackShapes b = new BlackShapes();
		   ArrayList<String> a = new ArrayList<String>();
/*	        a.add("OOOXOOO");
	        a.add("OOXXOXO");
	        a.add("OXOOOX0");*/
		   
/*	        a.add("XXX");
	        a.add("X00");
	        a.add("XX0");*/
		   
	        a.add("XXX");
	        a.add("0X0");
	        a.add("0X0");
	        
	        System.out.println(b.black(a));
	}
}
