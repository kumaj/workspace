
/**
 * Driver class to test the graph traversal
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Graph g = new Graph();
		int[][] graphMatrix = { {0,1,0,1}, {1,0,1,0}, {0,1,0,0}, {1,0,0,0} };
		g.DFS(0, graphMatrix);
	}
}
