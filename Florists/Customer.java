package florist;

public class Customer {
	private String customerName;
	private int cash;
	ShoppingCart cart;

	public Customer(String customerName, int cash) {
		this.customerName = customerName;
		this.cash = cash;
		cart = new ShoppingCart(this);
	}

	public void get(Flower flower) {cart.packContainer(flower);}

	public ShoppingCart getShoppingCart() {return cart;}

	public Double getCash() {return Double.valueOf(cash);}
	
	public String getName() {return customerName;}
	

	public void pay() {

		cart.removeElt();
		int size = cart.getContainer().size();

		double price = cart.flowerPrice();

		for (int i = 0; i < size; i++) {
			if (price <= cash) {
				cash -= price;
				break;
			} else {
				cart.removeExcess();
				price = cart.flowerPrice();

			}
		}
	}

	public void pack(Box pudelkoJanka) {
		for (Flower elt : cart.getContainer())
			pudelkoJanka.packContainer(elt);
	
		cart.removeAll();
	}
}
