
//http://stackoverflow.com/questions/2042813/calling-non-static-method-in-static-method-in-java
//let's overload the static method and see it's behaviour
public class StaticOverloading {
	
	public static int a;
	public int b;

	public static void foo(int a)
	{
		
		System.out.println("11");
	}
	
	public static void foo(int a, int b)
	{
		
		System.out.println("22");
	}
	public void printValue()
	{
		//let's print the static and non-static 
		System.out.println("Static value : " + a + " non-Static value : " + b);
	}
	
	public static void main(String[] args) {
		// let's call the methods
		StaticOverloading obj = new StaticOverloading();
		obj.foo(1);
		obj.foo(1, 2);
		
		//let's use the class call to call the methods and see the behaviour
		StaticOverloading.foo(1);
		StaticOverloading.foo(1, 2);
		
		obj.printValue();
		
	}
	
	//Ans:- Static method can be poverloaded as shown in the above example

}
