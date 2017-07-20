import java.util.ArrayList;


/**
 * 
 * @author kumaj04
 * It contains the arraylist of menuItems
 */
public class PancakeHouseMenu {
	ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		addItem("Samosa", "samosa is made up of ...", true, 12.5);
		addItem("gulab jamun", "Gulab jamun is made up of ...", false, 20.4);
		addItem("Kalakand", "kalakand is made up of ...", true, 10);
		addItem("pakoda chicken", "Butter chicken is made up of...", false, 200);
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
}
