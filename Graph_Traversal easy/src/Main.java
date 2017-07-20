/**
 * This is the driver class
 * http://www.geeksforgeeks.org/graph-and-its-representations/
 * @author kumaj04
 *
 */
public class Main {
	public static void main(String[] args) {
		int[][] graphMatrix = { {0,1,0,0,0},
				              {1,0,1,0,0},
				              {0,1,0,1,0},
				              {0,0,1,0,1},
				              {0,0,0,1,0}
		                };
		
		int[][] graphMatrix2 = { {0, 1, 0, 0, 0, 0, 1, 0, 1, 0},
		                         {1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
		                         {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
		                         {0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
		                         {0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
		                         {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
		                         {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		                         {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		                         {1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
		                         {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}
		                         };
		//using the above input, do teh bfs and dfs traversal
		Traversal t = new Traversal();
		t.dfs(graphMatrix);
		System.out.println();
		t.dfs(graphMatrix2);
		System.out.println("\nbfs traversal");
		t.bfs(graphMatrix);
		System.out.println();
		t.bfs(graphMatrix2);
	}
}
