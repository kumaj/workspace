import java.util.ArrayList;
import java.util.Arrays;


public class LongestSeq {
	 public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		 int len = a.size();
		 int ii = 0;
		 int jj = -1;
		 int sum = 0;
		 
		 for(int i = 0, j = 0; i < len;) {
			 sum = sum + a.get(j);
			 if(sum == 0) { // save the ith and jth position 
				 if((j-i) > (jj - ii)) { // if the diff is greater than existing diff, then save the guys
					 ii = i;
					 jj = j;
					 i = j; // move the ith pointer to jth and start the same process
				 } else {
					 sum = 0;
					 j++;
					 if(j == len) 
						 break;
				 }
			 } else {
				 j++;
				 //what will happen if jth pointer moves to the end
				 // then in that case increment ith pointer
				 if(j == len) {
					 while(i < len) {
						 sum = sum - a.get(i);
						 i++;
						 //check if the sum is zero or not
						 if(sum == 0) {
							 if((j-i) > (jj - ii)) { // if the diff is greater than existing diff, then save the guys
								 ii = i;
								 jj = j-1;
								 i = len;
								 break; // break out of the while and for loop both
							 }
						 }// sum == 0
					 }// l< len
				 } // j ==len
			 }
		 } //for loop
		 
		 //iterate from ii to jj and save the elements into the list
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 for(int k = ii; k <= jj; k++) {
			 arr.add(a.get(k));
		 }
		 return arr;
	 }
}

class Solution {
	public static void main(String[] args) {
		LongestSeq l = new LongestSeq();
//		Integer[] Input =  {1 ,2 ,-2 ,4 ,-4};
//		Integer[] Input =  { 1, 2, -3, 3};
		Integer[] Input = {0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0};
		
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(Input));
		System.out.println(l.lszero(a));
	}
}
