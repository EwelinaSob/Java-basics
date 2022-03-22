package florist;

abstract class Flower {
	
	protected String name;
	protected String color;
	protected double price;
	private int number;
	

	public Flower() {
	}

	public Flower( String n, String k, double price, int number) {
		name = n;
		color = k;	
		this.price = price;
		this.number = number;
		
		}
	
	
	public String getName() {return name;}
	
	public String getColor() {return color;}
	
	public int getNumber() { return number;}
	
	public double getPrice() {return price;}
	

	
	 public String toString() {	 
	        return getName() + ", kolor: " + getColor() + ", ilość: " + getNumber() + ", cena: " + PriceList.getInstance().getPricePricelist(name);
	 }
}
