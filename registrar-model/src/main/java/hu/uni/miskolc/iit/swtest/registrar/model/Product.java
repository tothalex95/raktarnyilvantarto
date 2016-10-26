package hu.uni.miskolc.iit.swtest.registrar.model;

public class Product {

	private final long productNumber;
	private final Category category;
	private final String name;
	private final Manufacturer manufacturer;
	private final Size size;
	private final float weight;
	private final int restriction;

	public Product(long productNumber, Category category, String name, Manufacturer manufacturer, Size size,
			float weight, int restriction) {
		super();
		this.productNumber = productNumber;
		this.category = category;
		this.name = name;
		this.manufacturer = manufacturer;
		this.size = size;
		this.weight = weight;
		this.restriction = restriction;
	}

	public long getProductNumber() {
		return productNumber;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Size getSize() {
		return size;
	}

	public float getWeight() {
		return weight;
	}

	public int getRestriction() {
		return restriction;
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", category=" + category + ", name=" + name
				+ ", manufacturer=" + manufacturer + ", size=" + size + ", weight=" + weight + ", restriction="
				+ restriction + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productNumber ^ (productNumber >>> 32));
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
		Product other = (Product) obj;
		if (productNumber != other.productNumber)
			return false;
		return true;
	}

}
