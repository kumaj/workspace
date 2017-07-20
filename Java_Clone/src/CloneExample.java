import java.util.ArrayList;
import java.util.List;

/**
 *  This class illustrate the use of the clone() method. Why the clone method is used?
 *  Clone is used to create a replica of the existing object. It means it will create a new memory location after
 *  cloning of the existing object where it copies each field of the existing object into the new memory location.
 *  It is also called as deep copy.
 *  When we do assignment then a new reference will be created to the existing memory(object)
 *  https://en.wikipedia.org/wiki/Clone_(Java_method)
 *  
 *  if the class has only primitive data type members then a completely new copy of the object will
 *   be created and the reference to the new object copy will be returned. But, if the class contains 
 *   members of any class type then only the object references to those members are copied and hence the
 *    member references in both the original object as well as the cloned object refer to the same object.
 * @author kumaj04
 *
 */
public class CloneExample implements Cloneable {

	private Integer i;
	private String str;
	private List<String> list;
	
	public CloneExample(Integer ii, String ss) {
		this.setI(ii);
		this.setStr(ss);
		this.setList(new ArrayList<String>());
	}

	@Override
	protected CloneExample clone() throws CloneNotSupportedException {
		return (CloneExample) super.clone(); // Notice here you are calling the super clone()??
	}
	/**
	 * @return the i
	 */
	public Integer getI() {
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(Integer i) {
		this.i = i;
	}

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
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
	public static void main(String[] args) throws CloneNotSupportedException {
		Integer i = 10;
		String str = "Ajit";
		CloneExample c = new CloneExample(i, str);
		//get the list and add some eleemnts into it
		List<String> list = c.getList();
		list.add("One"); list.add("Two"); list.add("Three");
		//Now print it
		System.out.println("I orig Obj : " + c.getI());
		System.out.println("Str orig Obj : " +  c.getStr());
		System.out.println("List orig Obj" + c.getList());
		
		// now clone c 
		/**
		 * Clone will not hapeen unless and until the CloneExample class implements the Cloneable interface
		 * and override the clone() method.
		 */
		CloneExample cloneObj = c.clone();
		//Now print it
		System.out.println("I clone Obj : " + cloneObj.getI());
		System.out.println("Str clone Obj : " + cloneObj.getStr());
		System.out.println("List clone Obj : " + cloneObj.getList());
		
		// Print the memory location of original and clonable object.
		System.out.println(c);
		System.out.println(cloneObj);
		
		/*
		 * Since equals() method has not been overridden then it will call its super class
		 * which is object class equals() method. And Object class equals() methods is similar to == operator.
		 */
		System.out.println(c.equals(cloneObj));
		System.out.println(c == cloneObj);		
		
		CloneExample c2 = c;
		System.out.println(c.equals(c2));
		System.out.println(c == c2);	
	}
}
