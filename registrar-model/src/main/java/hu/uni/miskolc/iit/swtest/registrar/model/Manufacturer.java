package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.ArrayList;
import java.util.Collection;

public enum Manufacturer {

	A("A"), B("B"), C("C");
	
	private final String name;
	private final Collection<Category> categories;
	
	private Manufacturer(String name) {
		this.name = name;
		categories = new ArrayList<Category>();
	}

	public String getName() {
		return name;
	}

	public Collection<Category> getCategories() {
		return categories;
	}
	
}
