package com.kaustavn.stack;

public class Stack {

	public static class Node {

		private Node next;

		private int data;

		public Node(int value) {
			this.next = null;
			this.data = value;
		}

	}

	private Node top;

	public boolean isEmpty() {

		if (top == null)
			return true;

		return false;
	}

	public int peek() {
		if (top == null)
			throw new IllegalStateException();
		return top.data;

	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;

	}

	public int pop() {
		if (top == null)
			throw new IllegalStateException();

		int data = top.data;
		top = top.next;
		return data;

	}
}
