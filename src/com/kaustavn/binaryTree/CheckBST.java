package com.kaustavn.binaryTree;

public class CheckBST {

	/*
	 * linear time solution ........................ space complexity log(n) if
	 * it is balance tree
	 */
	public static boolean isBST(Node<Integer> root) {

		if (root == null) {
			return false;
		}
		return isBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private static boolean isBSTHelper(Node<Integer> root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (root.getValue() > max && root.getValue() < min)
			return false;

		return (isBSTHelper(root.getLeft(), root.getValue() - 1, min)
				&& isBSTHelper(root.getRight(), max, root.getValue() + 1));
	}

}
