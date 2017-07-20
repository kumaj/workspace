import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * Input:
[4,1,0]
Expected:
[[],[4],[1],[1,4],[0],[0,4],[0,1],[0,1,4]]
 */

public class Subset {
	//Leet Code
    public List<List<Integer>> subsets(int[] nums) {
        
    	int len = nums.length;
    	ArrayList<Integer> a1 = new ArrayList<Integer>();
    	ArrayList<Integer> a2 = new ArrayList<Integer>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();

    	if(len < 1)
    		return res;
    	
    	//add [] and first element into the res
    	res.add(a2);
    	res.add(a1);
    	a1.add(nums[0]);
    	
    	int count = res.size();
    	int extraAdded = 0;
    	
    	//Iterate through loop
    	for(int i = 1; i< len; i++) {
    		for(int j = 0; j < count ; j++) {
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
    		count = count + extraAdded;
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
	//	Collections.sort(a);
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
    	
    	int count = res.size();
    	int extraAdded = 0;
    	
    	for(int i = 1; i< len; i++) {
    		for(int j = 0; j < count ; j++) {
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
    		count = count + extraAdded;
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
		/*Integer[] nums = { 15, 20, 12, 19, 4 };*/
		//int[] nums = { 1,2,3};
		//s.subsets(nums);
		
		Integer[] nums = { 1,2,3};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(nums));
		s.subsets(a);
	}
}
