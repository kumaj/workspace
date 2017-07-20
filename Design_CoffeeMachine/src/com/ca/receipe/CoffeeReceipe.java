package com.ca.receipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which hardcoded the receipe for the coffee making
 * @author kumaj04
 *
 */
public class CoffeeReceipe implements Receipe {

	@Override
	public List<ReceipeItem> receipe() {
		// Create the receipe for the tea
		// Water -- 1 unit
		// Milk -- 2 units
		// Sugar -- 1 unit
		// Coffee -- 3 units
		// cream -- 1 units
		
		//get the common ingredient and tea list
		List<ReceipeItem> receipeItemList = new ArrayList<ReceipeItem>();
		ReceipeItem item1 = new ReceipeItem("Water", 1.0);
		ReceipeItem item2 = new ReceipeItem("Milk", 2.0);
		ReceipeItem item3 = new ReceipeItem("Sugar", 1.0);
		ReceipeItem item4 = new ReceipeItem("Coffee", 3.0);
		ReceipeItem item5 = new ReceipeItem("Cream", 1.0);
		receipeItemList.add(item1); receipeItemList.add(item2); 
		receipeItemList.add(item3); receipeItemList.add(item4);
		receipeItemList.add(item5);
		
		return receipeItemList;
	}

	@Override
	public List<ReceipeItem> updateReceipe() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
