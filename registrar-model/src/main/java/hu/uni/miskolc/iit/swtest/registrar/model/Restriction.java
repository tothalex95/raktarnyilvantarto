package hu.uni.miskolc.iit.swtest.registrar.model;

public class Restriction {
	
	private static final int FLAMMABLE = 0b0001;
	private static final int FRAGILE = 0b0010;
	private static final int POISONOUS = 0b0100;
	private static final int NAUGHTY = 0b1000;
	
	private int restr = 0b0000;
	
	public Restriction(boolean flammable, boolean fragile, boolean poisonous, boolean naughty) {
		super();
		if (flammable) restr |= (1 << 3);
		if (fragile) restr |= (1 << 2);
		if (poisonous) restr |= (1 << 1);
		if (naughty) restr |= (1 << 0);
	}
	
	public boolean isFlammable() {
		return (restr & FLAMMABLE) == FLAMMABLE;
	}
	
	public boolean isFragile() {
		return (restr & FRAGILE) == FRAGILE;
	}
	
	public boolean isPoisonous() {
		return (restr & POISONOUS) == POISONOUS;
	}
	
	public boolean isNaughty() {
		return (restr & NAUGHTY) == NAUGHTY;
	}

}
