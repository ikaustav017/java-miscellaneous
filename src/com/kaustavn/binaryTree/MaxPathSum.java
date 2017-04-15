package com.kaustavn.binaryTree;

public class MaxPathSum {

	int max = 0;

	public int maxPathSum(NodeSimple root) {
		max = Integer.MIN_VALUE;
		maxPathSumUtil(root);
		return max;

	}

	private int maxPathSumUtil(NodeSimple root) {
		if (root == null)
			return 0;

		int left = maxPathSumUtil(root.getLeft());
		if (left < 0)
			left = 0;

		int right = maxPathSumUtil(root.getRight());

		if (right < 0)
			right = 0;
		max = Math.max(max, root.getData() + left + right);
		return root.getData() + Math.max(left, right);

	}

}
