package com.ca.tdm.card.beans;

import java.util.Date;

/**
 * 
 * @author kumaj04
 * This bean class store the card details.
 * Each card should have the details about it shopping mall.
 */
public class Card extends ShoppingMall{
	private int cardNo;
	private Date validFrom;
	private Date validTo;
	/**
	 * @return the cardNo
	 */
	public int getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}
	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
