package com.ca.pattern.decorator;

// https://en.wikipedia.org/wiki/Decorator_pattern

public class DecoratedWindowTest {
	public static void main(String[] args) {
		
		//first of all create a simple window
		Window simpleWindow = new SimpleWindow();
		System.out.println(simpleWindow.getDescription());
		
		// create a window with only vertical scroll bar
		Window verticalWindow = new VerticalScrollBarDecorator(new SimpleWindow());
		System.out.println(verticalWindow.getDescription());
		
		//Create a decorated window with horizontal and vertical scrollbars
		Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
		System.out.println(decoratedWindow.getDescription());
	
	}
}
