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
		
		double price = cart.flowerPrice();

		if (price <= cash) {
			cash -= price;
		} else {
			cart.removeExcess();
			price = cart.flowerPrice();
			cash -= price;
			}
	}

	public void pack(Box pudelkoJanka) {
		for (Flower elt : cart.getContainer())
			pudelkoJanka.packContainer(elt);
	
		cart.removeAll();
	}
}
