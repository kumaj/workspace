import java.util.ArrayList;
import java.util.List;


public class Company {
	static List<String> commonEmployeesList = new ArrayList<String>();
	
	public void addCommonEmployees(String empName) {
		commonEmployeesList.add(empName);
	}
	
	public void removeCommonEmployees(String empName) {
		commonEmployeesList.remove(empName);
	}
	
	public void printCommonEmployees() {
		for (String empName : commonEmployeesList) {
			System.out.println(empName);
		}
	}
}
