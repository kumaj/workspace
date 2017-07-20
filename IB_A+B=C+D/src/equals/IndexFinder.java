package equals;

import java.util.ArrayList;
import java.util.HashMap;

class Index {
	private int i;
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	private int j;
	
	public Index(int a, int b) {
		this.i = a;
		this.j = b;
	}
}

public class IndexFinder {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
    	ArrayList<Integer> indexArr = new ArrayList<Integer>();
    	//hashMap to store the sum and index of 2 nos.
    	HashMap<Integer , Index> hashmap = new HashMap<Integer, Index>();
    	int size = a.size();
    	for(int i = 0; i < size -1; i++) {
    		for(int j =  i+1; j< size; j++) {
    			int sum = a.get(i) + a.get(j);
    			//Check Is the sum lie in hashmap or not
    			if(hashmap.containsKey(sum)) {
    				//Get the index of the sum and compare with current i and j
    				Index index = hashmap.get(sum);
    				int a1 = index.getI();
    				int b1 = index.getJ();
    				int c1 = i;
    				int d1 = j;
    				
    				//If the current index is correct, then store it in arraylist
    				if(a1 < b1 && c1 < d1 && a1 < c1 && b1 != d1 && b1 != c1) {
    					if(indexArr.isEmpty()) { // If no result is store in array, then it is the first list of index
    						indexArr.add(a1);
    						indexArr.add(b1);
    						indexArr.add(c1);
    						indexArr.add(d1);
    					} else { 
    	    				int a2 = indexArr.get(0);
    	    				int b2 = indexArr.get(1);
    	    				int c2 = indexArr.get(2);
    	    				int d2 = indexArr.get(3);
/*    	    				S1 is lexicographically smaller than S2 iff
    	    				  A1 < A2 OR
    	    				  A1 = A2 AND B1 < B2 OR
    	    				  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
    	    				  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2*/
    	    				//Check for lexicographically smallest set of indexes.
    						if((a1<a2) || ((a1==a2) && (b1<b2)) || ((a1==a2) && (b1==b2) && (c1<c2)) || ((a1==a2) && (b1==b2) && (c1==c2) && (d1<d2))) {
    							indexArr.set(0, a1);
    							indexArr.set(1, b1);
    							indexArr.set(2, c1);
    							indexArr.set(3, d1);
    						}
    						//If the current set of indexes are not lexicographically smallest, then don't change the indexes in arraylist
    					}
    				}
    				
    			} else {
    				//Insert the sum and its index in hashMap
    				hashmap.put(sum, new Index(i,j));
    			}
    		} //1st for loop
    	} // 2nd for loop.
    	return indexArr;
    }	
}

class Solution {
	public static void main(String[] args) {
		IndexFinder indx = new IndexFinder();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(3);arr.add(4);arr.add(7);arr.add(1);arr.add(2);arr.add(9);arr.add(8);
		
		System.out.println(indx.equal(arr));
	}
}
