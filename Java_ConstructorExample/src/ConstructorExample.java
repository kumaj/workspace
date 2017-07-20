/**
 * Can i class have a single constructor?
 * @author kumaj04
 *
 */
public class ConstructorExample {

	private String str;
	private Integer ii;
	public ConstructorExample() {
	}
	
	public ConstructorExample(String str) {
		this.setStr(str);
	}
	
	public ConstructorExample(String str, Integer ii) {
		this.setStr(str);
		this.setIi(ii);
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
	 * @return the ii
	 */
	public Integer getIi() {
		return ii;
	}

	/**
	 * @param ii the ii to set
	 */
	public void setIi(Integer ii) {
		this.ii = ii;
	}
}

class Solution {
	public static void main(String[] args) {
		ConstructorExample c = new ConstructorExample();
		System.out.println(c);
		System.out.println(c.getClass());
		System.out.println(c.getClass().getName());
		System.out.println(c.getStr());
		System.out.println(c.getIi());
	}
}


