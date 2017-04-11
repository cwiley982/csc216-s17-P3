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

	/**
	 * Constructs a new TestCase
	 * 
	 * @param s
	 * @param f
	 * @param tt
	 * @param d
	 * @param j
	 * @param tf
	 * @param d2
	 * @param idk
	 * @param tf2
	 */
	public TestCase(String id, String description, TestingType testingType, Date creationDateTime,
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpectedResults() {
		return expectedResults;
	}

	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	public String getActualResults() {
		return actualResults;
	}

	public void setActualResults(String actualResults) {
		this.actualResults = actualResults;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Date getLastTestedDateTime() {
		return lastTestedDateTime;
	}

	public void setLastTestedDateTime(Date lastTestedDateTime) {
		this.lastTestedDateTime = lastTestedDateTime;
	}

	public boolean tested() {
		return false;
	}

	public void setTestedStatus(boolean tf) {

	}

	public boolean pass() {
		return false;
	}

	public void setPass(boolean tf) {

	}

	public void setTestingType(TestingType tt) {

	}

	public TestingType getTestingType() {
		return null;
	}

	public String getTestCaseID() {
		return null;
	}

	private void setTestCaseID(String s) {

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
		return true;
	}

	@Override
	public int compareTo(TestCase arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
