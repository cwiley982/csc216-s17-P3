package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc216.bbtp.model.TestingType;

/**
 * Contains the data displayed in the TestCaseListPane's JTable
 * 
 * @author Caitlyn
 *
 */
public class TestCaseTableModel extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = 5954551753060998701L;
	/** Array of the names of each column in the table */
	private String[] colNames = { "ID", "Description", "Test Type", "Creation Date", "Last Tested Date", "Tested?",
			"Expected Results", "Actual Results", "Pass?" };
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
		if (testCases == null) {
			throw new IllegalArgumentException();
		}
		data = testCases;
	}

	/**
	 * Gets the number of rows in the table
	 * 
	 * @return number of rows
	 */
	public int getRowCount() {
		return data.length;
	}

	/**
	 * Gets the number of columns in the table
	 * 
	 * @return number of columns
	 */
	public int getColumnCount() {
		return colNames.length;
	}

	/**
	 * Gets the name of the column
	 * 
	 * @param index
	 *            the index to get the name of the column of
	 * @return name of the column
	 */
	public String getColumnName(int index) {
		if (index < 0 || index >= colNames.length) {
			throw new IndexOutOfBoundsException();
		}
		return colNames[index];
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
		if (row < 0 || row >= data.length || col < 0 || col > colNames.length) {
			throw new IndexOutOfBoundsException();
		}
		return data[row][col];
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
		if (obj == null) {
			throw new IllegalArgumentException();
		}
		if (row < 0 || row >= data.length || col < 0 || col > colNames.length) {
			throw new IndexOutOfBoundsException();
		}
		data[row][col] = obj;

	}

	/**
	 * Returns all the data in the row specified, all data is for one test case
	 * 
	 * @param row
	 *            the row to get data for
	 * @return TestCaseData object containing the test case's info
	 */
	public TestCaseData getTestCaseRowData(int row) {
		if (row < 0 || row > data.length) {
			throw new IndexOutOfBoundsException();
		}
		String id = (String) data[row][0];
		String desc = (String) data[row][1];
		TestingType testType = (TestingType) data[row][2];
		Date created = (Date) data[row][3];
		Date lastTested = (Date) data[row][4];
		boolean tested = (boolean) data[row][5];
		String exp = (String) data[row][6];
		String act = (String) data[row][7];
		boolean pass = (boolean) data[row][8];
		
		TestCaseData tcd = new TestCaseData(id, desc, testType, created, lastTested, tested, exp, act, pass);
		return tcd;
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
		if (row < 0 || row > this.data.length) {
			throw new IndexOutOfBoundsException();
		}
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data[row] = data.getDataArray();
	}

}
