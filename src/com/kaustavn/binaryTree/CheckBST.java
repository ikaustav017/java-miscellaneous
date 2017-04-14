package com.kaustavn.binaryTree;

public class CheckBST {

	static int MAX = 99999;
	static int MIN = -99999;

	public static boolean isBST(Node<Integer> root) {

		if (root == null) {
			return false;
		}
		return isBSTHelper(root, MAX, MIN);
	}

	private static boolean isBSTHelper(Node<Integer> root, int max, int min) {
		if (root == null) {
			return true;
		}
		if (root.getValue() < max && root.getValue() > min) {
			return (isBSTHelper(root.getLeft(), root.getValue(), min)
					&& isBSTHelper(root.getRight(), max, root.getValue()));
		}

		return false;
	}

}
