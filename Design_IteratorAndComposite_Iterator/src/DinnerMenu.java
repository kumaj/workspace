import java.util.Iterator;


public class DinnerMenu {
	static final int MAX_ITEMS = 6;
	int numOfItems = 0;
	MenuItem[] menuItems;
	
	public DinnerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("Roti", "Roti made up of..", true, 5);
		addItem("Rice", "Rice made up of..", true, 12);
		addItem("Chapati", "Chapati	 made up of..", true, 22);
		addItem("Biryani", "Biryani made up of..", true, 33);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numOfItems > 6)
			System.out.println("Menu is full. We can't add more to it");
		else {
			menuItems[numOfItems] = menuItem;
			numOfItems++;
		}
	}
	
	public Iterator<MenuItem> createIterator() {
		return new DinnerMenuIterator(menuItems);
	}
}
