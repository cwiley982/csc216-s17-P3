package util;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.bbtp.util.ArrayList;

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
		al = new ArrayList(5);
	}

	@Test
	public void testAddObj() {
		assertFalse(al.add(null));
	}

	@Test
	public void testAddIntObj() {

	}

	@Test
	public void testContains() {

	}

	@Test
	public void testIndexOf() {

	}

	@Test
	public void testGet() {

	}

	@Test
	public void testIsEmpty() {

	}

	@Test
	public void testRemove() {

	}
}
