import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class to do the bfs and dfs traversal
 * @author kumaj04
 *
 */
public class Traversal {

/*	public void dfs(int[][] graphMatrix) {
		int row = graphMatrix.length;
		int col = graphMatrix[0].length;
		boolean[] isVisisted = new boolean[row]; // false
		
		//start the traversal from the beginning of the matrix
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		while(!stack.isEmpty()) {
			int temp = stack.pop(); // peek the element not remove it
			System.out.print(temp + " "); // print this node
			//get the node which is attached to it and unvisited
			int node = getUnvisitedNode(temp, col, graphMatrix, isVisisted);
			while(node != 0) {
				stack.push(node);
				node = getUnvisitedNode(temp, col, graphMatrix, isVisisted);
			} 
		}
	}*/
	
	
	public void dfs(int[][] graphMatrix) {
		int row = graphMatrix.length;
		int col = graphMatrix[0].length;
		boolean[] isVisisted = new boolean[row]; // false
		
		//start the traversal from the beginning of the matrix
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		isVisisted[0] = true;
		System.out.print(0 + " "); // print this node
		
		while(!stack.isEmpty()) {
			int temp = stack.peek(); // peek the element not remove it
			//get the node which is attached to it and unvisited
			int node = getUnvisitedNode(temp, col, graphMatrix, isVisisted);
			if(node != 0) {
				System.out.print(node + " "); // print this node
				stack.push(node);
			} else {
				stack.pop();
			}
		}
	}
	
	/**
	 * BFS Traversal of the node.
	 * @param graphMatrix
	 */
	public void bfs(int[][] graphMatrix) {
		int row = graphMatrix.length;
		int col = graphMatrix[0].length;
		boolean[] isVisited = new boolean[row];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		isVisited[0] =  true;
		System.out.print(0 + " ");
		
		while(!queue.isEmpty()) {
			//remove the element from the queue
			int temp = queue.remove();
			//get all the unvisited node 
			int child = 0;
			while((child = getUnvisitedNode(temp, col, graphMatrix, isVisited)) != 0) {
				//add the child into the queue
				queue.add(child);
				System.out.print(child + " ");
			}
		}
	}

	private int getUnvisitedNode(int temp, int col, int[][] matrix, boolean[] isVisited) {
		for(int j = 0; j<col; j++) {
			if(matrix[temp][j] == 1 && !isVisited[j]) {
				isVisited[j] = true;
				return j;
			}
		}
		return 0;
	}
}
