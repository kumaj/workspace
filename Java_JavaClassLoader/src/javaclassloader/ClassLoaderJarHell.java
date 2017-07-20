package javaclassloader;

import java.net.URL;

// http://www.herongyang.com/JVM/ClassLoader-Class-Load-Problem-JAR-Hell.html
public class ClassLoaderJarHell {

	public static void main(String[] args) {
		java.io.PrintStream out = System.out;
		java.net.URL u = null;
		
		out.println("");
		out.println("Find all locations of Hello.class...");
		try {
			URL e = ClassLoader.getSystemResource("Hello.class");
			out.println(e);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		out.println("");
		out.println("Running Hello class...");
		Hello.main(null);
	}
}
