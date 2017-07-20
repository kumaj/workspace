package checkPalindrome;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//Example:
//
//"A man, a plan, a canal: Panama" is a palindrome.
//
//"race a car" is not a palindrome.
//
//Return 0 / 1 ( 0 for false, 1 for true ) for this problem

public class CheckPalindrome {
	
	public int isPalindrome(String a) {
		
		int len = a.length();
		int returnValue = 0;
		int i = 0;
		int j = len - 1;
		while(i < j)
		{
			char c1 = a.charAt(i);
			char c2 = a.charAt(j);
			if(Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2))
			{
				if(Character.toLowerCase(c1)==Character .toLowerCase(c2))
				{
					i++; 
					j--;
					returnValue = 1;
				}
				else
				{
					returnValue = 0;
					break;
				}
						
			}
			else if(Character.isLetterOrDigit(c1) && (!Character.isLetterOrDigit(c2)))
					j--;
			else if((!Character.isLetterOrDigit(c1)) && Character.isLetterOrDigit(c2))
					i++;
		}
		return returnValue;
	}

}

class Solution
{
	public static void main(String[] args)
	{
		String str = "A man, a plan, a canal: Panama";
		CheckPalindrome chk = new CheckPalindrome();
		System.out.println(chk.isPalindrome(str));
	}
}
