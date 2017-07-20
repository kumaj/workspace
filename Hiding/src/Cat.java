// http://stackoverflow.com/questions/16313649/what-is-method-hiding-in-java-even-the-javadoc-explantion-is-so-confusing

//program to illustrate the function hiding in java
class Animal
{
	public void foo()
	{
		System.out.println("Animal::foo()");
	}
	
}
//lets extends the animal class in Cat and override the foo() method
public class Cat extends Animal{

	public void foo()
	{
		System.out.println("Cat::foo()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//from the main call the foo() method and see what is called with what object ?
		Animal a = new Animal();
		a.foo();
		
		Cat c = new Cat();
		c.foo();
		
		//let's do some trick
		Animal ac = new Cat();
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
