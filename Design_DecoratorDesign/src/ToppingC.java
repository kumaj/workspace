/**
 * 3rd type of topping
 * @author kumaj04
 *
 */
public class ToppingC extends Toppings{

	public ToppingC(String toppingName, double toppingPrice) {
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
