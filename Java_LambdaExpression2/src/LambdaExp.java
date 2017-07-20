import java.util.TreeSet;

/**
 * https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 * https://dzone.com/articles/java-lambda-expressions-basics
 * @author kumaj04
 *
 */
public class LambdaExp {
	 interface MathOperation {
	      int operation(int a, int b);
	      // Functional interface must have only one method 
	     // int operation2(int a, int b);
	 }
	 
	 private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	 }
	 
	 public TreeSet test() {
		 TreeSet t = new TreeSet<String>();
		 t.add(new String("H"));
		 t.add(new String("A"));
		 t.add(new String("C"));
		 t.add(new String("K"));
		 return t;
	 }
	 
	 public static void main(String[] args) {
		LambdaExp tester = new LambdaExp();
		
		// each lambda exp must be bound with a functional interface. here MathOperation is functional interface
		
		MathOperation addition =  (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println(tester.operate(1, 2, addition));
		System.out.println(tester.operate(3, 4, subtraction));
		
		System.out.println(tester.test());
	}
}
