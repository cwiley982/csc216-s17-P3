package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * Creates a serializable LinkedList
 * 
 * @author Cameron
 * @author Caitlyn
 *
 */
public class LinkedList implements List, Serializable {

	private static final long serialVersionUID = 349987L;
	private Node front;
	private int size;

	/**
	 * Constructs a linked list
	 */
	public LinkedList() {
		front = null;
	}

	/**
	 * Adds an object to the list
	 * 
	 * @param obj
	 *            object to add to the list
	 * @return true if object can be added
	 */
	public boolean add(Object obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (contains(obj)) {
			throw new IllegalArgumentException();
		}
		if (front == null) {
			front = new Node(obj, null);
			size++;
			return true;
		} else {
			Node current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(obj, null);
			size++;
			return true;
		}
	}

	@Override
	public void add(int index, Object obj) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (contains(obj)) {
			throw new IllegalArgumentException();
		}
		if (index == 0) { // adding to front
			front = new Node(obj, front);
		} else if (index == size) { // adding to back
			Node current = front;
			for (int i = 0; i < size() - 1; i++) {
				current = current.next;
			}
			current.next = new Node(obj, null);
		} else { // adding to middle
			Node current = front;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = new Node(obj, current.next);
		}
		size++;
	}

	@Override
	public boolean contains(Object obj) {
		Node currentCheck = front;
		for (int i = 0; i < size; i++) { // checks entire list for a duplicate
			if (currentCheck.value.equals(obj)) {
				return true;
			}
			currentCheck = currentCheck.next;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}

	@Override
	public int indexOf(Object obj) { // testing cases won't be equal to an ID
										// passed in, need to fix
		Node current = front;
		for (int i = 0; i < size; i++) {
			if (current.value == obj) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node removedNode = null;
		if (index == 0) {
			removedNode = front;
			front = front.next;
		} else {
			Node current = front;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			removedNode = current.next;
			current.next = current.next.next;
		}
		size--;
		return removedNode.value;
	}

	@Override
	public int size() {
		return size;
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
		Object value;
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
			if (obj == null) {
				throw new NullPointerException();
			}
			value = obj;
			next = node;
		}
	}
}
