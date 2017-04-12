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

	/**
	 * creates a new BBTP Object and initializes state
	 */
	public BBTP() {
		// empty constructor
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
		// TODO
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
		// TODO
		getNextTestCaseListNum();
		incNextTestCaseListNum();
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
		return null;
	}

	/**
	 * returns the TestingTypeList
	 * 
	 * @return the TestingTypeList
	 */
	public TestingTypeList getTestingTypeList() {
		return null;
	}

	/**
	 * adds a test case list to the testCases array and returns the index of the
	 * added TestCaseList
	 * 
	 * @return the index of the added testCaseList
	 */
	public int addTestCaseList() {
		// TODO
		if (RESIZE < numLists)
			return 0;
		else
			return 1;
	}

	/**
	 * removes a testCaseList from the array at the given index
	 * 
	 * @param idx
	 *            the index to remove from
	 */
	public void removeTestCaseList(int idx) {
		// TODO
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
