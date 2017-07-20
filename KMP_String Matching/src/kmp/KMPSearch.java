package kmp;

import java.io.BufferedReader;

public class KMPSearch {

	/** Failure array **/
	private int[] failure;
	
	/**Constructor **/
	public KMPSearch(String text, String pat) {
		/** pre construct failure array for a pattern **/
		failure = new int[pat.length()];
		fail(pat);
		
		/** find match **/
		int pos = posMatch(text, pat);
		if(pos == -1)
			System.out.println("\n No match has been found");
		else
			System.out.println("\n Match found at index : " + pos);
	}
	
	/** Failure function for a pattern **/
	private void fail(String pat) {
		int n = pat.length();
		failure[0] = -1;
		for(int j = 1; j < n; j++) {
			int i = failure[j - 1];
			while((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
				i = failure[i];
			if(pat.charAt(j) == pat.charAt(i + 1))
				failure[j] = i + 1;
			else
				failure[j] = -1;
		}
	}
	
	/** Function to find match for a pattern **/
	private int posMatch(String text, String pat) {
		int i = 0, j = 0;
		int lens = text.length();
		int lenp = pat.length();
		while(i < lens && j < lenp) {
			if(text.charAt(i) ==  pat.charAt(j)) {
				i++; 
				j++;
			} else if( j == 0)
				i++;
			else 
				j = failure[j - 1] + 1;
		}
		return ((j == lenp) ? (i = lenp) : -1);
	}
	
	/** Main function **/
	public static void main(String[] args) {
		//String text = "abcdefgh";
		//String pattern = "def";
		String text = "abcabc";
		String pattern = "abcd";
		
		KMPSearch kmp = new KMPSearch(text, pattern);
	}
}
