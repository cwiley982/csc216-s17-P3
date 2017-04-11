package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

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
	private int[] colWidths;
	private TestCaseTableModel tctm;

	/**
	 * Constructs a TestCaseListPane with the given list of test cases
	 * 
	 * @param list
	 *            the list of test cases to populate the pane with
	 */
	public TestCaseListPane(TestCaseList list) {
		// TODO Auto-generated constructor stub
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

	}

	/**
	 * Clears the current data
	 */
	public void clearSelection() {

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

	}

}
