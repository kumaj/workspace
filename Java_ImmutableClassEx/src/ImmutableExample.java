import java.util.ArrayList;
import java.util.List;


public final class ImmutableExample {

	private final String str;
	private final List<String> list;
	
	public ImmutableExample(String str, List<String> ls) {
		this.str =  str;
		
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < ls.size(); i++) {
			tempList.add(ls.get(i));
		}
		this.list = tempList;
	}

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			tempList.add(list.get(i));
		}
		return tempList;
	}
	
	@Override
	public String toString() {
		return str + " " + list;
	}
}

class Solution {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("Ajit");
		ImmutableExample i = new ImmutableExample("One", ls);
		
		System.out.println(i);
		
		ls.add("Good"); // Here the list gets modified which is agaianst the rule of immutability.
						// So in such cases copy the list to a new memory inside the constructor
						// If you don't copy it to new memory location then it wil get modified.
		
		List<String> ll = i.getList();
		ll.add("Boy");
		
		System.out.println(i);
	}
}
