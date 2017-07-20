import java.util.Stack;


/**
 * 20. Valid Parentheses
 * @author kumaj04
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {
	//Idea is to push opening brackets in stack and 
	// when a closing bracket comes pop and see if both are equal or not
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i< s.length(); i++) {
        	Character ch = s.charAt(i);
        	
        	if(ch == ')') {
        		if(stack.isEmpty() || stack.pop() != '(') 
        			return false;
        	} else if(ch == '}') {
        		if(stack.isEmpty() || stack.pop() != '{') 
        			return false;
        	} else if(ch == ']') {
        		if(stack.isEmpty() || stack.pop() != '[') 
        			return false;
        	} else {
        		//push into the stack
        		stack.push(ch);
        	}
        }
        
        if(stack.isEmpty())
        	return true;
        else
        	return false;
    }
}

class Solution {
	public static void main(String[] args) {
		ValidParenthesis v = new ValidParenthesis();
	}
}
