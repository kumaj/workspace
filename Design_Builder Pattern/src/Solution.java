/**
 * First we have to understand why the builder pattern is necessary?
 * What is the loss we have to incur in case we we won't use the builder pattern?
 * When we want to create a complex object and the constructor gets proliferated because of lot.
 * 
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		
		//Build the first car
		CarBuilder carBuilder = new CarBuilderImpl();
		carBuilder.setColour("RED");
		carBuilder.setWheels(3);
		carBuilder.build();
		System.out.println(carBuilder);
		
		//Let's build the 2nd car
		System.out.println("\n2nd car.....");
		CarBuilder carBuilder2 = new CarBuilderImpl();
		carBuilder2.setColour("WHITE").setWheels(4).build();
		System.out.println(carBuilder2);
	}
}
