import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author kumaj04
 *
 */
public interface Company {
	// The data members inside the interface is a static one. If u won't 
	// add the static keyword then internally compiler will make it as static.
	List<String> commonEmployeesList = new ArrayList<String>();
	
	public void addCommonEmployees(String empName);
	public void removeCommonEmployees(String empName);
	public void printCommonEmployees();
}
