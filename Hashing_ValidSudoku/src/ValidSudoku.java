import java.util.HashSet;
import java.util.List;


public class ValidSudoku {
	public int isValidSudoku(final List<String> a) {
	    //convert the list into 2D array of array
		Character[][] board = new Character[9][9];
		int k = 0;
		int l = 0;
		for(String str : a) {
			for(Character ch : str.toCharArray()) {
				board[k][l] = ch;
				l++;
			}
			k++;
		}
		
		// checking rows and columns
	    HashSet<Character> set, set2;
	    for (int i = 0; i < 9; i++) {
	        set = new HashSet<Character>();
	        set2 = new HashSet<Character>();
	        for (int j = 0; j < 9; j++) {
	            if(!set.add(board[i][j]) && board[i][j] != '.') return 0;
	            if(!set2.add(board[j][i]) && board[j][i] != '.') return 0;
	        }
	    }
	    // checking 9 boxes
	    for (int x = 0; x < 9; x += 3) {
	        for (int y = 0; y < 9; y += 3) {
	            set = new HashSet<Character>();
	            for (int i = x; i < x + 3; i++) {
	                for (int j = y; j < y + 3; j++) {
	                    if(!set.add(board[i][j]) && board[i][j] != '.') return 0;
	                }
	            }
	          }
	    }
	    return 1;
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
