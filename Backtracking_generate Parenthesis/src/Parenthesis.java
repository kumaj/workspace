import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Parenthesis {
	//Not working for n = 4
	   public List<String> generateParenthesis_02(int n) {
	     
		   List<String> ret = new ArrayList<String>();
		   if(n == 0)
			   return ret;
		   ret.add("()");
		   if(n == 1)
			   return ret;
		   
		   int count = 1;
		   int extraAdded = 0;
		   
		   //when n = 2 then use the already computed value from n = 1
		   for(int i = 1; i< n; i++) {
			   HashSet<String> set = new HashSet<String>();
			   for(int j = 0; j < count; j++) {
				   //append () before the orginal string, append () to the last, append () in mid
				   String orgStr = ret.get(j);
				   
				   //Now append () before the org string
				   if(set.add("()".concat(orgStr)))
					   extraAdded++;
				   
				   if(set.add("(".concat(orgStr).concat(")")))
					   extraAdded++;
				   
				   if(set.add(orgStr.concat("()")))
					   extraAdded++;
			   }
			   ;
			   ret.clear();
			   ret.addAll(new ArrayList<String>(set));
			   count = extraAdded;
			   extraAdded = 0;
		   }
		   return ret;  
	    }
	   
	   
	   public List<String> generateParenthesis(int n) {
		    ArrayList<String> result = new ArrayList<String>();
			ArrayList<Integer> diff = new ArrayList<Integer>();
		 
			result.add("");
			diff.add(0);
		 
			for (int i = 0; i < 2 * n; i++) {
				ArrayList<String> temp1 = new ArrayList<String>();
				ArrayList<Integer> temp2 = new ArrayList<Integer>();
		 
				for (int j = 0; j < result.size(); j++) {
					String s = result.get(j);
					int k = diff.get(j);
		 
					if (i < 2 * n - 1) {
						temp1.add(s + "(");
						temp2.add(k + 1);
					}
		 
					if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
						temp1.add(s + ")");
						temp2.add(k - 1);
					}
				}
		 
				result = new ArrayList<String>(temp1);
				diff = new ArrayList<Integer>(temp2);
			}
		 
			//Collections.sort(result);
			return result;
    }
}

class Solution {
	public static void main(String[] args) {
		Parenthesis p = new Parenthesis();
		
/*		int n = 0;
		System.out.println(p.generateParenthesis(n));
		
		int n1 = 1;
		System.out.println(p.generateParenthesis(n1));
		
		int n2 = 2;
		System.out.println(p.generateParenthesis(n2));*/
		
		int n3 = 3;
		System.out.println(p.generateParenthesis(n3));
		
/*		int n4 = 4;
		System.out.println(p.generateParenthesis(n4));*/
	}
}
