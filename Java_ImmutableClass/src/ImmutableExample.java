import java.util.HashMap;
import java.util.Iterator;

/**
 *  This is one of the famous interview question. 
 *  How to create immutable class?
 * @author kumaj04
 *
 */
public final class ImmutableExample {
	private final int id;
	private final String name;
	private final HashMap<String, String> testMap;
	
	/*
	 * Constructor performing the deep copy of the class members
	 * here if you won't initalize the members then final keyword force you to
	 * initialize it during declaration of the final members.
	 */
	public ImmutableExample(int id, String name, HashMap<String, String> hm) {
		System.out.println("Performing the deep copy of the object Initialization");
		this.id = id;
		this.name = name;
		//Here the clone of the hasmap has been returned. Not the original reference.
		HashMap<String, String>  testMap2 = new HashMap<String, String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			key = it.next();
			testMap2.put(key, hm.get(key));
		}
		this.testMap = testMap2;
	}
	
	/**
	 * Constructor performing Shallow Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	
/*	public ImmutableExample(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id=i;
		this.name=n;
		this.testMap=hm;
	}*/
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public HashMap<String, String> getTestMap() {
		System.out.println("getTestMap() has been called..");
		//return testMap --- You can't do like that otherwise the object will get modified and the whole crux
		// of the immutablity will get broke down
		// so return the copy of the testmap. Altogether a new reference
		//return testMap;
		 return (HashMap<String, String>) testMap.clone();
	}
	
	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> hashmap = new HashMap<String,String>();
		hashmap.put("1", "first");
		hashmap.put("2", "second");
		
		String name = "original";
		
		int i=10;
		
		//Here the object has been initialised that is memory has been initialised
		ImmutableExample imEx = new ImmutableExample(i, name, hashmap);
		//Lets see whether its copy by field or reference
		System.out.println(name == imEx.getName());
		System.out.println(name.equals(imEx.getName()));
		
		//Let's print the value of the object
		System.out.println("ID : " + imEx.getId());
		System.out.println("Name : " + imEx.getName());
		System.out.println("HashMap : " + imEx.getTestMap());
		
		//Let's go ahead and change the variable values
		i = 20;
		name = "Modified";
		hashmap.put("3", "third");
		
		// print the value again
		System.out.println("ID after change : " + imEx.getId());
		System.out.println("Name after change : " + imEx.getName());
		System.out.println("HashMap after change : " + imEx.getTestMap());
		
		HashMap<String, String> hmTest = imEx.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("imEx testMap after changing variable from accessor methods:" + imEx.getTestMap());
		
		/*
		 * Now let’s comment the constructor providing deep copy and uncomment the constructor providing shallow copy. 
		 * Also uncomment the return statement in getTestMap() method that returns
		 *  the actual object reference and then execute the program once again.
		 */
		
	}
}
