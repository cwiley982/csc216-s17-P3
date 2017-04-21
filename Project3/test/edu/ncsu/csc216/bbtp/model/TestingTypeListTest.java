package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the TestingTypeList class
 * 
 * @author Caitlyn
 *
 */
public class TestingTypeListTest {

	TestingTypeList ttl;

	/**
	 * Sets up a testing type list to be used in testing
	 */
	@Before
	public void setUp() {
		ttl = new TestingTypeList();
	}

	/**
	 * Tests adding a testing type with valid and invalid parameters
	 */
	@Test
	public void testAddTestingType() {
		assertFalse(ttl.addTestingType("", "desc"));
		assertFalse(ttl.addTestingType(null, "desc"));

		assertTrue(ttl.addTestingType("name", "desc"));
		assertEquals(1, ttl.size());
	}

	/**
	 * Tests getting the testing type at a certain index
	 */
	@Test
	public void testGetTestingTypeAt() {
		ttl.addTestingType("name", "desc");
		assertEquals(1, ttl.size());
		assertEquals("TT1", ttl.getTestingTypeAt(0).getTestingTypeID());
	}

	/**
	 * Tests getting the index of a testing type by its name and its id
	 */
	@Test
	public void testIndexOf() {
		ttl.addTestingType("name", "desc");
		assertEquals(1, ttl.size());
		assertEquals(0, ttl.indexOf("TT1"));
		assertEquals(0, ttl.indexOfName("name"));
		assertEquals(-1, ttl.indexOf("TT0"));
		assertEquals(-1, ttl.indexOfName("names"));
	}

	/**
	 * Tests telling whether the list is empty or not
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(ttl.isEmpty());
		ttl.addTestingType("name", "desc");
		assertFalse(ttl.isEmpty());
	}

	/**
	 * Tests removing a testing type at an index
	 */
	@Test
	public void testRemoveAt() {
		ttl.addTestingType("name", "desc");
		ttl.addTestingType("name2", "desc2");
		ttl.addTestingType("name3", "desc3");
		assertEquals("desc2", ttl.removeTestingTypeAt(1).getDescription());
	}

	/**
	 * Tests removing a testing type by its id
	 */
	@Test
	public void testRemove() {
		ttl.addTestingType("name", "desc");
		assertTrue(ttl.removeTestingType("TT1"));
		assertFalse(ttl.removeTestingType("TT0"));
	}

	/**
	 * Tests getting 2D array
	 */
	@Test
	public void testGet2DArray() {
		ttl.addTestingType("name", "desc");
		ttl.addTestingType("name2", "desc");
		assertEquals("name2", ttl.get2DArray()[1][1]);
	}

	// I commented this out because it was causing a PMD error that stopped TS
	// cases from running
	/*
	 * @Test public void testUpdate() { ttl.addTestingType("name", "desc");
	 * ttl.addTestingType("name2", "desc"); TestingType tt = new
	 * TestingType("id3", "name3", "desc3");
	 * 
	 * // TODO figure out what's what so I can test correctly
	 * 
	 * ttl.update(tt, tt); // assertEquals(3, ttl.get2DArray().length); // //
	 * tt.setName("new name"); // ttl.update(tt, tt); //
	 * assertEquals("new name", ttl.get2DArray()[2][1]); }
	 */

}
