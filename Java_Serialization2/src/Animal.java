import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * What will happen to serialization and de-serialization if only the subclass will implement the serializable interface?
 * http://stackoverflow.com/questions/14042319/how-serialization-works-when-only-subclass-implements-serializable
 * It won't serialize the the fields of the class which has not implemented serializable interface. During the de-serialization
 * no-args constructor of the super class is called and fields has been initialized as per default constructor initialization in super class.
 * 
 * During deserialization, the fields of non-serializable classes will be initialized using the public or protected no-arg constructor
 *  of the class. A no-arg constructor must be accessible to the subclass that is serializable. The fields of serializable subclasses 
 *  will be restored from the stream.
 *  
 *  http://stackoverflow.com/questions/16442802/will-serialization-save-the-superclass-fields
 * 
 * @author kumaj04
 *
 */
public class Animal {

	private int i;
	Animal(){
		i=10;
    }
    int getVal() {
        return i;
    }
    void setVal(int i) {
        this.i=i;
    }	    
}

class Tiger extends Animal implements Serializable{

    private String s;
    //private Animal animal;

    Tiger(String s) {
        this.s = s;
        setVal(20);
    }

    public String toString() {
        return s + " " + getVal();
    }
}

class Solution {

    public static void main(String args[]) {
        Tiger m = new Tiger("Serial");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://serial.txt"));
            oos.writeObject(m); //writing current state
            oos.flush();
            oos.close();
            System.out.println("After Serialization : " + m); // display current state object value
        } catch (IOException e) {
            System.out.print(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://serial.txt"));
            Tiger o = (Tiger) ois.readObject(); // reading saved object
            ois.close();
            System.out.println("After Deserialization : " + o); // display saved object state
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
