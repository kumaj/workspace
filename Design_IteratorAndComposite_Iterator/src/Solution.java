import java.util.Iterator;


public class Solution {
	public static void main(String[] args) {
		DinnerMenu dinner = new DinnerMenu();
		//now get the dinner iterator
		Iterator<MenuItem> dinnerIter = dinner.createIterator();
		while (dinnerIter.hasNext()) {
			MenuItem dinneritem = (MenuItem) dinnerIter.next();
			System.out.print(dinneritem.getName() + " ");	
		}
		
		System.out.println();
		
		PancakeHouseMenu panCake = new PancakeHouseMenu();
		Iterator<MenuItem> panCakeIter = panCake.createIterator();
		while (panCakeIter.hasNext()) {
			MenuItem panCakeItem = (MenuItem) panCakeIter.next();
			System.out.print(panCakeItem.getName() + " ");
		}
	}
}
