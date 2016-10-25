package hu.uni.miskolc.iit.swtest.registrar.model;

public class Box {
	
	private final Product product;
	private final int count;
	private final BoxSize boxSize;
	
	public Box(Product product, int count, BoxSize boxSize) {
		if (new Size(product.getSize(), count).compareTo(boxSize.size) == -1)
			throw new IllegalArgumentException("boxsize is not large enough");
		this.product = product;
		this.count = count;
		this.boxSize = boxSize;
	}
	
	public float getWeight() {
		return count * product.getWeight();
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
	public String toString() {
		return "Box [product=" + product + ", count=" + count + ", boxSize=" + boxSize + "]";
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
