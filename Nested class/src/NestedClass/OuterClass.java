package NestedClass;

/*
 * What is the difference between nested class and inner classes ?
 * Basically concept is related to nested class. There are 2 types of nested class
 * When the inner class is static then it is called as nested static class
 * When the inner class is non-static then it is called as simply inner class
 * http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class?lq=1
 * http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 */
public class OuterClass {

	//declare a field and a method in the outer class
	int outerX;
	public void outerFun() {
		System.out.println("OuterFun() in OuterClass");
	}
	class InnerClass {
		//declare the field and method in the inner class
		int innerX;
		public void innerFun() {
			System.out.println("innerFun():innerClass");
		}
	}
}

//Example to illustrate static nested class
class OuterClass2 {
	int outer2X;
	public void outer2Fun() {
		System.out.println("outer2Fun():OutterClass2");
	}
	
	static class innerStaticClass {
		int innerStaticX; //Can a static class contains a non-static variable ?
		static int z;
		public void innerStaticFun() {
			System.out.println("innerStaticFun():OuterClass2");
		}
	}
}


class solution {
	//let's try to call the outer and inner class fields and methods.\
	public static void main(String[] args) {
		
		//create outer class object
		OuterClass out = new OuterClass();
		out.outerX = 10;
		System.out.println("outerX : " + out.outerX);
		out.outerFun();
		
/*		create inner class object
		you cannot create the object like this
		InnerClass in = new InnerClass();
		OuterClass.InnerClass in = new InnerClass();
		 To instantiate an inner class, you must first instantiate the outer class. 
		Then, create the inner object within the outer object with this syntax:
		*/
		OuterClass.InnerClass in = out.new InnerClass();
		in.innerX = 20;
		System.out.println("innerX : " + in.innerX);
		in.innerFun();
		
/*		Can the inner class object access the members of the outer class and vice-versa ?
		 If yes then why if not then why ?
		in.outerX = 111; error
		 in.outerFun(); error
		 out.innerX = 222; error
		 What would be the behaviour in the case of nested static class
		 */
		
		//Let's try to call the static nested class
		OuterClass2 out2 = new OuterClass2();
		out2.outer2X = 11;
		System.out.println(out2.outer2X);
		out2.outer2Fun();
		
		
		//call the static nested class
		//U cannot create the inner object like this.
		//OuterClass2.innerStaticClass in2 = out2.new innerStaticClass(); 
		//OuterClass2.innerStaticClass in2 = OuterClass2.innerStaticClass();
		OuterClass2.innerStaticClass.z = 100;
		System.out.println("z : " + OuterClass2.innerStaticClass.z);
		
		// Try to access the innerStaticX fiels and fun, you cannot
		// //OuterClass2.innerStaticClass.innerStaticX
		//So create the object of the nested static class object
		OuterClass2.innerStaticClass in2 = new OuterClass2.innerStaticClass();
		in2.innerStaticX = 21;
		System.out.println(in2.innerStaticX);
		in2.innerStaticFun();
		
		
	}
}
