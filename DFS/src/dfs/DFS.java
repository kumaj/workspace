package dfs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class DFS {
	private int V; // no of vertex
    private LinkedList<Integer>[] adj; // array of linklist
    
    /**
     * Constructor
     * @param v
     */
    public DFS(int v) {
    	V = v;
    	adj = new LinkedList[v];
    	for(int i = 0; i<v; i++) {
    		adj[i] =  new LinkedList<Integer>();
    	}
	}
    
    /**
     * Method to add the edge between two vertex
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
    	adj[v].add(w);
    }
    
    /**
     * Method to do the depth first traversal 
     * @param source
     */
    public void depthFirstTraversal(int source) {
    	// Array of boolean 
    	boolean[] hasVisited = new boolean[V];
    	
    	// Create a stack to put the vertices
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	//Mark the current vertex as visited
    	hasVisited[source] = true;
    	stack.add(source);
    	
    	while (!stack.isEmpty()) {
			//Pop the element from the stack and print it
    		int s = stack.pop();
			System.out.println(s + " ");
			
			ListIterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if(!hasVisited[n]) {
					hasVisited[n] = true;
					stack.push(n);
				}
			}
		}
    }
    
    public static void main(String[] args) {
        DFS g = new DFS(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.depthFirstTraversal(0);
	}
}
