package hu.uni.miskolc.iit.swtest.registrar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SizeTest {

	@Test
	public void testSizeIntIntInt() {
		new Size(1,1,1);
	}

	@Test
	public void testSizeInt() {
		new Size(1);
	}

	@Test
	public void testSizeSizeInt() {
		new Size(new Size(1), 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeConstructorWithInvalidParameters() {
		new Size(-1);
	}

	@Test
	public void testGetHeight() {
		Size s = new Size(1);
		assertEquals("height=1", 1, s.getHeight());
	}

	@Test
	public void testGetDepth() {
		Size s = new Size(1);
		assertEquals("depth=1", 1, s.getDepth());
	}

	@Test
	public void testGetWidth() {
		Size s = new Size(1);
		assertEquals("width=1", 1, s.getWidth());
	}

	@Test
	public void testEqualsObject() {
		Size s = new Size(1);
		Size t = new Size(1);
		assertEquals("(1,1,1)=(1,1,1)", true, s.equals(t));
	}
	
	@Test
	public void testEqualsObjectWithDifferentSizes() {
		Size s = new Size(1);
		Size t = new Size(2);
		assertEquals("(1,1,1)=(2,2,2)", false, s.equals(t));
	}

	@Test
	public void testCompareTo() {
		Size s = new Size(1);
		Size t = new Size(1);
		assertEquals("", 0, s.compareTo(t));
	}
	
	@Test
	public void testCompareToWithBiggerParamater() {
		Size s = new Size(1);
		Size t = new Size(2);
		assertEquals("", -1, s.compareTo(t));
	}
	
	@Test
	public void testCompareToWithSmallerParameter() {
		Size s = new Size(3);
		Size t = new Size(2);
		assertEquals("", 1, s.compareTo(t));
	}

}
