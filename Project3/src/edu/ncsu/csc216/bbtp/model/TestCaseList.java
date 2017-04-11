package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

import edu.ncsu.csc216.bbtp.model.TestingType;
import junit.framework.TestCase;

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

	}

	/**
	 * Gets the test list name
	 * 
	 * @return name of the current list
	 */
	public String getName() {
		return "";
	}

	/**
	 * Sets the name of the list
	 * 
	 * @param name
	 *            name of the list
	 */
	public void setName(String name) {

	}

	/**
	 * Gets the id of the test case list
	 * 
	 * @return the list's id
	 */
	public String getTestCaseListID() {
		return "";
	}

	private void setTestCaseListID() {

	}

	private int getNextTestCaseNum() {
		return -1;
	}

	private void incNextTestCaseNum() {

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

	public TestCase getTestCaseAt(int idx) {
		return null;
	}

	public int indexOf(String arg) {
		return -1;
	}

	public int size() {
		return -1;
	}

	public boolean isEmpty() {
		return false;
	}

	public TestCase removeTestCaseAt(int idx) {
		return null;
	}

	public boolean removeTestCase(String arg) {
		return false;
	}

	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Observable observable, Object obj) {

	}
}
