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

	public TestCaseEditPane(TestingTypeList ttl) {

	}

	public TestCaseEditPane(TestCaseData tcd, TestingTypeList ttl) {

	}

	private void init() {

	}

	private void initView() {

	}

	protected JSpinner getTestCreationDateSpinner() {
		return testCreationDate;
	}

	protected JSpinner getTestLastTestedDateSpinner() {
		return testLastTestedDate;
	}

	protected Date getTestCreationDate() {
		return null;
	}

	protected Date getLastTestedDate() {
		return null;
	}

	protected JTextField getTestCaseID() {
		return testCaseID;
	}

	protected JTextArea getTestCaseDescription() {
		return testCaseDescription;
	}

	protected JComboBox<TestingType> getTestingType() {
		return tcTestingType;
	}

	protected JTextArea getExpectedResults() {
		return expectedResults;
	}

	protected JTextArea getActualResults() {
		return actualResults;
	}

	protected JCheckBox pass() {
		return null;
	}

	protected JCheckBox tested() {
		return null;
	}

	protected void setCreationDateTime(Date d) {

	}

	protected void setLastTestedDateTime(Date d) {

	}

	protected boolean isAddMode() {
		return false;
	}

	protected boolean isEditMode() {
		return false;
	}

	protected void enableAdd() {

	}

	protected void disableAdd() {

	}

	protected void enableEdit(TestCaseData tcd) {

	}

	protected void disableEdit() {

	}

	protected boolean fieldsNotEmpty() {
		return false;
	}

	protected void setTestCaseData(TestCaseData tcd) {

	}

	protected void addFieldListener(EventListener el) {

	}

	protected void fillFields() {

	}

	protected void clearFields() {

	}

	protected TestCaseData getFields() {
		return null;
	}

	public void update(Observable o, Object o1) {

	}
}
