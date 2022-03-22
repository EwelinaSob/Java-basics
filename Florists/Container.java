package florist;

import java.util.*;

abstract class Container {

	protected Customer customer;
	protected List<Flower> list;

	public Container(Customer customer) {
		this.customer = customer;
		list = new ArrayList<Flower>();
	}

	public void packContainer(Flower flower) {
		list.add(flower);
	}

	public List<Flower> getContainer() {
		return list;
	}

	public String toString() {
		String info = "";
		StringBuffer sb = new StringBuffer();

		for (Flower flower : list) {
			sb.append(flower).append('\n');
		}

		if (this instanceof Box && this.getContainer().size() != 0) {
			info = "Pudełko własciciel " + customer.getName() + '\n';
			return info + sb.toString().trim();

		} else if (this instanceof Box && this.getContainer().size() == 0) {
			return "Pudełko własciciel " + customer.getName() + " -- pusto";

		} else if (this instanceof ShoppingCart && this.getContainer().size() != 0) {
			info = "Wózek własciciel " + customer.getName() + '\n';
			return info + sb.toString().trim();

		} else if (this instanceof ShoppingCart && this.getContainer().size() == 0) {
			return "Wózek własciciel " + customer.getName() + " -- pusto";

		} else
			return "Błąd";

	}
}
