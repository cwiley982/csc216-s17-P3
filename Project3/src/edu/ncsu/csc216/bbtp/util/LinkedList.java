package edu.ncsu.csc216.bbtp.util;

import java.util.List;

public class LinkedList implements List {

	private static final long serialVersionUID;
	private Node head;

	public LinkedList() {

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

	public class Node {
		private static final long serialVersionUID;
		private Object value; // not right, place holder until I figure it out
		private Node next;

		public Node(Object obj, Node node) {

		}
	}
}
