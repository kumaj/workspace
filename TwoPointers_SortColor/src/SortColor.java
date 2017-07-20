import java.util.ArrayList;
import java.util.Arrays;


public class SortColor {
	public void sortColors(ArrayList<Integer> a) {
	//count no of zeroes and ones
		int zeroCount = 0;
		int onesCount = 0;
		int twoCount = 0;
		int i = 0;
		int len = a.size();
		
		while(i < len) {
			if(a.get(i) == 0)
				zeroCount++;
			else if(a.get(i) == 1)
				onesCount++;
			else
				twoCount++;
			i++;	
		}
		
		//insert the count into orignal arrays
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		while(j < len) {
			if(k < zeroCount) {
				a.set(j, 0);
				j++;
				k++;
				continue;
			} else if(l < onesCount) {
				a.set(j, 1);
				j++;
				l++;
				continue;
			} else {
				a.set(j, 2);
				j++;
				m++;
				continue;
			}	
		} //while loop
		System.out.println(a);		
	}
}

class Solution {
	public static void main(String[] args) {
		SortColor s = new SortColor();
		Integer[] a = {0, 1, 2, 0, 1, 2};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
		
		s.sortColors(arr);
	}
}
