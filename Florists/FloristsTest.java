package florist;

public class FloristsTest {
	
	/* 
	 * Application for "self-service" florist.  
	 */
	
	  //  method - summing of the value of flowers with the given color
		static int valueOf(Box box, String color) {
	    
		int result = 0;
		for (Flower elt : box.getContainer()) {
			if(elt.getColor().equals(color)) {
				result += elt.getPrice() * elt.getNumber();	
			};		
		}
		return result;

	  }

	  public static void main(String[] args) {
	    
	    // setting of the price list
	    PriceList pl = PriceList.getInstance();
	    pl.put("róża", 10.0);
	    pl.put("bez", 12.0);
	    pl.put("piwonia", 8.0);

	    // First client Janek. He has 200 PLN.
	    Customer janek = new Customer("Janek", 200);

	    // He takes:
	    janek.get(new Rose(5));
	    janek.get(new Peony(5));
	    janek.get(new Freesia(3));
	    janek.get(new Lilac(3));

	    // And puts them in the shopping cart
	    // What does he has there?
	    ShoppingCart wozekJanka = janek.getShoppingCart();
	    System.out.println("Przed płaceniem\n" + wozekJanka);

	    // He needs to pay...
	    janek.pay();

	    // It turned out that he has in the cart flowers, with no price.
	    // We need to remove them
	    // Does he have enaugh money?

	    System.out.println("Po zapłaceniu\n" + janek.getShoppingCart());

	    // How much money has Janek's left?
	    System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

	    // We need to pack them?
	    Box pudelkoJanka = new Box(janek);
	    janek.pack(pudelkoJanka);

	    // What's in his shopping cart?
	    // (It should be empty.)
	    System.out.println("Po zapakowaniu do pudełka\n" + janek.getShoppingCart());

	    // what is in the box?
	    System.out.println(pudelkoJanka);

	    // Let's see the value of the red flowers in Janek's box
	    System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: "
	        + valueOf(pudelkoJanka, "czerwony"));

	    // Now comes Stefan
	    // He has only 60 PLN
	    Customer stefan = new Customer("Stefan", 60);

	    // /But he took a bit too many flowers...
	    stefan.get(new Lilac(3));
	    stefan.get(new Rose(5));

	    // What's in his shopping cart?
	    System.out.println(stefan.getShoppingCart());

	    // he pays and packs into a box
	    stefan.pay();
	    Box pudelkoStefana = new Box(stefan);
	    stefan.pack(pudelkoStefana);

	    // What he bought?
	    System.out.println(pudelkoStefana);
	    // ... How much money he has now?
	    System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
	  }
}
