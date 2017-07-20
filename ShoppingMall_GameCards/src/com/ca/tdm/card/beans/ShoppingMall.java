package com.ca.tdm.card.beans;

import java.util.Date;

/**
 * 
 * @author kumaj04
 * This bean class store teh details of shopping mall
 */
public class ShoppingMall {
	
	private String mallName;
	private String address;
	private String mallid;
	private Date establishedYr;
	/**
	 * @return the mallName
	 */
	public String getMallName() {
		return mallName;
	}
	/**
	 * @param mallName the mallName to set
	 */
	public void setMallName(String mallName) {
		this.mallName = mallName;
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
	 * @return the mallid
	 */
	public String getMallid() {
		return mallid;
	}
	/**
	 * @param mallid the mallid to set
	 */
	public void setMallid(String mallid) {
		this.mallid = mallid;
	}
	/**
	 * @return the establishedYr
	 */
	public Date getEstablishedYr() {
		return establishedYr;
	}
	/**
	 * @param establishedYr the establishedYr to set
	 */
	public void setEstablishedYr(Date establishedYr) {
		this.establishedYr = establishedYr;
	}
}
