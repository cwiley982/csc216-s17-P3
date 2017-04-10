package edu.ncsu.csc216.bbtp.ui;

public class TestCaseTableModel {

	private static final long serialVersionUID;
	private String[] colNames;
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
