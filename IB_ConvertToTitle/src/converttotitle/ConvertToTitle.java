//Given a positive integer, return its corresponding column title as appear in an Excel sheet.

//For example:

  //  1 -> A
   // 2 -> B
  //  3 -> C
  //  ...
  //  26 -> Z
  //  27 -> AA
  //  28 -> AB 


package converttotitle;

public class ConvertToTitle {

	public String convertToTitle(int a) {
		
		StringBuffer bf = new StringBuffer();
		int rem = 0;
		Boolean flag = false;
		while(a > 0)
		{
			if(a >= 1 && a <= 26)
			{
				bf.insert(0, (char)(a + 64));   //BAQTZ 943566
				return bf.toString();
			}
			else
			{
				rem = a % 26;
				if(flag)
				{
					rem = rem - 1;
					flag = false;
				}
				if(rem == 0) 
				{
					rem = rem + 26;
					flag = true;
				}
				a = a / 26;
				bf.insert(0, (char)(rem + 64));
			}
		}
		return bf.toString();
	}
}

class Solution
{
	public static void main(String[] args)
	{
		ConvertToTitle tl = new ConvertToTitle();
		System.out.println(tl.convertToTitle(18278));
	}
}
