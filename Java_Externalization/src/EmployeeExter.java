import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * This class illustrate the implementation of externalization. Why do we need externalization?
 * What is the use of externalization? How is it different between externalization and serialization?
 * http://www.java2blog.com/2014/02/externalizable-in-java.html#Ljv65r9jypogJAyA.99
 * https://examples.javacodegeeks.com/core-java/io/externalizable/java-io-externalizable-example/
 * http://www.jusfortechies.com/java/core-java/externalization.php
 * 
 * The writeExternal and readExternal methods of the Externalizable
 * interface are implemented by a class to give the class complete
 * control over the format and contents of the stream for an object
 * and its supertypes
 * 
 * So if you already have serializable then why do you need it?
 * @author kumaj04
 *
 */
public class EmployeeExter implements Externalizable {
	private Integer empId;
	private String name;
	private String address;
	
	// you must have no args contructor if you implement externalizable. 
	// otherwise we will get invalidclass exception
	public EmployeeExter() {}
	
	//let's create a parametrized cnstr 
	public EmployeeExter(Integer empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Read Ext called");
		empId = in.readInt();
		name = (String) in.readObject();
	}
	
	@Override
	 public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Write Ext called");
		out.writeInt(empId);
		out.writeObject(name);
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}

class Solution {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Here we have created an object using no-arg cnstr
		EmployeeExter emp = new EmployeeExter();
		emp.setEmpId(1);
		emp.setName("Ajit");
		
		//Serialize it
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://serialEmp.txt"));
         oos.writeObject(emp); //writing current state
         oos.flush();
         oos.close();
		
         //deserialize it
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://serialEmp.txt"));
         EmployeeExter empp =  (EmployeeExter) ois.readObject();
         
         System.out.println(empp.getEmpId());
         System.out.println(empp.getName());
         
      // Here we have created an object using no-arg cnstr
 		EmployeeExter emp2 = new EmployeeExter(2, "kumar", "Hyd");
 		
 		//Serialize it
 		 ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C://serialEmp.txt"));
         oos2.writeObject(emp2); //writing current state
         oos2.flush();
         oos2.close();
 		
          //deserialize it
          ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("C://serialEmp.txt"));
          EmployeeExter empp2 =  (EmployeeExter) ois2.readObject();
          
          System.out.println(empp2.getEmpId());
          System.out.println(empp2.getName());
         
	}
}
