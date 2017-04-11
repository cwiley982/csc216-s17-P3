package edu.ncsu.csc216.bbtp;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

public class BBTP extends Observable implements Serializable, Observer {

	private static final long serialVersionUID = 34992L;
	private static final int RESIZE = 0;
	private int numLists;
	private String filename;
	private boolean changed;
	private int nextTestCaseListNum;

	public BBTP() {

	}

	public boolean isChanged() {
		return false;
	}

	public void setChanged(boolean tf) {

	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String s) {
		this.filename = s;
	}

	private int getNextTestCaseListNum() {
		return 0;
	}

	private void incNextTestCaseListNum() {

	}

	public int getNumTestCaseLists() {
		return 0;
	}

	public TestCaseList getTestCaseList(int i) {
		return null;
	}

	public TestingTypeList getTestingTypeList() {
		return null;
	}

	public int addTestCaseList() {
		return 0;
	}

	public void removeTestCaseList(int i) {

	}

	public boolean saveDataFile(String s) {
		return false;
	}

	public boolean openDataFile(String s) {
		return false;
	}

	public void update(Observable o, Object o1) {

	}
}
