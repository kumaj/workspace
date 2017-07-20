//Convert an array into Binary search tree
// This question has been asked in directI written interview
package Tree;

import java.util.Arrays;

class TNode
{
	int data;
	TNode lChild;
	TNode rChild;
	
	//create a constructor 
	TNode(int value)
	{
		data = value;
	}
}

public class SortedArrayToBST {
	
	public void arrayToBST(int[] arr)
	{
		//sort the array
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		
		//Create the BST
		
	}
	
	public TNode createBST(int[] arr, int start, int end)
	{
		if(start > end)
			return null;
		
		//createBST(arr, end, end);
		return null;
		
	}
	

}

//class to execute the test
class Program
{
	public static void main(String[] args)
	{
		//pass an array 
		int[] arr = { 4,1,3,2};
		
	}
}
