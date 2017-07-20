import java.util.Stack;

/**
 * Test if the directed graph is cyclic or not
 * @author kumaj04
 *
 */
public class CyclicGraph {
	public boolean isDirectedGraphCyclic(int[][] matrix, int root) {
		// Do DFS and if a visited node is visited gain then it means the graph is cyclic
		// because in cyclic graph you can visit any visited node again
		int noOfNodes = matrix.length;
		boolean[] isVisited = new boolean[noOfNodes];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);
		isVisited[root] = true;
		
		while(!stack.isEmpty()) {
			//pop the stack element
			int temp = stack.pop();
			int childNode = 0;
			while((childNode = getUnvistedAdjacentNode(matrix, temp, isVisited))!= 0) {
				if(childNode == -1) // if -1 then it is cyclic
					return true;
				else if(childNode == 1)
					stack.push(childNode);
			} // while
		} // outer while
		return false;
	}

	private int getUnvistedAdjacentNode(int[][] matrix, int temp, boolean[] isVisited) {
		int col = matrix[0].length;
		for(int i = 0; i<col; i++) {
			if(matrix[temp][i] == 1 && !isVisited[i]) {
				isVisited[i] = true;
				return i;
			}
			else if(matrix[temp][i] == 1 && isVisited[i]){ // if this node is already visited earlier then it is cyclic
				return -1;
			}
		}
		return 0;
	}
}
