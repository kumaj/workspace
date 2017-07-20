import java.util.Date;
// http://howtodoinjava.com/core-java/related-concepts/how-to-make-a-java-class-immutable/

/**
 * String is immutable means that you cannot change the object itself, but you can change the reference to the object.
* Always remember that your instance variables will be either mutable or immutable.
* Identify them and return new objects with copied content for all mutable objects.
* Immutable variables can be returned safely without extra effort.
* */
// Make the class as final so that it can't be extended so that its methods 
// doesn't get overriden by the sub classes 
// immutable in the sense of memory. It creates new objects every time you create strings or assign a new string/change the value. 
// That's why it is advisable to be careful when using string
public final class ImmutableExample {
	
	// When the fields are final even the intellisense doesn't create setter methods of it.
	private final String str;
	private final int i;
	private final Date date;
	
	public ImmutableExample(String str, Integer i, Date d) {
		this.str = str;
		this.i = i;
		this.date = new Date();
	}
	

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return new Date(date.getTime());
	}
	
	@Override
	public String toString() {
		return str + " " + i + " " + date;
	}
}

class Solution{
	public static void main(String[] args) {
		ImmutableExample i = new ImmutableExample("One", 1, new Date());
		System.out.println(i);
		
		// Lets modify the i object. Since it is an immutable object then it should not change its value
		String str = i.getStr();
		int ii = i.getI();
		Date date = i.getDate(); // This is very imp here. getDate() is giving altogether a new memory location.
		
		str = "Two";
		ii = 3;
		date.setDate(10);
		
		System.out.println(i);
		
		
	}
}
