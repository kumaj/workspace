/**
 * This class store the attribute of the card and 
 * @author kumaj04
 *
 */
public class MetroCard {
	private String cardNo;
	private Integer balance;
	
	public MetroCard() {}
	
	public MetroCard(String cardNo, int balance) {
		this.setCardNo(cardNo);
		this.balance = balance;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
