package com.ca.pattern.decorator;
// https://en.wikipedia.org/wiki/Decorator_pattern
public class HorizontalScrollBarDecorator extends WindowDecorator {
	public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
		super(windowToBeDecorated);
	}
	
	@Override
	public void draw() {
		super.draw();
		drawHorizontalScrollBar();
	}
	
	private void drawHorizontalScrollBar() {
		System.out.println("draw horizontal scroll bar..");
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", including horizontal scrollbar";
	}
}
