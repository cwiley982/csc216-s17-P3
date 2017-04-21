package edu.ncsu.csc216.bbtp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests TestCaseList functionality
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class TestCaseListTest {

	private TestCaseList tcl;

	/**
	 * Creates a new test case list to be used for testing before each test is
	 * run
	 */
	@Before
	public void setUp() {
		tcl = new TestCaseList("New List", "ID");
	}

	/**
	 * Tests setting the test case list's name to an invalid name
	 */
	@Test
	public void testSetInvalidName() {
		try {
			tcl.setName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("New List", tcl.getName());
		}

		try {
			tcl.setName("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("New List", tcl.getName());
		}
	}

	/**
	 * Tests constructing a new test case list with an invalid id
	 */
	@Test
	public void setInvalidTestCaseListID() {
		TestCaseList tcl2 = null;
		try {
			tcl2 = new TestCaseList("New List", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tcl2);
		}

		try {
			tcl2 = new TestCaseList("New List", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tcl2);
		}
	}

	/**
	 * Tests adding test cases to a test case list, valid and duplicate
	 */
	@Test
	public void testAddTestCase() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		assertTrue(tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false));
		assertFalse(tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false));
		assertTrue(tcl.addTestCase("desc2", tt, (new Date(20170421)), "exp", false, lastTested, "act", false));
		assertFalse(tcl.addTestCase("desc2", tt, (new Date(20170421)), "exp", false, lastTested, "act", false));
	}

	/**
	 * Tests getting a test case at an index
	 */
	@Test
	public void testGetTestCaseAt() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals("ID-TC1", tcl.getTestCaseAt(0).getTestCaseID());
	}

	/**
	 * Tests isEmpty() method
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(tcl.isEmpty());
	}

	/**
	 * Tests getting the index of a test case by its id
	 */
	@Test
	public void testIndexOf() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals(0, tcl.indexOf("ID-TC1"));
	}

	/**
	 * Tests removing at an index
	 */
	@Test
	public void testRemoveInt() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals("ID-TC1", tcl.removeTestCaseAt(0).getTestCaseID());
	}

	/**
	 * Tests removing a test case by its id
	 */
	@Test
	public void testRemoveByID() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		tcl.removeTestCase("ID-TC1");
		assertTrue(tcl.isEmpty());
	}

	/**
	 * Tests getting the 2D array
	 */
	@Test
	public void testGet2DArray() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals("desc", tcl.get2DArray()[0][1]);
	}

}
