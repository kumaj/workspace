package com.ca.pattern.decorator;

/** https://en.wikipedia.org/wiki/Decorator_pattern
 * abstract decorator class - note that it implements window
 * @author kumaj04
 *
 */
public abstract class WindowDecorator implements Window{

	// the window to be decorated
	protected Window windowToBeDecorated;
	
	public WindowDecorator(Window windowToBeDecorated) {
		this.windowToBeDecorated = windowToBeDecorated;
	}
	
	public void draw() {
		windowToBeDecorated.draw();
	}
	
	public String getDescription() {
		return windowToBeDecorated.getDescription();
	}
}
