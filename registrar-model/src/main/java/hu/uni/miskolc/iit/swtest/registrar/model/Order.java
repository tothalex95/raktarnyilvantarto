package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Map;

public class Order {

	private final long orderID;
	private final Map<Product, Integer> products;
	private final Customer customer;

	public Order(long orderID, Map<Product, Integer> products, Customer customer) {
		super();
		this.orderID = orderID;
		this.products = products;
		this.customer = customer;
	}

	public void add(Product product, int count) {
		products.put(product, count);
	}

	public void remove(Product product, int count) {
		if (!products.containsKey(product))
			throw new IllegalArgumentException("no such product");
		if (count > products.get(product))
			throw new IllegalArgumentException("there is not as much of that product");

		if (products.get(product) == count)
			products.remove(product);
		else
			products.put(product, products.get(product).intValue() - count);
	}

	public void remove(Product product) {
		remove(product, products.get(product));
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", products=" + products + ", customer=" + customer + "]";
	}

	public long getOrderID() {
		return orderID;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderID ^ (orderID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderID != other.orderID)
			return false;
		return true;
	}
	
	public float getWeight() {
		float ret = 0;
		for (Product p : products.keySet()) {
			ret += p.getWeight() * products.get(p);
		}
		return ret;
	}
	
	

}
