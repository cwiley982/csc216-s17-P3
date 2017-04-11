package edu.ncsu.csc216.bbtp.util;

public interface List {

	public int size();

	public boolean isEmpty();

	public boolean contains(Object o);

	public Object get(int i);

	public void add(int i, Object o);

	public Object remove(int i);

	public int indexOf(Object o);
}
