package countLenght;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//If the last word does not exist, return 0.
//Note: A word is defined as a character sequence consists of non-space characters only.
//Example:
//Given s = "Hello World",
//return 5 as length("World") = 5.
//Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

public class CountLength {

	public int lengthOfLastWord(final String a) {
		
		int len = a.length();
		int i = 0;
		int count = 0;
		int save = 0;
		
		while(i < len)
		{
			if(a.charAt(i)!= ' ')
			{
				count++;
				if(count > save)
					save = count;
			}
			else
			{
				if(i < len-1 && (a.charAt(i+1)!= ' '))
				{
					save = 0;
					count = 0;
				}
			}
			i++;
		}
		return save;
	}
	
}

class Solution
{
	public static void main(String[] args)
	{
		CountLength cnt = new CountLength();
		String str1 = "d";
		String str2 = "Wordl   ";
		System.out.println(cnt.lengthOfLastWord(str2));
	}
}
