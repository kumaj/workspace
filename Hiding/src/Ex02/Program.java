
//Can we extend a class and implement multiple interface in a class ?
// http://stackoverflow.com/questions/129267/why-no-static-methods-in-interfaces-but-static-fields-and-inner-classes-ok/135722#135722
//http://www.journaldev.com/2752/java-8-interface-changes-static-methods-default-methods-functional-interfaces
package Ex02;
class Parent
{
	void foo()
	{
		System.out.println("Parent::foo()");
	}
}

interface firstInterface
{
	//Java 8 supports static methods in interface but previous version doesn't 
	//allow to declare the static methods in an interface. Also static methods can't be overridden
	// Actually the compiler allow it to override the static method but the run-time polymorphism 
	// cannot be achieved using the static methods becuase of compile time feature of static methods.
	 static void foo()
	{
		System.out.println("firstInterface::foo()");
	}
	 
	 //let's only declare the static method 
	 //static void foo2();
	 
	 //let's declare one more method
	 void show();
}

//Let's create another interface
interface secondInterface
{
	//how this foo() will be called
	static void foo()
	{
		System.out.println("secondInterface::foo()");
	}
	void show();
}

//Let's create a class which extends the class and both the interface
class classImpl implements firstInterface, secondInterface
{

	@Override
	public void show() {
		System.out.println("classImpl::foo()");
		
	}	
}

class classImpl2 extends Parent implements firstInterface, secondInterface
{

	@Override
	public void show() {
		System.out.println("classImpl::foo()");
		
	}	
}

public class Program {

	public static void main(String[] args) {

		classImpl obj = new classImpl();
		obj.show();

		classImpl2 obj2 = new classImpl2();
		obj2.foo();
		
		//call the foo
		firstInterface.foo();
		secondInterface.foo();
	}

}
