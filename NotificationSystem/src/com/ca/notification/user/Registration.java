package com.ca.notification.user;

import com.ca.notification.admin.RegistrationMgmt;

/**
 * 
 * @author kumaj04
 * This class is dedicated for registring to the subscription
 */
public class Registration {
	
	RegistrationMgmt mgmt = new RegistrationMgmt();
	public Boolean register(User user) {
		if(mgmt.doRegistration(user))
			System.out.println("User has been registered successfully..");
		else
			System.out.println("Failed to register the user");
		return true;
	}
	public Boolean unRegister(User user) {
		if(mgmt.doUnregistration(user)) 
			System.out.println("User has been unregistered sucessfully..");
		else
			System.out.println("Failed to unregister the user..");
		return true;
	}
}
