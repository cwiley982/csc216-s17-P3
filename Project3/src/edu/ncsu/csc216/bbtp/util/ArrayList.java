package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * Creates an array list that is serializable
 * 
 * @author Caitlyn
 * @author Cameron
 *
 */
public class ArrayList implements List, Serializable {
	private static final long serialVersionUID = 28592L;
	private static final int RESIZE = 2;
	private Object[] list;
	private int size;

	/**
	 * Constructs an empty array list and initializes its state
	 */
	public ArrayList() {
		list = new Object[5];
		size = 0;
	}

	/**
	 * Constructs an array list with the given size
	 * 
	 * @param num
	 *            size of array list
	 */
	public ArrayList(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException();
		}
		list = new Object[num];
		size = 0;
	}

	/**
	 * Adds object to back of list
	 * 
	 * @param obj
	 *            object to add
	 * @return true if object can be added, false otherwise
	 */
	public boolean add(Object obj) {
		if (obj == null)
			throw new NullPointerException();
		if (list[list.length - 1] != null) {
			growArray();
		}
		list[size] = obj;
		size++;
		return true;
	}

	@Override
	public void add(int idx, Object obj) {
		if (size == list.length) {
			growArray();
		}

		if (obj == null) {
			throw new NullPointerException();
		}

		if (idx < 0 || idx > size) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < size; i++) {
			if (list[i].equals(obj)) {
				throw new IllegalArgumentException();
			}
		}

		if (idx == size) {
			list[size] = obj;
		} else {
			for (int i = size; i > idx; i--) {
				list[i] = list[i - 1];
			}
			list[idx] = obj;
		}
		size++;
	}

	private void growArray() {
		Object[] tempList = new Object[list.length * RESIZE];
		for (int i = 0; i < list.length; i++) {
			tempList[i] = list[i];
		}
		list = tempList;
	}

	@Override
	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return list[idx];
		}
	}

	@Override
	public int indexOf(Object obj) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(obj))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size <= 0;
	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Object removed = list[index];

		if (index == size - 1) {
			list[index] = null;
		}

		list[index] = null;
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;

		return removed;
	}

	@Override
	public int size() {
		return size;
	}
}
