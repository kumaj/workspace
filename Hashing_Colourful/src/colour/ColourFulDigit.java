package colour;

import java.util.ArrayList;
import java.util.Set;

public class ColourFulDigit {
	public int colorful(int a) {
		
		Integer num = new Integer(a);
		String no = num.toString();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Integer lastNo = 0;
		
		int i = 0;
		int length = no.length();
		while(i < length) {
			Character chr = no.charAt(i);
			lastNo =Integer.parseInt(chr.toString());
			if(arr.contains(lastNo))
				return 0;
			else
				arr.add(lastNo);
			for(int j = i+1; j< length; j++) {
				Character chrDigit = no.charAt(j);
				Integer Digit =Integer.parseInt(chrDigit.toString());
				Integer mul = lastNo*Digit;
				lastNo = mul;
				if(arr.contains(mul))
					return 0;
				else
					arr.add(mul);
			}
			i++;
		}
		return 1;
	}
}

class Solution {
	public static void main(String[] args) {
		ColourFulDigit clr = new ColourFulDigit();
		int a = 23;
		System.out.println(clr.colorful(a));
	}
}
