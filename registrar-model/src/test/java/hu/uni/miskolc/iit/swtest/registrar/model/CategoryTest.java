package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void testToStringFood() {
		assertEquals("toString()=Food", "Food", Category.FOOD.toString());
	}
	
	@Test
	public void testToStringNarcotics() {
		assertEquals("toString()=Narcotics", "Narcotics", Category.NARCOTICS.toString());
	}
	
	@Test
	public void testToStringFurniture() {
		assertEquals("toString()=Furniture", "Furniture", Category.FURNITURE.toString());
	}
	
	@Test
	public void testToStringIndustrialEquipment() {
		assertEquals("toString()=Industrial Equipment", "Industrial Equipment", Category.INDUSTRIAL_EQUIPMENT.toString());
	}
	
	@Test
	public void testValueOf() {
		assertEquals(Category.FOOD, Category.valueOf("FOOD"));
	}

}
