package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Positions {

	private final Map<Long, String> positions;
	
	public Positions() {
		positions = new HashMap<Long, String>();
	}
	
	public void add(Long productNumber, String location) {
		if (positions.values().contains(location))
			throw new IllegalArgumentException("fuck you");
		positions.put(productNumber, location);
	}
	
	public void remove(Long productNumber) {
		positions.remove(productNumber);
	}
	
	public Collection<String> getUsedPositions() {
		return positions.values();
	}
	
	public String getPosition(Long productNumber) {
		return positions.get(productNumber);
	}

}
