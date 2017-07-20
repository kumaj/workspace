
public class PhoneLetter {
	public String[] letterCombinations(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		String[] res = new String[l1*l2];
		int i = 0;
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		getLetterCombinations(s1, s2, 0, 0, res, i);
		return res;
	}

	private void getLetterCombinations(char[] s1, char[] s2, int l1, int l2, String[] res, int i) {
		
		if(l2 >= s2.length && l1 < s1.length) {
			l2 = 0;
			l1++;
			return;
		}
		if(l1 >= s1.length || l2 >= s2.length)
			return;
		Character c1  = s1[l1];
		Character c2 = s2[l2];
		int p = c1 + c2;
		getLetterCombinations(s1, s2, l1, ++l2, res, ++i);
	}
}

class Solution {
	public static void main(String[] args) {
		PhoneLetter ph = new PhoneLetter();
		String str1 = "ax";
		String str2 = "bc";
		String[] a = ph.letterCombinations(str1, str2);
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
