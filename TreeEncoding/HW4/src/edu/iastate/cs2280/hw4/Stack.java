package edu.iastate.cs2280.hw4;

import java.util.NoSuchElementException;

/**
 * Stack for implementing non recursive building of message tree
 * @author Jonathan Clark
 *
 * @param <E>
 */
public class Stack<E>{
	
	private int size;
	private Node top;
	
	/**
	 * Constructs empty stack
	 */
	public Stack() {
		size = 0;
		top = null;
	}

	/**
	 * Push an element to top of stack
	 * @param element - element to push
	 */
	public void push(E element) {
		//linking new node to top node
		Node newTop = new Node(element, top);
		
		//reassign top reference to new node
		top = newTop;
		size++;
	}


	/**
	 * @return is stack empty
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Returns size of stack
	 * @return size of stack
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Internal node Class for linking stack
	 * 
	 * @author Jonathan Clark
	 *
	 */
	class Node {
		E data;
		Node next;
		
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		
	}

	/**
	 * Pops top element
	 * @return top
	 */
	public E pop() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		E popData = top.data;
		top = top.next;
		size--;
		
		return popData;
	}

	/**
	 * Returns top element without removing
	 * @return top element
	 */
	public E peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return top.data;
	}

}

