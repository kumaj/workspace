import java.util.ArrayList;
import java.util.Iterator;


public class PanCakeIterator implements Iterator<MenuItem> {
	ArrayList<MenuItem> menuItems;
	int position = 0;
	
	public PanCakeIterator(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		if(menuItems.size() <= position || menuItems.size() == 0)
			return false;
		else
			return true;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = menuItems.get(position);
		position = position + 1;
		return menuItem;
	}

}
