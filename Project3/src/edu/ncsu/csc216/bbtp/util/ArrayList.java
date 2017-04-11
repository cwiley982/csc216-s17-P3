package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;
import java.util.List;

public class ArrayList implements List, Serializable {
	private static final long serialVersionUID = 28592L;
	private static final int RESIZE;
	private Object[] list;
	private int size;

	public ArrayList() {

	}

	public ArrayList(int num) {

	}

	@Override
	public boolean add(Object obj) {
		return false;
	}

	@Override
	public void add(int idx, Object obj) {

	}

	@Override
	public boolean contains(Object obj) {
		return false;
	}

	@Override
	public Object get(int idx) {
		return null;
	}

	@Override
	public int indexOf(Object obj) {
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Object remove(int idx) {
		return null;
	}

	@Override
	public int size() {
		return -1;
	}
}
