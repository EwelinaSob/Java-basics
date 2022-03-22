package florist;

import java.util.Comparator;



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
	
	public static Comparator<Flower> PriceComp = new Comparator<Flower>() {
		public int compare(Flower o1, Flower o2) {
			double nr1 = o1.getPrice() * o1.getNumber();
			double nr2 = o2.getPrice() * o1.getNumber();
			return (int) (nr2 - nr1);
		}};
	
	 public String toString() {	 
	        return getName() + ", kolor: " + getColor() + ", ilość: " + getNumber() + ", cena: " + PriceList.getInstance().getPricePricelist(name);
	 }
}
