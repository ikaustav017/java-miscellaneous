package com.kaustavn.binaryTree;

public class CreateBST {
	/*
	 * Given a sorted array, create a BST
	 */

	public static <T> Node<T> sortedArraytoBST(T sorted[]) {

		if (sorted.length == 0)
			return null;

		return sortedArrayToBST(sorted, 0, sorted.length - 1);

	}

	public static <T> Node<T> sortedArrayToBST(T sorted[], int start, int end) {
		if (start > end)
			return null;
		// for (int i = start; i <= end; i++)
		// System.out.print("\t " + sorted[i]);

		int mid = (start + end) / 2;
		// System.out.println("\nMid is " + sorted[mid]);
		Node<T> root = new Node<T>(sorted[mid]);
		root.setLeft(sortedArrayToBST(sorted, start, mid - 1));
		// System.out.println("Mid left is " + root.getLeft());
		root.setRight(sortedArrayToBST(sorted, mid + 1, end));
		// System.out.println("Mid right is " + root.getRight());

		return root;
	}

	public static void main(String[] args) {

		Node<Integer> root = CreateBST.sortedArraytoBST(new Integer[] { 10, 30, 50, 70, 90, 100 });

		System.out.println("PreOrder");
		Traversal.preOrder(root);
		System.out.println("\nInorder");
		Traversal.inOrder(root);
		System.out.println(" \nPostOrder");
		Traversal.postOrder(root);
	}

}
