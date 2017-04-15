package com.kaustavn.binaryTree;

public class Height {

	// space com[lexity ..height of binary tree O(n)
	// time complexity On
	public static int findHeight(NodeSimple root) {

		if (root == null)
			return -1; // count edges //return 0 if you count nodes

		return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;

	}

	public static int findSize(NodeSimple root) {

		if (root == null)
			return 0; // count edges //return 0 if you count nodes

		return findHeight(root.getLeft()) + findHeight(root.getRight()) + 1;

	}
}
