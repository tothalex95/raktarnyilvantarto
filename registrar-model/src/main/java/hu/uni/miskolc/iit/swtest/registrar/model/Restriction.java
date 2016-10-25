package hu.uni.miskolc.iit.swtest.registrar.model;

import java.util.EnumSet;

public enum Restriction {

	FLAMMABLE, FRAGILE, NAUGHTY, POISONOUS;

	private final long flag;

	private Restriction() {
		this.flag = 1 << this.ordinal();
	}

	public long getFlag() {
		return flag;
	}

	public static EnumSet<Restriction> getRestrictions(long flag) {
		EnumSet<Restriction> flags = EnumSet.noneOf(Restriction.class);
		for (Restriction restriction : Restriction.values()) {
			if ((restriction.flag & flag) == restriction.flag)
				flags.add(restriction);
		}
		return flags; 
	}

}
