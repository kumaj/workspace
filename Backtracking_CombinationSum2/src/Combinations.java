import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Combinations {
	  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    	int len = candidates.length;
	    	ArrayList<Integer> a1 = new ArrayList<Integer>();
	    	ArrayList<Integer> a2 = new ArrayList<Integer>();
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	List<List<Integer>> ret = new ArrayList<List<Integer>>();

	    	if(len < 1)
	    		return res;
	    	
	    	//add [] and first element into the res
	    	Arrays.sort(candidates);
	    	
	    	res.add(a2);
	    	res.add(a1);
	    	a1.add(candidates[0]);
	    	if(candidates[0] == target)
	    		ret.add(a1);
	    	
	    	int extraAdded = 0; 
	    	int prevTotal = 1;
	    	int total = 2; //[], [1]
	    	
	    	//Iterate through loop
	    	for(int i = 1; i< len; i++) {
	    		if(candidates[i-1] != candidates[i] ) {
		    		for(int j = 0; j < total ; j++) {
		    			//get the arraylist from the resultant and add the current no int it
		    			List<Integer> temp = new ArrayList<Integer>();
		    			List<Integer> arr = res.get(j);
		    			
		    			//Now get the temp 
		    			temp.add(candidates[i]);
		    			temp.addAll(arr);
		    			//Collections.sort(temp); //to maintain the order [0,1,2,3,4] No need to sort
		    			int k = 0;
		    			int sum = 0;
		    			while(k < temp.size()) {
		    				sum += temp.get(k);
		    				k++;
		    			}
	    				if(sum == target) {
	    					Collections.sort(temp);
	    					ret.add(temp);
			    			res.add(temp);
			    			extraAdded++;
			    			break;
	    				} else {
			    			res.add(temp);
			    			extraAdded++;
	    				}
		    		}
	    		} else { // if previous and current elements are same
		    		for(int j = prevTotal ; j < total ; j++) {
		    			//get the arraylist from the resultant and add the current no int it
		    			List<Integer> temp = new ArrayList<Integer>();
		    			List<Integer> arr = res.get(j);
		    			
		    			//Now get the temp 
		    			temp.add(candidates[i]);
		    			temp.addAll(arr);
		    			//Collections.sort(temp); //to maintain the order [0,1,2,3,4]
		    			
		    			int k = 0;
		    			int sum = 0;
		    			while(k < temp.size()) {
		    				sum += temp.get(k);
		    				k++;
		    			}
	    				if(sum == target) {
	    					Collections.sort(temp);
	    					ret.add(temp);
			    			res.add(temp);
			    			extraAdded++;
			    			break;
	    				} else {
			    			res.add(temp);
			    			extraAdded++;
	    				}
		    		}
	    		}
	    		prevTotal = total;
	    		total = total + extraAdded;
	    		extraAdded = 0;
	    	}
	    	
	    	
	    	for (List<Integer> list : ret) {
				System.out.println(list);
			}
	    	return ret;
	   }
}

class Solution {
	public static void main(String[] args) {
		Combinations c = new Combinations();
/*		int[] arr = {10,1,2,7,6,1,5};
		int target = 8;
		c.combinationSum2(arr, 8);*/
		
		int[] arr = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int target = 27;
		c.combinationSum2(arr, target);
	}
}
