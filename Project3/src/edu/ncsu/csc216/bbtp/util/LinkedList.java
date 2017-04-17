package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * Creates a serializable LinkedList
 * 
 * @author Cameron
 * @author Caitlyn
 *
 * @param E
 *            generic parameter
 */
public class LinkedList<E> implements List, Serializable {

	private static final long serialVersionUID = 349987L;
	private Node head;

	/**
	 * Constructs a linked list
	 */
	public LinkedList() {
		// TODO
	}

	/**
	 * Adds an object to the list
	 * 
	 * @param obj
	 *            object to add to the list
	 * @return true if object can be added
	 */
	public boolean add(Object obj) {
		// TODO
		if (head != null)
			return true;
		return false;
	}

	@Override
	public void add(int idx, Object obj) {
		// TODO
	}

	@Override
	public boolean contains(Object obj) {
		return false;
	}

	@Override
	public E get(int idx) {
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

	/**
	 * Creates Nodes to be held by LinkedList
	 * 
	 * @author Caitlyn
	 *
	 */
	public class Node implements Serializable {
		private static final long serialVersionUID = 484909840L;
		/** Value of the node */
		protected Object value; // not right I don't think, place holder until I
								// figure it out
		private Node next;

		/**
		 * Constructs a node with an object and a reference to the next node in
		 * the list
		 * 
		 * @param obj
		 *            the object for the node to hold
		 * @param node
		 *            the next node after the one being created
		 */
		public Node(Object obj, Node node) {
			// TODO
			if (next != null)
				next = new Node(obj, node);
		}
	}
}
