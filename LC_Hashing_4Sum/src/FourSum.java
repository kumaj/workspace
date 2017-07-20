import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* LC_Hashing_4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    
[2,1,0,-1]
2
Output:
[[2,-1,1,0],[2,0,1,-1],[2,1,0,-1]]
Expected:
[[-1,0,1,2]]
 */

//class tp store the elements
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


public class FourSum {
    public List<List<Integer>> fourSum_LeetCode(int[] nums, int target) {
    	//List to store the result
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	if(len < 4)
    	    return res;
    	
        //Using the hashMap to store sum and corresponding 2 elements
    	HashMap<Integer, Index> h = new HashMap<Integer, Index>();
    	
    	for(int i = 0; i < len-1; i++) {
    		for(int j = i+1; j < len; j++) {
    			int sum = nums[i] + nums[j];
    			if(h.containsKey(target-sum)) {
    				//then get the elements of the existing sum stored in hashmap
    				Index indx = h.get(target-sum);
    				int exI = indx.getI();
    				int exJ = indx.getJ();
    				if(res.size() == 0) {
    					List<Integer> l = new ArrayList<Integer>();
	    				l.add(exI);
	    				l.add(exJ);
	    				l.add(nums[i]);
	    				l.add(nums[j]);
	    				Collections.sort(l);
	    				res.add(l);
    				} else {
	    				if((exI != nums[i]) && (exJ != nums[j])) {
	    					List<Integer> l = new ArrayList<Integer>();
		    				l.add(exI);
		    				l.add(exJ);
		    				l.add(nums[i]);
		    				l.add(nums[j]);

		    				Collections.sort(l);
		    				for(List<Integer> ll : res) {
		    					if(!ll.equals(l))
		    						res.add(l);
		    				}
		    				
	    				}
    				}
    			} else
    				h.put(sum, new Index(nums[i], nums[j]));
    		}
    	}
    	return res;
    }
    
    //interview Bit
    /*
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
     */
    
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		 
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				int k = j + 1;
				int l = a.size() - 1;
	 
				while (k < l) {
					int sum =a.get(i) + a.get(j) + a.get(k) + a.get(l);
	 
					if (sum > b) {
						l--;
					} else if (sum < b) {
						k++;
					} else if (sum == b) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(j));
						temp.add(a.get(k));
						temp.add(a.get(l));
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
	
	//Not working as exception is thrown. This a littele verbose coding where multiple sorting is happening.
	public ArrayList<ArrayList<Integer>> fourSum_02(ArrayList<Integer> a, int b) {
		//List to store the result
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	int len = a.size();
    	if(len < 4)
    	    return res;
    	
        //Using the hashMap to store sum and corresponding 2 elements
    	HashMap<Integer, Index> h = new HashMap<Integer, Index>();
    	
    	for(int i = 0; i < len-1; i++) {
    		for(int j = i+1; j < len; j++) {
    			int sum = a.get(i) + a.get(j);
    			if(h.containsKey(b-sum)) {
    				//then get the elements of the existing sum stored in hashmap
    				Index indx = h.get(b-sum);
    				int exI = indx.getI();
    				int exJ = indx.getJ();
    				if(res.size() == 0) {
    					ArrayList<Integer> l = new ArrayList<Integer>();
	    				l.add(exI);
	    				l.add(exJ);
	    				l.add( a.get(i));
	    				l.add( a.get(j));
	    				Collections.sort(l);
	    				res.add(l);
    				} else {
	    				if((exI != a.get(i)) && (exJ != a.get(j))) {
	    					ArrayList<Integer> l = new ArrayList<Integer>();
		    				l.add(exI);
		    				l.add(exJ);
		    				l.add(a.get(i));
		    				l.add(a.get(j));

		    				Collections.sort(l);
		    				boolean flag = true;
		    				
		    				for(ArrayList<Integer> ll : res) {
		    					if(ll.equals(l)) {
		    						flag = false;
		    						break;
		    					}
		    				}
		    				if(flag == true)
		    					res.add(l);
		    				
	    				}
    				}
    			} else
    				h.put(sum, new Index(a.get(i), a.get(j)));
    		}
    	}
    	return res;
	}
}

class Solution {
	public static void main(String[] args) {
		FourSum f = new FourSum();
		
		//int[] nums = {0,0,0,0};
		//int target = 0;
		
//		Integer[] AA = {2,1,0,-1};
//		int target = 2;
		
		Integer[] AA = {1, 0, -1, 0, -2, 2};
		int target = 0;
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(AA));
		System.out.println(f.fourSum(arr2, target));
	}
}