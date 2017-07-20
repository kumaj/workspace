import java.util.ArrayList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combination {
	
	//To calculate Comb(n), get Comb(n-1) and apppend the integers upto n to it
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	// [ [1], [2], [3] ]
		
		int i = 1;
		while(i <= n) {
			ArrayList<Integer> a1 = new ArrayList<Integer>();
			a1.add(i);
			ret.add(a1);
			i++;
		}
		
		int count = 1;
		while(count < k) {
			int len = ret.size();
			List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
			
			for(int j = 0; j<len; j++) {
				List<Integer> a2 = ret.get(j);
				int last = a2.get(a2.size() - 1);
					
				while(last+1 <= n) {
					List<Integer> a3 = new ArrayList<Integer>();
					a3.addAll(a2);
					a3.add(last+1);
					ret2.add(a3);
					last++;
				} //while
			} //for
			ret.clear();
			ret.addAll(ret2);
			count++;
		} //while
		return ret;
    }
    
    //Interview Bit version
    public ArrayList<ArrayList<Integer>> combine_IB(int n, int k) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	// [ [1], [2], [3] ]
		
		int i = 1;
		while(i <= n) {
			ArrayList<Integer> a1 = new ArrayList<Integer>();
			a1.add(i);
			ret.add(a1);
			i++;
		}
		
		int count = 1;
		while(count < k) {
			int len = ret.size();
			ArrayList<ArrayList<Integer>> ret2 = new ArrayList<ArrayList<Integer>>();
			
			for(int j = 0; j<len; j++) {
				List<Integer> a2 = ret.get(j);
				int last = a2.get(a2.size() - 1);
					
				while(last+1 <= n) {
					ArrayList<Integer> a3 = new ArrayList<Integer>();
					a3.addAll(a2);
					a3.add(last+1);
					ret2.add(a3);
					last++;
				} //while
			} //for
			ret.clear();
			ret.addAll(ret2);
			count++;
		} //while
		return ret;
    }
    
	//Not working for n = 4, k=3
    public List<List<Integer>> combine_02(int n, int k) {
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
        for(int i = 1; i <= n-k+1; i++) {
        	List<Integer> arr = new ArrayList<Integer>();
        	
        	int j = i;
        	int count = 1;
        	while(count <= k-1) {
        		arr.add(j);
        		j++;
        		count++;
        	}
        	
        	for(int m = j; m<= n; m++) {
        		List<Integer> a2 = new ArrayList<Integer>();
        		a2.addAll(arr);
        		a2.add(m);
        		ret.add(a2);
        	} 
        	if(k == 1)
        		return ret;
        }
        return ret;
    }
}

class Solution {
	public static void main(String[] args) {
		Combination c = new Combination();
		/*int n = 4, k = 2;*/
		
		/*int n = 5, k = 3;*/
		
	/*	int n = 4, k = 3;*/
		
		int n = 4, k = 1;
		
		System.out.println(c.combine(n, k));
				
	}
}
