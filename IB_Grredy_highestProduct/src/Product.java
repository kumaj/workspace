import java.util.ArrayList;

/**
 * 
 * @author kumaj04
 * Highest Product
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000
 */
public class Product {
	
	// This logic doesn't work for the negative nos.
    public int maxp3(ArrayList<Integer> a) {
    	int size = a.size();
    	
    	int first = Integer.MIN_VALUE;
    	int second = Integer.MIN_VALUE;
    	int third = Integer.MIN_VALUE;
    	for(int i = 0; i< size; i++) {
    		int curr = a.get(i);
    		
    		if(curr > first) {
    			third = second;
    			second = first;
    			first = curr;
    		} else if( curr < first && curr > second) {
    			third = second;
    			second = curr;
    		} else if(curr < second && curr > third) {
    			third = curr;
    		}
    	}
    	return first*second*third;
    }
}

class Solution {
	public static void main(String[] args) {
		
	}
}
