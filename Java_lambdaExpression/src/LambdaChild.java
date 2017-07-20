/**
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * @author kumaj04
 *
 */
public class LambdaChild {
	//With anaoymous class
	IsFunctional isFunc = new IsFunctional() {
		
		@Override
		public void testMethod(String data) {
			System.out.println("Printing " + data + "Anonymous class");
		}
	};
	
	// With lambda expression
	IsFunctional func = (demoData) -> {
		System.out.println("Printing " + demoData + " From lambda expression");
	};
	
	/**
	 * // No argument.
	() -> { System.out.println("No argument"); }
	// Single argument.
	(int arg) -> { System.out.println("Single integer argument : " + arg); }
	// More than one arguments.
	( int arg1, String arg2 ) -> { System.out.println("Two arguments : " + arg1 + " and " + arg2)
	 */

}
