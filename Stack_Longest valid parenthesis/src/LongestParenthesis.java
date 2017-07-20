import java.util.Stack;


/**
 * 32. Longest Valid Parentheses
 * @author kumaj04
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestParenthesis {
	
	//It calculates the total no of valid parenthesis.
	// Ex. "()(()" --> 4
	// But the longest valid parenthesis is 2 only. 
    public int longestValidParentheses_totalValidCount(String s) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for(int i = 0; i< s.length(); i++) {
        	Character ch = s.charAt(i);
        	
        	if(ch == ')') {
        		if(!stack.isEmpty() && stack.pop() == '(') 
        			count += 2;
        	} else if(ch == '}') {
        		if(!stack.isEmpty() && stack.pop() == '{') 
        			count += 2;
        	} else if(ch == ']') {
        		if(!stack.isEmpty() && stack.pop() == '[') 
        			count += 2;
        	} else {
        		//push into the stack
        		stack.push(ch);
        	}
        }
        return count;
    }
    
    //It calculates the longest valid parenthesis not total count.
    //Ex. "()(()" --> 2
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        int max_count = 0;
        for(int i = 0; i< s.length(); i++) {
        	Character ch = s.charAt(i);
        	
        	if(ch == ')') {
        		if(!stack.isEmpty() && stack.pop() == '(') {
        			count += 2;
        			if(count > max_count)
        				max_count = count;
        		} else
        			count = 0;
        	} else if(ch == '}') {
        		if(!stack.isEmpty() && stack.pop() == '{') {
        			count += 2;
        			if(count > max_count)
        				max_count = count;
        		} else
        			count = 0;
        	} else if(ch == ']') {
        		if(!stack.isEmpty() && stack.pop() == '[') {
        			count += 2;
        			if(count > max_count)
        				max_count = count;
        		} else
        			count = 0;
        	} else {
        		//push into the stack
        		stack.push(ch);
        		if(!stack.isEmpty())
        			count = 0;
        	}
        }
        return max_count;
    }
}

class Solution {
	public static void main(String[] args) {
		LongestParenthesis l = new LongestParenthesis();
		String s = ")"; // 0
		String s2 = "()(()"; // 2
		String s3 = "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";
		String s4 = ")()())"; // 4
		String s5 = "()()"; // 4
		System.out.println(l.longestValidParentheses(s4));
	}
}
