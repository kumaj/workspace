package com.ca.tdm.test;

import com.ca.tdm.util.UtilA;
import com.ca.tdm.util.UtilB;

public class Parent {
	private UtilA source;
	private UtilB target;
	
	public Parent() {
		// TODO Auto-generated constructor stub
	}
	
	public Parent(UtilA uA, UtilB uB) {
		this.source = uA; 
		this.target = uB;
	}

	public UtilA getSource() {
		return source;
	}

	public void setSource(UtilA source) {
		this.source = source;
	}
	
	//let's call some method of util1 and util2
	public void CallerA() {
		source.fun1();
		source.fun2();
	}
	
	public void CallerB() {
		target.fun3();
		target.fun4();
	}

	public UtilB getTarget() {
		return target;
	}

	public void setTarget(UtilB target) {
		this.target = target;
	}
}
