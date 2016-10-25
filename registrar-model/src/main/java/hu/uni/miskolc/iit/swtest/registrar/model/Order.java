package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Map;

public class Order {

	private final Map<Product, Integer> products;
	private final String destination;
	
	public Order(Map<Product, Integer> products, String destination) {
		super();
		this.products = products;
		this.destination = destination;
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

	public String getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		return "Order [products=" + products + ", destination=" + destination + "]";
	}
	
}
