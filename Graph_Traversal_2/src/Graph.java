import java.util.Stack;

/**
 * This is my own version of graph traversal using adjacency matrix
 * I wrote it by my own thinking.
 * @author kumaj04
 *
 */
public class Graph {
	public void DFS(int root, int[][] graphMatrix) {
		//create a stack and put the root node in it
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root); 
		int noOfNodes = graphMatrix.length;
		boolean[] hasVisited = new boolean[noOfNodes];
		hasVisited[0] = true;
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			System.out.println(temp + " ");
			//get it adjacent nodes which are not visisted yet and 
			// put it inside the stack
			int childNode = 0;
			while((childNode = getAdjacentUnvisitedNode(temp, graphMatrix, hasVisited)) != 0) {
				stack.push(childNode);
			}
		}
	}

	private int getAdjacentUnvisitedNode(int sourceNode, int[][] graphMatrix, boolean[] hasVisited) {
		//traverse the sourceNode row in matrix and get all the element whose value is 1
		//Get no of columns first
		int col = graphMatrix[0].length;
		for(int i = 0; i <  col; i++) {
			if(graphMatrix[sourceNode][i] == 1 && !hasVisited[i]) {
				hasVisited[i] = true;
				return i;
			}// if
		} // for
		return 0;
	}
}
