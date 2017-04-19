package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.ncsu.csc216.bbtp.model.TestingType;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * Creates a TestCaseEditPane that the user will see to add a test and edit
 * existing test's data
 * 
 * @author Caitlyn
 * @author Cameron
 *
 */
public class TestCaseEditPane extends JPanel implements Serializable, Observer {

	private static final long serialVersionUID = 5479139338455751629L;
	private TestingTypeList testingTypes;
	private JTextField testCaseID;
	private JComboBox<TestingType> tcTestingType;
	private JTextArea expectedResults;
	private JTextArea actualResults;
	private JTextArea testCaseDescription;
	private JSpinner testCreationDate;
	private JSpinner testLastTestedDate;
	private JCheckBox tested;
	private JCheckBox pass;
	private boolean add;
	private boolean edit;

	/**
	 * Constructs a TestCaseEditPane with the given list of testing types
	 * 
	 * @param ttl
	 *            the list of testing types
	 */
	public TestCaseEditPane(TestingTypeList ttl) {
		testingTypes = ttl;

	}

	/**
	 * Constructs a TestCaseEditPane with the given list of testing types and
	 * test case
	 * 
	 * @param tcd
	 *            data for the test case to edit
	 * @param ttl
	 *            list of testing types to allow user to choose from
	 */
	public TestCaseEditPane(TestCaseData tcd, TestingTypeList ttl) {

		// TODO
	}

	private void init() {
		// TODO
	}

	/**
	 * Initializes the view
	 */
	private void initView() {
		// TODO
	}

	/**
	 * Gets the date the test was created as a JSpinner
	 * 
	 * @return the date created as a JSpinner
	 */
	protected JSpinner getTestCreationDateSpinner() {
		// TODO
		init();
		initView();
		return testCreationDate;
	}

	/**
	 * Gets the date the test case was last tested as a JSpinner
	 * 
	 * @return the last test date as a JSpinner
	 */
	protected JSpinner getTestLastTestedDateSpinner() {
		return testLastTestedDate;
	}

	/**
	 * Gets the date created as a Date object
	 * 
	 * @return the date the test was created as a Date
	 */
	protected Date getTestCreationDate() {
		return null;
	}

	/**
	 * Gets the date last tested as a Date object
	 * 
	 * @return the date the test was last tested as a Date
	 */
	protected Date getLastTestedDate() {
		return null;
	}

	/**
	 * Gets the test case id
	 * 
	 * @return the test case's id
	 */
	protected JTextField getTestCaseID() {
		return testCaseID;
	}

	/**
	 * Gets the description for the test case
	 * 
	 * @return test case's description
	 */
	protected JTextArea getTestCaseDescription() {
		return testCaseDescription;
	}

	/**
	 * Returns a combo box containing all possible testing type options
	 * 
	 * @return combo box with all testing types
	 */
	protected JComboBox<TestingType> getTestingType() {
		return tcTestingType;
	}

	/**
	 * Gets the expected results in a JTextArea
	 * 
	 * @return expected results in a JTextArea
	 */
	protected JTextArea getExpectedResults() {
		return expectedResults;
	}

	/**
	 * Gets the actual results in a JTextArea
	 * 
	 * @return actual results in a JTextArea
	 */
	protected JTextArea getActualResults() {
		return actualResults;
	}

	/**
	 * Returns a checkbox for the user to click if the test has passed
	 * 
	 * @return checkbox for if the test passed
	 */
	protected JCheckBox pass() {
		return null;
	}

	/**
	 * Returns a checkbox for the user to click if the test has been tested
	 * 
	 * @return checkbox for if the test has been tested
	 */
	protected JCheckBox tested() {
		return null;
	}

	/**
	 * Sets the creation date with the date given
	 * 
	 * @param date
	 *            the date to set the creation date to
	 */
	protected void setCreationDateTime(Date date) {
		// TODO
	}

	/**
	 * Sets the last tested date to the date given
	 * 
	 * @param date
	 *            the date to set the last tested date to
	 */
	protected void setLastTestedDateTime(Date date) {
		// TODO
	}

	/**
	 * Tells whether the pane is being used to add a test case
	 * 
	 * @return true if a test is being added, false otherwise
	 */
	protected boolean isAddMode() {
		// TODO
		if (pass != null && tested != null && testingTypes != null)
			return true;
		if (add && edit)
			return true;
		return false;
	}

	/**
	 * Tells whether the pane is being used to edit a test case
	 * 
	 * @return true if a test is being edited, false otherwise
	 */
	protected boolean isEditMode() {
		return false;
	}

	/**
	 * Enables the panel to be able to add a test case
	 */
	protected void enableAdd() {
		// TODO
	}

	/**
	 * Disables the panel being able to add test cases
	 */
	protected void disableAdd() {
		// TODO
	}

	/**
	 * Enables the panel to allow editing of test cases
	 * 
	 * @param tcd
	 *            test case data to update test with
	 */
	protected void enableEdit(TestCaseData tcd) {
		// TODO
	}

	/**
	 * Disables the panel from edit mode
	 */
	protected void disableEdit() {
		// TODO
	}

	/**
	 * Tells of the fields are not empty
	 * 
	 * @return true if all fields are not empty
	 */
	protected boolean fieldsNotEmpty() {
		return false;
	}

	/**
	 * Sets the test case data for a test
	 * 
	 * @param tcd
	 *            the test case data to set
	 */
	protected void setTestCaseData(TestCaseData tcd) {
		// TODO
	}

	/**
	 * Adds a field listener to an event listener for the test case
	 * 
	 * @param el
	 *            the event listener
	 */
	protected void addFieldListener(EventListener el) {
		// TODO
	}

	/**
	 * Fills all fields with current test case data
	 */
	protected void fillFields() {
		// TODO
	}

	/**
	 * Clears all fields so no data is shown
	 */
	protected void clearFields() {
		// TODO
	}

	/**
	 * Gets the fields data and returns it in a TestCaseData object
	 * 
	 * @return TestCaseData object holding data from all fields
	 */
	protected TestCaseData getFields() {
		return null;
	}

	/**
	 * Notifies observers of a change when one is made to an observable
	 * 
	 * @param o
	 *            the observable
	 * @param ol
	 *            the object being changed
	 */
	public void update(Observable o, Object ol) {
		// TODO
	}
}
