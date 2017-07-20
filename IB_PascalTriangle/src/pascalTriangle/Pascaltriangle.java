//Given an index k, return the kth row of the Pascal’s triangle.
//Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
//Example:
//Given k = 3,
//Return [1,3,3,1].

package pascalTriangle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Pascaltriangle 
{
	public ArrayList<Integer> getRow(int A)
	{
		//create an arraylist to store the values
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Deque<Integer> deq = new ArrayDeque<Integer>();
		if(A == 0)
		{
			arr.add(1);
		}
		else if(A == 1)
		{
			arr.add(1);
			arr.add(1);
		}
		else
		{
			arr.add(1); arr.add(1);
			for(int i = 2; i<= A; i++)
			{
				int size = arr.size();
				for(int k = 0; k < size-1; k++)
				{
					int add = arr.get(k) + arr.get(k+1);
					deq.add(add);
				}
				deq.addFirst(1);
				deq.addLast(1);
				arr.clear();
				arr.addAll(deq);
				deq.clear();
			}
		}
		return arr;
	}
	
	//Here return all the rows of the pascal triangle from 1 to k
	public ArrayList<ArrayList<Integer>> generate(int A)
	{
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> arrList = null;
		Deque<Integer> deq = new ArrayDeque<Integer>();
		ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
		
		if(A == 0)
			return resList;
		
		arrList = new ArrayList<Integer>();
		arrList.add(1);
		hashMap.put(1, arrList);
		
		for(int i = 2; i<= A; i++)
		{
			arrList = new ArrayList<Integer>();
			if(i == 2)
			{
				arrList.add(1);  arrList.add(1);
				hashMap.put(i,arrList);
			}
			else
			{
				ArrayList<Integer> arr = hashMap.get(i-1);
				int size = arr.size();
				for(int k = 0; k < size-1; k++)
				{
					int add = arr.get(k) + arr.get(k+1);
					deq.add(add);
				}
				deq.addFirst(1);
				deq.addLast(1);
				arrList.addAll(deq);
				hashMap.put(i, arrList);
				deq.clear();
			}
		} //for loop
		
		//get all the elements of the hashMap and put it in aray of arrayList
		for(Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet())
			resList.add(entry.getValue());
		
		return resList;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		Pascaltriangle pscl = new Pascaltriangle();
		//System.out.println(pscl.getRow(4));
		
		System.out.println(pscl.generate(0));
	}
	
}
