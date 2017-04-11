package edu.ncsu.csc216.bbtp.model;

/**
 * This interface can be implemented to get a 2D array of data tp be used to
 * populate a table
 * 
 * @author Caitlyn
 *
 */
public interface Tabular {

	/**
	 * Gets the info in an array for a list of items
	 * 
	 * @return a 2D array of Objects
	 */
	public Object[][] get2DArray();

}
