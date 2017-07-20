import java.math.BigInteger;
import java.security.SecureRandom;


/*
 * How to generate a random alpha-numeric string?

I've been looking for a simple Java algorithm to generate a pseudo-random alpha-numeric string. 
In my situation it would be used as a unique session/key identifier that would "likely" be unique over
 500K+ generation (my needs don't really require anything much more sophisticated). 
 Ideally, I would be able to specify a length depending on my uniqueness needs. 
 For example, a generated string of length 12 might look something like "AEYGF7K0DM1X".
 */
public class RandomAlphaNumeric {

	private SecureRandom secRandom = new SecureRandom();
	
	
	public String getNextSessionId(){
		return new BigInteger(16, secRandom).toString(32);
	}
	
	public BigInteger getNextSessionIdIntegerOnly(){
		return new BigInteger(16, secRandom);
	}
}


class Solution {
	public static void main(String[] args) {
		RandomAlphaNumeric alpha = new RandomAlphaNumeric();
		System.out.println(alpha.getNextSessionId());
		
		System.out.println(alpha.getNextSessionIdIntegerOnly());
	}
}