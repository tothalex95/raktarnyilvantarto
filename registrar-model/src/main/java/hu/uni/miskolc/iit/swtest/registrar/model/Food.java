package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Date;

public class Food extends Product {

	private int storageTemperature;
	private Date expirationDate;
	
	public Food(int serialNumber, int productNumber, String name, Manufacturer manufacturer,
			Size size, float weight, int storageTemperature, Date expirationDate) {
		super(serialNumber, productNumber, Category.FOOD, name, manufacturer, size, weight);
		this.storageTemperature = storageTemperature;
		this.expirationDate = expirationDate;
	}

	public int getStorageTemperature() {
		return storageTemperature;
	}

	public void setStorageTemperature(int storageTemperature) {
		this.storageTemperature = storageTemperature;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Food [storageTemperature=" + storageTemperature + ", expirationDate=" + expirationDate + ", toString()="
				+ super.toString() + "]";
	}

}
