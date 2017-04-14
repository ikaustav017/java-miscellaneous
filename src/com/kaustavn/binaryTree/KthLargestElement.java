package com.kaustavn.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElement<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root = CreateBST.sortedArraytoBST(new Integer[] { 10, 30, 50, 70, 90, 100 });
		System.out.println("inOrder");
		Traversal.inOrder(root);
		System.out.println("");
		int pos = 3;
		System.out.println(pos + " th largest elememt is " + KthLargestElement.findKthLargest(root, pos));

	}

	public static <K> K findKthLargest(Node<?> root, int pos) {
		List<K> list = new ArrayList<K>();
		if (root != null)
			list = helper(root, list, pos);

		// for (int i = 0; i < list.size(); i++)
		// System.out.println("findKthLargest " + list.get(i));
		return list.get(list.size() - 1);
	}

	private static <K> List<K> helper(Node<?> root, List<K> list, int pos) {
		if (root.getLeft() != null)
			helper(root.getLeft(), list, pos);

		// System.out.println("List size: " + list.size());
		if (list.size() == pos)
			return list;

		list.add((K) root.getValue());
		if (root.getRight() != null)
			helper(root.getRight(), list, pos);
		return list;

	}

}
