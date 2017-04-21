package edu.ncsu.csc216.bbtp.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of ArrayList
 * 
 * @author Caitlyn
 *
 */
public class ArrayListTest {

	private ArrayList al;

	/**
	 * Creates an array list to be used in testing
	 */
	@Before
	public void setUp() {
		al = new ArrayList(3);
	}

	/**
	 * Tests adding to the array list without a specified index
	 */
	@Test
	public void testAddObj() {
		try {
			assertFalse(al.add(null));
			fail();
		} catch (NullPointerException e) {
			assertEquals(0, al.size());
		}

		al.add("hey");
		assertEquals(1, al.size());
	}

	/**
	 * Tests adding to the array list at a specified index
	 */
	@Test
	public void testAddIntObj() {
		try {
			al.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(0, al.size());
		}

		try {
			al.add(-1, "hey");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		try {
			al.add(1, "hey");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		al.add(0, "hey");
		assertEquals(1, al.size());
		al.add("hi");
		al.add("hello");
		assertEquals(3, al.size());
		al.add("bye");
		assertEquals(4, al.size());
	}

	/**
	 * Tests contains() method
	 */
	@Test
	public void testContains() {
		al.add("hi");
		assertTrue(al.contains("hi"));
		assertFalse(al.contains("hey"));
	}

	/**
	 * Tests getting the index of an object
	 */
	@Test
	public void testIndexOf() {
		al.add(0, "hey");
		assertEquals(0, al.indexOf("hey"));
		assertEquals(-1, al.indexOf("hi"));
	}

	/**
	 * Tests getting an object at an index
	 */
	@Test
	public void testGet() {
		try {
			al.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		try {
			al.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		al.add("hi");
		assertEquals(0, al.indexOf("hi"));
	}

	/**
	 * Tests isEmpty() method
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(al.isEmpty());
		al.add("hi");
		assertFalse(al.isEmpty());
	}

	/**
	 * Tests remove method
	 */
	@Test
	public void testRemove() {
		try {
			al.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		try {
			al.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, al.size());
		}

		al.add("hi");
		al.add("hey");
		al.add("hello");

		assertEquals("hello", al.remove(2));
		assertEquals("hi", al.remove(0));
		assertEquals("hey", al.remove(0));
	}
}
