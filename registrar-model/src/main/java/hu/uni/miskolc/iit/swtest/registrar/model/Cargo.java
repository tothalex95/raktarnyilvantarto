package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Collection;

public class Cargo {

	private final Collection<Box> boxes;
	private final Address source;
	private final Address destination;
	
	public Cargo(Collection<Box> boxes, Address source, Address destination) {
		if(boxes==null) throw new NullPointerException("Boxes cannot be Null");
		else if(boxes.isEmpty()) throw new IllegalArgumentException("Boxes cannot be empty");
		else if(source==null) throw new IllegalArgumentException("Source cannot be Null");
		else if(destination==null) throw new IllegalArgumentException("Destinaition cannot be Null");
		this.boxes = boxes;
		this.source = source;
		this.destination = destination;
	}

	public Collection<Box> getBoxes() {
		return boxes;
	}

	public Address getSource() {
		return source;
	}

	public Address getDestination() {
		return destination;
	}
	
	

}
