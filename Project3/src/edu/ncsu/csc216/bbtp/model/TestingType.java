package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * Class to hold the testing type of each test case
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class TestingType extends Observable implements Serializable, Comparable<TestingType> {

	private static final long serialVersionUID = 459188L;
	private String name;
	private String description;
	private String testingTypeID;

	/**
	 * creates new testing type and initializes state
	 * 
	 * @param id
	 *            id of the test type
	 * @param name
	 *            name of the test type
	 * @param desc
	 *            description of the test type
	 */
	public TestingType(String id, String name, String desc) {
		// TODO
	}

	/**
	 * gets name of the testing type
	 * 
	 * @return name of the testing type
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the tetsting type
	 * 
	 * @param name
	 *            name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the description of the testing type
	 * 
	 * @return description of the testing type
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description of the testing type
	 * 
	 * @param description
	 *            description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * gets the id of the testing type
	 * 
	 * @return id of the testing type
	 */
	public String getTestingTypeID() {
		// TODO
		setTestingTypeID("fake");
		return testingTypeID;
	}

	/**
	 * sets the id of the testing type
	 * 
	 * @param testingTypeID
	 *            the testing type id to set
	 */
	private void setTestingTypeID(String testingTypeID) {
		this.testingTypeID = testingTypeID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestingType other = (TestingType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (testingTypeID == null) {
			if (other.testingTypeID != null)
				return false;
		} else if (!testingTypeID.equals(other.testingTypeID))
			return false;
		return true;
	}

	@Override
	public int compareTo(TestingType o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((testingTypeID == null) ? 0 : testingTypeID.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TestingType [name=" + name + ", description=" + description + ", testingTypeID=" + testingTypeID + "]";
	}

}
