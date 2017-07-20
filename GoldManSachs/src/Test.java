import java.util.HashSet;
import java.util.Set;
// https://www.careercup.com/question?id=19300678

public class Test {
	
	public long getCount(String input) {
		Set<String> set = decode("", input);
		return set.size();
	}
	public Set<String> decode(String prefix, String code) {
		Set<String> set = new HashSet<String>();
		if (code.length() == 0) {
			set.add(prefix);
			return set;
		}

		if (code.charAt(0) == '0')
			return set;

		set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'),
				code.substring(1)));
		if (code.length() >= 2 && code.charAt(0) == '1') {
			set.addAll(decode(
					prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
		if (code.length() >= 2 && code.charAt(0) == '2'
				&& code.charAt(1) <= '6') {
			set.addAll(decode(
					prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
	
		return set;
	}
	
	public int DP(int []a, int n) {
        int [] dp = new int [n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
        	
        	 if(i>1 && a[i-2] <= 2) {
                 dp[i] = dp[i-1] + dp[i-2] + 1;
             }
        	 
            if(i>1 && a[i-2] <= 2 && a[i-1] <= 6) {
                dp[i] = dp[i-1] + dp[i-2] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n]+1; // +1 for base case where all characters are made of single digits
    }
}

class Solution {
	public static void main(String[] args) {
		Test t = new Test();
		String input = "2102";
		System.out.println(t.getCount(input));
		
		Integer num = Integer.valueOf(input);
		int[] a = new int[input.length()];
		
		for(int i = 0; i<input.length(); i++) {
			Character ch = input.charAt(i);
			int no = Integer.valueOf(ch.toString());
			a[i] = no;
		}
		
		System.out.println(t.DP(a, input.length()));
		
	}
}
