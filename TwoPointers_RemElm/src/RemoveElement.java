import java.util.ArrayList;
import java.util.Arrays;


public class RemoveElement {
	
	public int removeElement(ArrayList<Integer> a, int b) {
		int i = 0;
		int j = 0;
		int count = 0;
		int len = a.size();
		
		//copy all the ellemnsts except b into a temp arr
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(i < len) {
			if(a.get(i) != b) {
				arr.add(a.get(i));
				count++;
			}
			i++;
		}
		
		//Now put all the elments into original array from arr
		int k = 0;
		while( j < len) {
			if(j < count) {
				a.set(j, arr.get(k));
				k++;
			} else 
				a.set(j, b);
			j++;
		}
		return count;
	}
	
	
	//Time complexity is O(N^2)
	public int removeElement_02(ArrayList<Integer> a, int b) {
		
		int i = 0;
		int j = 0;
		int count = 0;
		int len = a.size();
		
		if(len ==1 && a.get(i) == b) {
			a.remove(i);
			return a.size();
		}
		
		while(i < len) {
			if(i < (len-1) && a.get(i) == b ) { //swap
				j = i + 1;
				while((j < len) && a.get(j) == b) {
					j++;
				}
				if(j == len)
					break;
				else {
					//swap the elements
					int temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
					count++;
					i++;
				}
			} else {
				if(i == len-1 && a.get(i) == b) {
					a.remove(i);
					break;
				} else {
					count++;
					i++;
				}
			}
		}
		return count;
	}
}

class Solution {
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		
		Integer[] a = {4,1,1,2,1,3};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
		
		int b = 1;
		System.out.println(r.removeElement(arr, b));
	}
}
