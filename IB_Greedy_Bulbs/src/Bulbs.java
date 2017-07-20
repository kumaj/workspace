import java.util.ArrayList;


public class Bulbs {
	 public int bulbs(ArrayList<Integer> a) {
		  int count = 0;
		  // get the first zero
		  int size = a.size();
		  for(int i = 0; i < size; i++) {
			 if(a.get(i) == 1)
				 continue;
			 else {
				 // change the bit to 1
				 count++;
				 a.set(i, 1);
				 // flip the rest of the bits
				 int j = i + 1;
				 while(j < size) {
					 if(a.get(j) == 0)
						 a.set(j, 1);
					 else
						 a.set(j, 0);
					 j++;
				 }
			 }
		  }
		  return count;
	 }
	 
	 // Better way of doing it
	int solve(int A[], int N) {
	     
	    int state= 0, ans = 0;
	    for (int i = 0; i < N;i++) {
	        if (A[i] == state) {
	            ans++;
	            state = 1 - state;
	        }
	    }
	     
	    return ans;
	}
}

class Solution {
	public static void main(String[] args) {
		
	}
}
