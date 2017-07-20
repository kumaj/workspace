import java.util.List;

/**
 * 
 * @author kumaj04
 *
 */
public class NotifyUser {

	public void notifyForDiscount(Observer observ, String itemName) {
		List<String> subscriptionList = observ.getSubscriptionList();
		for(String name : subscriptionList)
			System.out.println("Hi " + name + " discount has been added on " + itemName + "of 10%" );
	}
	
	public void notifyForitemAdded(Observer observ, String itemName) {
		List<String> subscriptionList = observ.getSubscriptionList();
		for(String name : subscriptionList)
			System.out.println("Hi " + name + " new item " + itemName + " has been added..");
	}
}
