package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Positions {

	private final Map<Product, String> positions;

	public Positions() {
		positions = new HashMap<Product, String>();
	}

	public void add(Product product, String location) {
		if (positions.values().contains(location))
			throw new IllegalArgumentException("fuck you");
		positions.put(product, location);
	}

	public void remove(Product product) {
		if (!positions.containsKey(product))
			throw new IllegalArgumentException("No such product.");
		positions.remove(product);
	}

	public Collection<String> getUsedPositions() {
		return positions.values();
	}

	public String getPosition(Product product) {
		return positions.get(product);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<Product, String> entry : positions.entrySet()) {
			sb.append(entry.getValue()).append(": ").append(entry.getKey().toString()).append(System.lineSeparator());
		}
		return sb.toString();
	}

}
