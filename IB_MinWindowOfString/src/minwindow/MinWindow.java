package minwindow;

import java.util.HashMap;

public class MinWindow {
	public String minWindow(String S, String T) {
		//Create a hashSet to store the character of target
		HashMap<Character, Integer> map = AddPatternInMap(T);
		
		int j = 0;
		int global_start = -1;
		int global_end = -1;
		int curr_start = -1;
		int curr_end = -1;
		boolean flag = false;
		int len = 0;
		int global_len = S.length();
		int curr_len = 0;
		while(j < S.length()) {
			//If the source char present in set, then store its starting and ending index
			Character ch = S.charAt(j);
			if(map.containsKey(ch)) {
				len++;
				//decrement the count of the character. if count == 0, then remove it from map.
				int count = map.get(ch);
				--count;
				if(count == 0) {
					map.remove(ch);
				} else
					map.put(ch, count);
				
				if(flag == false) { //save the starting index
					curr_start = j;
					flag = true;
				}
				if(len == T.length()) { //save the end index
					curr_end = j;
				}
				curr_len = curr_end - curr_start;
				//Set the global start and end index and initialize all the variables once again
				// in order to search next pattern if exist
				if(len == T.length() && (curr_len < global_len)) {
					global_start = curr_start;
					global_end = curr_end;
					global_len = curr_len;
					curr_start = -1;
					curr_end = -1;
					len = 0;
					flag = false;
					// Once again add all the pattern string in map.
					map.clear();
					map = AddPatternInMap(T);
				}
			}
			j++;
		} //while
		
		//Now copy all the elements into result array
		StringBuilder result = new StringBuilder();
		if(global_start > -1) {
			while(global_start <= global_end) {
				result.append(S.charAt(global_start));
				global_start++;
			}
		}
		return result.toString();
	}
	
	public HashMap<Character, Integer> AddPatternInMap(String T) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		
		while(i < T.length()) {
			int count = 1;
			Character ch = T.charAt(i);
			if(map.containsKey(ch)) { //increment the count by 1
				count = map.get(ch);
				++count;
				map.put(ch, count);
			} else
				map.put(ch, count);
			i++;
		}
		return map;
	}
}

class Solution {
	public static void main(String[] args) {
		//String S = "ADOBECODEBANC";
		//String T = "ABC";
		//String S = "W";
		//String T = "w";
		//String S = "0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes";
		//String S = "slj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zY";
		//String T = "rsm2ty04PYPEOPYO5";
		//String S = "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
		//String T =  "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
		///String S = "BBBCCCNAA";
		//String T = "BCA";		
		String S = "8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvR";
		String T = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
		MinWindow min = new MinWindow();
		System.out.println(min.minWindow(S, T));
	}
}
