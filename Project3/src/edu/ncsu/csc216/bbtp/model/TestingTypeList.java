package edu.ncsu.csc216.bbtp.model;

import java.util.Observable;

import edu.ncsu.csc216.bbtp.util.ArrayList;

public class TestingTypeList implements Tabular {

	private static final long serialVersionUID;
	private String name;
	private int nextTestingTypeNum;
	private ArrayList list;

	public TestingTypeList() {

	}

	public String getName() {
		return "";
	}

	public boolean addTestingType(String name, String description) {
		return false;
	}

	public TestingType getTestingTypeAt(int idx) {

	}

	public int indexOf(String arg) {
		return -1;
	}

	public int indexOfName(String name) {
		return -1;
	}

	public int size() {
		return -1;
	}

	public boolean isEmpty() {
		return false;
	}

	public TestingType removeTestingTypeAt(int idx) {
		return null;
	}

	public boolean removeTestingType(String arg) {
		return false;
	}

	private int getNextTestingTypeNum() {
		return -1;
	}

	private void incNextTestingTypeNum() {

	}

	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Observable oservable, Object obj) {

	}
}
