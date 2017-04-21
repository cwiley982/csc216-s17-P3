package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests TestingType class
 * 
 * @author Caitlyn
 *
 */
public class TestingTypeTest {

	TestingType tt;

	/**
	 * Creates a testing type to be used in testing
	 */
	@Before
	public void setUp() {
		tt = new TestingType("id", "name", "desc");
	}

	/**
	 * Tests creating a new testing type with an invalid id
	 */
	@Test
	public void testSetInvalidId() {
		TestingType tt2 = null;
		try {
			tt2 = new TestingType(null, "name", "desc");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tt2);
		}

		try {
			tt2 = new TestingType("", "name", "desc");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tt2);
		}
	}

	/**
	 * Tests equals method, should only compare ids
	 */
	@Test
	public void testEquals() {
		TestingType tt2 = new TestingType("id", "name2", "desc");
		TestingType tt3 = new TestingType("ID", "name2", "desc");
		assertTrue(tt.equals(tt2));
		assertFalse(tt.equals(tt3));
	}

	/**
	 * Tests compare to method, should sort by names
	 */
	@Test
	public void testCompareTo() {
		TestingType tt2 = new TestingType("id", "name2", "desc");
		assertEquals(1, tt.compareTo(tt2));
	}

	/**
	 * Tests toString method
	 */
	@Test
	public void testToString() {
		assertEquals("TestingType [name=name, description=desc, testingTypeID=id]", tt.toString());
	}

}
