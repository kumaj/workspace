
/**
 * class to store the customer information
 * @author kumaj04
 *
 */
public class CustomerInfo {
	private String name;
	private String secondaryAccountName; // required for joint account type.
	private String address;
	private String IdProofNo;
	private Integer stockAmount; // required for demat account.
	
	// This is best place to implement the builder pattern ...
	// as the constructor gets proliferated.....
	
	//Constructor for saving account
	public CustomerInfo(String name, String address, String IdProofNo) {
		this.name = name;
		this.address = address;
		this.setIdProofNo(IdProofNo);
	}
	
	//Constructor for joint account
	public CustomerInfo(String name, String secondaryAccountName, String address, String IdProofNo) {
		this.name = name;
		this.secondaryAccountName = secondaryAccountName;
		this.address = address;
		this.setIdProofNo(IdProofNo);
	}
	
	//Constructor for demat account
	public CustomerInfo(String name, Integer stockAmount, String address, String IdProofNo) {
		this.name = name;
		this.stockAmount = stockAmount;
		this.address = address;
		this.setIdProofNo(IdProofNo);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the idProofNo
	 */
	public String getIdProofNo() {
		return IdProofNo;
	}
	/**
	 * @param idProofNo the idProofNo to set
	 */
	public void setIdProofNo(String idProofNo) {
		IdProofNo = idProofNo;
	}
	/**
	 * @return the secondaryAccountName
	 */
	public String getSecondaryAccountName() {
		return secondaryAccountName;
	}
	/**
	 * @param secondaryAccountName the secondaryAccountName to set
	 */
	public void setSecondaryAccountName(String secondaryAccountName) {
		this.secondaryAccountName = secondaryAccountName;
	}
	/**
	 * @return the stockAmount
	 */
	public Integer getStockAmount() {
		return stockAmount;
	}
	/**
	 * @param stockAmount the stockAmount to set
	 */
	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}
}
