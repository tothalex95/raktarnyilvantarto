package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Collection;

public class Cargo {

	private final long id;
	private final Collection<Box> boxes;
	private final Address source;
	private final Address destination;

	public Cargo(long id, Collection<Box> boxes, Address source, Address destination) {
		if (boxes == null)
			throw new NullPointerException("Boxes cannot be Null");
		if (boxes.isEmpty())
			throw new IllegalArgumentException("Boxes cannot be empty");
		if (source == null)
			throw new IllegalArgumentException("Source cannot be Null");
		if (destination == null)
			throw new IllegalArgumentException("Destinaition cannot be Null");
		this.id = id;
		this.boxes = boxes;
		this.source = source;
		this.destination = destination;
	}

	public long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", boxes=" + boxes + ", source=" + source + ", destination=" + destination + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Cargo other = (Cargo) obj;
		if (id != other.id)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

}
