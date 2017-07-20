import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class SingleNo {
	 public int singleNumber(int[] nums) {
		 //use the hashing technique
		 HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		 for(int no : nums) {
			 if(h.containsKey(no)) {
				 int count = h.get(no);
				 count--;
				 if(count == 0)
					 h.remove(no);
				 else
					 h.put(no, count);
			 } else
				 h.put(no, 1);
		 }
		 //there exists is a single item in hashmap
		 Entry<Integer, Integer> entry = h.entrySet().iterator().next();
		 return entry.getKey();
	 }
}

class Solution {
	public static void main(String[] args) {
		
	}
}
