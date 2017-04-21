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
 * Tests functionality of Test Case
 * 
 * @author Caitlyn
 *
 */
public class TestCaseTest {

	TestCase tc;

	/**
	 * Sets up a TestCase to be used in tests
	 */
	@Before
	public void setUp() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		tc = new TestCase("id", "desc", tt, created, "exp", false, lastTested, "act", false);
	}

	/**
	 * Tests setting the description with invalid parameters
	 */
	@Test
	public void testSetDescription() {
		try {
			tc.setDescription(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("desc", tc.getDescription());
		}

		try {
			tc.setDescription("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("desc", tc.getDescription());
		}
	}

	/**
	 * Tests setting invalid exp results
	 */
	@Test
	public void testSetExpectedResults() {
		try {
			tc.setExpectedResults(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("exp", tc.getExpectedResults());
		}

		try {
			tc.setExpectedResults("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("exp", tc.getExpectedResults());
		}
	}

	/**
	 * Tests setting invalid act results
	 */
	@Test
	public void testSetActualResults() {
		try {
			tc.setActualResults(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("act", tc.getActualResults());
		}

		try {
			tc.setActualResults("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("act", tc.getActualResults());
		}
	}

	/**
	 * Tests setting creation date time to null
	 */
	@Test
	public void testSetCreationDateTime() {
		try {
			tc.setCreationDateTime(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals((new Date(20170420)), tc.getCreationDateTime());
		}
	}

	/**
	 * Tests setting last tested date time to null
	 */
	@Test
	public void testSetLastTestedDateTime() {
		try {
			tc.setLastTestedDateTime(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals((new Date(20170420)), tc.getLastTestedDateTime());
		}
	}

	/**
	 * Tests setting testing type to null
	 */
	@Test
	public void testSetTestingType() {
		try {
			tc.setTestingType(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals((new TestingType("id", "type1", "desc")), tc.getTestingType());
		}
	}

	/**
	 * Tests setting id to invalid values
	 */
	@Test
	public void testSetTestCaseID() {
		TestCase tc2 = null;
		try {
			TestingType tt = new TestingType("id", "type1", "desc");
			Date created = new Date(20170420);
			Date lastTested = new Date(20170420);
			tc2 = new TestCase("", "desc", tt, created, "exp", false, lastTested, "act", false);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tc2);
		}

		try {
			TestingType tt = new TestingType("id", "type1", "desc");
			Date created = new Date(20170420);
			Date lastTested = new Date(20170420);
			tc2 = new TestCase(null, "desc", tt, created, "exp", false, lastTested, "act", false);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(tc2);
		}
	}

	@Test
	public void testEquals() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		TestCase tc2 = new TestCase("id2", "desc", tt, created, "exp", false, lastTested, "act", false);
		TestCase tc3 = new TestCase("id", "desc3", tt, created, "exp", false, lastTested, "act", false);
		TestCase tc4 = new TestCase("id", "desc", (new TestingType("id2", "type1", "desc")), created, "exp", false, lastTested, "act", false);
		TestCase tc5 = new TestCase("id", "desc", tt, (new Date(20170421)), "exp", false, lastTested, "act", false);
		TestCase tc6 = new TestCase("id", "desc", tt, created, "exp6", false, lastTested, "act", false);
		TestCase tc7 = new TestCase("id", "desc", tt, created, "exp", true, lastTested, "act", false);
		TestCase tc8 = new TestCase("id", "desc", tt, created, "exp", false, (new Date(20170421)), "act", false);
		TestCase tc9 = new TestCase("id", "desc", tt, created, "exp", false, lastTested, "act9", false);
		TestCase tc10 = new TestCase("id", "desc", tt, created, "exp", false, lastTested, "act", true);
		assertFalse(tc.equals(null));
		assertTrue(tc.equals(tc));
		assertFalse(tc.equals(tc2));
		assertFalse(tc.equals(tc3));
		assertFalse(tc.equals(tc4));
		assertFalse(tc.equals(tc5));
		assertFalse(tc.equals(tc6));
		assertFalse(tc.equals(tc7));
		assertFalse(tc.equals(tc8));
		assertFalse(tc.equals(tc9));
		assertFalse(tc.equals(tc10));
	}

	@Test
	public void testHashCode() {
		TestingType tt = new TestingType("id", "type1", "desc");
		Date created = new Date(20170420);
		Date lastTested = new Date(20170420);
		TestCase tc2 = new TestCase("id", "desc", tt, created, "exp", false, lastTested, "act", false);
		assertEquals(tc.hashCode(), tc2.hashCode());
	}
}
