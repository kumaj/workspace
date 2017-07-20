package Area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxArea {
	public int largestRectangleArea(ArrayList<Integer> a) {
		int size = a.size();
		if (size == 1)
			return a.get(0);
		int maxArea = 0;
		int area = 0;
		for (int i = 0; i < size - 1; i++) {
			int min = a.get(i);
			int count = 1;
			maxArea = min * count;

			for (int j = i + 1; j < size; j++) {
				count++;
				if (a.get(j) < min) {
					min = a.get(j);
					area = min * count;
				} else {
					area = min * count;
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	// http://n00tc0d3r.blogspot.in/2013/03/largest-rectangle-in-histogram.html
	// http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
	public int largestRectangleArea2(ArrayList<Integer> a) {
		if (a == null || a.size() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < a.size()) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || a.get(i) >= a.get(stack.peek())) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the
				// previous one
				int p = stack.pop();
				int h = a.get(p);
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = a.get(p);
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}
}

class Solution {
	public static void main(String[] args) {
		MaxArea mx = new MaxArea();
		// ArrayList<Integer> arr = new ArrayList<Integer>();
		// arr.add(1);

		// A : [ 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 ]
		Integer[] a = { 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 };
		// Integer[] a = { 2, 82, 11, 89, 7, 21, 92, 13, 11, 94, 4, 96, 3 };
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
		System.out.println(mx.largestRectangleArea(arr));
	}
}
