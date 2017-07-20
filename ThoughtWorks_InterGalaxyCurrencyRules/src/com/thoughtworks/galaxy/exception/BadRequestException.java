package com.thoughtworks.galaxy.exception;

public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadRequestException() {}

	public BadRequestException(String message)
	{
		super(message);
	}
	
	public BadRequestException(String errorCode, String message)
	{
		super(errorCode);
	}
	
	public BadRequestException(String errorCode, String message, String detail)
	{
		super();
	}	
}
