package com.ca.notification.admin;

import com.ca.notification.user.User;

/**
 * 
 * @author kumaj04
 * This class used by Admin for approval of registration.
 */
public class RegistrationMgmt {
	
	public Boolean doRegistration(User user) {
		doProcessing();
		return true;
	}
	
	public Boolean doUnregistration(User user) {
		doProcessing();
		return false;
	}
	
	// This function will do the processing 
	private void doProcessing() {
	}
}
