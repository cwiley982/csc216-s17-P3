package edu.ncsu.csc216.bbtp;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * The controller class, takes information from the other classes and sends it
 * to the GUI
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class BBTP extends Observable implements Serializable, Observer {

	private static final long serialVersionUID = 34992L;
	private static final int RESIZE = 0;
	private int numLists;
	private String filename;
	private boolean changed;
	private int nextTestCaseListNum;
	private TestCaseList[] testCases;
	private TestingTypeList testingTypes;

	/**
	 * creates a new BBTP Object and initializes state
	 */
	public BBTP() {
		testCases = new TestCaseList[3];
		TestCaseList tcl = new TestCaseList("New List", "abc");
		tcl.addObserver(this); // look under the Observer Pattern heading in the
								// instructions,
								// it explains that this is how to do that, but
								// I don't know what
								// it means.
		testCases[0] = tcl;

		testingTypes = new TestingTypeList();
		testingTypes.addObserver(this);
		changed = false;
	}

	/**
	 * returns the value stored in changed
	 * 
	 * @return the value stored in changed
	 */
	public boolean isChanged() {
		return changed;
	}

	/**
	 * sets the changed field
	 * 
	 * @param tf
	 *            boolean to set
	 */
	public void setChanged(boolean tf) {
		this.changed = tf;
	}

	/**
	 * returns the filename
	 * 
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * sets the filename to the given parameter
	 * 
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		if (filename == null || filename.isEmpty())
			throw new IllegalArgumentException();
		this.filename = filename;
	}

	/**
	 * returns nextTestCaseListNum
	 * 
	 * @return nextTestCaseListNum
	 */
	private int getNextTestCaseListNum() {
		return nextTestCaseListNum;
	}

	/**
	 * increments the nextTestCaseListNum variable
	 */
	private void incNextTestCaseListNum() {
		nextTestCaseListNum++;
	}

	/**
	 * returns the number of testCaseLists
	 * 
	 * @return the number of testCaseLists
	 */
	public int getNumTestCaseLists() {
		return numLists;
	}

	/**
	 * returns the testCaseList at the given index
	 * 
	 * @param idx
	 *            the index to get
	 * @return the testCaseList at the given index
	 */
	public TestCaseList getTestCaseList(int idx) {
		if (idx < 0 || idx >= testCases.length)
			throw new IndexOutOfBoundsException();
		return testCases[idx];
	}

	/**
	 * returns the TestingTypeList
	 * 
	 * @return the TestingTypeList
	 */
	public TestingTypeList getTestingTypeList() {
		return testingTypes;
	}

	/**
	 * adds a test case list to the testCases array and returns the index of the
	 * added TestCaseList
	 * 
	 * @return the index of the added testCaseList
	 */
	public int addTestCaseList() {
		if (getNextTestCaseListNum() == testCases.length) {
			TestCaseList[] temp = new TestCaseList[testCases.length * RESIZE];
			for (int i = 0; i < testCases.length; i++) {
				temp[i] = testCases[i];
			}
			TestCaseList added = new TestCaseList("New List", ("TCL" + getNextTestCaseListNum()));
			added.addObserver(this);
			notifyObservers(added);
			temp[testCases.length] = added;
			int l = testCases.length;
			testCases = temp;
			incNextTestCaseListNum();
			return l;
		} else {
			for (int i = 0; i < testCases.length - 1; i++) {
				if (testCases[i] == null) {
					TestCaseList added = new TestCaseList("New List", ("TCL" + getNextTestCaseListNum()));
					added.addObserver(this);
					notifyObservers(added);
					testCases[i] = added;
					incNextTestCaseListNum();
					return i;
				}
			}
			return -1;
		}
	}

	/**
	 * removes a testCaseList from the array at the given index
	 * 
	 * @param idx
	 *            the index to remove from
	 */
	public void removeTestCaseList(int idx) {
		if (idx < 0 || idx >= testCases.length) {
			throw new IndexOutOfBoundsException();
		}
		if (testCases[idx] != null) {
			testCases[idx].deleteObserver(this);
			testCases[idx] = null;
			for (int i = idx; i < testCases.length; i++) {
				testCases[i] = testCases[i + 1];
				if (testCases[i + 1] == null) { // I think this will prevent the
												// last two things in the list
												// from being the same after
												// removing
					testCases[i] = null;
				}
			}
		}
	}

	/**
	 * saves the data to a file
	 * 
	 * @param filename
	 *            the file to save to
	 * @return true or false
	 */
	public boolean saveDataFile(String filename) {
		return false;
	}

	/**
	 * opens data from a file
	 * 
	 * @param filename
	 *            the file to pull data from
	 * @return true or false
	 */
	public boolean openDataFile(String filename) {
		return false;
	}

	/**
	 * automatically called if a TestCaseList or TestingTypeList is changed
	 * 
	 * @param o
	 *            Observable object
	 * @param arg
	 *            changed object
	 */
	public void update(Observable o, Object arg) {
		// TODO
	}
}
