package com.ca.constructor;

/**
 * Exercise 1: (1) Create a class containing an uninitialized String reference. Demonstrate
that this reference is initialized by Java to null.

Exercise 2: (2) Create a class with a String field that is initialized at the point of
definition, and another one that is initialized by the constructor. What is the difference
between the two approaches?
 * @author kumaj04
 *
 */
public class ConstructorExample {
	String name;
	String aliasName = "Ajit";
	// Initialize the object with custom value of string 
	public ConstructorExample(String value) {
		this.name = value;
		this.aliasName = value;
	}
	
}

class Solution {
	public static void main(String[] args) {
		ConstructorExample cstr = new ConstructorExample(null);
		System.out.println(cstr.name);
		System.out.println(cstr.aliasName);
		
		ConstructorExample cstr2 = new ConstructorExample("Kumar");
		System.out.println(cstr2.name);
		System.out.println(cstr2.aliasName);
	}
}
