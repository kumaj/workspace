import java.util.ArrayList;


/**
 * 
 * @author kumaj04
 * This class will access both the classes and print the menu. 
 * Here the problem is that the menu items are not encapsulated as 2 loops are required.
 * It is because their implementation is different.
 */
public class Solution {

	public static void main(String[] args) {
		
		//get the pancake items
		PancakeHouseMenu pancake = new PancakeHouseMenu();
		ArrayList<MenuItem> pancakeMenu = pancake.getMenuItems();
		//Iterate over the loop to print the menu items
		for (MenuItem menuItem : pancakeMenu) {
			System.out.print(menuItem.getName() + " ");
		}
		System.out.println();
		
		//get the dinner items
		DinerMenu dinner = new DinerMenu();
		MenuItem[] dinnerItems = dinner.getMenuItems();
		for (int i = 0; i < dinnerItems.length; i++) {
			System.out.print(dinnerItems[i].getName() + " ");
		}
	}
}
