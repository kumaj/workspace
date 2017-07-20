package com.ca.receipe;

import java.util.ArrayList;
import java.util.List;
/**
 * Class which hardcoded the receipe for the tea making
 * @author kumaj04
 *
 */
public class TeaReceipe implements Receipe {

	@Override
	public List<ReceipeItem> receipe() {
		// Create the receipe for the tea
		// Water -- 1 unit
		// Milk -- 2 units
		// Sugar -- 1 unit
		// Tea -- 2 units
		
		//get the common ingredient and tea list
		List<ReceipeItem> receipeItemList = new ArrayList<ReceipeItem>();
		ReceipeItem item1 = new ReceipeItem("Water", 1.0);
		ReceipeItem item2 = new ReceipeItem("Milk", 2.0);
		ReceipeItem item3 = new ReceipeItem("Sugar", 1.0);
		ReceipeItem item4 = new ReceipeItem("Tea", 2.0);
		receipeItemList.add(item1); receipeItemList.add(item2); 
		receipeItemList.add(item3); receipeItemList.add(item4);
		return receipeItemList;
	}

	@Override
	public List<ReceipeItem> updateReceipe() {
		// TODO Auto-generated method stub
		return null;
	}

}
