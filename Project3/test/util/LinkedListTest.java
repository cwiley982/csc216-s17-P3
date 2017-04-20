package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.bbtp.util.LinkedList;

public class LinkedListTest {

	LinkedList ll = new LinkedList();

	@Before
    public void setup() {
		ll = new LinkedList();
        ll.add("hi0");
        ll.add("hi1");
        ll.add("hi2");
        ll.add("hi3");
        ll.add("hi4");
        ll.add("hi5");
        ll.add("hi6");
        ll.add("hi7");
        ll.add("hi8");
        ll.add("hi9");
    }

    /**
     * Tests adding at the beginning, middle and end of the array
     */
    @Test
    public void testAdd() {
        ll.add(10, "hi");
        assertEquals(11, ll.size());
        ll.add(0, "hello");
        assertEquals(12, ll.size());
        assertEquals("hello", ll.get(0));
        ll.add(4, "hola");
        assertEquals(13, ll.size());
        assertEquals("hola", ll.get(4));

        try {
			ll.add(4, new String("hola"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(13, ll.size());
        }

        try {
            ll.add(14, "bienvenidos");
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(13, ll.size());
        }

        try {
            ll.add(4, null);
            fail();
        } catch (NullPointerException e) {
            assertEquals(13, ll.size());
        }

    }

    /**
     * Tests getting an element from the array
     */
    @Test
    public void testGet() {
        assertEquals("hi5", ll.get(5));
        try {
            ll.get(24);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(10, ll.size());
        }

        try {
            ll.get(12);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(10, ll.size());
        }
    }

    /**
     * tests removing at the beginning, middle, and end of an array
     */
    @Test
    public void testRemove() {
        try {
            ll.remove(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(10, ll.size());
        }

        ll.remove(9);
        assertEquals(9, ll.size());

		ll = new LinkedList();
        ll.add("a");
        ll.add("b");
        ll.remove(0);
        assertEquals("b", ll.get(0));
    }

}
