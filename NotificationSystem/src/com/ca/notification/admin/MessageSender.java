package com.ca.notification.admin;

public interface MessageSender {
	public void initialize();
	public void sendMessage();
	public void stop();
}
