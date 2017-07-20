
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *  Here the sublass which is serializable is referncing to a non-serializable class then what will happen?
 *  In such it will throw the exception during the serialization time stating that the reference class (Here Animal) is not serializable.
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

class Tiger implements Serializable{

    private String s;
    private Animal animal;

    Tiger(String s) {
        this.s = s;
        animal = new Animal();
        animal.setVal(20);
    }

    public String toString() {
        return s + " " + animal.getVal();
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
            System.out.println(m); // display current state object value
        } catch (IOException e) {
            System.out.print(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://serial.txt"));
            Tiger o = (Tiger) ois.readObject(); // reading saved object
            ois.close();
            System.out.println(o); // display saved object state
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
