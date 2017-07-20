import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Difference {
	public int diffPossible(final List<Integer> a, int b) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(Integer num : a) {
			set.add(num);
		}
		
		for (Integer num : a) {
			if(set.contains(Math.abs(b-num))) {
				if((Math.abs(num - Math.abs(b-num)) == b))
					return 1;
			}
			else
				set.add(num);
		}
		return 0;
	}
}

class Solution {
	public static void main(String[] args) {
		Difference d = new Difference();
		Integer[] arr1 = { 34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29 };
		int k1  = 97; // 0
		
		Integer[] arr2 = {11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
		int k2 = 60; // 1
		
		Integer[] arr3 = {59, 65, 70, 36, 47, 52, 1, 32, 65, 3, 20, 35, 32, 4, 52};
		int k3 = 58; // 1
		
		Integer[] arr4 = { 90, 85, 74, 25, 34, 63, 43, 91, 30};
		int k4 = 55; // 1
		
		List<Integer> a1 = Arrays.asList(arr1);
		List<Integer> a2 = Arrays.asList(arr2);
		List<Integer> a3 = Arrays.asList(arr3);
		List<Integer> a4 = Arrays.asList(arr4);
		
		System.out.println(d.diffPossible(a1, k1));
		System.out.println(d.diffPossible(a2, k2));
		System.out.println(d.diffPossible(a3, k3));
		System.out.println(d.diffPossible(a4, k4));
	}
}
