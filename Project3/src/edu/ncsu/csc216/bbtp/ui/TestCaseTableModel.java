package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;

public class TestCaseTableModel implements Serializable {

	private static final long serialVersionUID = 5954551753060998701L;
	/** Array of the names of each column in the table */
	private String[] colNames;
	/** 2D array containing all the data in the table */
	private Object[][] data;

	public TestCaseTableModel(Object[][] testCases) {

	}

	public int getRowCount() {
		return -1;
	}

	public int getColumnCount() {
		return -1;
	}

	public String getColumnName() {
		return "";
	}

	public Object getValueAt(int row, int col) {
		return null;
	}

	public void setValueAt(Object obj, int row, int col) {

	}

	public TestCaseData getTestCaseRowData(int row) {
		return null;
	}

	public void setTaskRowData(int row, TestCaseData data) {

	}

}
