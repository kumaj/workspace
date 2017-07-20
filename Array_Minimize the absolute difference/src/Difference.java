import java.util.ArrayList;


public class Difference {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    	if(A.size() == 0 || B.size() == 0 || C.size() == 0) 
    		return -1; // Boundary case
    	//Compare the min between 2 elements first
    	int i = 0, j = 0;
    	int min_global = Integer.MAX_VALUE;
    	while(i < A.size() && j < B.size()) {
    		int min = Integer.MAX_VALUE;
    		int diff = Math.abs(A.get(i) - B.get(j));
    		if(diff < min) {
    			//Find an element in the 3rd element
    			for(int k = 0; k < C.size(); k++) {
    				int diff2 = Math.abs(Math.max(Math.max(A.get(i), B.get(j)), C.get(k)) - Math.min(Math.min(A.get(i), B.get(j)), C.get(k)));
    				if(diff2 < min_global)
    					min_global = diff2;
    			}
    		} // if
    		if(A.get(i) < B.get(j)) {
    			i++;
    		} else if(A.get(i) > B.get(j)) {
    			j++;
    		} else {
    			i++; 
    			j++;
    		}
    	}
    	return min_global;
    }
}
