package hu.uni.miskolc.iit.swtest.registrar.model;

public class Product {

	private final long productNumber;
	private final Category category;
	private final String name;
	private final Manufacturer manufacturer;
	private final Size size;
	private final float weight;
	private final Restriction restriction;
	
	public Product(long productNumber, Category category, String name, Manufacturer manufacturer, Size size,
			float weight, Restriction restriction) {
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
	public Restriction getRestriction() {
		return restriction;
	}
	
}
