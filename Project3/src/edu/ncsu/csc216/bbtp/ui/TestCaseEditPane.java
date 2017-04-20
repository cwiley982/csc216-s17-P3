package edu.ncsu.csc216.bbtp.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

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
	private JLabel testingTypeTitle;
	private JComboBox<TestingType> tcTestingType;
	private JTextArea expectedResults;
	private JTextArea actualResults;
	private JTextArea testCaseDescription;
	private JLabel creationDateTitle;
	private JSpinner testCreationDate;
	private JLabel lastTestedDateTitle;
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
		this(ttl);
		setTestCaseData(tcd);
	}

	private void init() {
		testCaseID = getTestCaseID();
		testingTypeTitle = new JLabel("Testing Type");
		tcTestingType = getTestingType();
		expectedResults = getExpectedResults();
		actualResults = getActualResults();
		testCaseDescription = getTestCaseDescription();
		testCreationDate = getTestCreationDateSpinner();
		testLastTestedDate = getTestLastTestedDateSpinner();
		creationDateTitle = new JLabel("Test Creation Date & Time:");
		lastTestedDateTitle = new JLabel("Last Tested Date & Time:");
		tested = tested();
		pass = pass();
	}

	/**
	 * Initializes the view
	 */
	private void initView() {
		// TODO put everything into a pretty panel
	}

	/**
	 * Gets the date the test was created as a JSpinner
	 * 
	 * @return the date created as a JSpinner
	 */
	protected JSpinner getTestCreationDateSpinner() {
		if (testCreationDate == null) {
			testCreationDate = new JSpinner(new SpinnerDateModel());
		}
		return testCreationDate;
	}

	/**
	 * Gets the date the test case was last tested as a JSpinner
	 * 
	 * @return the last test date as a JSpinner
	 */
	protected JSpinner getTestLastTestedDateSpinner() {
		if (testLastTestedDate == null) {
			testLastTestedDate = new JSpinner(new SpinnerDateModel());
		}
		return testLastTestedDate;
	}

	/**
	 * Gets the date created as a Date object
	 * 
	 * @return the date the test was created as a Date
	 */
	protected Date getTestCreationDate() {
		return (Date) testCreationDate.getValue();
	}

	/**
	 * Gets the date last tested as a Date object
	 * 
	 * @return the date the test was last tested as a Date
	 */
	protected Date getLastTestedDate() {
		return (Date) testLastTestedDate.getValue();
	}

	/**
	 * Gets the test case id
	 * 
	 * @return the test case's id
	 */
	protected JTextField getTestCaseID() {
		if (testCaseID == null) {
			testCaseID = new JTextField("Test Case ID:");
		}
		return testCaseID;
	}

	/**
	 * Gets the description for the test case
	 * 
	 * @return test case's description
	 */
	protected JTextArea getTestCaseDescription() {
		if (testCaseDescription == null) {
			testCaseDescription = new JTextArea("Descrption:");
		}
		return testCaseDescription;
	}

	/**
	 * Returns a combo box containing all possible testing type options
	 * 
	 * @return combo box with all testing types
	 */
	protected JComboBox<TestingType> getTestingType() {
		if (tcTestingType == null) {
			tcTestingType = new JComboBox<TestingType>();
			for (int i = 0; i < testingTypes.size(); i++) {
				tcTestingType.addItem(testingTypes.getTestingTypeAt(i));
			}
		}
		return tcTestingType;
	}

	/**
	 * Gets the expected results in a JTextArea
	 * 
	 * @return expected results in a JTextArea
	 */
	protected JTextArea getExpectedResults() {
		if (expectedResults == null) {
			expectedResults = new JTextArea("Expected Results:");
		}
		return expectedResults;
	}

	/**
	 * Gets the actual results in a JTextArea
	 * 
	 * @return actual results in a JTextArea
	 */
	protected JTextArea getActualResults() {
		if (actualResults == null) {
			actualResults = new JTextArea("Actual Results:");
		}
		return actualResults;
	}

	/**
	 * Returns a checkbox for the user to click if the test has passed
	 * 
	 * @return checkbox for if the test passed
	 */
	protected JCheckBox pass() {
		if (pass == null) {
			pass = new JCheckBox("Pass?");
		}
		return pass;
	}

	/**
	 * Returns a checkbox for the user to click if the test has been tested
	 * 
	 * @return checkbox for if the test has been tested
	 */
	protected JCheckBox tested() {
		if (tested == null) {
			tested = new JCheckBox("Tested?");
		}
		return tested;
	}

	/**
	 * Sets the creation date with the date given
	 * 
	 * @param date
	 *            the date to set the creation date to
	 */
	protected void setCreationDateTime(Date date) {
		testCreationDate.setValue(date);
	}

	/**
	 * Sets the last tested date to the date given
	 * 
	 * @param date
	 *            the date to set the last tested date to
	 */
	protected void setLastTestedDateTime(Date date) {
		testLastTestedDate.setValue(date);
	}

	/**
	 * Tells whether the pane is being used to add a test case
	 * 
	 * @return true if a test is being added, false otherwise
	 */
	protected boolean isAddMode() {
		return add;
	}

	/**
	 * Tells whether the pane is being used to edit a test case
	 * 
	 * @return true if a test is being edited, false otherwise
	 */
	protected boolean isEditMode() {
		return edit;
	}

	/**
	 * Enables the panel to be able to add a test case
	 */
	protected void enableAdd() {
		add = true;
	}

	/**
	 * Disables the panel being able to add test cases
	 */
	protected void disableAdd() {
		add = false;
	}

	/**
	 * Enables the panel to allow editing of test cases
	 * 
	 * @param tcd
	 *            test case data to update test with
	 */
	protected void enableEdit(TestCaseData tcd) {
		edit = true;
		setTestCaseData(tcd);
	}

	/**
	 * Disables the panel from edit mode
	 */
	protected void disableEdit() {
		edit = false;
	}

	/**
	 * Tells if the fields are not empty
	 * 
	 * @return true if all fields are not empty
	 */
	protected boolean fieldsNotEmpty() {
		if (testCaseID.getText().equals("")) {
			return false;
		} else if (testCaseDescription.getText().equals("")) {
			return false;
		} else if (tcTestingType.getSelectedIndex() == -1) {
			return false;
		} else if (expectedResults.getText().equals("")) {
			return false;
		} else if (actualResults.getText().equals("")) {
			return false;
		} else if (testCreationDate.getValue() == null) {
			return false;
		} else if (testLastTestedDate.getValue() == null) {
			return false;
		}
		return true;
	}

	/**
	 * Fills the fields with the data in the TestCaseData object
	 * 
	 * @param tcd
	 *            the test case data to set
	 */
	protected void setTestCaseData(TestCaseData tcd) {
		testCaseID.setText(tcd.getTestCaseID());
		testCaseDescription.setText(tcd.getDescription());
		tcTestingType.setSelectedIndex(testingTypes.indexOf(tcd.getTestingType().getTestingTypeID()));
		testCreationDate.setValue(tcd.getCreationDateTime());
		testLastTestedDate.setValue(tcd.getLastTestedDateTime());
		tested.setSelected(tcd.tested());
		expectedResults.setText(tcd.getExpectedResults());
		actualResults.setText(tcd.getActualResults());
		pass.setSelected(tcd.pass());
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
		testCaseID.setText("");
		testCaseDescription.setText("");
		tcTestingType.setSelectedIndex(-1);
		testCreationDate.setValue(null); // don't know if this is right
		testLastTestedDate.setValue(null);
		tested.setSelected(false);
		expectedResults.setText("");
		actualResults.setText("");
		pass.setSelected(false);
	}

	/**
	 * Gets the fields data and returns it in a TestCaseData object
	 * 
	 * @return TestCaseData object holding data from all fields
	 */
	protected TestCaseData getFields() {
		String id = testCaseID.getText();
		String desc = testCaseDescription.getText();
		TestingType tt = (TestingType) tcTestingType.getSelectedItem();
		Date created = (Date) testCreationDate.getValue();
		Date lastTested = (Date) testLastTestedDate.getValue();
		boolean wasTested = tested.isSelected();
		String exp = expectedResults.getText();
		String act = actualResults.getText();
		boolean passed = pass.isSelected();
		TestCaseData tcd = new TestCaseData(id, desc, tt, created, lastTested, wasTested, exp, act, passed);

		return tcd;
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
		fillFields();
	}
}
