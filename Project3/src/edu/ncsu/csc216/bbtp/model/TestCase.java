package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * Class for creating a TestCase object
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class TestCase extends Observable implements Comparable<TestCase>, Serializable {
	/** Serializable ID */
	private static final long serialVersionUID = 7459L;
	private String testCaseID;
	private Date creationDateTime;
	private String description;
	private String expectedResults;
	private String actualResults;
	private Date lastTestedDateTime;
	private boolean testedStatus;
	private boolean pass;
	private TestingType testingType;

	/**
	 * Constructs a new TestCase
	 * 
	 * @param id
	 *            id of the test case
	 * @param description
	 *            description of the test case
	 * @param testingType
	 *            the testing type of the test case
	 * @param creationDateTime
	 *            the date and time the test case was created
	 * @param expectedResults
	 *            the expected results of the test
	 * @param tested
	 *            whether or not the test case has been tested
	 * @param lastTestedDate
	 *            date the test case was last tested
	 * @param actualResults
	 *            the actual results of the test
	 * @param pass
	 *            whether or not the test passed
	 */
	public TestCase(String id, String description, TestingType testingType, Date creationDateTime,
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		setTestCaseID(id);
		setDescription(description);
		setTestingType(testingType);
		setCreationDateTime(creationDateTime);
		setExpectedResults(expectedResults);
		setTestedStatus(tested);
		setLastTestedDateTime(lastTestedDate);
		setActualResults(actualResults);
		setPass(pass);
		setChanged();
		notifyObservers(this);
	}

	/**
	 * gets the description of the test case
	 * 
	 * @return the description of the test case
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description of the test case
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		if (description == null || description.trim().isEmpty())
			throw new IllegalArgumentException();
		this.description = description;
		setChanged();
		notifyObservers(this); // potential point of failure, can be removed.
	}

	/**
	 * gets the expected results of the test
	 * 
	 * @return the expected results of the test
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * sets the expected results of the test
	 * 
	 * @param expectedResults
	 *            expected results to set
	 */
	public void setExpectedResults(String expectedResults) {
		if (expectedResults == null || expectedResults.trim().isEmpty())
			throw new IllegalArgumentException();
		this.expectedResults = expectedResults;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * returns the actual results of the test
	 * 
	 * @return the actual results of the test
	 */
	public String getActualResults() {
		return actualResults;
	}

	/**
	 * sets the actual results of the test
	 * 
	 * @param actualResults
	 *            actual results to set
	 */
	public void setActualResults(String actualResults) {
		if (testedStatus && (actualResults == null || actualResults.trim().isEmpty())) {
				throw new IllegalArgumentException();
		}
		this.actualResults = actualResults;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * gets the date and time the test was created
	 * 
	 * @return the date and time the test was created
	 */
	public Date getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * sets the date the test was created
	 * 
	 * @param creationDateTime
	 *            creation date to set
	 */
	public void setCreationDateTime(Date creationDateTime) {
		if (creationDateTime == null)
			throw new IllegalArgumentException();
		this.creationDateTime = creationDateTime;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * gets the last tested date and time
	 * 
	 * @return date the test was lasted tested
	 */
	public Date getLastTestedDateTime() {
		return lastTestedDateTime;
	}

	/**
	 * sets the date and time the test was last tested
	 * 
	 * @param lastTestedDateTime
	 *            last tested date to set
	 */
	public void setLastTestedDateTime(Date lastTestedDateTime) {
		if (testedStatus && lastTestedDateTime == null) {
			throw new IllegalArgumentException();
		}
		this.lastTestedDateTime = lastTestedDateTime;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * determines if the test has been tested
	 * 
	 * @return true or false
	 */
	public boolean tested() {
		return testedStatus;
	}

	/**
	 * sets whether the test has been tested
	 * 
	 * @param tf
	 *            boolean to set
	 */
	public void setTestedStatus(boolean tf) {
		this.testedStatus = tf;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * determines if the test passed
	 * 
	 * @return true or false
	 */
	public boolean pass() {
		return pass;
	}

	/**
	 * sets whether or not the test passed
	 * 
	 * @param tf
	 *            true or false
	 */
	public void setPass(boolean tf) {
		this.pass = tf;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * sets the testing type for the test case
	 * 
	 * @param tt
	 *            testing type to set
	 */
	public void setTestingType(TestingType tt) {
		if (tt == null)
			throw new IllegalArgumentException();
		this.testingType = tt;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * gets the testing type of the test
	 * 
	 * @return the testing type of the test
	 */
	public TestingType getTestingType() {
		return testingType;
	}

	/**
	 * gets the test case id
	 * 
	 * @return the test case id
	 */
	public String getTestCaseID() {
		return testCaseID;
	}

	private void setTestCaseID(String id) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException();
		this.testCaseID = id;
		setChanged();
		notifyObservers(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualResults == null) ? 0 : actualResults.hashCode());
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expectedResults == null) ? 0 : expectedResults.hashCode());
		result = prime * result + ((lastTestedDateTime == null) ? 0 : lastTestedDateTime.hashCode());
		result = prime * result + (pass ? 1231 : 1237);
		result = prime * result + ((testCaseID == null) ? 0 : testCaseID.hashCode());
		result = prime * result + (testedStatus ? 1231 : 1237);
		result = prime * result + ((testingType == null) ? 0 : testingType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestCase other = (TestCase) obj;
		if (actualResults == null) {
			if (other.actualResults != null)
				return false;
		} else if (!actualResults.equals(other.actualResults))
			return false;
		if (creationDateTime == null) {
			if (other.creationDateTime != null)
				return false;
		} else if (!creationDateTime.equals(other.creationDateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedResults == null) {
			if (other.expectedResults != null)
				return false;
		} else if (!expectedResults.equals(other.expectedResults))
			return false;
		if (lastTestedDateTime == null) {
			if (other.lastTestedDateTime != null)
				return false;
		} else if (!lastTestedDateTime.equals(other.lastTestedDateTime))
			return false;
		if (pass != other.pass)
			return false;
		if (testCaseID == null) {
			if (other.testCaseID != null)
				return false;
		} else if (!testCaseID.equals(other.testCaseID))
			return false;
		if (testedStatus != other.testedStatus)
			return false;
		if (testingType == null) {
			if (other.testingType != null)
				return false;
		} else if (!testingType.equals(other.testingType))
			return false;
		return true;
	}

	@Override
	public int compareTo(TestCase tc) {
		try {
			return tc.getLastTestedDateTime().compareTo(this.getLastTestedDateTime());
		} catch (NullPointerException e) {
			return -1;
		}
	}

}
