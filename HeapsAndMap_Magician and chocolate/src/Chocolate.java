import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;


public class Chocolate {
	    public int nchoc(int A, ArrayList<Integer> B) {
	    	//Put all the chocolate in the tree
	    	TreeSet<Integer> set = new TreeSet<Integer>();
	    	for (Integer num : B) {
	    		set.add(num);
			}
	    	//Now get the max element
	    	int total = 0;
	    	int M = 1000000007;
	    	for(int ii = 0; ii<A; ii++) {
	    		int max = set.last();
	    		total = (total%M + max%M)%M;
	    		set.remove(max);
	    		set.add(max/2);
	    		
	    	}
	    	return total;
	    }
	    
	    public int nchoc_2(int A, ArrayList<Integer> B) {
	    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(B.size(), Collections.reverseOrder());
	    	for (Integer num : B) {
	    		pq.add(num);
			}
	    	
	    	//Now get the max element
	    	int total = 0;
	    	int M = 1000000007;
	    	for(int ii = 0; ii<A; ii++) {
	    		int max = pq.poll();
	    		total = (total%M + max%M)%M;
	    		pq.add(max/2);
	    		
	    	}
	    	return total;
	    }
}

class Solution {
	public static void main(String[] args) {
		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		tree.put(1, 4);
		tree.put(2, 10);
		tree.put(4, 6);
		tree.put(3, 0);

		
		System.out.println(tree.lastKey());
		System.out.println(tree.lastEntry().getKey());
		System.out.println(tree.lastEntry().getValue());
		
		 for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
		        System.out.println(entry.getKey() + " " + entry.getValue() + " ");
		 } 
		 
		 Chocolate c = new Chocolate();
		 /**
		  * A : 10
B : [ 2147483647, 2000000014, 2147483647 ]
		  */
		 
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 arr.add(2147483647);
		 arr.add(2000000014);
		 arr.add(2147483647);
		 System.out.println(c.nchoc_2(10, arr));
	}
}
