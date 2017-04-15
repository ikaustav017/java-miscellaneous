package com.kaustavn.binaryTree;

public class NodeSimple {
	private NodeSimple left;
	private NodeSimple right;

	private int data;

	public NodeSimple getLeft() {
		return left;
	}

	public void setLeft(NodeSimple left) {
		this.left = left;
	}

	public NodeSimple getRight() {
		return right;
	}

	public void setRight(NodeSimple right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeSimple(int value) {
		this.left = null;
		this.right = null;
		this.data = value;
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null)
				left = new NodeSimple(value);
			else
				left.insert(value);

		} else {
			if (right == null)
				right = new NodeSimple(value);
			else
				right.insert(value);

		}
	}

	public boolean contains(int value) {

		if (value == data)
			return true;

		if (value < data) {
			if (left == null)
				return false;
			else
				return left.contains(value);
		} else {
			if (right == null)
				return false;
			else
				return right.contains(value);
		}
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.println(data);
		if (right != null)
			right.printInOrder();
	}

}
