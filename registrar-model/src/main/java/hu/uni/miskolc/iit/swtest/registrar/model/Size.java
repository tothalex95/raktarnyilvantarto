package hu.uni.miskolc.iit.swtest.registrar.model;

public final class Size {

	// mm
	private final int x;
	private final int y;
	private final int z;
	
	public Size(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Size(int n) {
		this(n,n,n);
	}

	@Override
	public String toString() {
		return x + "x" + y + "x" + z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
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
		Size other = (Size) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
}
