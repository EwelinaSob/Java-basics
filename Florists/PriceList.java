package florist;

import java.util.*;

public class PriceList {
	
	private static PriceList instance = null;
	Map <String, Double> pricelist = new HashMap<String, Double>();
	
	
	private PriceList() {
		pricelist = new HashMap<String, Double>();	
	}
	

	

	public static PriceList getInstance() {
		 if(instance == null) {
	         instance = new PriceList();
	      }
	      return instance;
	   
	}
	
	public void put(String name, double price) {
		pricelist.put(name, price);
	}
	
	public double getPricePricelist(String nazwa) {
		Double price ;
		
		if (pricelist.get(nazwa) == null)
			price =  -1.0;
		else price = pricelist.get(nazwa);
			
		return price;
	}
	

}

