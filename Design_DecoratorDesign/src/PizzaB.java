/**
 * 
 * @author kumaj04
 *
 */
public class PizzaB implements Pizza {

	@Override
	public void createPizza(String pizzaName) {
		System.out.println(pizzaName  + " has been created successfully..");
	}

	@Override
	public double getCost() {
		return 200;
	}

}
