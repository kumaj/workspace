/**
 * This class illustrate the difference between the equals and ==.
 1) use == to compare primitive e.g. boolean, int, char etc, while use equals() to compare objects in Java.
2) == return true if two reference are of same object. Result of equals() method depends on overridden implementation.
3) For comparing String use equals() instead of  == equality operator.

That’s all on the difference between equals method and  == operator in Java.  As I said the main difference 
between them is that one of them is an operator and other is a method and == is
used to compare both primitive and objects while equals() method is used to check equality of objects only.
http://javarevisited.blogspot.com/2012/12/difference-between-equals-method-and-equality-operator-java.html#ixzz4YaO4K400
 * @author kumaj04
 *
 */
public class EqualsExample {
 
	public static void main(String[] args) {
		
		Object obj1 = new Object();
		Object obj2 = new Object();

		boolean res = (obj1==obj2);
		System.out.println("Comparing two different Objects with == operator: " + res);
		     
		/* This is how the equals methods has been defined in the object class. It just checking the refernce of two objects 
		 * It doesn't have any content so there is no point of checking it
		 *     public boolean equals(Object obj) {
                    return (this == obj);
               }
		 */
		res = obj1.equals(obj2);
		System.out.println("Comparing two different Objects with equals() method: " + res);

		obj1=obj2;
		res = (obj1==obj2);
		System.out.println("Comparing two reference pointing to same Object with == operator: " + res);
		
		
		/*
		 * Lets try some hand on the string class and then try to see if they are equal or not.
		 */
		
		
		String personalLoan = new String("cheap personal loans");
		String homeLoan = new String("cheap personal loans");
		      
		boolean result = personalLoan == homeLoan;
		System.out.println("Comparing two strings with == operator: " + result);
		      
		/*
		 * Here equals() method has been overridden by the string class. It returns true if both obj are pointing to the same memory
		 * if not then it does the character by character comparision.
		 */
		result = personalLoan.equals(homeLoan);
		System.out.println("Comparing two Strings with same content using equals method: " + result);
		      
		homeLoan = personalLoan;
		result = (personalLoan == homeLoan);
		System.out.println("Comparing two reference pointing to same String with == operator: " + result);
		
		int i1 = 10;
		int i2 = 10;
		Integer i3 = 10;
		// http://javarevisited.blogspot.in/2010/10/what-is-problem-while-using-in.html
		System.out.println( i1 == i2); // equals() method is not applicable for primitive data types
	}
}
