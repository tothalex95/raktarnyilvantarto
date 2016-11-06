package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class PositionsTest {

	@Test
	public void testPositionsConstructor() {
		new Positions();
	}

	@Test
	public void testAddWithDifferentLocations() {
		Positions p = new Positions();
		p.add(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()), "t1");
		p.add(new Product(2, Category.FURNITURE, "fd", Manufacturer.BRAZZERS, new Size(10, 20, 5), 100,
				(int) Restriction.FLAMMABLE.getFlag()), "t2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddWithSameLocation() {
		Positions p = new Positions();
		p.add(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()), "t1");
		p.add(new Product(2, Category.FURNITURE, "fd", Manufacturer.BRAZZERS, new Size(10, 20, 5), 100,
				(int) Restriction.FLAMMABLE.getFlag()), "t1");
	}

	@Test
	public void testGetUsedPositions() {
		Positions p = new Positions();
		p.add(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()), "t1");
		p.add(new Product(2, Category.FURNITURE, "fd", Manufacturer.BRAZZERS, new Size(10, 20, 5), 100,
				(int) Restriction.FLAMMABLE.getFlag()), "t2");
		Collection<String> locs = new HashSet<>();
		locs.add("t1");
		locs.add("t2");
		assertEquals("p.used=locs", true, p.getUsedPositions().containsAll(locs));
	}

	@Test
	public void testGetPosition() {
		Positions p = new Positions();
		p.add(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()), "t1");
		p.add(new Product(2, Category.FURNITURE, "fd", Manufacturer.BRAZZERS, new Size(10, 20, 5), 100,
				(int) Restriction.FLAMMABLE.getFlag()), "t2");
		assertEquals("", "t1", p.getPosition(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag())));
	}

	@Test
	public void testRemove() {
		Positions p = new Positions();
		p.add(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()), "t1");
		p.remove(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveWithEmptyMap() {
		Positions p = new Positions();
		p.remove(new Product(1, Category.FOOD, "xy", Manufacturer.APPLE, new Size(1), 5,
				(int) Restriction.POISONOUS.getFlag()));
	}

}
