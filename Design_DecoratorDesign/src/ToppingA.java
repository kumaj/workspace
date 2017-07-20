/**
 * First type of Topping 
 * @author kumaj04
 *
 */
public class ToppingA extends Toppings {

	public ToppingA(String toppingName, double toppingPrice) {
		super(toppingName, toppingPrice);
	}

	@Override
	public String getToppingName() {
		return toppingName;
	}

	@Override
	public double getToppingPrice() {
		return toppingPrice;
	}

}
