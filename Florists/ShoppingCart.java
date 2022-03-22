package florist;

import java.util.Collections;
import java.util.Iterator;

public class ShoppingCart extends Container {


	public ShoppingCart(Customer customer) {
		super(customer);
	}
	
	public void removeElt() {
		Iterator<Flower> iter = list.iterator();
		while(iter.hasNext()) {
			if (iter.next().getPrice() == -1.0)
				iter.remove();}
	}
	
	public void removeAll() {
		list.clear();
	}
	public void removeExcess() {
		Collections.sort(list, Flower.PriceComp);
		System.out.println(list);
		list.remove(0);
	}

	public  double flowerPrice() {
		double priceSC = 0;
		
		for(Flower flower: list) {
			double cena= flower.getPrice();
			double ilość = Double.valueOf(flower.getNumber());
			priceSC += cena * ilość;}
		
		return priceSC;
		}
		

}
