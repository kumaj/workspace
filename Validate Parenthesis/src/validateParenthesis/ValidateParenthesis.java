package validateParenthesis;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidateParenthesis {
	public int isValid(String a) {
		//push all the enclosing parenthesis
		int i = 0;
		char popItem;
		Stack<Character> stack = new Stack<Character>();
		while(i < a.length()) {
			char ch = a.charAt(i);
			switch (ch) {
			case '(':
				stack.push(ch);
				break;
			case '{':
				stack.push(ch);
				break;
			case '[':
				stack.push(ch);
				break;
			case ')':
				if(!stack.isEmpty()) {
					popItem = stack.pop();
					if(popItem != '(')
						return 0;
				}
				else
					return 0;
				break;
			case '}':
				if(!stack.isEmpty()) {
					popItem = stack.pop();
					if(popItem != '{')
						return 0;
				}
				else 
					return 0;
				break;
			case ']':
				if(!stack.isEmpty()) {
					popItem = stack.pop();
					if(popItem != '[')
						return 0;
				}
				else
					return 0;
				break;	
			default:
				break;
			}
			i++;
		}
		if(stack.isEmpty())
			return 1;
		else
			return 0;
	}
	/*
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	Examples:
  	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(ArrayList<String> a) {
		Stack<String> stack = new Stack<String>();
		int i = 0;
		
		while(i < a.size()) {
			String item = a.get(i);
			if( item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
				//pop 2 items from the stack
				String pop1 = stack.pop();
				String pop2 = stack.pop();
				
				//apply the operator on the popped items and again push into the stack.
				Integer i1 = Integer.parseInt(pop1);
				Integer i2 = Integer.parseInt(pop2);
				
				Integer result = null;
				switch (item) {
				case "+":
					result = i2 + i1;
					break;
				
				case "-":
					result = i2 - i1;
					break;
				
				case "*":
					result = i2 * i1;
					break;
				
				case "/":
					result = i2 / i1;
					break;	
				default:
					break;
				}
				//push the result into the stack
				stack.push(result.toString());
			}
			else { //push the elemenst into the stack.
				stack.push(item);
			}
			i++;
		} // end of while
		if(!stack.isEmpty()) {
			return Integer.parseInt(stack.pop());
		}
		else //failure
			return -1;
	}
} // end of class

class Solution {
	public static void main(String[] args) {
		ValidateParenthesis vp = new ValidateParenthesis();
	//	String a = "()[]{}";
		String a = "])";
		System.out.println(vp.isValid(a));
	}
}
