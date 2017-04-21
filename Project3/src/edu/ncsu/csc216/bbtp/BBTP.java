package edu.ncsu.csc216.bbtp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;
import edu.ncsu.csc216.bbtp.util.ArrayList;

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
	private static final int RESIZE = 3;
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
		nextTestCaseListNum = 1;
		testCases = new TestCaseList[3];
		TestCaseList tcl = new TestCaseList("New List", ("TCL" + getNextTestCaseListNum()));
		numLists = 1;
		incNextTestCaseListNum();
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
		if (idx < 0 || idx >= getNumTestCaseLists())
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
		if (getNextTestCaseListNum() > testCases.length) {
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
			numLists++;
			return l;
		} else {
			for (int i = 0; i < testCases.length; i++) {
				if (testCases[i] == null) {
					TestCaseList added = new TestCaseList("New List", ("TCL" + getNextTestCaseListNum()));
					added.addObserver(this);
					notifyObservers(added);
					testCases[i] = added;
					incNextTestCaseListNum();
					numLists++;
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
		// do we need to change their IDs too so a number isn't skipped??
		if (idx < 0 || idx >= numLists) {
			throw new IndexOutOfBoundsException();
		}
		if (testCases[idx] != null) {
			testCases[idx].deleteObserver(this);
			for (int i = idx; i < numLists - 1; i++) {
				testCases[i] = testCases[i + 1];
			}
			testCases[numLists - 1] = null;
		}
		numLists--;
	}

	/**
	 * Saves the TestingTypeList and the array of TestCaseLists to the given
	 * file using object serialization.
	 * 
	 * @param fname
	 *            filename to save BBTP information to.
	 * @return true is saved successfully
	 */
	public boolean saveDataFile(String fname) {
		if (fname == null || fname.trim().equals("")) {
			System.err.println("Invalid filename" + fname);
			return false;
		} else {
			try {
				FileOutputStream fileOut = new FileOutputStream(fname);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				for (int i = 0; i < numLists; i++) {
					out.writeObject(testCases[i]);
				}
				out.writeObject(testingTypes);
				out.writeObject(filename);
				out.writeInt(nextTestCaseListNum);
				changed = false;
				out.close();
				fileOut.close();
				return true;
			} catch (IOException e) {
				System.err.println("An error occurred while saving file " + fname);
				e.printStackTrace(System.err);
				return false;
			}
		}
	}

	/**
	 * Opens a data file with the given name and creates the data structures
	 * from the serialized objects in the file.
	 * 
	 * @param fname
	 *            filename to create BBTP information from.
	 * @return true is opened successfully
	 */
	public boolean openDataFile(String fname) {
		if (changed) {
			saveDataFile(filename);
		}
		try {
			FileInputStream fileIn = new FileInputStream(fname);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList temp = new ArrayList();
			Object tl = in.readObject();
			while (tl instanceof TestCaseList) {
				TestCaseList l = (TestCaseList) tl;
				l.addObserver(this);
				temp.add(l);
				tl = in.readObject();
			}
			testCases = new TestCaseList[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				testCases[i] = (TestCaseList) temp.get(i);
			}
			numLists = temp.size();
			testingTypes = (TestingTypeList) tl;
			testingTypes.addObserver(this);
			filename = (String) in.readObject();
			nextTestCaseListNum = (int) in.readInt();
			for (int i = 0; i < numLists; i++) {
				TestCaseList list = testCases[i];
				for (int j = 0; j < list.size(); j++) {
					list.getTestCaseAt(j).addObserver(list);
				}
			}
			for (int i = 0; i < testingTypes.size(); i++) {
				testingTypes.getTestingTypeAt(i).addObserver(testingTypes);
			}
			changed = false;
			in.close();
			fileIn.close();
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while reading file " + fname);
			e.printStackTrace(System.err);
			return false;
		} catch (ClassNotFoundException c) {
			System.err.println("Error reconstructing BBTP from file " + fname);
			c.printStackTrace(System.err);
			return false;
		}
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
		setChanged(true);
		notifyObservers(arg);
		// if (o instanceof TestCaseList) {
		// // do something
		// notifyObservers(this);
		// } else if (o instanceof TestingTypeList) {
		// // do something
		// notifyObservers(this);
		// }
		// TODO
	}
}
