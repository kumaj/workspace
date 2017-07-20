package Immutable;
/*
 * What is an immutable class ?
 * Ans:- Any class which object's contenet cannot be modified is called as immutable class
 * Eg. String class
 * Ques:- How can we make any class as immutable? Expain with an example
 */
public class Immutable {

	private int id;
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	//Default constructor
	public Immutable() {
	}
	
	//Parametrized constructor.
	public Immutable(int id, String name) {
		this.setId(id);
		this.name = name;
	}
	
	//copy constructor
	public Immutable(Immutable im) {
		this.id = im.getId();
		this.name = im.getName();
	}
}

class Solution {
	public static void main(String[] args) {
		Immutable im = new Immutable();
		Immutable im2 = new Immutable(1, "Ajit");
		System.out.println(im.getId() + " " + im.getName());
		System.out.println(im2.getId() + " " + im2.getName());
		
		//let's change the content of im2
		Immutable im3 = new Immutable(2, "Kumar");
		//Assign im3 contenet to im2
		// im2 = im3; can't we do like this. In C++ we call it as assignment.
		// im2.getId() = im3.getId(); This is also an invalid way to assign the value. But why ?
		//call the copy constructor
		Immutable im4 = new Immutable(im3);
		System.out.println(im4.getId() + " " + im4.getName());
	}
}
