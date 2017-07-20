package com.ca.metro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Support the CRUD operation on the card
 * User can recharge teh card
 * @author kumaj04
 *
 */
public class Card {

	static Integer autoCardNoGenerator = 1;
	private String name;
	private String address;
	private int amount;
	private Integer cardNo = 1;
	static Map<Integer, Card> cardMap = new HashMap<Integer, Card>();
	
	/**
	 * Default constructor
	 */
	public Card() {
		this.setName(null);
		this.setAddress(null);
		this.setAmount(0);
	}
	
	/**
	 * Parametrized constructor
	 */
	public Card(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}
	
	/**
	 * Create a new card to the user and return the card no
	 * @param cardHolderName
	 * @param address
	 * @return
	 */
	public int createNewCard(String cardHolderName, String address) {
		cardNo = autoCardNoGenerator;
		autoCardNoGenerator += 1;
		Card card = new Card(cardHolderName, address);
		cardMap.put(cardNo, card);
		return cardNo;
	}
	
	/**
	 * Delete the card 
	 * @param cardNo
	 * @return
	 */
	public boolean deleteCard(Integer cardNo) {
		if(cardMap.containsKey(cardNo)) {
			cardMap.remove(cardNo);
			return true;
		}
		return false;
	}
	
	/**
	 * Get the total count of the card
	 * @return
	 */
	public Integer getTotalCardCount() {
		return cardMap.size();
	}
	
	public Card getCardInfo(Integer cardNo) {
		return cardMap.get(cardNo);
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
