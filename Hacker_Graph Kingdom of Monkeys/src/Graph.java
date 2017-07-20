import java.util.ArrayList;

/**
 * https://www.hackerearth.com/challenge/competitive/code-monk-graph-theory-i/problems/
 * https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/kingdom-of-monkeys/
 * @author kumaj04
 *
 */
public class Graph {
	ArrayList<Node> nodeList;
	boolean[] isVisited;
	int[][] matrix; // edges are represented in the form of adjacency matrix
	
	public Graph(int totalNodes) {
		nodeList = new ArrayList<Node>();
		isVisited = new boolean[totalNodes];
		matrix = new int[totalNodes][totalNodes];
	}
	/**
	 * Add the node in the arraylist
	 * @param node
	 */
	public void addNode(Node node) {
		// if the node is not present then add it 
		boolean isPresent = false;
		for(Node temp : nodeList) {
			if(temp.data == node.data) {
				isPresent = true;
			}
		}
		if(!isPresent)
			nodeList.add(node);
	}
	
	/**
	 * Connect two nodes
	 * @param source
	 * @param target
	 */
	public void connectNodes(int source, int target) {
		matrix[source-1][target-1] = 1;
		matrix[target-1][source-1] = 1;
	}
}

