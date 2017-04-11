package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

public class TestCaseListPane implements Serializable, Observer {

	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths;
	private TestCaseTableModel tctm;

	public TestCaseListPane(TestCaseList list) {
		// TODO Auto-generated constructor stub
	}

	public TestCaseTableModel getTestCaseTableModel() {
		return null;
	}

	public JTable getTable() {
		return null;
	}

	private void initView() {

	}

	public void clearSelection() {

	}

	public void update(Observable observable, Object obj) {

	}

}
