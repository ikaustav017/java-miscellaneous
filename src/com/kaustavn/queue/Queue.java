package com.kaustavn.queue;

public class Queue {

	public static class Node {

		private Node next;

		private int data;

		public Node(int value) {
			this.next = null;
			this.data = value;
		}

	}

	private Node tail;// add things here
	private Node head; // remove things here

	public boolean isEmpty() {

		if (head == null)
			return true;

		return false;
	}

	public int peek() {
		if (head == null)
			throw new IllegalStateException();
		return head.data;

	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (tail != null) {
			tail.next = newNode;
		}

		tail = newNode;
		if (head == null) {
			head = newNode;
		}

	}

	public int remove() {
		if (head == null)
			throw new IllegalStateException();

		int data = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		return data;

	}
}