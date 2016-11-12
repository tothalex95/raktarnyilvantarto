package hu.uni.miskolc.iit.swtest.registrar.model;

public class Box {

	private final long id;
	private final Product product;
	private final int count;
	private final BoxSize boxSize;

	public Box(long id, Product product, int count, BoxSize boxSize) {
		if (new Size(product.getSize(), count).compareTo(boxSize.size) == -1)
			throw new IllegalArgumentException("boxsize is not large enough");
		this.id = id;
		this.product = product;
		this.count = count;
		this.boxSize = boxSize;
	}

	public float getWeight() {
		return count * product.getWeight();
	}

	public long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}

	public BoxSize getBoxSize() {
		return boxSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Box other = (Box) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Box [id=" + id + ", product=" + product + ", count=" + count + ", boxSize=" + boxSize + "]";
	}

	public enum BoxSize {

		SMALL(500), MEDIUM(1000), BIG(1500);

		private final Size size;

		private BoxSize(int mm) {
			size = new Size(mm);
		}

		public Size getSize() {
			return size;
		}

		@Override
		public String toString() {
			return super.toString();
		}

	}

}
