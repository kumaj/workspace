
public class ToppingB extends Toppings {

	public ToppingB(String toppingName, double toppingPrice) {
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
