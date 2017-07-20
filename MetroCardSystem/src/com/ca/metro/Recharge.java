package com.ca.metro;

import java.util.Map;

/**
 * This class is dedicated for recharge of the account
 * @author kumaj04
 *
 */
public class Recharge {

	Card card = new Card();
	/**
	 * Recharge the card with the specified amount
	 * @param cardNo
	 * @param amount
	 * @return
	 */
	public boolean rechargeCard(Integer cardNo, Integer amount) {
		Card cardInfo = card.getCardInfo(cardNo);
		if(cardInfo == null)
			return false;
		cardInfo.setAmount(amount);
		return true;
	}
	
	/**
	 * Return the balance of the card
	 * @param cardNo
	 * @return
	 */
	public int getAccountBalance(Integer cardNo) {
		Card cardInfo = card.getCardInfo(cardNo);
		if(cardInfo == null)
			return 0;
		return cardInfo.getAmount();
	}
}
