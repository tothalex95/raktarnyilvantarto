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
	 * @param dangerLevel
	 */


	private int dangerLevel;
	
	public IndustrialEquipment(int serialNumber, int productNumber, Category category, String name,
			Manufacturer manufacturer, Size size, float weight, int dangerLevel) {
		super(serialNumber, productNumber, category, name, manufacturer, size, weight);
		this.dangerLevel=dangerLevel;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	@Override
	public String toString() {
		return "IndustrialEquipment [dangerLevel=" + dangerLevel + ", toString()=" + super.toString() + "]";
	}
	
	
}
