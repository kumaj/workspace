//This program illustrate the use of the sleep method. Sleep doesn't 
// guarantee that the thread will sleep for that exact time. it will depend upon the 
//resources and can be awake by different interrupts.
public class SleepImplem {
	
	public static void main(String[] args) throws InterruptedException
	{
		String[] words = {"aa", "bb", "cc", "dd", "ee", "ff" };
		
		for(String str:words)
		{
			//sleep for 1 sec
			Thread.sleep(1000);
			System.out.println(str);
			
		}
	}
	
	//Notice that main declares that it throws InterruptedException. 
	//This is an exception that sleep throws when another thread interrupts the current thread while sleep is active.

}
