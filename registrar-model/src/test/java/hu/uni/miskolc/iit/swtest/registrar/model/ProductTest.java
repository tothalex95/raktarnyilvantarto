package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.Test;

public class ProductTest {
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithIllegalProductNumber(){
		new Product(0, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithNullCategory(){
		new Product(5, null, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithNullName(){
		new Product(3, Category.FOOD, null, Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithEmptyName(){
		new Product(3, Category.FOOD, "", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithNullManufacturer(){
		new Product(3, Category.FOOD, "vaj", null, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithNullSize(){
		new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, null, 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithIllegalWeight(){
		new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 0, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testProductConstructorWithIllegalRestriction(){
		new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, 16);
	}
	
	@Test
	public void testProductConstructorWithValidParametes(){
		new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
	}
	
	
	@Test
	public void testGetProductNumber(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(3, butter.getProductNumber());
	}
	@Test
	public void testGetCategory(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(Category.FOOD, butter.getCategory());
	}
	@Test
	public void testGetName(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals("vaj", butter.getName());
	}
	@Test
	public void testGetManufacturer(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(Manufacturer.UMBRELLACORP, butter.getManufacturer());
	}
	@Test
	public void testGetSize(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(new Size(3), butter.getSize());
	}
	@Test
	public void testGetWeight(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(true, Float.floatToIntBits(25) == Float.floatToIntBits(butter.getWeight()));
	}
	@Test
	public void testGetRestriction(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(0, butter.getRestriction());
	}
	
	@Test
	public void testEqual(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(true, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentProductNumber() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(2, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentCategory() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FURNITURE, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentName() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "sajt", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	public void testEqualsObjectWithNullName(){
		Product butter = new Product(3, Category.FOOD, null, Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "sajt", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentManufacturer() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentSize() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(4), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentWeight() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 26, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualsObjectWithDifferentRestriction() {
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.of(Restriction.POISONOUS)));
		//System.out.println(butter2.toString());
		
		assertEquals(false, butter.equals(butter2));
	}
	@Test
	public void testEqualObjectWithItSelf(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(true, butter.equals(butter));
	}
	@Test
	public void testEqualsObjectWithNull()
	{
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals(null));
	}
	@Test
	public void testEqualsObjectWithDiffernetObject(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(false, butter.equals("string"));
	}
	
	@Test
	public void testToString(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals("Product [productNumber=3, category=Food, name=vaj, manufacturer=UMBRELLACORP, size=Size [width=3, height=3, depth=3], weight=25.0, restriction=0]", butter.toString());
	}
	@Test
	public void testHashCode(){
		Product butter = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		Product butter2 = new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertTrue(butter.hashCode()==butter2.hashCode());
	}
	
	

	
	
	
	
	
	

}
