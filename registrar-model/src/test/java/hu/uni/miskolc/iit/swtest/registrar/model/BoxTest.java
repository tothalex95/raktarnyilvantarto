package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Box.BoxSize;

public class BoxTest {

	@Test
	public void testBoxWithValidValues() {
		new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.BIG);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBoxWithTooSmallBox() {
		new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.MEDIUM);
	}

	@Test
	public void testGetWeight() {
		Box box = new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.BIG);
		assertEquals(true, Float.floatToIntBits(50) == Float.floatToIntBits(box.getWeight()));
	}

	@Test
	public void testGetProduct() {
		Box box = new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.BIG);
		Product product = new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class)));
		assertEquals(product, box.getProduct());
	}

	@Test
	public void testGetCount() {
		Box box = new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.BIG);
		assertEquals(true, Float.floatToIntBits(5) == Float.floatToIntBits(box.getCount()));
	}

	@Test
	public void testGetBoxSize() {
		Box box = new Box(1, new Product(1, Category.FOOD, "Mittomén", Manufacturer.APPLE, new Size(10), 10, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))), 5, BoxSize.BIG);
		assertEquals(true, BoxSize.BIG == box.getBoxSize());
	}

}
