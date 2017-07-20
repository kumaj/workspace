package bfs;

import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {
	private int V; // no of vertices
	private LinkedList<Integer> adj[];
	
	BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}		
	}
	
	//Add the edge
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// Prints BFS traversal from a given source s
	void BreadthFirstSearch(int s) {
		//Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		
		//Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		//Mark the current node as visited and enque it.
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			//Deque a vertex from queue and print it
			s = queue.poll(); // Same as removeFirst()
			System.out.println(s + " ");
			
			//Get all the adjacent vertices of the deque vertex s
			// If an adjacent has not been visited , then mark it as 
			// visited and enqueue it.
			 ListIterator<Integer> i = adj[s].listIterator();
			 while(i.hasNext()) {
				 int n = i.next();
				 if(!visited[n]) {
					 visited[n] = true;
					 queue.add(n);
				 }
			 }
		}
	}
	
	 // Driver method to
    public static void main(String args[])
    {
        BFS g = new BFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BreadthFirstSearch(2);
        
        //Call through BFS_02 class
        BFS_02 bfs2 = new BFS_02(4);
        bfs2.addEdge(0, 1);
        bfs2.addEdge(0, 2);
        bfs2.addEdge(1, 2);
        bfs2.addEdge(2, 0);
        bfs2.addEdge(2, 3);
        bfs2.addEdge(3, 3);
        
        System.out.println("BFS using BFS_02 class..");
        bfs2.BreadthFirstSearch(2);
    }
}

