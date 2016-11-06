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
	public void testSizeConstructorWithInvalidParameter() {
		new Size(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeConstructorWithInvalidHeight() {
		new Size(1, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeConstructorWithInvalidDepth() {
		new Size(1, 1, -1);
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
	public void testEqualsObjectWithSameSize() {
		Size s = new Size(1);
		assertEquals("(1,1,1)=(1,1,1)", true, s.equals(s));
	}
	
	@Test
	public void testEqualsObjectWithNull() {
		Size s = new Size(1);
		Size t = null;
		assertEquals("(1,1,1)=null", false, s.equals(t));
	}
	
	@Test
	public void testEqualsObjectWithDifferentObjectType() {
		Size s = new Size(1);
		Object o = new Object();
		assertEquals("(1,1,1)=object", false, s.equals(o));
	}
	
	@Test
	public void testEqualsObjectWithDifferentWidth() {
		Size s = new Size(1);
		Size t = new Size(2,1,1);
		assertEquals("(1,1,1)=(2,1,1)", false, s.equals(t));
	}
	
	@Test
	public void testEqualsObjectWithDifferentHeight() {
		Size s = new Size(1);
		Size t = new Size(1,2,1);
		assertEquals("(1,1,1)=(1,2,1)", false, s.equals(t));
	}
	
	@Test
	public void testEqualsObjectWithDifferentDepth() {
		Size s = new Size(1);
		Size t = new Size(1,1,2);
		assertEquals("(1,1,1)=(1,1,2)", false, s.equals(t));
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
	
	@Test
	public void testToString() {
		Size s = new Size(1);
		assertEquals("toString=...", true, s.toString().equals("Size [width=1, height=1, depth=1]"));
	}
	
	@Test
	public void testHashCode() {
		Size s = new Size(1);
		assertEquals("hashCode=30784", 30784, s.hashCode());
	}

}
