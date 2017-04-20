package edu.ncsu.csc216.bbtp.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.Serializable;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

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
	private TestCaseData data;

	/**
	 * Constructs a TestCaseEditPane with the given list of testing types
	 * 
	 * @param ttl
	 *            the list of testing types
	 */
	public TestCaseEditPane(TestingTypeList ttl) {
		super();
		testingTypes = ttl;
		init();
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
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		initView();
		fillFields();
	}

	/**
	 * Initializes the view
	 */
	private void initView() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Test Case ID: "));
		p.add(getTestCaseID());
		p.add(new JLabel("Testing Type: "));
		p.add(getTestingType());
		p.add(new JLabel("Test Creation Date and Time: "));
		p.add(getTestCreationDateSpinner());
		this.add(p);
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Description: "));
		p.add(getTestCaseDescription());
		this.add(p);
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Tested? "));
		p.add(tested());
		p.add(new JLabel("Last Tested Date and Time: "), SwingConstants.LEFT);
		p.add(getTestLastTestedDateSpinner());
		this.add(p);
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Expected Results: "));
		p.add(getExpectedResults());
		this.add(p);
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Actual Results: "));
		p.add(getActualResults());
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Pass? "));
		p.add(pass());
		this.add(p);
	}

	/**
	 * Gets the date the test was created as a JSpinner
	 * 
	 * @return the date created as a JSpinner
	 */
	protected JSpinner getTestCreationDateSpinner() {
		if (testCreationDate == null) {
			testCreationDate = new JSpinner(new SpinnerDateModel());
			testCreationDate.setVisible(true);
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
			testLastTestedDate.setVisible(true);
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
			testCaseID = new JTextField(20);
			testCaseID.setVisible(true);
			testCaseID.setEditable(false);
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
			testCaseDescription = new JTextArea(5, 70);
			testCaseDescription.setEditable(false);
			testCaseDescription.setVisible(true);
			testCaseDescription.setLineWrap(true);
			testCaseDescription.setAutoscrolls(true);

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
			expectedResults = new JTextArea(5, 70);
			expectedResults.setEditable(false);
			expectedResults.setVisible(true);
			expectedResults.setLineWrap(true);
			expectedResults.setAutoscrolls(true);
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
			actualResults = new JTextArea(5, 70);
			actualResults.setEditable(false);
			actualResults.setVisible(true);
			actualResults.setLineWrap(true);
			actualResults.setAutoscrolls(true);
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
			pass = new JCheckBox();
			pass.setVisible(true);
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
			tested = new JCheckBox();
			tested.setVisible(true);
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
		testCreationDate.setVisible(true);
	}

	/**
	 * Sets the last tested date to the date given
	 * 
	 * @param date
	 *            the date to set the last tested date to
	 */
	protected void setLastTestedDateTime(Date date) {
		testLastTestedDate.setValue(date);
		testLastTestedDate.setVisible(true);
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
		if (!isAddMode()) {
			data = null;
			add = true;
			edit = false;
			clearFields();
			fillFields();
		}
	}

	/**
	 * Disables the panel being able to add test cases
	 */
	protected void disableAdd() {
		add = false;
		clearFields();
	}

	/**
	 * Enables the panel to allow editing of test cases
	 * 
	 * @param tcd
	 *            test case data to update test with
	 */
	protected void enableEdit(TestCaseData tcd) {
		if (!isEditMode()) {
			edit = true;
			add = false;
			data = tcd;
			fillFields();
		}
	}

	/**
	 * Disables the panel from edit mode
	 */
	protected void disableEdit() {
		edit = false;
		clearFields();
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
		// TODO all fields need a listener

	}

	/**
	 * Fills all fields with current test case data
	 */
	protected void fillFields() {
		if (data == null) {
			clearFields();
			testCaseID.setEditable(false);
			tcTestingType.setEnabled(false);
			expectedResults.setEditable(false);
			actualResults.setEditable(false);
			testCaseDescription.setEditable(false);
			testCreationDate.setEnabled(false);
			testLastTestedDate.setEnabled(false);
			tested.setEnabled(false);
			pass.setEnabled(false);
		} else {
			testCaseID.setText(data.getTestCaseID());
			for (int i = 0; i < testingTypes.size(); i++) {
				tcTestingType.addItem(testingTypes.getTestingTypeAt(i));
			}
			expectedResults.setText(data.getExpectedResults());
			actualResults.setText(data.getActualResults());
			testCaseDescription.setText(data.getDescription());
			testCreationDate.setValue(data.getCreationDateTime());
			testLastTestedDate.setValue(data.getLastTestedDateTime());
			;
			tested.setSelected(data.tested());
			pass.setEnabled(data.pass());
		}

		if (isAddMode() || isEditMode()) {
			testCaseID.setEditable(true);
			tcTestingType.setEnabled(true);
			expectedResults.setEditable(true);
			actualResults.setEditable(true);
			testCaseDescription.setEditable(true);
			testCreationDate.setEnabled(true);
			testLastTestedDate.setEnabled(true);
			tested.setEnabled(true);
			pass.setEnabled(true);
		}
	}

	/**
	 * Clears all fields so no data is shown
	 */
	protected void clearFields() {
		testCaseID.setText("");
		testCaseDescription.setText("");
		tcTestingType.setSelectedIndex(-1);
		getTestCreationDateSpinner(); // don't know if this is right
		getTestLastTestedDateSpinner();
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
