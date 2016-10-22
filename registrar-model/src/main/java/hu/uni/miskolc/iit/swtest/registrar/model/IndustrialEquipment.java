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
	 */
	public IndustrialEquipment(int serialNumber, int productNumber, Category category, String name,
			Manufacturer manufacturer, Size size, float weight) {
		super(serialNumber, productNumber, category, name, manufacturer, size, weight);
		// TODO Auto-generated constructor stub
	}

}
