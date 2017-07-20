package com.ca.pattern.decorator;
// https://en.wikipedia.org/wiki/Decorator_pattern
public class VerticalScrollBarDecorator extends WindowDecorator {
	public VerticalScrollBarDecorator(Window windowToBeDecorated) {
		super(windowToBeDecorated);
	}
	
	@Override
	public void draw() {
		super.draw();
		drawVerticalScrollBar();
	}
	
	private void drawVerticalScrollBar() {
		System.out.println("draw vertical scroll bar..");
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", including vertical scroll bar";
	}

}
