import java.security.SecureRandom;
import java.util.Random;


public class AlphaNumericString implements Runnable{
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		Random rand = new SecureRandom();
		while(count-- != 0) {
			//int position = (int) Math.random()*ALPHA_NUMERIC_STRING.length();
			int position = rand.nextInt(ALPHA_NUMERIC_STRING.length());
			//System.out.print(position + " ");
			builder.append(ALPHA_NUMERIC_STRING.charAt(position));
		}
		return builder.toString();
	}
	@Override
	public void run() {
		System.out.println(randomAlphaNumeric(6));
	}
}

class Solution {
	public static void main(String[] args) {
		Thread t1 = new Thread(new AlphaNumericString());
		Thread t2 = new Thread(new AlphaNumericString());
		Thread t3 = new Thread(new AlphaNumericString());
		t1.start();
		t2.start();
		t3.start();
		
		AlphaNumericString al = new AlphaNumericString();
		System.out.println(al.randomAlphaNumeric(6));
	}
}
