
public abstract class Toppings extends PizzaDecorator {
	String toppingName;
	double toppingPrice;
	
	/**
	 * Constructor has been added so that all the subclasses will have
	 * toppingName and toppingPrice as its fields. So why can't put in super class?
	 * @param toppingName
	 * @param toppingPrice
	 */
	public Toppings(String toppingName, double toppingPrice) {
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;
	}
	
	public abstract String getToppingName();
	public abstract double getToppingPrice();
}
