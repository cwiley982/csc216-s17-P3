package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * Holds a lost of TestCases
 * 
 * @author Caitlyn
 *
 */
public class TestCaseList extends Observable implements Tabular, Serializable {

	private static final long serialVersionUID = 98734509L;
	/** The name of the test case list */
	private String name;
	/** The next number to be used when adding a test case */
	private int nextTestCaseNum;
	/** The unique id for the current list, specified by the user */
	private String testCaseListID;

	/**
	 * Constructs a TestCaseList with a name for the list and an id for the list
	 * 
	 * @param name
	 *            the name of the list
	 * @param testCaseListID
	 *            the id for the list
	 */
	public TestCaseList(String name, String testCaseListID) {
		// TODO
	}

	/**
	 * Gets the test list name
	 * 
	 * @return name of the current list
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the list
	 * 
	 * @param name
	 *            name of the list
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id of the test case list
	 * 
	 * @return the list's id
	 */
	public String getTestCaseListID() {
		// TODO
		setTestCaseListID();
		getNextTestCaseNum();
		incNextTestCaseNum();
		return testCaseListID;
	}

	private void setTestCaseListID() {

	}

	private int getNextTestCaseNum() {
		return nextTestCaseNum;
	}

	private void incNextTestCaseNum() {
		// TODO
	}

	/**
	 * Adds a test case to the test case list
	 * 
	 * @param desc
	 *            description of the test case
	 * @param type
	 *            type of testing the test case will do
	 * @param creation
	 *            when the test was created
	 * @param exp
	 *            expected results for the test case
	 * @param tested
	 *            if the test case has been tested
	 * @param lastTestDate
	 *            when the test case was last tested
	 * @param act
	 *            actual results from running the test
	 * @param pass
	 *            if the test has passed
	 * @return true if the test case is successfully created and added to the
	 *         list
	 */
	public boolean addTestCase(String desc, TestingType type, Date creation, String exp, boolean tested,
			Date lastTestDate, String act, boolean pass) {
		return false;
	}

	/**
	 * Gets the test case at the given index
	 * 
	 * @param idx
	 *            index to get test case from
	 * @return the test case at the index given
	 */
	public TestCase getTestCaseAt(int idx) {
		return null;
	}

	/**
	 * Gets the index of the test case whose id matches the one given
	 * 
	 * @param id
	 *            the id to check for
	 * @return the test case with matching id
	 */
	public int indexOf(String id) {
		return -1;
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return number of test cases in the list
	 */
	public int size() {
		return -1;
	}

	/**
	 * Tells whether the list is empty or not
	 * 
	 * @return true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Removes the test case at the given index
	 * 
	 * @param idx
	 *            the index to remove a test case from
	 * @return the test case removed
	 */
	public TestCase removeTestCaseAt(int idx) {
		return null;
	}

	/**
	 * Removes the test case whose id matches the one given
	 * 
	 * @param testCaseID
	 *            the id of the test case to remove
	 * @return true if there exists a test case with that id and it was removed
	 */
	public boolean removeTestCase(String testCaseID) {
		return false;
	}

	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Notifies the observers of a change to the list
	 * 
	 * @param observable
	 *            the action being observed, triggers a notification
	 * @param obj
	 *            the objects to be notified of the change
	 */
	public void update(Observable observable, Object obj) {
		// TODO
	}
}
