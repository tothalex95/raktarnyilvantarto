package hu.uni.miskolc.iit.swtest.registrar.model;

public class Product {

	private final long productNumber;
	private final Category category;
	private final String name;
	private final Manufacturer manufacturer;
	private final Size size;
	private final float weight;
	private final int restriction;

	public Product(Integer productNumber, Category category, String name, Manufacturer manufacturer, Size size,
			float weight, int restriction) {
		super();
		if (productNumber<1) throw new IllegalArgumentException("The productNumber cannot be under 1.");
		else if (category==null) throw new IllegalArgumentException("The category cannot be null.");
		else if (name==null || name.isEmpty()) throw new IllegalArgumentException("The name cannot be null.");
		else if (manufacturer == null) throw new IllegalArgumentException("Manufacturer cannot be null");
		else if (size==null) throw new IllegalArgumentException("Size cannot be null");
		else if (weight<1) throw new IllegalArgumentException("Weight cannot be under 1");
		else if (restriction<0||restriction>15) throw new IllegalArgumentException("Wrong Restirtion");
			
		this.productNumber = productNumber;
		this.category = category;
		this.name = name;
		this.manufacturer = manufacturer;
		this.size = size;
		this.weight = weight;
		this.restriction = restriction;
	}
	
	public Product(Integer productNumber, String ss1, String ss2, String ss3, Integer s1, Integer s2, Integer s3, Float f1, Integer r1){
		this.productNumber = 0;
		this.category = null;
		this.name = "";
		this.manufacturer = null;
		this.size = null;
		this.weight = 0;
		this.restriction = 1;
		System.out.println(
				"-----------------> "+ productNumber+" "+ ss1 + " " + ss2 +" "+ ss3 + " " + s1  +" "+ s2 +" " + s3 +" " + f1 + " " + r1); }

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
		result = prime * result + category.hashCode();
		result = prime * result + manufacturer.hashCode();
		result = prime * result + name.hashCode();
		result = prime * result + (int) (productNumber ^ (productNumber >>> 32));
		result = prime * result + restriction;
		result = prime * result + size.hashCode();
		result = prime * result + Float.floatToIntBits(weight);
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
		if (category != other.category)
			return false;
		if (manufacturer != other.manufacturer)
			return false;
		if (!name.equals(other.name))
			return false;
		if (productNumber != other.productNumber)
			return false;
		if (restriction != other.restriction)
			return false;
		if (!size.equals(other.size))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}

}
