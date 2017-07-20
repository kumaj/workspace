import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/***
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 * @author kumaj04
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 */

public class DistinctNo {
	// Not so optimise
    public ArrayList<Integer> dNums_01(ArrayList<Integer> A, int B) {
		  ArrayList<Integer> res = new ArrayList<Integer>();
		  int size = A.size();
		  
		  if(B > size)
			  return res;
		  for(int i = 0; i <= (size-B); i++) {
			  int j = i + B - 1;  
			  int k = i;
			  HashSet<Integer> set  = new HashSet<Integer>();
			  while(k <= j) {
				  // put the element in set and count the distinct element
				  set.add(A.get(k));
				  k++;
			  }
			  res.add(set.size());
			  set.clear();
		  }
		  return res;
    }
    
    /**
     * Correct Solution but time limit exceeded. Think of some optimal way
     * @param A
     * @param B
     * @return
     */
	  public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		  ArrayList<Integer> res = new ArrayList<Integer>();
		  int size = A.size();
		  
		  if(B > size)
			  return res;
		  HashSet<Integer> set  = new HashSet<Integer>();
		  // Add the first B elements into the set
		  for(int i = 0; i< B; i++) {
			  set.add(A.get(i));
		  }
		  res.add(set.size());
		  set.remove(A.get(0));
		  
		  for(int i = 1; i <= (size-B); i++) {
			  int j = i + B - 1;  
			  set.add(A.get(j));
			  res.add(set.size());
			  set.remove(A.get(i));
		  }
		  return res;
	  }
	  
	  /**
	   * Correct Answer but time limit exceeded. Think of some better solution
	   * @param A
	   * @param B
	   * @return
	   */
	  public ArrayList<Integer> dNums_03(ArrayList<Integer> A, int B) {
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  HashSet<Integer> set = new HashSet<Integer>();
		  int size = A.size();
		  if(B > size)
			  return result;

		  for(int i = 0; i<=(size-B); i++) {
			for(int j = i; j < (i+B); j++) {
				//Put K elements in map
				set.add(A.get(j));
			}
			result.add(set.size()); // count the no of elements in that block
			set.remove(A.get(i));
		  }
		  return result;
	  }
	  
	  /**
	   * Working good.. Using single for loop
	   * @param A
	   * @param B
	   * @return
	   */
	  public ArrayList<Integer> dNums_04(ArrayList<Integer> A, int B) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(A == null || A.size() == 0) return result;
	         
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	         
	        for(int i = 0; i<A.size(); i++){
	            int num = A.get(i);
	            if(!map.containsKey(num)){
	                map.put(num, 1);
	            }else{
	                map.put(num, map.get(num)+1);
	            }
	             
	            if(i-B+1>=0){
	                 
	                result.add(map.size());
	                 
	                int wStart = A.get(i-B+1);
	                int cur = map.get(wStart);
	                cur--;
	                 
	                if(cur == 0){
	                    map.remove(wStart);
	                }else{
	                    map.put(wStart, cur);
	                }
	            }
	        }
	        return result;
	    }
}

class Solution {
	public static void main(String[] args) {
		DistinctNo d = new DistinctNo();
		 ArrayList<Integer> A = new ArrayList<Integer>();
		 // A : [ 1, 2, 1, 3, 4, 3 ]
		 // B : 3
		 A.add(1);A.add(2);A.add(1);A.add(3);A.add(4);A.add(3);
		 System.out.println(d.dNums_03(A, 3));
		 
	}
}
