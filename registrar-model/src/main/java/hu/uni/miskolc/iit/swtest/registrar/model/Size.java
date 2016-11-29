package hu.uni.miskolc.iit.swtest.registrar.model;

public final class Size implements Comparable<Size> {

	// mm
	private final int width;
	private final int height;
	private final int depth;

	public Size(Integer width, Integer height, Integer depth) {
		super();
		if (width < 1 || height < 1 || depth < 1)
			throw new IllegalArgumentException("Size parameters must be positive.");
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public Size(int n) {
		this(n,n,n);
	}
	
	public Size(Size s, int n) {
		this(s.width*n, s.height*n, s.depth*n);
	}

	@Override
	public String toString() {
		return "Size [width=" + width + ", height=" + height + ", depth=" + depth + "]";
	}

	public int getHeight() {
		return height;
	}

	public int getDepth() {
		return depth;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + depth;
		result = prime * result + height;
		result = prime * result + width;
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
		if (depth != other.depth)
			return false;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public int compareTo(Size o) {
		int v1 = width * height * depth;
		int v2 = o.width * o.height * o.depth;
		if (v1 > v2)
			return 1;
		if (v1 < v2)
			return -1;
		return 0;
	}

}