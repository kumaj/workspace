
public class Reverse {

	// Given s = "the sky is blue"
	//outpu : blue is sky the
	public String reverseWords(String a) {
		//split the string based upon space
		String regex = " ";
		String[] str =  a.split(regex);
		
		//Now iterate through string  from last
		StringBuilder res = new StringBuilder();
		int j = str.length - 1;
		while(j >= 0) {
			if(str[j].hashCode() != 0)  {// if it is not the space space has the has code as 0
				res.append(str[j]);
				//add a space after the word
				if(j != 0)
					res.append(" ");
			}
			j--;
		}
		return res.toString().trim();
	}
	
	//Reverse the string using char array
	//ajit --> tija
	public String reverse(String a) {
		
		char[] ch = a.toCharArray();
		int i = 0;
		int j = a.length()-1;
		while(i <= j) {
			//swap i and j
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		return ch.toString();
	}
	
	//Reverse the string using stringBuilder
	public String reverse02(String a) {
		StringBuilder str = new StringBuilder();
		int len = a.length();
		for(int j = len-1; j>=0; j--) {
			str.append(a.charAt(j));
		}
		return str.toString();
	}

}

class Solution {
	public static void main(String[] args) {
		Reverse r = new Reverse();
		String a = " the sky is blue";
		//System.out.println(r.reverse(a));
		//out.println(r.reverse02(a));
		
		System.out.println(r.reverseWords(a));
	}
}
