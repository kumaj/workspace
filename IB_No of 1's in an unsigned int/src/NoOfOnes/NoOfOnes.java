package NoOfOnes;

import java.util.List;

public class NoOfOnes {

	public int numSetBits(long a) {
		String binary = Long.toBinaryString(a);
		
		int i = 0;
		int count = 0;
		while(i < binary.length())
		{
			if(binary.charAt(i) == '1')
				count++;
			i++;
		}
		return count;
	}	
	
	//Method 2
	//use the logic of x&(x-1). it makes the last 1's to '0'.
	public int NoOfOnes(long a)
	{
		int count = 0;
		while(a > 0)
		{
			a = a&(a-1);
			count++;
		}
		return count;
	}
	
	//Input : [1 2 2 3 1]
	//Output : 3
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) 
	{
		//do the xor operation
		int num = a.get(0);
		for(int i = 1; i< a.size(); i++)
		{
			num = num ^ a.get(i);
		}
		return num;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		NoOfOnes no = new NoOfOnes();
		System.out.println(no.numSetBits(4));
		
		//using method 2
		System.out.println(no.NoOfOnes(3));
	}
}
