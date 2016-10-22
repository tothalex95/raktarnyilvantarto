package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.Date;

public class Medicine extends Product {
	
	private Date expireDate;
	private int medicineBoxNumber;
	private int medicnieBoxWeight;

	public Medicine(int serialNumber, int productNumber, String name, Manufacturer manufacturer,
			Size size, float weight, Date expireDate, int medicineNumber, int medicineBoxWeight) {
		super(serialNumber, productNumber, Category.NARCOTICS, name, manufacturer, size, weight);
		this.expireDate = expireDate;
		this.medicineBoxNumber = medicineNumber;
		this.medicnieBoxWeight = medicineBoxWeight;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getMedicineBoxNumber() {
		return medicineBoxNumber;
	}

	public void setMedicineBoxNumber(int medicineBoxNumber) {
		this.medicineBoxNumber = medicineBoxNumber;
	}

	public int getMedicnieBoxWeight() {
		return medicnieBoxWeight;
	}

	public void setMedicnieBoxWeight(int medicnieBoxWeight) {
		this.medicnieBoxWeight = medicnieBoxWeight;
	}

	@Override
	public String toString() {
		return "Medicine [expireDate=" + expireDate + ", medicineBoxNumber=" + medicineBoxNumber
				+ ", medicnieBoxWeight=" + medicnieBoxWeight + ", toString()=" + super.toString() + "]";
	}
	
	
}
