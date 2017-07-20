package bank;

/**
 * Class to hold bank employee information
 * @author kumaj04
 *
 */
public class BankEmployee {
	private String employeeName;
	private String employeeId;
	private BankType bankType; // employee is assigned to which bank type.

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

	/**
	 * @return the bankType
	 */
	public BankType getBankType() {
		return bankType;
	}

	/**
	 * @param bankType the bankType to set
	 */
	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}
}
