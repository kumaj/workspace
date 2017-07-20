package arrayWave;

public class MaxHeightOfWave {

	public int findMaxWaveHeight(int[] arr)
	{
		//get the height of the array
		int size = arr.length;
		int waveCount = 1;
		int maxWaveCount = 1;
		Boolean flag = false;
		Boolean negativeFlag = false;
		
		//3 Conditions
		// 1. All nos are positive
		// 2. All nos are negative
		// 3. Combination of both
		for(int i =0; i< size-1 ; i++)
		{
			if(arr[i+1] > arr[i])   // {-5,-4,-3,2,-1, 0 ,1,2,3,5,6};
			{
				if(negativeFlag == true)
				{
					waveCount = 1;
					negativeFlag = false;
				}
				flag = true; //Wave should always be increasing first then decreasing
				waveCount++;
			}
			else
			{
				//The wave cannot be started with decreasing notation. That's why
				// boolean has been used.
				if(flag == true)
				{
					waveCount++;
					negativeFlag = true;
				}
			}
			if(waveCount > maxWaveCount)
				maxWaveCount = waveCount;
		}
		return maxWaveCount;
	}
	
	//Let's try to solve this problem using only one flag
	public int maxWaveHeight(int[] arr)
	{
		//get the size of the array
		int size = arr.length;
		int waveCount = 1;
		int maxWaveCount = 1;
		Boolean flag = false;
		
		for(int i = 0; i< size-1;i++)
		{
			//when element is positive
			if(arr[i+1] > arr[i])
			{
				//add the condition to reset the wavecount. check the corner cases
				if(i > 0 && arr[i-1] > arr[i] && arr[i] < arr[i+1])
					waveCount = 1;
				waveCount++;
				flag= true;
			}
			else //use a flag so that the wave starts from increasing notation only
			{
				if(flag == true)
					waveCount++;
			}
			//in the end compare the wavecount and maxWaveCount and update the count
			if(waveCount > maxWaveCount)
				maxWaveCount = waveCount;
		}
		return maxWaveCount;
	}
	
}


class Solution
{
	public static void main(String[] args)
	{
		MaxHeightOfWave mxht = new MaxHeightOfWave();
		
		//int[] arr = {1,2,3,4,5,6};
		//int[] arr = {1,2,1,0};
		//int[] arr = {-1,-2,-3,-4};
		//int[] arr = {-4,-3,-2,-1};
		//int[] arr = {7,5,3,1,2,5,6,7,0,-3,6,-7,5};
		//int[] arr = {-5,-4,-3,2,-1, 0 ,1,2,3,5,6};
		// int[] arr = {12, 4, 78, 90, 45, 23};
		//int[] arr = {20, 4, 1, 2, 3, 4, 2, 10};
		//int[] arr = {4,17,5,6,7,8,9,19,15,14,13,12,11,27,2};
		int[] arr = {7,-2,5,4,3,2,5,11,6};
		System.out.println("Max length of wave is : " + mxht.findMaxWaveHeight(arr));
		
		System.out.println("Max length of wave is : " + mxht.maxWaveHeight(arr));
	}
}
