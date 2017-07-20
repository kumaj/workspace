import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Subset {
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
		    
	    	int len = nums.length;
	    	ArrayList<Integer> a1 = new ArrayList<Integer>();
	    	ArrayList<Integer> a2 = new ArrayList<Integer>();
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();

	    	if(len < 1)
	    		return res;
	    	
	    	//add [] and first element into the res
	    	Arrays.sort(nums);
	    	
	    	res.add(a2);
	    	res.add(a1);
	    	a1.add(nums[0]);
	    	
	    	int extraAdded = 0; 
	    	int prevTotal = 1;
	    	int total = 2; //[], [1]
	    	
	    	//Iterate through loop
	    	for(int i = 1; i< len; i++) {
	    		if(nums[i-1] != nums[i] ) {
		    		for(int j = 0; j < total ; j++) {
		    			//get the arraylist from the resultant and add the current no into it
		    			List<Integer> temp = new ArrayList<Integer>();
		    			List<Integer> arr = res.get(j);
		    			
		    			//Now get the temp 
		    			temp.add(nums[i]);
		    			temp.addAll(arr);
		    			Collections.sort(temp); //to maintain the order [0,1,2,3,4]
		    			
		    			res.add(temp);
		    			extraAdded++;
		    		}
	    		} else { // if previous and current elements are same
		    		for(int j = prevTotal ; j < total ; j++) {
		    			//get the arraylist from the resultant and add the current no int it
		    			List<Integer> temp = new ArrayList<Integer>();
		    			List<Integer> arr = res.get(j);
		    			
		    			//Now get the temp 
		    			temp.add(nums[i]);
		    			temp.addAll(arr);
		    			Collections.sort(temp); //to maintain the order [0,1,2,3,4]
		    			
		    			res.add(temp);
		    			extraAdded++;
		    		}
	    		}
	    		prevTotal = total;
	    		total = total + extraAdded;
	    		extraAdded = 0;
	    	}
	    	
	    	
	    	for (List<Integer> list : res) {
				System.out.println(list);
			}
	    	return res;
	 }
	 
	 
	    //Interview Bit
		public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
			//Sort the input list first
			Collections.sort(a);
			int len = a.size();
	    	ArrayList<Integer> a1 = new ArrayList<Integer>();
	    	ArrayList<Integer> a2 = new ArrayList<Integer>();
	    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    	res.add(a2);
	    	
	    	if(len < 1) {
	    		return res;
	    	}
	    	
	    	//add [] and first element into the res
	    	
	    	res.add(a1);
	    	a1.add(a.get(0));
	    	
	    	int extraAdded = 0; 
	    	int prevTotal = 1;
	    	int total = 2; //[], [1]
	    	
	    	for(int i = 1; i< len; i++) {
	    		if(a.get(i-1) != a.get(i) ) {
		    		for(int j = 0; j < total ; j++) {
		    			//get the arraylist from the resultant and add the current no int it
		    			ArrayList<Integer> temp = new ArrayList<Integer>();
		    			ArrayList<Integer> arr = res.get(j);
		    			
		    			//Now get the temp 
		    			temp.add(a.get(i));
		    			temp.addAll(arr);
		    			Collections.sort(temp); //to maintain the order [0,1,2,3,4]
		    			
		    			res.add(temp);
		    			extraAdded++;
		    		}
	    		} else {
			    		for(int j = prevTotal ; j < total ; j++) {
			    			//get the arraylist from the resultant and add the current no int it
			    			ArrayList<Integer> temp = new ArrayList<Integer>();
			    			ArrayList<Integer> arr = res.get(j);
			    			
			    			//Now get the temp 
			    			temp.add(a.get(i));
			    			temp.addAll(arr);
			    			Collections.sort(temp); //to maintain the order [0,1,2,3,4]
			    			
			    			res.add(temp);
			    			extraAdded++;
			    		}
		    		}
	    		prevTotal = total;
	    		total = total + extraAdded;
	    		extraAdded = 0;
	    	}
	    	
			Collections.sort(res, new Comparator<ArrayList<Integer>>() {

				@Override
				public int compare(ArrayList<Integer> s1, ArrayList<Integer> s2) {
					int i = 0;
					int j = 0;
	                if(s1.size()!= 0 && s2.size() != 0 ) {
	                	while((i < s1.size() && j < s2.size()) && (s1.get(i).equals(s2.get(j)))) {
	                		i++;j++; 
	                		}
	                	if(i == s1.size())
	                		return s1.get(i-1).compareTo(s2.get(j));
	                	else if(j == s2.size())
	                		return s1.get(i).compareTo(s2.get(j-1));
	                	else
	                		return s1.get(i).compareTo(s2.get(j));
	                }
					return 0;
				}
			  }
			);
	    	
	    	
	    	for (List<Integer> list : res) {
				System.out.println(list);
			}
	    	return res;
		}
}

class Solution {
	public static void main(String[] args) {
		Subset s = new Subset();
		/*int[] nums = { 15, 20, 12, 19, 4 };*/
		//int[] nums = { 1,2,2 };
/*		int[] nums = {4,4,4,1,4};
		s.subsetsWithDup(nums);*/
		
		//Integer[] ar = {4,1,4};
		Integer[] ar = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		//Integer[] nums = { 1,2,3};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(ar));
		s.subsets(a);
		
	}
}
