package com.kaustavn.linkedList;

public class Node {

	private Node next;

	private int data;

	public Node(int value) {
		this.next = null;
		this.data = value;
	}

	public class LinkedList {
		Node head;

		public void append(int data) {
			if (head == null) {
				head = new Node(data);
				return;
			}
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
		}

		public void prepend(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;

		}

		public boolean delete(int value) {
			if (head == null)
				return false;
			if (head.data == value) {

				head = head.next;
				return true;
			}

			Node current = head;

			while (current.next != null) {
				if (current.next.data == value) {
					current.next = current.next.next;
					return true;
				}

				current = current.next;
			}
			return false;

		}
	}
}
