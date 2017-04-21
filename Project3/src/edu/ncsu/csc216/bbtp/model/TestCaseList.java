package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.LinkedList;

/**
 * Holds a lost of TestCases
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class TestCaseList extends Observable implements Tabular, Serializable, Observer {

	private static final long serialVersionUID = 98734509L;
	/** The name of the test case list */
	private String name;
	/** The next number to be used when adding a test case */
	private int nextTestCaseNum;
	/** The unique id for the current list, specified by the user */
	private String testCaseListID;
	private LinkedList list;

	/**
	 * Constructs a TestCaseList with a name for the list and an id for the list
	 * 
	 * @param name
	 *            the name of the list
	 * @param testCaseListID
	 *            the id for the list
	 */
	public TestCaseList(String name, String testCaseListID) {
		list = new LinkedList();
		nextTestCaseNum = 1;
		setName(name);
		setTestCaseListID(testCaseListID);
		setChanged();
		notifyObservers(this);
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
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException();
		this.name = name;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Gets the id of the test case list
	 * 
	 * @return the list's id
	 */
	public String getTestCaseListID() {
		return testCaseListID;
	}

	private void setTestCaseListID(String testCaseListID) {
		if (testCaseListID == null || testCaseListID.isEmpty())
			throw new IllegalArgumentException();
		this.testCaseListID = testCaseListID;
		setChanged();
		notifyObservers(this);
	}

	private int getNextTestCaseNum() {
		return nextTestCaseNum;
	}

	private void incNextTestCaseNum() {
		nextTestCaseNum++;
		setChanged();
		notifyObservers(this);
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
		TestCase tc = new TestCase((testCaseListID + "-TC" + getNextTestCaseNum()), desc, type, creation, exp, tested,
				lastTestDate, act, pass);

		if (list.size() == 0) {
			list.add(tc);
			tc.addObserver(this); // added this because it gave it as an
									// example,
									// i
			// don't know what it means
			incNextTestCaseNum();
			setChanged();
			notifyObservers(this);
			return true;
		} else {
			for (int i = 0; i < list.size(); i++) {

				// if the test case to add comes before the current one
				try {

					// if the test case to add comes before the current one
					if (((TestCase) list.get(i)).getLastTestedDateTime() != null) {
						int compare = tc.compareTo((TestCase) list.get(i));
						if (compare == 1) {
							list.add(i, tc);
							tc.addObserver(this);
							incNextTestCaseNum();
							setChanged();
							notifyObservers(this);
							return true;
						}
					}
				} catch (NullPointerException e) {
					// if last tested for new test is null
					list.add(i, tc);
					tc.addObserver(this);
					incNextTestCaseNum();
					setChanged();
					notifyObservers(this);
					return true;
				}
			}
			// if it gets through the entire list, new test case should be added
			// to back
			list.add(tc);
			tc.addObserver(this);
			incNextTestCaseNum();
			setChanged();
			notifyObservers(this);
			return true;
		}
	}

	/**
	 * Gets the test case at the given index
	 * 
	 * @param idx
	 *            index to get test case from
	 * @return the test case at the index given
	 */
	public TestCase getTestCaseAt(int idx) {
		return (TestCase) list.get(idx);
	}

	/**
	 * Gets the index of the test case whose id matches the one given
	 * 
	 * @param id
	 *            the id to check for
	 * @return the test case with matching id
	 */
	public int indexOf(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (((TestCase) list.get(i)).getTestCaseID().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return number of test cases in the list
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Tells whether the list is empty or not
	 * 
	 * @return true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Removes the test case at the given index
	 * 
	 * @param idx
	 *            the index to remove a test case from
	 * @return the test case removed
	 */
	public TestCase removeTestCaseAt(int idx) {
		TestCase tc = (TestCase) list.remove(idx);
		setChanged();
		notifyObservers(this);
		return tc;
	}

	/**
	 * Removes the test case whose id matches the one given
	 * 
	 * @param testCaseID
	 *            the id of the test case to remove
	 * @return true if there exists a test case with that id and it was removed
	 */
	public boolean removeTestCase(String testCaseID) {
		TestCase tc = null;
		for (int i = 0; i < nextTestCaseNum - 1; i++) {
			if (get2DArray()[i][0].equals(testCaseID)) {
				tc = (TestCase) list.remove(i);
				break;
			}
		}
		if (tc != null) {
			setChanged();
			notifyObservers(this);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object[][] get2DArray() {
		Object[][] obj = new Object[list.size()][9];
		for (int i = 0; i < list.size(); i++) {
			obj[i][0] = ((TestCase) list.get(i)).getTestCaseID();
			obj[i][1] = ((TestCase) list.get(i)).getDescription();
			obj[i][2] = ((TestCase) list.get(i)).getTestingType();
			obj[i][3] = ((TestCase) list.get(i)).getCreationDateTime();
			obj[i][4] = ((TestCase) list.get(i)).getLastTestedDateTime();
			obj[i][5] = ((TestCase) list.get(i)).tested();
			obj[i][6] = ((TestCase) list.get(i)).getExpectedResults();
			obj[i][7] = ((TestCase) list.get(i)).getActualResults();
			obj[i][8] = ((TestCase) list.get(i)).pass();
		}
		return obj;
	}

	/**
	 * Notifies the observers of a change to the list
	 * 
	 * @param o
	 *            the action being observed, triggers a notification
	 * @param obj
	 *            the objects to be notified of the change
	 */
	public void update(Observable o, Object obj) {
		// both parameters are test cases I think
		if (list.contains(o)) {
			// update list
			setChanged();
			notifyObservers(obj);
		}
	}
}
