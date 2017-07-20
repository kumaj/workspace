package MaxOccuringChar;

//Return maximum occurring character in the input string
//Write an efficient C function to return maximum occurring character in the input string e.g., if input string is “test string” then function should return ‘t’.
	
public class MaxOccurCharacter {

	char MaxOccCharacter(String str)
	{
		//scan each character and store its count
		int len = str.length();
		int count = 0;
		int max = 0;
		char ch = 0;
		for(int i = 0; i < len-1; i++)
		{
			for(int j = i; j < len; j++)
			{
				if(str.charAt(i) == str.charAt(j))
					count++;
				if(count > max)
				{
					max = count;
					ch = str.charAt(i);
				}
			}
			count = 0;
		}
		return ch;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		MaxOccurCharacter max = new MaxOccurCharacter();
		String str = "tesk";
		System.out.println(max.MaxOccCharacter(str));
	}
	
}
