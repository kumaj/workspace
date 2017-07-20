
public class exceptionhandling
{
	public void exceptionCheck(int age)
	{
		try
		{
			System.out.println("In Method exceptionCheck");
			if(age == 0)
				throw new NullPointerException("Age is 0"); // Here a new exception object has been created and it has been caught by
															// the catch block of this method. Notice the string passed into NullPointerException
			System.out.println("After Exception");
		}
		catch(Exception ex)
		{
			System.out.println("In catch block of exceptionCheck method");
			System.out.println(ex.getMessage());
		}
	}
	
	//This method doesn't have its own catch block, then where does it will get caught ?
	//It will get caught into its caller method
	public void exceptionCheck_02(int age)
	{
		//try
		{
			System.out.println("In Method exceptionCheck");
			if(age == 0)
				throw new NullPointerException("Age is 0");
			
			System.out.println("After Exception");
		}
//		catch(Exception ex)
//		{
//			System.out.println("In catch block of exceptionCheck method");
//			System.out.println(ex.getMessage());
//		}
	}
	
	// What will happen when we throw the exception in throw block ? Who will catch the exception ?
	public void exceptionCheck_03(int age)
	{
		try
		{
			System.out.println("In Method exceptionCheck");
			if(age == 0)
				throw new NullPointerException("Age is 0"); // Here a new exception object has been created and it has been caught by
															// the catch block of this method. Notice the string passed into NullPointerException
			System.out.println("After Exception");
		}
		catch(Exception ex)
		{
			System.out.println("In catch block of exceptionCheck method");
			System.out.println(ex.getMessage());
			throw new NullPointerException("Hiiiii");
		}
	}
}

class Solution
{
	public static void main(String[] args)
	{
		exceptionhandling ex = new exceptionhandling();
		try
		{
			//ex.exceptionCheck(0);
			//ex.exceptionCheck_02(0);
			ex.exceptionCheck_03(0);
		}
		catch(Exception e)
		{
			System.out.println("In catch block of main method");
			System.out.println(e.getMessage());
		}
	}
}
