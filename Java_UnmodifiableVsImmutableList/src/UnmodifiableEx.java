import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * http://stackoverflow.com/questions/8892350/immutable-vs-unmodifiable-collection
 * http://stackoverflow.com/questions/7713274/java-immutable-collections
 * http://stackoverflow.com/questions/12451013/immutable-objects-and-unmodifiable-collections
 * @author kumaj04
 *
 */

public class UnmodifiableEx {
	private List<String> list;
	public UnmodifiableEx(List<String> list) {
		this.setList(list);
	}
	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<String> list) {
		this.list = list;
	}
}

class Solution {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		System.out.println("Orig list :" + list);
		
		//Create an unmodifiable list
		List<String> unMod  = Collections.unmodifiableList(list);
		System.out.println("Unmod list :" +  unMod);
		List<String> immutableList=Collections.unmodifiableList(new ArrayList<String>(list)); //Here you have assigned new memory
		System.out.println("Immutable list :" +  immutableList);
		
		// Now add element into temp
		list.add("B");
		System.out.println("Orig list after adding element:" + list);
		System.out.println("Unmod list :" +  unMod);
		System.out.println("Immutable list :" +  immutableList);
	}
}
