package com.ca.pattern.decorator;

/** https://en.wikipedia.org/wiki/Decorator_pattern
 * Window interface
 * @author kumaj04
 *
 */
public interface Window {
	
	/**
	 * Draws the windows
	 */
	public void draw();
	
	/**returns the description of the window
	 * 
	 * @return
	 */
	public String getDescription();
}
