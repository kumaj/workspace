package palindrome;

public class Palindrome {
	
	public boolean isPalindrome(int a) {
		Integer num = a;
		String str = num.toString();
		
		int len = str.length() - 1;
		for(int i = 0, j=len ; i<=j; i++, j--)
		{
			if(!(str.charAt(i) == str.charAt(j)))
				return false;
		}
		return true;
	}

}

class Solution
{
	public static void main(String[] args)
	{
		Palindrome pd = new Palindrome();
		System.out.println(pd.isPalindrome(1));
	}
}
