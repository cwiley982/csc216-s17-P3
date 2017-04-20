package edu.ncsu.csc216.bbtp.ui;

import java.awt.Color;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ncsu.csc216.bbtp.model.TestCaseList;

/**
 * Holds a list of test cases and puts them into a table to be displayed to the
 * user
 * 
 * @author Caitlyn
 *
 */
public class TestCaseListPane extends JPanel implements Serializable, Observer {

	private static final long serialVersionUID = -2210716111020406799L;
	private TestCaseList testCases;
	private JTable table;
	private int[] colWidths = { 50, 200, 50, 100, 100, 50, 50, 50, 50 };
	private TestCaseTableModel tctm;

	/**
	 * Constructs a TestCaseListPane with the given list of test cases
	 * 
	 * @param list
	 *            the list of test cases to populate the pane with
	 */
	public TestCaseListPane(TestCaseList list) {
		super();
		if (list == null) {
			throw new IllegalArgumentException();
		}
		testCases = list;
		this.testCases.addObserver(this);
		tctm = new TestCaseTableModel(testCases.get2DArray());
		initView();
	}

	/**
	 * Gets the test case table model holding the data for test cases in a 2D
	 * array
	 * 
	 * @return tctm - defined above
	 */
	public TestCaseTableModel getTestCaseTableModel() {
		return tctm;
	}

	/**
	 * Returns a JTable containing the info for the test cases
	 * 
	 * @return a JTable with test case info
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Initializes the view by creating the JTable and associating it with the
	 * TestCaseTableModel
	 */
	private void initView() {
		table = new JTable(tctm);
		table.setVisible(true);
		for (int i = 0; i < colWidths.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(colWidths[i]);
		}
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(false);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	/**
	 * Clears the current data
	 */
	public void clearSelection() {
		table.clearSelection();
	}

	/**
	 * Notifies the observers when a change is made
	 * 
	 * @param observable
	 *            the action being observed
	 * @param obj
	 *            the object (observer) to be notified of the change
	 */
	public void update(Observable observable, Object obj) {
		if (observable instanceof TestCaseList) {
			TestCaseList tcl = (TestCaseList) observable;
			// If there is a different number of rows, create a new
			// TestingTypeTableModel.
			if (tcl.size() != tctm.getRowCount()) {
				tctm = new TestCaseTableModel(tcl.get2DArray());
				table.setModel(tctm);
			} else {
				// Otherwise, just update the values directly.
				Object[][] arr = tcl.get2DArray();
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < tctm.getColumnCount(); j++) {
						tctm.setValueAt(arr[i][j], i, j);
					}
				}
			}
		}
	}
}
