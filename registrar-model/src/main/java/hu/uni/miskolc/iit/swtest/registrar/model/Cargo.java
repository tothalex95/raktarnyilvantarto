package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Collection;

public class Cargo {

	private final Collection<Box> boxes;
	private final String source;
	private final String destination;
	
	public Cargo(Collection<Box> boxes, String source, String destination) {
		this.boxes = boxes;
		this.source = source;
		this.destination = destination;
	}

	public Collection<Box> getBoxes() {
		return boxes;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}
	
	

}
