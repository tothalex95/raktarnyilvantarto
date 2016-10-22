/**
 * 
 */
package hu.uni.miskolc.iit.swtest.registrar.model;

/**
 * @author Sátán Ádám
 *
 */
public class IndustrialEquipment extends Product {

	/**
	 * @param serialNumber
	 * @param productNumber
	 * @param category
	 * @param name
	 * @param manufacturer
	 * @param size
	 * @param weight
	 * @param dangerLevel
	 */
	private final int serialNumber;
	private final int productNumber;
	private final Category category;
	private String name;
	private Manufacturer manufacturer;
	private Size size;
	private float weight;
	private int dangerLevel;
	
	public IndustrialEquipment(int serialNumber, int productNumber, Category category, String name,
			Manufacturer manufacturer, Size size, float weight, int dangerLevel) {
		super(serialNumber, productNumber, category, name, manufacturer, size, weight);
		this.serialNumber=serialNumber;
		this.productNumber=productNumber;
		this.category=category;
		this.name=name;
		this.manufacturer=manufacturer;
		this.size=size;
		this.weight=weight;
		this.dangerLevel=dangerLevel;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public Category getCategory() {
		return category;
	}
	
	public int getDangerLevel()
	{
		return dangerLevel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productNumber;
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
		IndustrialEquipment other = (IndustrialEquipment) obj;
		if (productNumber != other.productNumber)
			return false;
		return true;
	}
}
