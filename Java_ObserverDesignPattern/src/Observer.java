import java.util.ArrayList;
import java.util.List;

/**
 * Let’s assume that we are working for a fantastic e-commerce site that has almost 
 * all kind of products and provide the latest information of the trends, new coupons, 
 * discount and other offers to its subscribed user. A user can subscribe to his/her 
 * favorite product (which may be currently out of stock) and get notification once 
 * the product is available in stock or the product is available at discount or when its price decreases.
 * @author kumaj04
 * Usually a user is an observer which observe which get notified about the discount, addition of new items etc
 * But first you have to register yourself to get the mail
 */
public class Observer {

	public List<String> subscriptionList;
	
	public Observer() {
		subscriptionList = new ArrayList<String>();
	}
	public void registerUser(String userName) {
		System.out.println(userName + " subscribed successfully");
		subscriptionList.add(userName);
	}
	
	public void unRegisterUser(String userName) {
		System.out.println(userName + " unsubscribed successfully ");
		subscriptionList.remove(userName);
	}
	public List<String> getSubscriptionList() {
		return subscriptionList;
	}
}
