import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class illustrate the use of scenarion when keys are equals?
 * Then will it form a linklist of replace the value?
 * Does it replace the keys as well? Ex:- Amy and May
 * @author kumaj04
 * When we try to insert any key in HashMap first it checks whether any other object present with same hashcode and if yes then it checks for the equals() method. 
 * If two objects are same then HashMap will not add that key instead it will replace the old value by new one.
 */
public class Test {
	String str;

	public Test(String str) {
		this.str = str;
	}
	@Override
	public int hashCode() {
        int hash = 1;
        hash = hash * 31;
        System.out.println("Hash Code : " + hash);
        return hash;
	}
	
	@Override 
	public boolean equals(final Object obj) {
		Test test = (Test)obj;
		Boolean val = str.equals(test.str);
		return val;
		//return true;
	}
}

class Solution {
	public static void main(String[] args) {
		Test t1 = new Test("may");
		Test t2 = new Test("may");
		//Create a hashMap
		HashMap<Test, String> ourMap = new HashMap<Test, String>();
		ourMap.put(t1, "May has been entered");
		ourMap.put(t2, "Amy has been entered");
		
		System.out.println("Total elements in map : " + ourMap.size());
		for (Entry<Test, String> set : ourMap.entrySet()) {
			System.out.println(set.getKey() +  " " + set.getValue());
		}
	}
}
