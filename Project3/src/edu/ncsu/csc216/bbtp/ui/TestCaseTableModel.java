package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;

/**
 * Contains the data displayed in the TestCaseListPane's JTable
 * 
 * @author Caitlyn
 *
 */
public class TestCaseTableModel implements Serializable {

	private static final long serialVersionUID = 5954551753060998701L;
	/** Array of the names of each column in the table */
	private String[] colNames;
	/** 2D array containing all the data in the table */
	private Object[][] data;

	/**
	 * Constructs a TestCaseTableModel using the information in the 2D array
	 * passed in
	 * 
	 * @param testCases
	 *            the 2D array with test case data
	 */
	public TestCaseTableModel(Object[][] testCases) {
		// TODO
	}

	/**
	 * Gets the number of rows in the table
	 * 
	 * @return number of rows
	 */
	public int getRowCount() {
		return -1;
	}

	/**
	 * Gets the number of columns in the table
	 * 
	 * @return number of columns
	 */
	public int getColumnCount() {
		return -1;
	}

	/**
	 * Gets the name of the column
	 * 
	 * @return name of the column
	 */
	public String getColumnName() {
		return "";
	}

	/**
	 * Returns the data being held at the row and column index given
	 * 
	 * @param row
	 *            row to get data from
	 * @param col
	 *            column to get data from
	 * @return data at position with row and column equal to given values
	 */
	public Object getValueAt(int row, int col) {
		return null;
	}

	/**
	 * Sets the data at the given row and column number to the specified object
	 * 
	 * @param obj
	 *            object to set data to
	 * @param row
	 *            row to consider
	 * @param col
	 *            column to consider
	 */
	public void setValueAt(Object obj, int row, int col) {
		// TODO
		if (colNames != null && data != null)
			getTestCaseRowData(3);
	}

	/**
	 * Returns all the data in the row specified, all data is for one test case
	 * 
	 * @param row
	 *            the row to get data for
	 * @return TestCaseData object containing the test case's info
	 */
	public TestCaseData getTestCaseRowData(int row) {
		return null;
	}

	/**
	 * Sets the data in the row specified to the data in the TestCaseData
	 * object, writes over current row data
	 * 
	 * @param row
	 *            the row to set the data for
	 * @param data
	 *            the TestCaseData object to get the data from
	 */
	public void setTaskRowData(int row, TestCaseData data) {
		// TODO
	}

}
