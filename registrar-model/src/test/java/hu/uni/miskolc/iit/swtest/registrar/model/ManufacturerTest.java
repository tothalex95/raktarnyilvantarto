package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ManufacturerTest {

	@Test
	public void testGetNameApple() {
		assertEquals("APPLE.name=Apple", "Apple", Manufacturer.APPLE.getName());
	}
	
	@Test
	public void testGetNameBrazzers() {
		assertEquals("BRAZZERS.name=Brazzers", "Brazzers", Manufacturer.BRAZZERS.getName());
	}
	
	@Test
	public void testGetNameUmbrellaCorp() {
		assertEquals("UMBRELLACORP.name=umbrellaCorp", "umbrellaCorp", Manufacturer.UMBRELLACORP.getName());
	}
	
	@Test
	public void testGetCategoriesApple() {
		assertEquals("APPLE.categories=new ...", new ArrayList<Category>(), Manufacturer.APPLE.getCategories());
	}
	
	@Test
	public void testGetCategoriesBrazzers() {
		assertEquals("BRAZZERS.categories=new ...", new ArrayList<Category>(), Manufacturer.BRAZZERS.getCategories());
	}
	
	@Test
	public void testGetCategoriesUmbrellaCorp() {
		assertEquals("UMBRELLACORP.categories=new ...", new ArrayList<Category>(), Manufacturer.UMBRELLACORP.getCategories());
	}

}
