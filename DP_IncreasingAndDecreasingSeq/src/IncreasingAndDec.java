import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;


public class IncreasingAndDec {
    public int longestSubsequenceLength(final List<Integer> A) {
    	
    	int[] maxArr = getIncreasingSeq(A);
    	//reverse the elements 
    	int maxPos = getMaxPosition(maxArr);
    	int maxEle = maxArr[maxPos];
    	List<Integer> arr = A.subList(maxPos+1, A.size());
    	int maxPos2 = getDecreasingSeq(arr);
    	
		return maxEle + maxPos2;
    }
    
    private int[] getIncreasingSeq(List<Integer> A) {
    	
    	int max = Integer.MIN_VALUE;
    	int maxPos = 0;
    	int[] temp = new int[A.size()];
    	temp[0] = 1;
    	for (int i = 1; i<A.size(); i++) {
			int count = 0;
			temp[i-1] = 1;
			for(int j=i-1; j>=0; j--) {
				if(A.get(j) < A.get(i)) {
					count = temp[j];
					if(count > max) {
						max = count;
						maxPos = i;
						temp[i] = count+1;
					}
				}
			} // inner for
		} // outer for
    	return temp;
     }
    
  private int getDecreasingSeq(List<Integer> A) {
    	
    	int max = Integer.MIN_VALUE;
    	int maxPos = 0;
    	int[] temp = new int[A.size()];
    	temp[0] = 1;
    	for (int i = 1; i<A.size(); i++) {
			int count = 0;
			temp[i-1] = 1;
			for(int j=i-1; j>=0; j--) {
				if(A.get(j) > A.get(i)) {
					count = temp[j];
					if(count > max) {
						max = count;
						maxPos = i;
						temp[i] = count+1;
					}
				}
			} // inner for
		} // outer for
    	return max;
     }

	private int getMaxPosition(int[] temp) {
		int max = Integer.MIN_VALUE;
		int pos = 0;
		for (int i=0; i< temp.length; i++) {
			if(temp[i] > max) {
				max = temp[i];
				pos = i;
			}
		}
		return pos;
	}
}

class Solution {
	public static void main(String[] args) {
		IncreasingAndDec i = new IncreasingAndDec();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// [1 11 2 10 4 5 2 1]
		arr.add(1); arr.add(11); arr.add(2); arr.add(10);arr.add(4);arr.add(5);arr.add(2);arr.add(1);
		
		System.out.println(i.longestSubsequenceLength(arr));
	}
}
