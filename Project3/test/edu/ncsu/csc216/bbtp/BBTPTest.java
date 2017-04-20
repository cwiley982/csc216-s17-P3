package edu.ncsu.csc216.bbtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * Tests the functionality of the BBTP class
 * 
 * @author Caitlyn
 * @author Cameron
 *
 */
public class BBTPTest {

	BBTP bbtp;

	/**
	 * Creates a BBTP object to modify and test before each test case is run
	 */
	@Before
	public void setUp() {
		bbtp = new BBTP();
	}

	/**
	 * Tests the BBTP constructor
	 */
	@Test
	public void testBBTP() {
		assertFalse(bbtp.isChanged());
		assertEquals(1, bbtp.getNumTestCaseLists());
	}

	/**
	 * Tests setting the filename to both valid and invalid names
	 */
	@Test
	public void testSetFilename() {
		try {
			bbtp.setFilename("name of file");
			assertEquals("name of file", bbtp.getFilename());
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			bbtp.setFilename(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name of file", bbtp.getFilename());
		}
		
		try {
			bbtp.setFilename("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name of file", bbtp.getFilename());
		}
	}

	/**
	 * Tests setting bbtp's changed field to true
	 */
	@Test
	public void testSetChanged() {
		bbtp.setChanged(true);
		assertTrue(bbtp.isChanged());
	}
	/**
	 * Tests adding a test case list to the bbtp
	 */
	@Test
	public void testAddTestCaseList() {
		assertEquals(1, bbtp.getNumTestCaseLists());
		bbtp.addTestCaseList();
		assertEquals(2, bbtp.getNumTestCaseLists());
		bbtp.addTestCaseList();

		// test add above capacity, should resize and add
		bbtp.addTestCaseList();
		assertEquals(4, bbtp.getNumTestCaseLists());
	}

	/**
	 * Tests getting a test case list at valid and invalid indexes
	 */
	@Test
	public void testGetTestCaseList() {
		assertEquals(1, bbtp.getNumTestCaseLists());
		bbtp.addTestCaseList();
		bbtp.addTestCaseList();
		assertEquals(3, bbtp.getNumTestCaseLists());
		TestCaseList tcl = new TestCaseList("New List", "TCL2");
		assertEquals(tcl.getTestCaseListID(), bbtp.getTestCaseList(1).getTestCaseListID());

		try {
			bbtp.getTestCaseList(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, bbtp.getNumTestCaseLists());
		}

		try {
			bbtp.getTestCaseList(3);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, bbtp.getNumTestCaseLists());
		}
	}

	/**
	 * Tests getting the testing type list that bbtp holds
	 */
	@Test
	public void testGetTestingTypeList() {
		TestingTypeList ttl = new TestingTypeList();
		assertEquals(ttl.getName(), bbtp.getTestingTypeList().getName());
	}

	/**
	 * Tests removing a test case list at both valid and invalid indexes
	 */
	@Test
	public void testRemoveTestCaseList() {
		assertEquals(1, bbtp.getNumTestCaseLists());
		bbtp.addTestCaseList();
		bbtp.addTestCaseList();
		assertEquals(3, bbtp.getNumTestCaseLists());

		try {
			bbtp.removeTestCaseList(1);
			assertEquals(2, bbtp.getNumTestCaseLists());
		} catch (IllegalArgumentException e) {
			fail();
		}

		try {
			bbtp.removeTestCaseList(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, bbtp.getNumTestCaseLists());
		}

		try {
			bbtp.removeTestCaseList(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(2, bbtp.getNumTestCaseLists());
		}
	}

	/**
	 * Tests saving bbtp info to a file
	 */
	@Test
	public void testSaveDataFile() {
		assertFalse(bbtp.saveDataFile(""));
		assertFalse(bbtp.saveDataFile(null));
		assertTrue(bbtp.saveDataFile("test-files/testing_save_method"));
		assertTrue(bbtp.openDataFile("test-files/testing_save_method"));
	}
}
