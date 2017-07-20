// How to call parent class method using the child class object
//it can do it using the "super" keyword to be called from child function
//This program illustrate the call of the parent class method using the object of the child class
package Ex01;

class parent
{
	void foo()
	{
		System.out.println("Parent::foo()");
	}
}

//let create a child class which derives from the parent class
class child extends parent
{
	void foo()
	{
		System.out.println("child::foo()");
	}
	
	void fun1()
	{
		System.out.println("Child::fun1()");
	}
}

public class Program {

	public static void main(String[] args) {
		// create the child object
		child cld = new child();
		cld.foo(); // Here the child class object will first search in the child class if it found it will print the 
				   // method, otherwise it will traverse up and call the parent method.
	}

}
