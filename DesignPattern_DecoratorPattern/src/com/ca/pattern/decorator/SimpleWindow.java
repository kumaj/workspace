package com.ca.pattern.decorator;
// https://en.wikipedia.org/wiki/Decorator_pattern
public class SimpleWindow implements Window{

	@Override
	public void draw() {
		System.out.println("draw the simple window..");
	}

	@Override
	public String getDescription() {
		return "Simple Window";
	}

}
