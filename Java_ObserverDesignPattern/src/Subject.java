import java.util.List;

/**
 * Let’s assume that we are working for a fantastic e-commerce site that has almost 
 * all kind of products and provide the latest information of the trends, new coupons, 
 * discount and other offers to its subscribed user. A user can subscribe to his/her 
 * favorite product (which may be currently out of stock) and get notification once 
 * the product is available in stock or the product is available at discount or when its price decreases.
 * @author kumaj04
 * This is the product class which tells about the discount and 
 * But first you have to register yourself to get the mail
 */
public class Subject {
	NotifyUser notify = new NotifyUser();
	Observer observ;
	
	public Subject(Observer observ) {
		this.observ = observ;
	}
	
	public void AddDiscount(String itemName) {
		/**
		 * Business logic has been written here
		 */
		notify.notifyForDiscount(observ, itemName);
	}
	
	public void itemAdded(String itemName) {
		/**
		 * Business logic has been written here
		 */
		notify.notifyForitemAdded(observ, itemName);
	}
}
