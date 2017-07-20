// http://geekexplains.blogspot.in/2008/06/can-you-override-static-methods-in-java.html
//http://stackoverflow.com/questions/2475259/can-i-override-and-overload-static-methods-in-java

//program to illustrate the function hiding in java for the static method
// in the Cat.java file same logic has been implemented but the functions are not static

//here Animal class is already defined inCat.Java file which is in the same package. 
//it was a name collision for the class name. Hence used Animals
class Animals
{
	public static void foo()
	{
		System.out.println("Animals::foo()");
	}
	
}
//lets extends the animal class in Cat and override the foo() method
public class Dog extends Animals{

	public static void foo()
	{
		System.out.println("Dog::foo()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//from the main call the foo() method and see what is called with what object ?
		Animals a = new Animals();
		a.foo();
		
		Dog c = new Dog();
		c.foo();
		
		//let's do some trick
		Animals ac = new Dog();
		ac.foo();
		
		//Here we have just created the reference but not hooked to the object
		// we can say that animal variable is only declared but not initialized
		//Animal aa;
		//aa.foo();
		
		//here both of the below statement is wrong as Animal cannot be casted into the cat type
		//Cat ccc = new Animal();
		//Cat cc = (Cat) new Animal();
		//cc.foo();
	}

}

//output
//Animals::foo()
//Dog::foo()
//Animals::foo()

//Java allows you to override the static method but it doesn't support the run-time polymorphism 
//static methods are at class level and hence they get resolved during the compile time only.