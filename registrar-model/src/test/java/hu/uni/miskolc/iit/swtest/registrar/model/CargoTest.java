package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import org.junit.Test;

import hu.uni.miskolc.iit.swtest.registrar.model.Box.BoxSize;

public class CargoTest {
	//public Cargo(Collection<Box> boxes, Address source, Address destination)
	@Test(expected = NullPointerException.class)
	public void testCargoConstructorWithNullBoxes() {
		new Cargo(null, new Address("A", "B", "C", 3),  new Address("A", "B", "C", 3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCargoConstructorWithEmptyBoxes(){
		Collection<Box> boxes = new ArrayList<Box>();
		new Cargo(boxes,  new Address("A", "B", "C", 3),  new Address("A", "B", "C", 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCargoConstructorWithNullSource(){
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(1, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1,BoxSize.BIG));
		new Cargo(boxes,null, new Address("A", "B", "C", 3));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCargoConstructorWithNullDestination(){
		Address source = new Address("country", "city", "street", 2);
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(1, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1,BoxSize.BIG));
		new Cargo(boxes, source, null);
	}
	
	@Test
	public void testCargoConstructor()throws NullPointerException, IllegalArgumentException{
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(3, Category.FOOD, "vaj", Manufacturer.UMBRELLACORP, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.of(Restriction.POISONOUS))),3,BoxSize.BIG));
		Address source = new Address("country", "city", "street", 2);
		Address destination = new Address("country1", "city1", "street1", 21);
		new Cargo(boxes, source, destination);
	}
	
	@Test
	public void testGetBoxes(){
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(1, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1,BoxSize.BIG));
		Cargo a = new Cargo(boxes,new Address("A", "B", "C", 3), new Address("A", "B", "C", 3));
		assertEquals(boxes, a.getBoxes());
	}
	@Test
	public void testGetSource(){
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(1, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1,BoxSize.BIG));
		Cargo a = new Cargo(boxes,new Address("A", "B", "C", 3), new Address("A", "B", "C", 3));
		assertEquals(new Address("A", "B", "C", 3), a.getSource());
	}
	@Test
	public void testGetDestination(){
		Collection<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(new Product(1, Category.FOOD, "vaj", Manufacturer.APPLE, new Size(3), 25, Restriction.getFlagFromRestrictions(EnumSet.noneOf(Restriction.class))),1,BoxSize.BIG));
		Cargo a = new Cargo(boxes,new Address("A", "B", "C", 3), new Address("A", "B", "C", 3));
		assertEquals(new Address("A", "B", "C", 3), a.getDestination());
	}

}
