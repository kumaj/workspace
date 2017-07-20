import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author kumaj04
 * Shared resource classs contain a arraylist which will be used by producer and consumer classes
 */
public class SharedResource {

	private List<Integer> arr;
	private Object obj = new Object();
	private Integer count;
	
	//Whenever this constructor is called, an arrylist get created
	public SharedResource() {
		setArr(new ArrayList<Integer>());
		setCount(1);
	}

	/**
	 * @return the arr
	 */
	public List<Integer> getArr() {
		return arr;
	}

	/**
	 * @param arr the arr to set
	 */
	public void setArr(List<Integer> arr) {
		this.arr = arr;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
