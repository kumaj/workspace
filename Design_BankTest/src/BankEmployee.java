

/**
 * Class to hold bank employee information
 * @author kumaj04
 *
 */
public class BankEmployee {
	private String employeeName;
	private String employeeId;

	public BankEmployee(String employeeName, String employeeId) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
    @Override
    public String toString() {
        return "BankEmployee [employeeName = " + employeeName + ", employeeId = " + employeeId  + "]";
    }
}
