/**
 * Driver class to test whether the directed graph is cyclic or not
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		CyclicGraph c = new CyclicGraph();
		/*int[][] graphMatrix = { {0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0} };*/
		
		int[][] graphMatrix = { {0,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,0}, {1,0,0,0, 0}, {1,1,1,1,0} };
		System.out.println(c.isDirectedGraphCyclic(graphMatrix, 0));
	}
}
