import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * PERMUTATIONS2Bookmark
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
 */

public class Permutation {
	//Leetcode version
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < nums.length; i++) {
			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, nums[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<List<Integer>>(currentSet);
		}
	 
		return returnList;
    }
	
	//Interview bit version
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < a.size(); i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, a.get(i));
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}
	 
		return returnList;
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
