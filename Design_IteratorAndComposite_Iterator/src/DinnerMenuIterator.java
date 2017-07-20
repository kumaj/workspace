import java.util.Iterator;

/**
 * 
 * @author kumaj04
 * 
 */
public class DinnerMenuIterator implements Iterator<MenuItem> {
	
	MenuItem[] items;
	int position = 0;
	
	public DinnerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if(items.length <= position || items[position] == null)
			return false;
		else
			return true;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

}
