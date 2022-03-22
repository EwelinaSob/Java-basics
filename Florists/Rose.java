package florist;

public class Rose extends Flower {

	public Rose(int i) {
			super("róża","czerwony", PriceList.getInstance().getPricePricelist("róża"), i) ;
		}
}
