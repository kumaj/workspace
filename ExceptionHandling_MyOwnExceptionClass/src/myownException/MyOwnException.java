package myownException;

//Exception is the base class. You can create your own exception class. Here
// it is MyownException 
public class MyOwnException extends Exception {
}

//Rather than throwing the general exception, now you can throw the custom exception
// But how it will be useful ?? In what case i have to use it ?
// What benefit did i get it here ?
class ExceptionChecking
{
	public void foo() throws MyOwnException
	{
		System.out.println("Throw my own exception from foo()");
		throw new MyOwnException();
	}
}

class Solution
{
	public static void main(String[] args)
	{
		ExceptionChecking e = new ExceptionChecking();
		try
		{
			e.foo();
		}
		catch(MyOwnException ex)
		{
			System.out.println("Caught it !!!");
		}
	}
}
