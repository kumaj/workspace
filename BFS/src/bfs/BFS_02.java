package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class use arraylist of arraylist
 * @author kumaj04
 *
 */
public class BFS_02 {
	private int vertex;
	private ArrayList<ArrayList<Integer>> adj;
	
	/**
	 * Constructor for the vertex
	 * @param vertex
	 */
	public BFS_02(int vertex) {
		this.vertex = vertex;
		adj = new ArrayList<ArrayList<Integer>>();		
	}
	
	/**
	 * Method to add the edge
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(w);
		adj.add(v, arr);

	}
	
	/**
	 * 
	 * @param srcVertex
	 */
	public void BreadthFirstSearch(int srcVertex) {
		boolean[] hasVisted = new boolean[vertex];
		
		//Create a queue to store the vertex
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(srcVertex);
		System.out.println(srcVertex + " ");
		
		while (!queue.isEmpty()) {
			int vertex = queue.removeFirst();
			//Now get all the adjacent elements of this vertex
			ArrayList<Integer> connectedNodes = adj.get(vertex);
			//once you get the connected nodes check if the vertex inside it is already visited
			for (Integer ver : connectedNodes) {
				if(!hasVisted[ver]) { // if the vertex is not visited then only add it into the queue and mark it as visited
					queue.add(ver);
					hasVisted[ver] = true;
				}
			}
		}
	}
}

