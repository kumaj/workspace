package com.ca.notification.user;

/**
 * 
 * @author kumaj04
 * This is the bean class to store the information of the user
 */
public class User {
	private String name;
	private Long id;
	private String emailId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
