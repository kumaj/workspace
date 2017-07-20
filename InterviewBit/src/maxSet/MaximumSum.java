//Find the countinous max sum in an array 
//{1, 2, 5, -7, 2, 3} .
//The two sub-arrays are {1, 2, 5} {2, 3} and the ans is {1, 2, 5} as its sum is larger than {2,3}
//NOTE: If there is a tie then compare with segment's length and return segment which has maximum length
//NOTE 2: If there is still a tie, then return the segment with minimum starting index

package maxSet;
import java.util.ArrayList;

public class MaximumSum
{
	// Step 1:
	// This method will return the maximum sum of a sub array.
	public int maxSum01(ArrayList<Integer> A)
	{
		//get the size of the arraylist
		int size = A.size();
		int sum = A.get(0);
		int max_sum = Integer.MIN_VALUE;
		Boolean flag = false;
		for(int i = 0; i< size ; i++)    // {1, 2, 5, -7, 2, 3} .
		{
			if(A.get(i) > 0)
			{
				if(flag == false)
					sum = 0;
				sum = sum + A.get(i);
				flag = true;
			}
			else //it means we got a negative number
			{
				flag = false;
				if(flag == false)
				{
					if(max_sum < A.get(i))
						max_sum = A.get(i);
				}
			}
			if(sum > max_sum)
				max_sum = sum;
		}
		return max_sum;
	}
	
	//Step2:
	//Return the arrayList which has max sum. In 
	public ArrayList<Integer> maxSum_02(ArrayList<Integer> A)
	{
		int size = A.size();
		int start_index = -1;
		int end_index = -1;
		
		int max_start_index = -1;
		int max_end_index = -1;
		
		long sum = A.get(0);
		long max_sum = Integer.MIN_VALUE;
		
		Boolean flag = false;
		
		for(int i =0; i < size; i++)
		{
			if(A.get(i) >= 0)
			{
				if(flag == false)
				{
					sum = 0;
					start_index = i;
					end_index = i;
				}
				else
				{
					end_index++;	
				}
				sum = sum + A.get(i);
				flag = true;
			}
			else
			{
				sum = Integer.MIN_VALUE;
				flag = false;
				start_index = -1;
				end_index = -1;
				//handle the case when all the elemnts are negative
				if(A.get(i) > max_sum)
				{
					max_sum = A.get(i);
					max_start_index = max_end_index = i;
				}
			}
			
			if(sum > max_sum)
			{
				max_sum = sum;
				max_start_index = start_index;
				max_end_index = end_index;
			}
			//if the case of collision return the array which has more elements in it.
			// if both of them has the same elements then return the lower index array
			else if(sum == max_sum)
			{
				if((end_index - start_index) > (max_end_index - max_start_index))
				{
					max_start_index = start_index;
					max_end_index = end_index;
				}
				else if(start_index < max_start_index)
				{
					max_start_index = start_index;
					max_end_index = end_index;
				}
			}
		}
		
		//Now store the elements into the ArrayList
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		for(int i = max_start_index ; i <= max_end_index ; i++)
			if(A.get(i) >= 0 )maxArray.add(A.get(i));
		
		return maxArray;
	}
	
}
class Solution {

	public static void main(String[] args) {
		
		MaximumSum mxSum = new MaximumSum();
		//Create an array list 
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(4);
		A.add(2);
		A.add(2);
		A.add(1);
		A.add(-3);
		A.add(1);
		A.add(5);
		A.add(1);
		A.add(2);
		
		// 2nd method
		//System.out.println("Max sum is : " + mxSum.maxSum_02(A));
		
		ArrayList<Integer> A2 = new ArrayList<Integer>();
		A2.add(-2);
		A2.add(-3);
		A2.add(4);
		A2.add(-1);
		A2.add(-2);
		A2.add(1);
		A2.add(5);
		A2.add(-3);
		
		//System.out.println("Max sum is : " + mxSum.maxSum01(A));
		
		// 2nd method
		//System.out.println("Max sum is : " + mxSum.maxSum_02(A2));
		
		ArrayList<Integer> A3 = new ArrayList<Integer>();
		A3.add(-1);
		A3.add(-1);
		A3.add(-1);
		A3.add(-1);
		A3.add(-1); 
		//System.out.println("Max sum is : " + mxSum.maxSum_02(A3));
		
		ArrayList<Integer> A4 = new ArrayList<Integer>();
		A4.add(0);
		A4.add(0);
		A4.add(-1);
		A4.add(0);
		//System.out.println("Max sum is : " + mxSum.maxSum_02(A4));
		
		ArrayList<Integer> A5 = new ArrayList<Integer>();
		A5.add(1967513926);
		A5.add(1540383426);
		A5.add(-1303455736);
		A5.add(-521595368);
		System.out.println("Max sum is : " + mxSum.maxSum_02(A5));		 

	}

}
