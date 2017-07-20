import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/word-search-board/
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell. 
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
 * @author kumaj04
 *
 */
public class WordSearch {
	public int exist(ArrayList<String> a, String b) {
		// put all the list of string into a 2d array
		int row = a.size();
		int col = a.get(0).length();
		int[][] matrix = new int[row][col];
		int i = 0;
		int j = 0;
		for (String str : a) {
			for(int k = 0; k<str.length(); k++) {
				matrix[i][j] = str.charAt(k);
				j++;
			}
			i++;
		}
		
		//Once you get the 2d array 
		return doesWordExist(matrix, b, row, col);
    }

	private int return doesWordExist(int[][] matrix, String b, int row, int col) {
		for(int i = 0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(matrix[i][j] == )
			}
		}
	}
}
