/**
 * This project is still unfinished and decorator pattern is yet to be implemented.
 * https://softwareengineering.stackexchange.com/questions/240281/how-is-the-decorator-pattern-actually-used-in-practice
 * http://stackoverflow.com/questions/2707401/please-help-me-understand-the-decorator-pattern-with-a-real-world-example
 * Decorator design pattern
 * @author kumaj04
 *
 */
public class Solution {
	public static void main(String[] args) {
		Pizza p1 = new PizzaA();
		Pizza p2 = new PizzaB();
		p1.createPizza("Pizza_A");
		p2.createPizza("Pizza_B");
		System.out.println("Pizza_A cost : " + p1.getCost());
		System.out.println("Pizza_B cost : " + p2.getCost());
		
		//Let's say we have 2 topping....
		Toppings topA = new ToppingA("Topping_A", 10);
		Toppings topB = new ToppingB("Topping_B", 15);
		Toppings topC = new ToppingC("Topping_C", 20);
		
		PizzaController controller = new PizzaController();
		// Since there are 3 types of topping, there would be pow(2,3)-1 = 7 combination of topping
		// So what would be better way of oops design?
		// A customer can ask for a pizza with any 7 combination.
		controller.createPizzaWithTopping("Pizza_A", "Topping_A", "Topping_B");
	}
}
