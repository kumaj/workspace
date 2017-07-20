package LongestCommonPrefix;

import java.util.ArrayList;

/*Write a function to find the longest common prefix string amongst an array of strings.
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
Example:
Given the array as:
[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”. */

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(ArrayList<String> a) {
		
		//Approach is to find the common substring between first 2 and then next and next
		String str1 = a.get(0);
		String res = "";
		for(int i = 1; i< a.size(); i++)
		{
			res = findCommon(str1, a.get(i));
			str1 = res;
		}
		return str1;
	}

	private String findCommon(String str1, String str2)
	{
		StringBuilder comm = new StringBuilder("");
		int i = 0;
		int j = 0;
		
		while(i< str1.length() && j< str2.length())
		{
			if(str1.charAt(i) == str2.charAt(j))
				comm.append(str1.charAt(i));
			i++;
			j++;
		}
		return comm.toString();
	}
}

class Solution
{
	public static void main(String[] args)
	{
		LongestCommonPrefix lngst = new LongestCommonPrefix();
		ArrayList<String> arr = new ArrayList<String>();
		String str1 = "abcdefgh";
		String str2 = "aefghijk";
		String str3 = "abcefgh";
		
		arr.add(str1);
		arr.add(str2);
		arr.add(str3);
		
		System.out.println(lngst.longestCommonPrefix(arr));
	}
}
