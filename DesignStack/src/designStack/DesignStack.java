package designStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.
 */
public class DesignStack {
	//Can we use a queue or array also whcih acts as a stack.
	// to store the min element we have to use an extra stack.
	    Deque<Integer> que = null;
	    Stack<Integer> minStack = null;
		public DesignStack() {
			que = new ArrayDeque<Integer>();
			minStack = new Stack<Integer>();
		}
	   public void push(int x) {
	        que.addLast(x);
	        if(!minStack.isEmpty()) {
	        	//get the top element and compare with the current item
	        	// if current element is less then push the current element 
	        	if(x < minStack.peek())
	        		minStack.push(x);
	        }
	        else
	        	minStack.push(x);
	    }

	    public void pop() {
	    	if(!que.isEmpty()) {
		       Integer item = que.removeLast();
		       if(item.equals(minStack.peek()))
		    	   minStack.pop();
	    	}
	    }

	    public int top() {
	    	if(!que.isEmpty()) {
		        Integer peekItem = que.peek();
		        return peekItem;
	    	}
	    	else
	    		return -1;
	    }

	    public int getMin() {
	    	if(!que.isEmpty()) {
	    		return minStack.peek(); 
	    	}
	    	else
	    		return -1;
	    }
	    
// correct solution	    
// http://leetcodesolution.blogspot.in/2014/11/leetcode-min-stack.html
}


class Solution2 {
	//Can we use a queue or array also whcih acts as a stack.
		// to store the min element we have to use an extra stack.
		    Stack<Integer> s;
	        Stack<Integer> sMin;
			public Solution() {
				s = new Stack<Integer>();
				sMin = new Stack<Integer>();
			}
		    
		    public void push(int x) {
	        s.push(x);
	        if (sMin.empty() || x <= sMin.peek())
	            sMin.push(x);
	        }

	        public void pop() {
	            if (s.peek() <= sMin.peek())
	                sMin.pop();
	            s.pop();
		    }

		    public int top() {
		    	return s.peek();
		    }

		    public int getMin() {
		    	 return sMin.peek();
		    }
	}

class Solution {
	public static void main(String[] args) {
		
	}
}
