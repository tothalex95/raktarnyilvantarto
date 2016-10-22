package hu.uni.miskolc.iit.swtest.registrar.model;

public enum Category {

	FOOD("Food"), NARCOTICS("Narcotics"), FURNITURE("Furniture"), INDUSTRIAL_EQUIPMENT("Industrial Equipment");
	
	private final String name;
	
	private Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
