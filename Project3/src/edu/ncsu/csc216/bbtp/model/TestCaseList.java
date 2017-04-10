package edu.ncsu.csc216.bbtp.model;

import java.util.Observable;

public class TestCaseList implements Tabular {
	private static final long serialVersionUID;
	private String name;
	private int nextTestCaseNum;
	private String testCaseListID;

	public TestCaseList(String arg1, String arg2) {

	}

	public String getName() {
		return "";
	}

	public void setName(String name) {

	}

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

	public boolean addTestCase(String arg1, TestingType type, Date creationDate, String arg2, boolean arg3,
			Date testedDate, String arg4, boolean arg5) {
		return false;
	}

	public TestCase getTestCaseAt(int idx) {

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
