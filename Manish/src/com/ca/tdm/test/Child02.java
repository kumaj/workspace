package com.ca.tdm.test;

import com.ca.tdm.util.UtilA;
import com.ca.tdm.util.UtilB;

/**
 * 
 * @author kumaj04
 * This class extends the Parent class
 */
public class Child02 extends Parent {
	//child class has the responsibilty to initialize the constructor of its parent class
	public Child02() {
		// TODO Auto-generated constructor stub
	}
	
	public Child02(UtilA uA, UtilB uB) {
		super(uA, uB);
	}
}
