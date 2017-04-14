package com.kaustavn.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {

	public static void preOrder(Node<?> root) {
		if (root == null)
			return;
		System.out.print("\t" + root.getValue());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public static void inOrder(Node<?> root) {
		if (root == null)
			return;
		inOrder(root.getLeft());
		System.out.print("\t" + root.getValue());
		inOrder(root.getRight());
	}

	public static void postOrder(Node<?> root) {
		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print("\t" + root.getValue());

	}

	public static <T> List<T> inOrderList(Node<?> root) {
		List<T> list = new ArrayList<T>();
		if (root != null)
			list = helper(root, list);

		return list;
	}

	private static <T> List<T> helper(Node<?> root, List<T> list) {
		if (root.getLeft() != null)
			helper(root.getLeft(), list);

		list.add((T) root.getValue());
		if (root.getRight() != null)
			helper(root.getRight(), list);
		return list;

	}

}
