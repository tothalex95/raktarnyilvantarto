package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.ArrayList;
import java.util.Collection;

public enum Manufacturer {

	A, B, C;
	
	private Collection<Category> categories;
	
	private Manufacturer() {
		categories = new ArrayList<Category>();
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}
	
	
	
}
