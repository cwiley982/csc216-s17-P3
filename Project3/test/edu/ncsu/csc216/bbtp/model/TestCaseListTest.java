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
	}

	@Test
	public void testGetTestCaseAt() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		// TestCase tc = new TestCase("New List-TC1", "desc", tt, created,
		// "exp", false, lastTested, "act", false);
		assertEquals("New List-TC1", tcl.getTestCaseAt(0).getTestCaseID());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tcl.isEmpty());
	}

	@Test
	public void testRemoveInt() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals("New List-TC1", tcl.removeTestCaseAt(0));
	}

	@Test
	public void testRemoveByID() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		tcl.removeTestCase("New List-TC1");
		assertTrue(tcl.isEmpty());
	}

	@Test
	public void testGet2DArray() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tcl.addTestCase("desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals("desc", tcl.get2DArray()[0][2]);
	}

}
