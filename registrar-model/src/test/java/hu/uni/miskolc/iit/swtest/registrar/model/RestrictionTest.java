package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.Test;

public class RestrictionTest {

	@Test
	public void testGetFlagFlammable() {
		assertEquals("FLAMMABLE=0001", 0b0001, Restriction.FLAMMABLE.getFlag());
	}
	
	@Test
	public void testGetFlagFragile() {
		assertEquals("FRAGILE=0010", 0b0010, Restriction.FRAGILE.getFlag());
	}
	
	@Test
	public void testGetFlagNaughty() {
		assertEquals("NAUGHTY=0100", 0b0100, Restriction.NAUGHTY.getFlag());
	}
	
	@Test
	public void testGetFlagPoisonous() {
		assertEquals("POISONOUS=1000", 0b1000, Restriction.POISONOUS.getFlag());
	}

	@Test
	public void testGetRestrictionsFromFlag() {
		assertEquals("", EnumSet.of(Restriction.POISONOUS, Restriction.FLAMMABLE), Restriction.getRestrictionsFromFlag(0b1001));
	}

	@Test
	public void testGetFlagFromRestrictions() {
		assertEquals("", 0b1001, Restriction.getFlagFromRestrictions(EnumSet.of(Restriction.POISONOUS, Restriction.FLAMMABLE)));
	}
	
	@Test
	public void testToString() {
		assertEquals("NAUGHTY.toString=NAUGHTY", true, Restriction.NAUGHTY.toString().equals("NAUGHTY"));
	}
	
	@Test
	public void testValueOf() {
		assertEquals("", Restriction.FLAMMABLE, Restriction.valueOf("FLAMMABLE"));
	}

}
