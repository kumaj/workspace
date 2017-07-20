import java.util.ArrayList;


public class Flip {

	ArrayList<Integer>flipp(ArrayList<Integer> a) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int size = a.size();
		
		int i = 0;
		int j = 0;
		int count = 0;
		int g_count = -1;
		int min = 0;
		int max = 0;
		while(i < size) {
			if(a.get(i) == 0) {
				min = i;
				j = i;
				max = j;
				count++;
				if(count > g_count) {
					g_count = count;
				}
				while(j < size) {
					j++;
					if(a.get(j) == 0) {
						count++;
					} else {
						count--;
					}
					if(count > g_count) {
						g_count = count;
						max = j;
					}
					else if(count == 0) {
						i++;
						j = i;
						count = 0;
						break;
					}
				} // inner while
			} 
			
			res.add(min);
			res.add(max);
		i++;	
		} //outer while
		return res;
	}
}

class Solution {
	Flip f = new Flip();
	
}
