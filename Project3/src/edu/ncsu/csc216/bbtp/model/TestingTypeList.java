package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;

import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.util.ArrayList;

/**
 * Holds a list of TestingTypes to be displayed
 * 
 * @author Caitlyn
 *
 */
public class TestingTypeList extends Observable implements Tabular, Serializable {

	private static final long serialVersionUID = 984509L;
	private String name = "Testing Types";
	private int nextTestingTypeNum;
	private ArrayList list;

	/**
	 * Constructs the ArrayList and sets nextTestingTypeNum to 1
	 */
	public TestingTypeList() {

	}

	/**
	 * Returns the TestingTypeList name
	 * 
	 * @return name of the list
	 */
	public String getName() {
		return "";
	}

	/**
	 * Adds a new testing type to the current list and gives it a unique id
	 * 
	 * @param name
	 *            the name of the testing type being added
	 * @param desc
	 *            a description of the type being added
	 * @return true if the TestingType is added to the list and false otherwise
	 */
	public boolean addTestingType(String name, String desc) {
		return false;
	}

	/**
	 * Returns the testing type object at the specified index
	 * 
	 * @param idx
	 *            the index that the user wants to get the testing type from
	 * @return the testing type at the specified index
	 */
	public TestingType getTestingTypeAt(int idx) {
		return null;
	}

	/**
	 * Finds the index of a specific testing type whose id matches the parameter
	 * 
	 * @param id
	 *            the id of the testing type
	 * @return the index of the testing type
	 */
	public int indexOf(String id) {
		return -1;
	}

	/**
	 * Finds the index of a specific testing type whose name matches the
	 * parameter
	 * 
	 * @param name
	 *            the name of the testing type
	 * @return the index of the testing type
	 */
	public int indexOfName(String name) {
		return -1;
	}

	/**
	 * Gets the size of the current list of testing types
	 * 
	 * @return size of list
	 */
	public int size() {
		return -1;
	}

	/**
	 * Tells whether the list is empty or not
	 * 
	 * @return true if list contains 0 elements, false otherwise
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Returns the TestingType removed from the list at the given index
	 * 
	 * @param idx
	 *            index to remove type from
	 * @return the testing type that was removed
	 */
	public TestingType removeTestingTypeAt(int idx) {
		return null;
	}

	/**
	 * Returns the testing type with a matching id if it exists in the list
	 * 
	 * @param id
	 *            id of the testing type to be removed
	 * @return true if testing type was removed, false if not (ie can't be
	 *         found)
	 */
	public boolean removeTestingType(String id) {
		return false;
	}

	private int getNextTestingTypeNum() {
		return -1;
	}

	private void incNextTestingTypeNum() {

	}

	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Observable oservable, Object obj) {

	}
}
